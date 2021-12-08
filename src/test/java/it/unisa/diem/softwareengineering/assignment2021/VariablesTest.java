package it.unisa.diem.softwareengineering.assignment2021;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VariablesTest {
    private Variables variables;
    private static char letter1, notLetter;
    private static ComplexNumber cn1;

    @BeforeEach
    public void setup() {
        variables = new Variables();
    }

    @BeforeAll
    public static void assign() {
        letter1 = 'c';
        notLetter = '!';
        cn1 = new ComplexNumber(57.32,8.11);
    }

    @Test
    public void testPut() {
        variables.put(letter1,cn1);

        assertEquals(cn1,variables.get(letter1));

        assertThrows(IllegalArgumentException.class, () -> variables.put(notLetter,cn1), "The variable must be a lowercase letter!");
    }

 
}
