package it.unisa.diem.softwareengineering.assignment2021;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;

public class PersonalizedOperationsMap extends HashMap<String,String>{
    
    
    public Iterator<String> getPersonalizedOperationIterator(String key){
        String[] strings= this.get(key).split(" ");
        ArrayList<String> values= new ArrayList<>(Arrays.asList(strings));
        return values.iterator();
    }

    
    
}
