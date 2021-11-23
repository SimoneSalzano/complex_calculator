package it.unisa.diem.softwareengineering.assignment2021;

import java.util.Arrays;
import java.util.List;

public class Manager {

    //Manager is a Singleton. 
    private static Manager instance = null;
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

    public List<ComplexNumber> getMemory(int numberOfElements) {
        return memory.asList(numberOfElements);
    }
    
    public List<ComplexNumber> processInput(String input, int numberOfElements) throws NumberFormatException,NotEnoughOperationsException{
        //Check if inpput contains a legal operation
        if (Arrays.asList(allowedOperations).contains(input)) {
            ComplexNumber firstOperand, secondOperand,result;
            switch (input) {
                case "+":
                    if (memory.size() < 2)
                        throw new NotEnoughOperationsException("Sum requires 2 operands to be in the memory!");
                    firstOperand = memory.pop();
                    secondOperand = memory.pop();
                    result = ComplexOperations.sum(firstOperand,secondOperand);
                case "-":
                    if (memory.size() < 2)
                        throw new NotEnoughOperationsException("Subtraction requires 2 operands to be in the memory!");
                    firstOperand = memory.pop();
                    secondOperand = memory.pop();
                    result = ComplexOperations.sub(firstOperand,secondOperand);
                case "*":
                    if (memory.size() < 2)
                        throw new NotEnoughOperationsException("Multiplication requires 2 operands to be in the memory!");
                    firstOperand = memory.pop();
                    secondOperand = memory.pop();
                    result = ComplexOperations.mul(firstOperand,secondOperand);
                case "/":
                    if (memory.size() < 2)
                        throw new NotEnoughOperationsException("Division requires 2 operands to be in the memory!");
                    firstOperand = memory.pop();
                    secondOperand = memory.pop();
                    result = ComplexOperations.div(firstOperand,secondOperand);
                case "+-":
                    if (memory.size() < 1)
                        throw new NotEnoughOperationsException("Inversion requires 1 operand to be in the memory!");
                    firstOperand = memory.pop();
                    result = ComplexOperations.inv(firstOperand);
                //If input is contained in allowedOperations but is not any of the cases above, then it's sqrt.
                default:
                    if (memory.size() < 1)
                        throw new NotEnoughOperationsException("Inversion requires 1 operand to be in the memory!");
                    firstOperand = memory.pop();
                    result = ComplexOperations.sqrt(firstOperand);             
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

    public List<ComplexNumber> processInput(String input) throws NumberFormatException, NotEnoughOperationsException{
        return processInput(input,12);
    }

}
