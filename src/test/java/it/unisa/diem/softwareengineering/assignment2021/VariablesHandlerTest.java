package it.unisa.diem.softwareengineering.assignment2021;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VariablesHandlerTest {

    VariablesHandler variablesHandler;
    private static char letter1, letter2, notLetter;
    private static ComplexNumber cn1, cn2;

    @BeforeEach
    public void setup() {
        variablesHandler = new VariablesHandler();
    }

    @BeforeAll
    public static void assign() {
        letter1 = 'c';
        letter2 = 't';
        notLetter = '!';
        cn1 = new ComplexNumber(57.32,8.11);
        cn2 = new ComplexNumber(77.777,381.12);
    }

    @Test
    public void testLoad() {
        variablesHandler.store(letter1,cn1);

        assertEquals(variablesHandler.load(letter1),cn1);

        assertThrows(NoSuchElementException.class, () -> variablesHandler.load(letter2), "No value has been assigned to this variable yet!");   
    }

    @Test
    public void testSumToVariable() {
        variablesHandler.store(letter1,cn1);
        variablesHandler.sumToVariable(letter1, cn2);

        assertEquals(ComplexOperations.sum(cn1,cn2), variablesHandler.load(letter1));

        assertThrows(NoSuchElementException.class, () -> variablesHandler.sumToVariable(letter2,cn2), "The input variable doesn't exists!");   
    }


    @Test
    public void testSubFromVariable() {
        variablesHandler.store(letter1,cn1);
        variablesHandler.subFromVariable(letter1, cn2);

        assertEquals(ComplexOperations.sub(cn1,cn2), variablesHandler.load(letter1));

        assertThrows(NoSuchElementException.class, () -> variablesHandler.subFromVariable(letter2,cn2), "The input variable doesn't exists!");   
    }
    
}
