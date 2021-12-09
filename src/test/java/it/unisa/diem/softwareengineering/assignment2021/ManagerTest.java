package it.unisa.diem.softwareengineering.assignment2021;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Iterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;


public class ManagerTest {

    private static ComplexNumber expected[];
    private static Manager manager;

    @BeforeAll
    public static void setup() {
        manager = Manager.getManager();

        expected = new ComplexNumber[10];
        expected[0] = new ComplexNumber(8.0, 7.0);          
        expected[1] = new ComplexNumber(2.0, 3.0);
        expected[2] = new ComplexNumber(5.0, 25.0);
        expected[3] = new ComplexNumber(1.923, 0.385);
        expected[4] = new ComplexNumber(-5.0, -5.0);
        expected[5] = new ComplexNumber(2.457, 1.018);
        expected[6] = new ComplexNumber(7.071,0.0);
        expected[7] = new ComplexNumber(0.785,0.0);
        expected[8] = new ComplexNumber(42.099,-142.317);
        expected[9] = new ComplexNumber(0.0,50.0);
    }

    @AfterEach
    public void teardown() {
        manager.clearMap();
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
        
        manager.processInput(c1);
        manager.processInput("mod");
        memory = manager.getMemory();
        result = memory.next();
        result.setReal(Math.round(result.getReal()*1000d)/1000d);
        result.setImm(Math.round(result.getImm()*1000d)/1000d);
        assertEquals(expected[6], result);

        manager.processInput(c1);
        manager.processInput("arg");
        memory = manager.getMemory();
        result = memory.next();
        result.setReal(Math.round(result.getReal()*1000d)/1000d);
        result.setImm(Math.round(result.getImm()*1000d)/1000d);
        assertEquals(expected[7], result);

        manager.processInput(c1);
        manager.processInput("exp");
        memory = manager.getMemory();
        result = memory.next();
        result.setReal(Math.round(result.getReal()*1000d)/1000d);
        result.setImm(Math.round(result.getImm()*1000d)/1000d);
        assertEquals(expected[8], result);
        
        manager.processInput(c1);
        manager.processInput("2");
        manager.processInput("pow");
        memory = manager.getMemory();
        result = memory.next();
        result.setReal(Math.round(result.getReal()*1000d)/1000d);
        result.setImm(Math.round(result.getImm()*1000d)/1000d);
        assertEquals(expected[9], result);

        manager.processInput("dup");
        memory = manager.getMemory();
        ComplexNumber duplicate = memory.next();
        ComplexNumber original = memory.next();
        assertEquals(duplicate, original);

        manager.processInput("drop");
        memory = manager.getMemory();
        ComplexNumber last = memory.next();
        ComplexNumber secondToLast = memory.next();
        assertEquals(expected[9], last);
        assertEquals(expected[8], secondToLast);

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
        assertEquals(expected[8], last);
        assertEquals(expected[9], secondToLast);
        
        manager.processInput("clear");
        memory = manager.getMemory();
        assertFalse(memory.hasNext());

        manager.processInput(expected[1].toString());
        manager.processInput(">a");
        Iterator<String> variables = manager.getVariables();
        assertEquals("a:"+expected[1].toString()+": ", variables.next());
        
        manager.processInput("<a");
        memory = manager.getMemory();
        assertEquals(expected[1], memory.next());

        manager.processInput("6+4j");
        manager.processInput("+a");
        variables = manager.getVariables();
        assertEquals("a:"+expected[0].toString()+": ", variables.next());

        manager.processInput("6+4j");
        manager.processInput("-a");
        variables = manager.getVariables();
        assertEquals("a:"+expected[1].toString()+": ", variables.next());

        assertThrows(NumberFormatException.class, () -> manager.processInput(">!") );
        manager.processInput("clear");
        assertThrows(NumberFormatException.class, () -> manager.processInput(">abc") );
        manager.processInput("clear");
        assertThrows(NotEnoughOperatorsException.class, () -> manager.processInput("pow") );
        manager.processInput("clear");
        assertThrows(NotEnoughOperatorsException.class, () -> manager.processInput("dup") );

        manager.processInput("save");
        variables = manager.getVariables();
        assertEquals("a:"+expected[1].toString()+":"+expected[1].toString(), variables.next());
        manager.processInput(expected[2].toString());
        manager.processInput(">a");
        variables = manager.getVariables();
        assertEquals("a:"+expected[2].toString()+":"+expected[1].toString(), variables.next());
        manager.processInput("restore");
        variables = manager.getVariables();
        assertEquals("a:"+expected[1].toString()+": ", variables.next());

    }

    @Test
    public void testInsertPersonalizedOperation() throws PersonalizedOperationException {
        String name1 = "DoubleSum";
        String name2 = "Get3Pi/2";
        String wrongName1 = "3-4j";
        String wrongName2 = "Double Sum";
        String wrongName3 = "*";
        
        String operations1 = "+ +";
        String operations2 = "3.14 dup dup DoubleSum 2 /";
        String wrongOperations1 = "";
        String wrongOperations2 = null;
        
        assertThrows(PersonalizedOperationException.class, () -> manager.insertPersonalizedOperation("", operations1), "You have inserted no name for inserted operation!");
        assertThrows(PersonalizedOperationException.class, () -> manager.insertPersonalizedOperation(name1, wrongOperations1), "You have inserted no operation for " + name1 + "!" );
        assertThrows(PersonalizedOperationException.class, () -> manager.insertPersonalizedOperation(name2, wrongOperations2), "You have inserted no operation for " + name2 + "!");
        assertThrows(PersonalizedOperationException.class, () -> manager.insertPersonalizedOperation(wrongName1, operations1), "Your operation name can't be a Complex Number!");
        assertThrows(PersonalizedOperationException.class, () -> manager.insertPersonalizedOperation(wrongName2, operations2), "Operation names can't contain any spaces!");
        assertThrows(PersonalizedOperationException.class, () -> manager.insertPersonalizedOperation(wrongName3, operations1), "A personalized operation can't have the same name of an elementary operation!");
        assertThrows(PersonalizedOperationException.class, () -> manager.insertPersonalizedOperation(name2, operations2), "One or more of your commands in " + name2 +" isn't recognized!"); //Reference to an operation not yet inserted

        manager.insertPersonalizedOperation(name1, operations1);
        manager.insertPersonalizedOperation(name2, operations2);
        
        Iterator<String> personalizedOperations = manager.getPersonalizedOperations();
        assertEquals(name2+":"+operations2, personalizedOperations.next());
        assertEquals(name1+":"+operations1, personalizedOperations.next());
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

    @Test
    public void testEditPersonalizedOperation() throws PersonalizedOperationException {
        //operation validity is already tested in testInsertPersonalizedOperation, and both methods call the same utility method to check it.
        String name1 = "myOperation";
        String operation1 = "+ + +";
        String operation2 = "* + +";
        String modifiedName = "myModifiedOperation";

        manager.insertPersonalizedOperation(name1, operation1);
        manager.editPersonalizedOperation(name1, modifiedName, operation1);

        Iterator<String> personalizedOperations = manager.getPersonalizedOperations();
        assertEquals(modifiedName+":"+operation1, personalizedOperations.next());
        assertFalse(personalizedOperations.hasNext());

        manager.editPersonalizedOperation(modifiedName, modifiedName, operation2);

        personalizedOperations = manager.getPersonalizedOperations();
        assertEquals(modifiedName+":"+operation2, personalizedOperations.next());
        assertFalse(personalizedOperations.hasNext());

        manager.editPersonalizedOperation(modifiedName, name1, operation1);

        personalizedOperations = manager.getPersonalizedOperations();
        assertEquals(name1+":"+operation1, personalizedOperations.next());
        assertFalse(personalizedOperations.hasNext());

        assertThrows(PersonalizedOperationException.class, () -> manager.editPersonalizedOperation("NotExistingOperation", "NewPersonalizedOperation", "dup drop dup drop"), "There is no operation named NotExistingOperation!");
        manager.insertPersonalizedOperation(modifiedName,operation2);
        assertThrows(PersonalizedOperationException.class, () -> manager.editPersonalizedOperation(name1,modifiedName,operation1), "There is already an operation named " + modifiedName + "!" );
    }

    @Test
    public void testDeletePersonalizedOperation() throws PersonalizedOperationException {
        String name1 = "myOperation";
        String operation1 = "+ + +";
        manager.insertPersonalizedOperation(name1, operation1);
        manager.deletePersonalizedOperation(name1);

        Iterator<String> personalizedOperations = manager.getPersonalizedOperations();
        assertFalse(personalizedOperations.hasNext());

        assertThrows(PersonalizedOperationException.class, () -> manager.deletePersonalizedOperation(name1));
    }

}
