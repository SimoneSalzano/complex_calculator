package it.unisa.diem.softwareengineering.assignment2021;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeAll;


public class ManagerTest {

    private static ComplexNumber expected[];
    private static Manager manager;

    @BeforeAll
    public static void setup() {
        manager = Manager.getManager();

        expected = new ComplexNumber[6];
        expected[0] = new ComplexNumber(8.0, 7.0);          
        expected[1] = new ComplexNumber(2.0, 3.0);
        expected[2] = new ComplexNumber(5.0, 25.0);
        expected[3] = new ComplexNumber(1.923, 0.385);
        expected[4] = new ComplexNumber(-5.0, -5.0);
        expected[5] = new ComplexNumber(2.457, 1.018);
    }

    @Test
    public void testProcessInput() throws NotEnoughOperatorsException{
        /*
        * Since the inner components of the inner classes have their own testing modules, 
        * this test focuses only on checking that every input corresponds to the right operation.
        */
        Iterator<ComplexNumber> memory;
        String c1 = "5+5j";
        String c2 = "3+2j";

        manager.processInput(c1);
        assertThrows(NotEnoughOperatorsException.class, () -> manager.processInput("+"));

        manager.processInput(c1);
        manager.processInput(c2);
        manager.processInput("+");
        memory = manager.getMemory();
        assertEquals(expected[0], memory.next());

        manager.processInput(c1);
        manager.processInput(c2);
        manager.processInput("-");
        memory = manager.getMemory();
        assertEquals(expected[1], memory.next());

        manager.processInput(c1);
        manager.processInput(c2);
        manager.processInput("*");
        memory = manager.getMemory();
        assertEquals(expected[2], memory.next());

        manager.processInput(c1);
        manager.processInput(c2);
        manager.processInput("/");
        memory = manager.getMemory();
        ComplexNumber result = memory.next();
        result.setReal(Math.round(result.getReal()*1000d)/1000d);
        result.setImm(Math.round(result.getImm()*1000d)/1000d);
        assertEquals(expected[3], result);

        manager.processInput(c1);
        manager.processInput("+-");
        memory = manager.getMemory();
        assertEquals(expected[4], memory.next());

        manager.processInput(c1);
        manager.processInput("sqrt");
        memory = manager.getMemory();
        result = memory.next();
        result.setReal(Math.round(result.getReal()*1000d)/1000d);
        result.setImm(Math.round(result.getImm()*1000d)/1000d);
        assertEquals(expected[5], result);

        manager.processInput("dup");
        memory = manager.getMemory();
        ComplexNumber duplicate = memory.next();
        ComplexNumber original = memory.next();
        assertEquals(duplicate, original);

        manager.processInput("drop");
        memory = manager.getMemory();
        ComplexNumber last = memory.next();
        ComplexNumber secondToLast = memory.next();
        assertEquals(expected[5], last);
        assertEquals(expected[4], secondToLast);

        manager.processInput("over");
        memory = manager.getMemory();
        duplicate = memory.next();
        memory.next();
        original = memory.next();
        assertEquals(duplicate, original);

        manager.processInput("drop");

        manager.processInput("swap");
        memory = manager.getMemory();
        last = memory.next();
        secondToLast = memory.next();
        assertEquals(expected[4], last);
        assertEquals(expected[5], secondToLast);

        manager.processInput("clear");
        memory = manager.getMemory();
        assertFalse(memory.hasNext());
    }

    @Test
    public void testInsertPersonalizedOperation() throws PersonalizedOperationException {
        String name1 = "DoubleSum";
        String name2 = "Get3Pi/2";
        String wrongName1 = "3-4j";
        String wrongName2 = "Double Sum";
        
        String operations1 = "+ +";
        String operations2 = "3.14 dup dup DoubleSum 2 /";
        String wrongOperations1 = "";
        String wrongOperations2 = null;
        

        assertThrows(PersonalizedOperationException.class, () -> manager.insertPersonalizedOperation(wrongName1, operations1));
        assertThrows(PersonalizedOperationException.class, () -> manager.insertPersonalizedOperation(wrongName2, operations2));
        assertThrows(PersonalizedOperationException.class, () -> manager.insertPersonalizedOperation(name2, operations2)); //Reference to an operation not yet inserted
        assertThrows(PersonalizedOperationException.class, () -> manager.insertPersonalizedOperation(name1, wrongOperations1));
        assertThrows(PersonalizedOperationException.class, () -> manager.insertPersonalizedOperation(name2, wrongOperations2));

        manager.insertPersonalizedOperation(name1, operations1);
        manager.insertPersonalizedOperation(name2, operations2);
        
        Iterator<String> personalizedOperations = manager.getPersonalizedOperations();
        assertEquals(personalizedOperations.next(), name2+":"+operations2);
        assertEquals(personalizedOperations.next(), name1+":"+operations1);
    }

    @Test
    public void testExecutePersonalizedOperation() throws PersonalizedOperationException, NumberFormatException, ArithmeticException, NotEnoughOperatorsException {
        String name1 = "DoubleSum";
        String name2 = "Get3Pi/2";
        String operations1 = "+ +";
        String operations2 = "3.141 dup dup DoubleSum 2 /";
        ComplexNumber threeAndAHalphPi = new ComplexNumber(3.0*3.141/2.0,0.0); 
        Iterator<ComplexNumber> memory;

        manager.insertPersonalizedOperation(name1, operations1);
        manager.insertPersonalizedOperation(name2, operations2);

        manager.processInput("1+1j");
        manager.processInput("2");
        manager.processInput("5+6j");
        manager.processInput(name1);
        memory = manager.getMemory();
        
        assertEquals(expected[0], memory.next());

        manager.processInput(name2);
        memory = manager.getMemory();

        assertEquals(threeAndAHalphPi, memory.next());

        manager.processInput("clear");

        manager.processInput(expected[0].toString());
        manager.processInput(expected[1].toString());
        manager.insertPersonalizedOperation("DoubleSubtraction", "- -");
        assertThrows(NotEnoughOperatorsException.class, () -> manager.processInput("DoubleSubtraction"));
        memory = manager.getMemory();
        assertEquals(expected[1],memory.next());
        assertEquals(expected[0],memory.next());
    }


}
