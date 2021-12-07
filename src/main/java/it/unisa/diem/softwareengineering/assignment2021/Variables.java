package it.unisa.diem.softwareengineering.assignment2021;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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


    public Iterator<ComplexNumber> variablesIterator() {
        List<Character> alphabet = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            alphabet.add(c);
        }
        List<ComplexNumber> variablesValues = new ArrayList<>();
        alphabet.forEach( (c) -> variablesValues.add(this.get(c)) );
        return variablesValues.iterator();
    }
    
    public ComplexNumber loadVariable(char variable) throws IllegalArgumentException{
        
        ComplexNumber x = this.get(variable);
        
        if(x!=null){
            return x;
        }else {  
           throw new IllegalArgumentException("The input variable doesn't exists!");
        }
}
    
    public void sumToVariable(char variable,ComplexNumber last) throws IllegalArgumentException{
        
        ComplexNumber x = this.get(variable);
        
        if(x==null){
            throw new IllegalArgumentException("The input variable doesn't exists!");
        }else {
            ComplexNumber result = ComplexOperations.sum(x, last);
            this.put(variable,result);        
        }
    }
    
    public void subFromVariable(char variable,ComplexNumber last) throws IllegalArgumentException{
        
        ComplexNumber x = this.get(variable);
        
        if(x==null){
            throw new IllegalArgumentException("The input variable doesn't exists!");
        }else {
            ComplexNumber result = ComplexOperations.sub(x,last);
            this.put(variable,result);
        }
    }


}
