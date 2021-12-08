package it.unisa.diem.softwareengineering.assignment2021;
import java.util.*;


/** 
 * A stack that manages complex numbers, which can be observed.
 * It extends Observable, so it can be observed by any class interested in keeping up to date with 
 * the state of the memory.
 * @Authors  Simone Salzano, Michele Spremulli, Dario Montervino 
 */
public class Memory extends Observable{
    private Deque<ComplexNumber> stack;

    public Memory(){
        this.stack=new ArrayDeque<ComplexNumber>();
    }

    
    /** 
     * Remove the last element in the memory and return it (LIFO), then notify observers.
     * @return ComplexNumber
     */
    public ComplexNumber pop(){
        ComplexNumber poppedValue = this.stack.pop();
        setChanged();
        notifyObservers();
        return poppedValue;
    }

    
    /** Return the last element in the memory (LIFO)
     * @return ComplexNumber
     */
    public ComplexNumber top(){
        return this.stack.getFirst();
    }

    
    /** Insert an element in the memory, then notifies the observers
     * @param complex1
     */
    public void push(ComplexNumber complex1){
        this.stack.push(complex1);
        setChanged();
        notifyObservers();
    }

    
    /** Return the number of the elements memorized
     * @return int
     */
    public int size(){
        return this.stack.size();
    }
    
    
    /** Return true if the memory is empty, false if not
     * @return boolean
     */
    public boolean isEmpty(){
        return this.stack.size()==0;
    }

    
    /** Return an iterator of the stack
     * @param n  
     * @return List<ComplexNumber>
     */
    public Iterator<ComplexNumber> getIterator(){
        Iterator<ComplexNumber> itr=this.stack.iterator();
        return itr;
    }
    
    /**
     * Remove all the elements from the stacks, then notifies the observers
     */ 
    public void clear(){
        this.stack.removeAll(stack);
        setChanged();
        notifyObservers();
    }
    
    /**
     * Duplicate the last element in the stack, then notifies the observers
     * @throws NotEnoughOperatorsException
     */
    public void dup() throws NotEnoughOperatorsException{
        if(this.size()>=1){
            this.push(this.top());
        }
        else
            throw new NotEnoughOperatorsException("Drop requires one operand!");
        notifyObservers();
    }
    /**
     * Delete the last element in the stack, then notifies the observers
     * @throws NotEnoughOperatorsException
     */
    public void drop() throws NotEnoughOperatorsException{
        if(this.size()>=1){
            this.pop();
        }
        else
            throw new NotEnoughOperatorsException("Drop requires one operand!");
    }
    /**
     * Duplicate the penultimate element from the stack, then notifies the observers
     * @throws NotEnoughOperatorsException
     */
    public void over() throws NotEnoughOperatorsException{
        if(this.size()>=2){
            ComplexNumber last = this.pop();
            ComplexNumber penultimate = this.pop();
            this.push(penultimate);
            this.push(last);
            this.push(penultimate);
        }
        else
            throw new NotEnoughOperatorsException("Swap requires two operands!");
    }
    /**
     * Swap the last element and penultimate element, then notifies the observers
     * @throws NotEnoughOperatorsException
     */
    public void swap() throws NotEnoughOperatorsException{
        if(this.size()>=2){
            ComplexNumber last = this.pop();
            ComplexNumber penultimate = this.pop();
            this.push(last);
            this.push(penultimate);
        }
        else
            throw new NotEnoughOperatorsException("Swap requires two operands!");
    }
}



