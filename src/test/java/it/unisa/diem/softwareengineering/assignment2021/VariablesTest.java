package it.unisa.diem.softwareengineering.assignment2021;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VariablesTest {
    private Variables variables;
    private static char letter1, letter2, notLetter;
    private static ComplexNumber cn1,cn2;

    @BeforeEach
    public void setup() {
        variables = new Variables();
    }

    @BeforeAll
    public static void assign() {
        letter1 = 'c';
        letter2 = 't';
        notLetter = '!';
        cn1 = new ComplexNumber(57.32,8.11);
        cn2 = new ComplexNumber(16.0,0.0);
    }

    @Test
    public void testPut() {
        variables.put(letter1,cn1);

        assertEquals(cn1,variables.get(letter1));

        assertThrows(IllegalArgumentException.class, () -> variables.put(notLetter,cn1), "The variable must be a lowercase letter!");
    }

    @Test
    public void testLoadVariable() {
        variables.put(letter1,cn1);

        assertEquals(variables.loadVariable(letter1),cn1);

        assertThrows(IllegalArgumentException.class, () -> variables.loadVariable(letter2), "The input variable doesn't exists!");   
    }

    @Test
    public void testSumToVariable() {
        variables.put(letter1,cn1);
        variables.sumToVariable(letter1, cn2);

        assertEquals(ComplexOperations.sum(cn1,cn2), variables.get(letter1));

        assertThrows(IllegalArgumentException.class, () -> variables.sumToVariable(letter2,cn2), "The input variable doesn't exists!");   
    }


    @Test
    public void testSubFromVariable() {
        variables.put(letter1,cn1);
        variables.subFromVariable(letter1, cn2);

        assertEquals(ComplexOperations.sub(cn1,cn2), variables.get(letter1));

        assertThrows(IllegalArgumentException.class, () -> variables.subFromVariable(letter2,cn2), "The input variable doesn't exists!");   
    }
}
