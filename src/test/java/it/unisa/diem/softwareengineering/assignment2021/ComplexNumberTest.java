package it.unisa.diem.softwareengineering.assignment2021;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ComplexNumberTest {


    @Test
    public void testParseToComplexNumber() {
        ComplexNumber expected1 = new ComplexNumber(3.8,4.8);
        ComplexNumber expected2 = new ComplexNumber(3.0,4.0);
        ComplexNumber expected3 = new ComplexNumber(-55.0,55.0);
        ComplexNumber expected4 = new ComplexNumber(55.7,-55.7);
        ComplexNumber expected5 = new ComplexNumber(-12.357, -12345.4);
        ComplexNumber expected6 = new ComplexNumber(312.78, 0.0);
        ComplexNumber expected7 = new ComplexNumber(0.0,54.9);
        ComplexNumber expected8 = new ComplexNumber(0.0,-1.0);

        ComplexNumber c1 = ComplexNumber.parseToComplexNumber("3.8+4.8j");
        ComplexNumber c2 = ComplexNumber.parseToComplexNumber("3.8+j4.8");
        
        assertEquals(expected1,c1);
        assertEquals(expected1,c2);
        
        c1 = ComplexNumber.parseToComplexNumber("4j+3");
        c2 = ComplexNumber.parseToComplexNumber("j4+3");
        assertEquals(expected2,c1);
        assertEquals(expected2,c2);
        
        c1 = ComplexNumber.parseToComplexNumber("-55+55j");
        c2 = ComplexNumber.parseToComplexNumber("-55.0+j55.0");
        assertEquals(expected3,c1);
        assertEquals(expected3,c2);
        
        c1 = ComplexNumber.parseToComplexNumber("55.7-55.7j");
        c2 = ComplexNumber.parseToComplexNumber("+55.7-j55.7");
        assertEquals(expected4,c1);
        assertEquals(expected4,c2);

        c1 = ComplexNumber.parseToComplexNumber("-12.357-j12345.4");
        c2 = ComplexNumber.parseToComplexNumber("-12.357-12345.4j");
        assertEquals(expected5,c1);
        assertEquals(expected5,c2);

        c1 = ComplexNumber.parseToComplexNumber("+312.78");
        c2 = ComplexNumber.parseToComplexNumber("0j+312.78");
        assertEquals(expected6,c1);
        assertEquals(expected6,c2);
        
        c1 = ComplexNumber.parseToComplexNumber("54.9j");
        c2 = ComplexNumber.parseToComplexNumber("54.9j+0");
        assertEquals(expected7,c1);
        assertEquals(expected7,c2);

        c1 = ComplexNumber.parseToComplexNumber("-j");
        c2 = ComplexNumber.parseToComplexNumber("0-j");
        assertEquals(expected8,c1);
        assertEquals(expected8,c2);

        //Assert it throws exceptions when passing strings that are not complex numbers
        assertThrows(NumberFormatException.class, () -> ComplexNumber.parseToComplexNumber("Not a complex number"));
        assertThrows(NumberFormatException.class, () -> ComplexNumber.parseToComplexNumber("+"));
        assertThrows(NumberFormatException.class, () -> ComplexNumber.parseToComplexNumber("7+somethingj"));
        assertThrows(NumberFormatException.class, () -> ComplexNumber.parseToComplexNumber("something+4j"));
    }

    @Test
    public void testToString() {
        String expected = "3+4j";
        ComplexNumber c = new ComplexNumber(3.0,4.0);
        assertEquals(expected,c.toString());

        expected = "2.8-4.5j";
        c.setReal(2.8);
        c.setImm(-4.5);
        assertEquals(expected,c.toString());

        expected = "-7.777-7.77j";
        c.setReal(-7.777);
        c.setImm(-7.77);
        assertEquals(expected,c.toString());

        expected = "-2+3j";
        c.setReal(-2.000);
        c.setImm(3.0);
        assertEquals(expected,c.toString());
    }

    @Test
    public void testIsComplexNumber() {
        String cn1 = "3-4j";
        String cn2 = "-3-4j";
        String cn3 = "3.5j-4.8";
        String cn4 = "-3.77-j4.77";
        String cn5 = "3+4j";
        String cn6 = "3.12";
        String cn7 = "j3.4";
        String cn8 = "-j57.4";
        String notcn1 = "notcn";
        String notcn2 = "jnotcn";
        String notcn3 = "54.12+notcn.38j";
        String notcn4 = "54.4+12.7j-8.4j";

        assertTrue(ComplexNumber.isComplexNumber(cn1));
        assertTrue(ComplexNumber.isComplexNumber(cn2));
        assertTrue(ComplexNumber.isComplexNumber(cn3));
        assertTrue(ComplexNumber.isComplexNumber(cn4));
        assertTrue(ComplexNumber.isComplexNumber(cn5));
        assertTrue(ComplexNumber.isComplexNumber(cn6));
        assertTrue(ComplexNumber.isComplexNumber(cn7));
        assertTrue(ComplexNumber.isComplexNumber(cn8));

        assertFalse(ComplexNumber.isComplexNumber(notcn1));
        assertFalse(ComplexNumber.isComplexNumber(notcn2));
        assertFalse(ComplexNumber.isComplexNumber(notcn3));
        assertFalse(ComplexNumber.isComplexNumber(notcn4));
    }


}
