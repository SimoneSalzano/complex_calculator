
import org.junit.jupiter.api.Test;

import it.unisa.diem.softwareengineering.assignment2021.PersonalizedOperationsMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;

import org.junit.jupiter.api.BeforeAll;


public class PersonalizedOperationsMapTest {

    @Test
    public void testGetPersonalizedOperationIterator(){
        PersonalizedOperationsMap map= new PersonalizedOperationsMap();
        map.put("1 operation","* dup + / -");
       

        Iterator<String> itr=map.getPersonalizedOperationIterator("1 operation");
        assertEquals("*", itr.next());
        assertEquals("dup", itr.next());
        assertEquals("+", itr.next());
        assertEquals("/", itr.next());
        assertEquals("-", itr.next());
    }

    @Test
    public void testGetMapIterator(){
        PersonalizedOperationsMap map= new PersonalizedOperationsMap();
        map.put("1 operation","* dup + / -");
        map.put("2 operation","* dup - / -");
        map.put("3 operation","* dup * / -");
        map.put("4 operation","* dup / / -");
        map.put("5 operation","* dup over / -");
        map.put("6 operation","* dup swap / -");
        Iterator<String> itr=map.getMapIterator();
       
        ArrayList<String> arrayCompare= new ArrayList<>();
        arrayCompare.add("1 operation:* dup + / -");
        arrayCompare.add("2 operation:* dup - / -");
        arrayCompare.add("3 operation:* dup * / -");
        arrayCompare.add("4 operation:* dup / / -");
        arrayCompare.add("5 operation:* dup over / -");
        arrayCompare.add("6 operation:* dup swap / -");
        
        
        for(int i=0;i<6 || itr.hasNext();i++){
            if(arrayCompare.contains(itr.next())){
                assertEquals(true, true);
            }else{
                assertEquals(false, true);
            }
        }
    }

    
}
