package it.unisa.diem.softwareengineering.assignment2021;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Observer;
import java.util.StringTokenizer;

/**
* The Manager of the Complex Calculator, which makes the comunication between the GUI, the Memory and the available operations possible.
* @author Simone Salzano
* 
*/
public class Manager{

    //Manager is a Singleton. 
    private static Manager instance = null;
    
    /** 
     * A method that creates a new Manager if it wasn't already created, or the previously istanced one.
     * @return Manager the manager of the Complex Calculator.
     */
    public static Manager getManager() {
        if (instance == null)
            instance = new Manager();
        return instance;
    }

    private Memory memory;
    private PersonalizedOperationsMap personalizedOperations;
    private String [] allowedOperations = {"+","-","*","/","+-","sqrt","clear","mod","arg","pow","exp","dup","drop","over","swap","save","restore"}; 
    private VariablesHandler variables;

    private Manager() {
        memory = new Memory();
        personalizedOperations = new PersonalizedOperationsMap();
        variables = new VariablesHandler();
    }

    /** 
     * Gets 12 elements from the memory as an iterator.
     * @return Iterator<ComplexNumber> the iterator over the elements in the memory
     */
    public Iterator<ComplexNumber> getMemory() {
        return memory.getIterator();
    }

        /** 
     * Gets an iterator over the personalized operation loaded in runtime, separating key name from the operation list with ":".
     * @return Iterator<String>
     */
    public Iterator<String> getPersonalizedOperations() {
        return personalizedOperations.getMapIterator();
    }
    
    
    /** 
     * Processes the input submitted by the user and operates on the stack according to the contents of the input, that could be 
     * a new number insertion or an operation, then proceeds to update the stack accordingly.
     * @param input the String inputted from the user which will be parsed.
     * @throws NumberFormatException when the input doesn't correspond neither to an operation, nor to a properly formatted Complex Number.
     * @throws NotEnoughOperatorsException when there aren't enough operands in the memory to process an operation
     * @throws ArithmeticException when a arithmetically illegal operation occurs.
     */
    public void processInput(String input) throws NumberFormatException, NotEnoughOperatorsException, ArithmeticException, NoSuchElementException{
        //Check if inpput contains a legal operation
        if (Arrays.asList(allowedOperations).contains(input)) {
            this.executeAllowedOperation(input);
        }
        //Check if input references the name of a personalized operation
        else if (personalizedOperations.containsKey(input)) {
            this.executePersonalizedOperation(input);
        }
        else if (this.isVariablesOperation(input)) {
            this.executeVariablesOperation(input);
        }
        //if it's not an operation, it's either a complex number, or a wrong input, in which case formatting it to a Complex Number produces an exception which will be handles by GUI. 
        else {
            this.executeNumberInsertion(input);
        }
    }
    
    /**
     * Inserts a personalized operation into runtime environment, so that it can be later called again. 
     * @param name the name of the personalized operation 
     * @param operations the list of elementary operations that compose the personalized operation
     * @throws PersonalizedOperationException when a element of operations isn't recognized, naming the operation with a complex number or the name contains a space.
     */
    public String insertPersonalizedOperation(String name, String operations) throws PersonalizedOperationException{
        checkValidPersonalizedOperation(name, operations);
        return personalizedOperations.put(name,operations);
    }

    /**
     * Delete a personalized operation from runtime.
     * @param name the name of the personalized operation to remove.
     * @throws PersonalizedOperationException when there is no operation named like the parameter passed.
     */
    public void deletePersonalizedOperation(String name) throws PersonalizedOperationException{

        if (personalizedOperations.containsKey(name))
            personalizedOperations.remove(name);

        else
            throw new PersonalizedOperationException("There is no operation named " + name + "!");
    }

    /**
     * Edits a personalized operation's name, or operations.
     * @param oldName the personalized operation's former name.
     * @param newName the personalized operation's new name.
     * @param operations the new operations performed by this personalized operation.
     * @throws PersonalizedOperationException when there was no operation named like oldName.
     */
    public void editPersonalizedOperation(String oldName, String newName, String newOperations) throws PersonalizedOperationException {

        checkValidPersonalizedOperation(newName, newOperations);

        if (personalizedOperations.containsKey(oldName)) {
            //check if newName isn't another existing personalizedOperation, so that we don't overwrite it.
            if(oldName.equals(newName) || !personalizedOperations.containsKey(newName)){
                //remove the old operation if the new name is different from the old name, otherwise just update the elementary operations. 
                if (!oldName.equals(newName))
                    personalizedOperations.remove(oldName);
                personalizedOperations.edit(newName,newOperations);
            }
            else{
                throw new PersonalizedOperationException("There is already an operation named " + newName + "!" );
            }
        }
        else
            throw new PersonalizedOperationException("There is no operation named " + oldName + "!");
    }

    /**
     * Saves the personalized operations defined at runtime to a standard file.
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void saveMapToFile() throws ClassNotFoundException, IOException {
        personalizedOperations.saveToFile("personalized-operations");
    }

    /**
     * Loads the personalized operation from the standard file to runtime.
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void LoadMapToFile() throws ClassNotFoundException, IOException {
        personalizedOperations.loadFromFile("personalized-operations");
    }
    
    /**
     * Deletes every personalized operations defined at runtime.
     */
    public void clearMap(){
        personalizedOperations.clear();
    }

    /**
     * Clears every element from the runtime variables.
     */
    public void resetVariables() {
        variables.reset();
    }

    /**
     * Returns an iterator over every runtime variable, from a to z, followed by the older values precedently stored in the variables. 
     * @return an iterator over every runtime variable, from a to z, followed by the older values precedently stored in the variables. 
     */
    public Iterator<String> getVariables() {
        return variables.getVariables();
    }

    /**
     * Makes it so the variables can be observed by an observer, so that the changes on Variables will be noticed by the observer, and it will update accordingly. 
     * @param observer the observer that observes a VariableHandler
     */
    public void observeVariables(Observer observer) {
        variables.addObserver(observer);
    }

    /**
     * Utility methot that checks if the personalized operation passed is valid.
     * @param name the name of the personalized operation.
     * @param operations the elementary operations contained in the personalized operation.
     * @return true if the operation is valid
     * @throws PersonalizedOperationException when the operation is not valid, varying its message in each case.
     */
    private boolean checkValidPersonalizedOperation(String name, String operations) throws PersonalizedOperationException{
        if (name == null || name.equals(""))
            throw new PersonalizedOperationException("You have inserted no name for inserted operation!");
        else if (operations == null || operations.equals(""))
            throw new PersonalizedOperationException("You have inserted no operation for " + name + "!");
        else if (ComplexNumber.isComplexNumber(name))
            throw new PersonalizedOperationException("Your operation name can't be a Complex Number!");
        else if (name.contains(" ") || name.contains("\t")) 
            throw new PersonalizedOperationException("Operation names can't contain any spaces!"); 
        StringTokenizer itr = new StringTokenizer(operations);
        String operationToCheck;
        while (itr.hasMoreTokens()) {
            operationToCheck = itr.nextToken();
            if (Arrays.asList(allowedOperations).contains(operationToCheck)) 
                continue;
            else if (personalizedOperations.containsKey(operationToCheck))
                continue;
            else if (isVariablesOperation(operationToCheck))
                continue;
            else if (ComplexNumber.isComplexNumber(operationToCheck))
                continue;
            //if our operation doesn't pass any of the above checks, then it hasn't been recognized.
            throw new PersonalizedOperationException("One or more of your commands in " + name +" isn't recognized!");
        }
        return true;
    }


    /**
     * A utility method used by processInput to execute elementary allowed operations. 
     * @param operationName the name of the operation to execute.
     * @throws ArithmeticException when the resulting operation is arithmetically illegal.
     * @throws NotEnoughOperatorsException when there aren't enough operators in the stack to execute the operation.
     */
    private void executeAllowedOperation(String operationName) throws ArithmeticException, NotEnoughOperatorsException {
        ComplexNumber secondOperand, firstOperand,result;

        switch (operationName) {

            case "+":
                if (memory.size() < 2)
                    throw new NotEnoughOperatorsException("Sum requires 2 operands to be in the memory!");
                secondOperand = memory.pop();
                firstOperand = memory.pop();
                result = ComplexOperations.sum(firstOperand,secondOperand);
                memory.push(result);
                break;

            case "-":
                if (memory.size() < 2)
                    throw new NotEnoughOperatorsException("Subtraction requires 2 operands to be in the memory!");
                secondOperand = memory.pop();
                firstOperand = memory.pop();
                result = ComplexOperations.sub(firstOperand,secondOperand);
                memory.push(result);
                break;

            case "*":
                if (memory.size() < 2)
                    throw new NotEnoughOperatorsException("Multiplication requires 2 operands to be in the memory!");
                secondOperand = memory.pop();
                firstOperand = memory.pop();
                result = ComplexOperations.mul(firstOperand,secondOperand);
                memory.push(result);
                break;

            case "/":
                if (memory.size() < 2)
                    throw new NotEnoughOperatorsException("Division requires 2 operands to be in the memory!");
                secondOperand = memory.pop();
                firstOperand = memory.pop();
                result = ComplexOperations.div(firstOperand,secondOperand);
                memory.push(result);
                break;

            case "+-":
                if (memory.size() < 1)
                    throw new NotEnoughOperatorsException("Inversion requires 1 operand to be in the memory!");
                firstOperand = memory.pop();
                result = ComplexOperations.inv(firstOperand);
                memory.push(result);
                break;

            case "sqrt":
                if (memory.size() < 1)
                    throw new NotEnoughOperatorsException("Inversion requires 1 operand to be in the memory!");
                firstOperand = memory.pop();
                result = ComplexOperations.sqrt(firstOperand);
                memory.push(result);
                break;

            case "mod":
                if (memory.size() < 1)
                    throw new NotEnoughOperatorsException("Inversion requires 1 operand to be in the memory!");
                firstOperand = memory.pop();
                result = ComplexOperations.mod(firstOperand);
                memory.push(result);
                break;

            case "arg":
                if (memory.size() < 1)
                    throw new NotEnoughOperatorsException("Inversion requires 1 operand to be in the memory!");
                firstOperand = memory.pop();
                result = ComplexOperations.arg(firstOperand);
                memory.push(result);
                break;

            case "exp":
                if (memory.size() < 1)
                    throw new NotEnoughOperatorsException("Inversion requires 1 operand to be in the memory!");
                firstOperand = memory.pop();
                result = ComplexOperations.exp(firstOperand);
                memory.push(result);
                break;

            case "pow":
                if (memory.size() < 2)
                    throw new NotEnoughOperatorsException("Inversion requires 1 operand to be in the memory!");
                secondOperand = memory.pop();
                firstOperand = memory.pop();
                result = ComplexOperations.pow(firstOperand,secondOperand);
                memory.push(result);
                break;

            case "drop":
                memory.drop();
                break;

            case "swap":
                memory.swap();
                break;

            case "over":
                memory.over();
                break;

            case "dup":
                memory.dup();
                break;

            case "save":
                variables.save();
                break;

            case "restore":
                variables.restore();
                break;
        }
    }


    /**
     * Utility method used by processInput to execute personalized operations, by calling processInput for each elementary operation or complex number stated in the personalized operation.
     * @param personalizedOperationName the name of the personalized operation.
     * @throws NumberFormatException on the same conditions of processInput.
     * @throws NotEnoughOperatorsException on the same conditions of processInput.
     * @throws ArithmeticException on the same conditions of processInput.
     */
    private void executePersonalizedOperation(String personalizedOperationName) throws NumberFormatException, NotEnoughOperatorsException, ArithmeticException, NoSuchElementException{
        Iterator<String> personalizedOperation = personalizedOperations.getPersonalizedOperationIterator(personalizedOperationName);

        //preserve old memory in case an exception occurs
        ArrayList<ComplexNumber> backupMemory = new ArrayList<>();
        Iterator<ComplexNumber> itr = memory.getIterator();
        while (itr.hasNext()) {
            backupMemory.add(itr.next());
        }

        try {
            while (personalizedOperation.hasNext()) {
                this.processInput(personalizedOperation.next());
            }
        } catch (Exception ex) {
            //restore memory before trying the chain of operations called by this method. 
            memory.clear();
            while (!backupMemory.isEmpty()) {
                memory.push(backupMemory.remove(backupMemory.size() - 1));
            }
            //propagate the exception so that the GUI can handle it.
            throw ex;
        }
    }

    /**
     * Utility method used py processInput to insert a new Complex Number, if the passed argument has the proper format.
     * @param complexNumber the String to parse to Complex Number. 
     * @throws NumberFormatException when the passed String is not a ComplexNumber.
     */
    private void executeNumberInsertion(String complexNumber) throws NumberFormatException{
        ComplexNumber newNumber = ComplexNumber.parseToComplexNumber(complexNumber);
        memory.push(newNumber);
    }

    /**
     * Utility method that checks if input corresponds to a operation on the current variables such as >x, <x, +x, -x, where x is a lowercase letter.
     * @param input the input to check
     * @return true if input is a variable operation, false if not.
     */
    private Boolean isVariablesOperation(String input) {
        String variablesOperationRegex = "(<|>|\\+|-)[a-z]";
        return input.matches(variablesOperationRegex);
    }

    /**
     * Utility method that executes variables operations based on what's in input. 
     * @param input the operation written as a String. It is expected it's format is checked with isVariablesOperation method before running this method.
     * @throws NotEnoughOperatorsException when there are not enough complex numbers in the stack to perform the requested operation.
     * @throws NoSuchElementException when there is an attempt to load a variable that has no value stored yet.
     */
    private void executeVariablesOperation(String input) throws NotEnoughOperatorsException, NoSuchElementException{
        char operation = input.charAt(0);
        char variable = input.charAt(1);
        ComplexNumber cn;
        switch (operation) {

            case '<':
                cn = variables.load(variable);
                memory.push(cn);
                break;

            case '>':
                if (memory.size() < 1)
                    throw new NotEnoughOperatorsException("Storing to a variable requires 1 operand to be in the memory!");
                cn = memory.pop();
                variables.store(variable,cn);
                break;

            case '+':
            if (memory.size() < 1)
                throw new NotEnoughOperatorsException("Summing to a variable requires 1 operand to be in the memory!");
                cn = memory.pop();
                variables.sumToVariable(variable,cn);
                break;

            case '-':
            if (memory.size() < 1)
                throw new NotEnoughOperatorsException("Subtracting from a variable requires 1 operand to be in the memory!");
                cn = memory.pop();
                variables.subFromVariable(variable,cn);
                break;
            }
    }

}
