package it.unisa.diem.softwareengineering.assignment2021;

import java.util.Observable;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * A handler for the Variables class, which manages the current runtime variables and the old states
 * of the variables when the save and restore commands are called, by keeping them in a stack.
 * It extends Observable, so it can be observed by any class interested in keeping up to date with 
 * the state of the variables and their values.
 * @Author Dario Montervino
 */
public class VariablesHandler extends Observable{

    private Variables currentVariables;
    private Deque<Variables> stackVariables;

    /**
     * Initializes the variables handler, starting the stack of states and the current variables state.
     */
    public VariablesHandler(){
        currentVariables = new Variables();
        stackVariables = new ArrayDeque<>();
    }

    /**
     * Saves the current state of the variables and pushes it to the variables stack, then notifies observers.
     */
    public void save(){
        Variables mapToSave = new Variables();
        for (Map.Entry<Character, ComplexNumber> pair: currentVariables.entrySet()){
            mapToSave.put(pair.getKey(), pair.getValue());
        }
        stackVariables.push(mapToSave);
        setChanged();
        notifyObservers();
    }

    /**
     * restores the most recent state of the variables by popping it from the variables stack, then notifies the observers.
     * @throws NoSuchElementException when there are no states saved in the variables stack. 
     */
    public void restore() throws NoSuchElementException{
        if(stackVariables.isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            this.currentVariables=stackVariables.pop();
            setChanged();
        }
        notifyObservers();
    }

    /**
     * Clears the value of every current variable, by setting them to null, then notifies the observers. 
     */
    public void reset(){
        for(char c='a';c<='z';c++){
            currentVariables.put(c,null);
        }
        setChanged();
        notifyObservers();
    }

    /**
     * returns the value of every variable from the current variables set and the most recent saved state of the variables,
     * in a format like "variable:currentValue:oldValue".
     * @return said iterator.
     */
    public Iterator<String> getVariables(){
        List<String> listPairs = new ArrayList<>();
        Iterator<String> itrVariables = this.currentVariables.variablesIterator();
        
        
        while (itrVariables.hasNext()){
            String pair = itrVariables.next();
            Character key = pair.split(":")[0].charAt(0);
            if(stackVariables.isEmpty()){
                listPairs.add(pair+": ");
            }
            else{
                Variables oldMap = stackVariables.getFirst();
                ComplexNumber oldValue = oldMap.get(key);
                if(oldValue == null){
                    listPairs.add(pair+": ");
                }
                else{
                    listPairs.add(pair+":"+oldValue);
                }
            }
        }
        return listPairs.iterator();
    }

    /**
     * Loads a variable's value.
     * @param variable the variable's name.
     * @return the complex number stored into the variable.
     * @throws NoSuchElementException when the variable has no value yet.
     */
    public ComplexNumber load(Character variable) throws NoSuchElementException{
        ComplexNumber value = currentVariables.get(variable);
        if(value!=null){
            return value;
        }
        else{
            throw new NoSuchElementException("No value has been assigned to this variable yet!");
        }
    }

    /**
     * Stores a complex number into a variable, then notifies the observers.
     * @param variable the value in which the complex number will be stored.
     * @param value the value to store into the variable.
     */
    public void store(Character variable,ComplexNumber value){
        currentVariables.put(variable,value);
        setChanged();
        notifyObservers();
    }

    /**
     * Sums a complex number to a variable's value, then notifies the observers.
     * @param variable the variable to which its value will be summed with a complex number
     * @param cNumber the complex number to sum to a variable's value.
     * @throws NoSuchElementException when the variable has no value yet.
     */
    public void sumToVariable(char variable,ComplexNumber cNumber) throws NoSuchElementException{
        
        ComplexNumber x = currentVariables.get(variable);
        
        if(x==null){
            throw new NoSuchElementException("No value has been assigned to this variable yet!");
        }
        else {
            ComplexNumber result = ComplexOperations.sum(x, cNumber);
            currentVariables.put(variable,result);   
            setChanged();     
        }
        notifyObservers();
    }
    
    /**
     * Subtracts a complex number from a variable's value, then notifies the observers.
     * @param variable the variable to which its value will be subtracted with a complex number
     * @param cNumber the complex number to subtract from a variable's value.
     * @throws NoSuchElementException when the variable has no value yet.
     */
    public void subFromVariable(char variable,ComplexNumber cNumber) throws NoSuchElementException{
        
        ComplexNumber x = currentVariables.get(variable);
        
        if(x==null){
            throw new NoSuchElementException("No value has been assigned to this variable yet!");
        }
        else {
            ComplexNumber result = ComplexOperations.sub(x,cNumber);
            currentVariables.put(variable,result);
            setChanged();
        }
        notifyObservers();
    }
}
