package it.unisa.diem.softwareengineering.assignment2021;

import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.lang.model.util.ElementScanner6;


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
    private String [] allowedOperations = {"+","-","*","/","+-","sqrt","clear","dup","over","swap"}; 

    private Manager() {
        memory = new Memory();
        personalizedOperations = new PersonalizedOperationsMap();
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

    public void insertPersonalizedOperation(String key, String operations) throws PersonalizedOperationException{
        boolean validOperation = true;
        if (operations != null)
            throw new PersonalizedOperationException("You have inserted no operation for this command!");
        else if (ComplexNumber.isComplexNumber(key))
            throw new PersonalizedOperationException("Your operation name can't be a Complex Number!");
        else {
            StringTokenizer itr = new StringTokenizer(operations);
            String operationToCheck;
            boolean validOperation = true;
            while (itr.hasMoreTokens() || !validOperation) {
                operationToCheck = itr.nextToken();
                if (Arrays.asList(allowedOperations).contains(operationToCheck)) 
                    continue;
                else if (personalizedOperations.containsKey(operationToCheck))
                    continue;
                else if (ComplexNumber.isComplexNumber())
                    continue;
                else
                    throw new PersonalizedOperationException("One or more of your commands isn't recognized!");
            }
        }
    }


    private void executeOperation(String operationName) throws ArithmeticException, NotEnoughOperatorsException {
        ComplexNumber secondOperand, firstOperand,result;

        switch (operationName) {

            case "+":
                if (memory.size() < 2)
                    throw new NotEnoughOperatorsException("Sum requires 2 operands to be in the memory!");
                secondOperand = memory.pop();
                firstOperand = memory.pop();
                result = ComplexOperations.sum(firstOperand,secondOperand);
                break;

            case "-":
                if (memory.size() < 2)
                    throw new NotEnoughOperatorsException("Subtraction requires 2 operands to be in the memory!");
                secondOperand = memory.pop();
                firstOperand = memory.pop();
                result = ComplexOperations.sub(firstOperand,secondOperand);
                break;

            case "*":
                if (memory.size() < 2)
                    throw new NotEnoughOperatorsException("Multiplication requires 2 operands to be in the memory!");
                secondOperand = memory.pop();
                firstOperand = memory.pop();
                result = ComplexOperations.mul(firstOperand,secondOperand);
                break;

            case "/":
                if (memory.size() < 2)
                    throw new NotEnoughOperatorsException("Division requires 2 operands to be in the memory!");
                secondOperand = memory.pop();
                firstOperand = memory.pop();
                result = ComplexOperations.div(firstOperand,secondOperand);
                break;

            case "+-":
                if (memory.size() < 1)
                    throw new NotEnoughOperatorsException("Inversion requires 1 operand to be in the memory!");
                firstOperand = memory.pop();
                result = ComplexOperations.inv(firstOperand);
                break;

            default:
                //If input is contained in allowedOperations but is not any of the cases above, then it's sqrt.
                if (memory.size() < 1)
                    throw new NotEnoughOperatorsException("Inversion requires 1 operand to be in the memory!");
                firstOperand = memory.pop();
                result = ComplexOperations.sqrt(firstOperand);   
                break;
        }

        memory.push(result);

    }


    private void executePersonalizedOperation(String personalizedOperationName) throws NumberFormatException,NotEnoughOperatorsException,ArithmeticException{
        Iterator<String> personalizedOperation = personalizedOperations.getPersonalizedOperationIterator(personalizedOperationName);

        while (personalizedOperation.hasNext()) {
            this.processInput(personalizedOperation.next());
        }

    }

    private void executeNumberInsertion(String complexNumber) throws NumberFormatException{
        ComplexNumber newNumber = ComplexNumber.parseToComplexNumber(complexNumber);
        memory.push(newNumber);
    }

}
