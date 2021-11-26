package it.unisa.diem.softwareengineering.assignment2021;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


public class ManagerTest {

    private static ComplexNumber expectedArray[];
    private static Manager manager;

    @BeforeAll
    public static void setupManager() {
        manager = Manager.getManager();
    }

    @BeforeEach 
    public static void setup() {
        expectedArray = new ComplexNumber[6];
        expectedArray[0] = new ComplexNumber(5.0, 5.0);
        expectedArray[1] = new ComplexNumber(0.0, 0.0);
        expectedArray[2] = new ComplexNumber(-3.8, 17.8);
        expectedArray[3] = new ComplexNumber(4.2, -5.6);
        expectedArray[4] = new ComplexNumber(-11.0, -77.7);
        expectedArray[5] = new ComplexNumber(8.8, 8.8);                    
    }

    @Test
    public void testProcessInput() throws NotEnoughOperatorsException{
        //Since the 
        String c1 = "5+5j";
        String c2 = "3+2j";
        manager.processInput(c1);
        manager.processInput(c2);
        manager.processInput("+");

    }
}
