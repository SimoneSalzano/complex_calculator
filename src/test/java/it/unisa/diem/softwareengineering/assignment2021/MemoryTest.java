package it.unisa.diem.softwareengineering.assignment2021;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemoryTest {
    

    @Test
    public void testPush(){
        Memory memory=new Memory();
        ComplexNumber complex1=new ComplexNumber(5.0,10.0);
        ComplexNumber complex2=new ComplexNumber(-2.0,6.0);
        ComplexNumber complex3=new ComplexNumber(10.0,-2.0);
        ComplexNumber complex4=new ComplexNumber(14.5,0.0);
        ComplexNumber complex5=new ComplexNumber(0.0, -4.5);
        ComplexNumber complex6=new ComplexNumber(0.0, 0.0);

        memory.push(complex1);
        memory.push(complex2);
        memory.push(complex3);
        memory.push(complex4);
        memory.push(complex5);
        memory.push(complex6);

    }

    @Test
    public void testPop(){
        Memory memory=new Memory();
        ComplexNumber complex1=new ComplexNumber(5.0,10.0);
        ComplexNumber complex2=new ComplexNumber(-2.0,6.0);
        ComplexNumber complex3=new ComplexNumber(10.0,-2.0);
        ComplexNumber complex4=new ComplexNumber(14.5,0.0);
        ComplexNumber complex5=new ComplexNumber(0.0, -4.5);
        ComplexNumber complex6=new ComplexNumber(0.0, 0.0);

        memory.push(complex1);
        memory.push(complex2);
        memory.push(complex3);
        memory.push(complex4);
        memory.push(complex5);
        memory.push(complex6);

        assertEquals(complex6, memory.pop());
        assertEquals(complex5, memory.pop());
        assertEquals(complex4, memory.pop());
        assertEquals(complex3, memory.pop());
        assertEquals(complex2, memory.pop());
        assertEquals(complex1, memory.pop());

        assertThrows(NoSuchElementException.class, () -> memory.pop());
    }

    @Test
    public void testTop(){
        Memory memory=new Memory();
        ComplexNumber complex1=new ComplexNumber(5.0,10.0);
        ComplexNumber complex2=new ComplexNumber(-2.0,6.0);
        ComplexNumber complex3=new ComplexNumber(10.0,-2.0);
        ComplexNumber complex4=new ComplexNumber(14.5,0.0);
        ComplexNumber complex5=new ComplexNumber(0.0, -4.5);
        ComplexNumber complex6=new ComplexNumber(0.0, 0.0);

        memory.push(complex1);
        memory.push(complex2);
        memory.push(complex3);
        memory.push(complex4);
        memory.push(complex5);
        memory.push(complex6);

        assertEquals(complex6, memory.top());
        memory.pop();
        assertEquals(complex5, memory.top());
        memory.pop();
        assertEquals(complex4, memory.top());
        memory.pop();
        assertEquals(complex3, memory.top());
        memory.pop();
        assertEquals(complex2, memory.top());
        memory.pop();
        assertEquals(complex1, memory.top());
        memory.pop();

        assertThrows(NoSuchElementException.class, () -> memory.top());
    }

    @Test
    public void testSize(){
        Memory memory=new Memory();
        ComplexNumber complex1=new ComplexNumber(5.0,10.0);
        ComplexNumber complex2=new ComplexNumber(-2.0,6.0);
        ComplexNumber complex3=new ComplexNumber(10.0,-2.0);
        ComplexNumber complex4=new ComplexNumber(14.5,0.0);
        ComplexNumber complex5=new ComplexNumber(0.0, -4.5);
        ComplexNumber complex6=new ComplexNumber(0.0, 0.0);

        memory.push(complex1);
        assertEquals(1,memory.size());
        memory.push(complex2);
        assertEquals(2,memory.size());
        memory.push(complex3);
        assertEquals(3,memory.size());
        memory.push(complex4);
        assertEquals(4,memory.size());
        memory.push(complex5);
        assertEquals(5,memory.size());
        memory.push(complex6);
        assertEquals(6,memory.size());

        memory.pop();
        assertEquals(5,memory.size());
        memory.pop();
        assertEquals(4,memory.size());
        memory.pop();
        assertEquals(3,memory.size());
        memory.pop();
        assertEquals(2,memory.size());
        memory.pop();
        assertEquals(1,memory.size());
        memory.pop();
        assertEquals(0,memory.size());
    }
    
    @Test public void testIsEmpty(){
        Memory memory=new Memory();
        ComplexNumber complex1=new ComplexNumber(5.0,10.0);

        assertEquals(true, memory.isEmpty());
        memory.push(complex1);
        assertEquals(false, memory.isEmpty());
        memory.pop();
        assertEquals(true, memory.isEmpty());
    }


    public static boolean assertArrayListEquals(List<ComplexNumber> expected, List<ComplexNumber> actual){
        Iterator<ComplexNumber> itr_actual=expected.iterator();
        Iterator<ComplexNumber> itr_expected=actual.iterator();
        if(expected.size()!=actual.size()){
            return false;
        }
        while(itr_actual.hasNext()){
            if(!itr_expected.hasNext()|| !(itr_actual.next().equals(itr_expected.next()))){
                return false;
            }
        }
        return true;
    }


    @Test
    public void testAsList(){
        Memory memory=new Memory();
        ComplexNumber complex1=new ComplexNumber(5.0,10.0);
        ComplexNumber complex2=new ComplexNumber(-2.0,6.0);
        ComplexNumber complex3=new ComplexNumber(10.0,-2.0);
        ComplexNumber complex4=new ComplexNumber(14.5,0.0);
        ComplexNumber complex5=new ComplexNumber(0.0, -4.5);
        ComplexNumber complex6=new ComplexNumber(0.0, 0.0);

        memory.push(complex1);
        memory.push(complex2);
        memory.push(complex3);
        memory.push(complex4);
        memory.push(complex5);
        memory.push(complex6);

        List<ComplexNumber> expected_array= new ArrayList<ComplexNumber>();
        
        
        assertTrue(assertArrayListEquals(expected_array, memory.asList(0)));

        expected_array.add(0, complex1);
        assertTrue(assertArrayListEquals(expected_array, memory.asList(1)));

        expected_array.add(0,complex2);
        assertTrue(assertArrayListEquals(expected_array, memory.asList(2)));

        expected_array.add(complex3);
        assertTrue(assertArrayListEquals(expected_array, memory.asList(3)));

        expected_array.add(complex4);
        assertTrue(assertArrayListEquals(expected_array, memory.asList(4)));

        expected_array.add(complex5);
        assertTrue(assertArrayListEquals(expected_array, memory.asList(5)));

        expected_array.add(complex6);
        assertTrue(assertArrayListEquals(expected_array, memory.asList(6)));

        
        assertTrue(assertArrayListEquals(expected_array, memory.asList(7)));
        
    }

    


}
