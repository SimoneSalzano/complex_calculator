package it.unisa.diem.softwareengineering.assignment2021;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Iterator;
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
    public void testStore(){
        variablesHandler.store('a', new ComplexNumber(3.0, 4.1));
        variablesHandler.store('z', new ComplexNumber(0.0, 4.1));
        variablesHandler.store('f', new ComplexNumber(3.0, 0.0));
        variablesHandler.store('m', new ComplexNumber(0.0, 0.0));

        String[] expected={
            "a:3+4.1j: ",
            "b: : ", 
            "c: : ",
            "d: : ",
            "e: : ",
            "f:3+0j: ",
            "g: : ",
            "h: : ",
            "i: : ",
            "j: : ",
            "k: : ",
            "l: : ",
            "m:0+0j: ",
            "n: : ",
            "o: : ",
            "p: : ",
            "q: : ",
            "r: : ",
            "s: : ",
            "t: : ",
            "u: : ",
            "v: : ",
            "w: : ",
            "x: : ",
            "y: : ",
            "z:0+4.1j: "
        };
        
        Iterator<String> itr=variablesHandler.getVariables();
        int i=0;
        while(itr.hasNext()){
            String temp=itr.next();
            if(!temp.equals(expected[i])){
                System.out.println(temp);
                assertEquals(false, true);
            }
            i=i+1;
        }
        assertEquals(true, true);
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

    @Test
    public void testSave(){
        variablesHandler.store('a', new ComplexNumber(3.0, 4.1));
        variablesHandler.store('z', new ComplexNumber(0.0, 4.1));
        variablesHandler.store('f', new ComplexNumber(3.0, 0.0));
        variablesHandler.store('m', new ComplexNumber(0.0, 0.0));

        variablesHandler.save();

        String[] expected={
            "a:3+4.1j:3+4.1j",
            "b: : ", 
            "c: : ",
            "d: : ",
            "e: : ",
            "f:3+0j:3+0j",
            "g: : ",
            "h: : ",
            "i: : ",
            "j: : ",
            "k: : ",
            "l: : ",
            "m:0+0j:0+0j",
            "n: : ",
            "o: : ",
            "p: : ",
            "q: : ",
            "r: : ",
            "s: : ",
            "t: : ",
            "u: : ",
            "v: : ",
            "w: : ",
            "x: : ",
            "y: : ",
            "z:0+4.1j:0+4.1j"
        };

        Iterator<String> itr=variablesHandler.getVariables();
        int i=0;
        while(itr.hasNext()){
            String temp=itr.next();
            if(!temp.equals(expected[i])){
                System.out.println(temp);
                assertEquals(false, true);
            }
            i=i+1;
        }
        assertEquals(true, true);
    }

    @Test
    public void testRestore(){
        variablesHandler.store('a', new ComplexNumber(3.0, 4.1));
        variablesHandler.store('z', new ComplexNumber(0.0, 4.1));
        variablesHandler.store('f', new ComplexNumber(3.0, 0.0));
        variablesHandler.store('m', new ComplexNumber(0.0, 0.0));

        variablesHandler.save();
        variablesHandler.reset();

        variablesHandler.restore();

        String[] expected={
            "a:3+4.1j: ",
            "b: : ", 
            "c: : ",
            "d: : ",
            "e: : ",
            "f:3+0j: ",
            "g: : ",
            "h: : ",
            "i: : ",
            "j: : ",
            "k: : ",
            "l: : ",
            "m:0+0j: ",
            "n: : ",
            "o: : ",
            "p: : ",
            "q: : ",
            "r: : ",
            "s: : ",
            "t: : ",
            "u: : ",
            "v: : ",
            "w: : ",
            "x: : ",
            "y: : ",
            "z:0+4.1j: "
        };

        Iterator<String> itr=variablesHandler.getVariables();
        int i=0;
        while(itr.hasNext()){
            String temp=itr.next();
            if(!temp.equals(expected[i])){
                System.out.println(temp);
                assertEquals(false, true);
            }
            i=i+1;
        }
        assertEquals(true, true);
    }

    @Test
    public void testGetVariables(){
        variablesHandler.store('a', new ComplexNumber(3.0, 4.1));
        variablesHandler.store('z', new ComplexNumber(0.0, 4.1));
        variablesHandler.store('f', new ComplexNumber(3.0, 0.0));
        variablesHandler.store('m', new ComplexNumber(0.0, 0.0));

        variablesHandler.save();

        variablesHandler.store('b', new ComplexNumber(-3.0, 4.1));
        variablesHandler.store('g', new ComplexNumber(0.0, -4.1));
        variablesHandler.store('l', new ComplexNumber(-3.0, 0.0));
        variablesHandler.store('m', new ComplexNumber(0.0, 5.0));

        String[] expected={
            "a:3+4.1j:3+4.1j",
            "b:-3+4.1j: ", 
            "c: : ",
            "d: : ",
            "e: : ",
            "f:3+0j:3+0j",
            "g:0-4.1j: ",
            "h: : ",
            "i: : ",
            "j: : ",
            "k: : ",
            "l:-3+0j: ",
            "m:0+5j:0+0j",
            "n: : ",
            "o: : ",
            "p: : ",
            "q: : ",
            "r: : ",
            "s: : ",
            "t: : ",
            "u: : ",
            "v: : ",
            "w: : ",
            "x: : ",
            "y: : ",
            "z:0+4.1j:0+4.1j"
        };
        
        Iterator<String> itr=variablesHandler.getVariables();
        int i=0;
        while(itr.hasNext()){
            String temp=itr.next();
            if(!temp.equals(expected[i])){
                System.out.println(temp);
                assertEquals(false, true);
            }
            i=i+1;
        }
        assertEquals(true, true);
    }

    @Test
    public void testReset(){
        variablesHandler.store('a', new ComplexNumber(3.0, 4.1));
        variablesHandler.store('z', new ComplexNumber(0.0, 4.1));
        variablesHandler.store('f', new ComplexNumber(3.0, 0.0));
        variablesHandler.store('m', new ComplexNumber(0.0, 0.0));

        variablesHandler.reset();

        String[] expected={
            "a: : ",
            "b: : ", 
            "c: : ",
            "d: : ",
            "e: : ",
            "f: : ",
            "g: : ",
            "h: : ",
            "i: : ",
            "j: : ",
            "k: : ",
            "l: : ",
            "m: : ",
            "n: : ",
            "o: : ",
            "p: : ",
            "q: : ",
            "r: : ",
            "s: : ",
            "t: : ",
            "u: : ",
            "v: : ",
            "w: : ",
            "x: : ",
            "y: : ",
            "z: : "
        };
        
        Iterator<String> itr=variablesHandler.getVariables();
        int i=0;
        while(itr.hasNext()){
            String temp=itr.next();
            if(!temp.equals(expected[i])){
                System.out.println(temp);
                assertEquals(false, true);
            }
            i=i+1;
        }
        assertEquals(true, true);
    }


    
}
