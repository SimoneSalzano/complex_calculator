package it.unisa.diem.softwareengineering.assignment2021;

import java.util.Arrays;
import java.util.List;

public class Manager {

    //Manager is a Singleton. 
    private static Manager instance = null;
    
    /** 
     * @return Manager
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
     * @param numberOfElements
     * @return List<ComplexNumber>
     */
    public List<ComplexNumber> getMemory(int numberOfElements) {
        return memory.asList(numberOfElements);
    }
    
    
    /** 
     * @param input
     * @param numberOfElements
     * @return List<ComplexNumber>
     * @throws NumberFormatException
     * @throws NotEnoughOperatorsException
     */
    public List<ComplexNumber> processInput(String input, int numberOfElements) throws NumberFormatException,NotEnoughOperatorsException,ArithmeticException{
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
        //if it's not a number, either it's acomplex number, that we need to push into the stack, or we need to propagate the exception to the GUI
        else {
            ComplexNumber newNumber = ComplexNumber.parseToComplexNumber(input);
            memory.push(newNumber);
        }
        return memory.asList(numberOfElements);
    }

    
    /** 
     * @param input
     * @return List<ComplexNumber>
     * @throws NumberFormatException
     * @throws NotEnoughOperatorsException
     */
    public List<ComplexNumber> processInput(String input) throws NumberFormatException, NotEnoughOperatorsException{
        return processInput(input,12);
    }

}
