package it.unisa.diem.softwareengineering.assignment2021;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    }
}
