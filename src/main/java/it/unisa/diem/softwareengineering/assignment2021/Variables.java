package it.unisa.diem.softwareengineering.assignment2021;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Variables extends HashMap<Character,ComplexNumber>{
    
    @Override
    public ComplexNumber put(Character key, ComplexNumber value) throws IllegalArgumentException{
        if (Character.isLowerCase(key)) {
            super.put(key, value);
        }
        else
            throw new IllegalArgumentException("The variable must be a lowercase letter!");
        return value;
    }


    public List<ComplexNumber> variablesIterator() {
        List<Character> alphabet = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            alphabet.add(c);
        }
        List<ComplexNumber> variablesValues = new ArrayList<>();
        alphabet.forEach( (c) -> variablesValues.add(this.get(c)) );
        return variablesIterator();
    }


}
