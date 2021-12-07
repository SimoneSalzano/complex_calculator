package it.unisa.diem.softwareengineering.assignment2021;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.Deque;

/**
* The Manager of the Complex Calculator, which makes the comunication between the GUI, the Memory and the available operations possible.
* @author Simone Salzano
* 
*/
public class Manager {

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
    private String [] allowedOperations = {"+","-","*","/","+-","sqrt","clear","dup","drop","over","swap"}; 
    private Deque<Variables> stackVariables;
    private Variables variables;

    private Manager() {
        memory = new Memory();
        personalizedOperations = new PersonalizedOperationsMap();
        stackVariables = new ArrayDeque<>();
        variables = new Variables();
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
    public void processInput(String input) throws NumberFormatException,NotEnoughOperatorsException,ArithmeticException{
        //Check if inpput contains a legal operation
        if (Arrays.asList(allowedOperations).contains(input)) {
            this.executeOperation(input);
        }
        //Check if input references the name of a personalized operation
        else if (personalizedOperations.containsKey(input)) {
            this.executePersonalizedOperation(input);
        }
        //if it's not an operation, it's either a complex number, or a wrong input, in which case formatting it to a Complex Number produces an exception which will be handles by GUI. 
        else {
            this.executeNumberInsertion(input);
        }
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
            else if (ComplexNumber.isComplexNumber(operationToCheck))
                continue;
            //if our operation doesn't pass any of the above checks, then it hasn't been recognized.
            throw new PersonalizedOperationException("One or more of your commands in " + name +" isn't recognized!");
        }
        return true;
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
     * A utility method used by processInput to execute elementary allowed operations. 
     * @param operationName the name of the operation to execute.
     * @throws ArithmeticException when the resulting operation is arithmetically illegal.
     * @throws NotEnoughOperatorsException when there aren't enough operators in the stack to execute the operation.
     */
    private void executeOperation(String operationName) throws ArithmeticException, NotEnoughOperatorsException {
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

            case "clear":
                memory.clear();
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
        }
    }


    /**
     * Utility method used by processInput to execute personalized operations, by calling processInput for each elementary operation or complex number stated in the personalized operation.
     * @param personalizedOperationName the name of the personalized operation.
     * @throws NumberFormatException on the same conditions of processInput.
     * @throws NotEnoughOperatorsException on the same conditions of processInput.
     * @throws ArithmeticException on the same conditions of processInput.
     */
    private void executePersonalizedOperation(String personalizedOperationName) throws NumberFormatException,NotEnoughOperatorsException,ArithmeticException{
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

    public void saveVariables(){
        stackVariables.push(variables);
    }

    public void restoreVariables() throws NoSuchElementException{
        if(stackVariables.isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            this.variables=stackVariables.pop();
        }
    }

    public Iterator<String> getVariables(){
        List<String> listPairs = new ArrayList<>();
        Iterator<String> itrVariables = this.variables.variablesIterator();
        
        
        while (itrVariables.hasNext()){
            String pair = itrVariables.next();
            Character key = pair.split(":")[0].charAt(0);
            if(stackVariables.isEmpty()){
                listPairs.add(pair+": ");
            }
            else{
                Variables oldMap = stackVariables.getFirst();
                ComplexNumber oldValue = oldMap.get(key);
                if(oldValue == null){
                    listPairs.add(pair+": ");
                }
                else{
                    listPairs.add(pair+":"+oldValue);
                }
            }
        }
        return listPairs.iterator();
    }

    public void resetVariables(){
        for(char c='a';c<='z';c++){
            variables.put(c,null);
        }
    }
}
