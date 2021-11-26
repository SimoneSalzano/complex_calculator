package it.unisa.diem.softwareengineering.assignment2021;

import java.util.Arrays;
import java.util.Iterator;


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
    private String [] allowedOperations = {"+","-","*","/","+-","sqrt"}; 

    private Manager() {
        memory = new Memory();
    }

    /** 
     * Gets 12 elements from the memory as a list.
     * @return List<ComplexNumber> the list of the elements in the memory
     */
    public Iterator<ComplexNumber> getMemory() {
        return memory.getIterator();
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
            ComplexNumber secondOperand, firstOperand,result;
            switch (input) {
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
        //if it's not a number, either it's a complex number, that we need to push into the stack, or we need to propagate the exception to the GUI
        else {
            ComplexNumber newNumber = ComplexNumber.parseToComplexNumber(input);
            memory.push(newNumber);
        }
    }

}
