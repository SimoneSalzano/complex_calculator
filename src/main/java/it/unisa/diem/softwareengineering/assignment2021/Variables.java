package it.unisa.diem.softwareengineering.assignment2021;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.List;

/**
 * A treemap that manages the variables the user can use to store and load variables from, which takes 
 * alphabetical lowercase characters as keys and ComplexNumber as values. 
 * @Author Simone Salzano
 */
public class Variables extends TreeMap<Character,ComplexNumber>{
    
    /**
     * Puts a complex number in the treemap, associated with a key that can only be an alphabetical lowercase character.
     * @param key an alphabetical lowercase character used as a key of this treemap.
     * @param value the complex number to store inside the treemap 
     * @return the value that has been put inside the treemap.
     * @throws IllegalArgumentException when the key is not a lowercase alphabetical character. 
     */
    @Override
    public ComplexNumber put(Character key, ComplexNumber value) throws IllegalArgumentException{
        if (Character.isLowerCase(key)) {
            super.put(key, value);
        }
        else
            throw new IllegalArgumentException("The variable must be a lowercase letter!");
        return value;
    }

    /**
     * Iterates over the treemap in a sorted way, showing the variables from a to z.
     * @return the sorted iterator, in which every element has the format "x:value" where 
     * x is the variable name and value is the string representation of a complex number.
     */
    public Iterator<String> variablesIterator() {
        List<String> listPairs = new ArrayList<>();
        for (char key='a'; key<='z'; key++){
            ComplexNumber value = this.get(key);
            if(value == null){
                listPairs.add(key+": ");
            }
            else{
                listPairs.add(key+":"+value);
            }
        }
        return listPairs.iterator();
    }
    
    


}
