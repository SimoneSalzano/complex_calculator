package it.unisa.diem.softwareengineering.assignment2021;

import java.util.Observable;

import javax.swing.plaf.synth.SynthEditorPaneUI;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class VariablesHandler extends Observable{

    private Variables currentVariables;
    private Deque<Variables> stackVariables;

    public VariablesHandler(){
        currentVariables = new Variables();
        stackVariables = new ArrayDeque<>();
    }

    public void save(){
        stackVariables.push(currentVariables);
        setChanged();
        notifyObservers();
    }

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

    public void reset(){
        for(char c='a';c<='z';c++){
            currentVariables.put(c,null);
        }
        setChanged();
        notifyObservers();
    }

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

    public ComplexNumber load(Character key) throws NoSuchElementException{
        ComplexNumber value = currentVariables.get(key);
        if(value!=null){
            return value;
        }
        else{
            throw new NoSuchElementException("No value has been assigned to this variable yet!");
        }
    }

    public void store(Character key,ComplexNumber value){
        currentVariables.put(key,value);
        setChanged();
        notifyObservers();
    }

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
