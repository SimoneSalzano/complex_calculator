package it.unisa.diem.softwareengineering.assignment2021;
import java.util.*;



public class Memory {
    private Deque<ComplexNumber> stack;

    public Memory(){
        this.stack=new ArrayDeque<ComplexNumber>();
    }

    
    /** 
     * Remove the last element in the memory and return it (LIFO) 
     * @return ComplexNumber
     */
    public ComplexNumber pop(){
        return this.stack.pop();
    }

    
    /** Return the last element in the memory (LIFO)
     * @return ComplexNumber
     */
    public ComplexNumber top(){
        return this.stack.getFirst();
    }

    
    /** Insert an element in the memory
     * @param complex1
     */
    public void push(ComplexNumber complex1){
        this.stack.push(complex1);
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
     * Remove all the elements from the stacks
     */ 
    public void clear(){
        this.stack.removeAll(stack);
    }
    
    /**
     * Duplicate the last element in the stack
     * @throws NotEnoughOperatorsException
     */
    public void dup() throws NotEnoughOperatorsException{
        if(this.size()>=1){
            this.push(this.top());
        }
        else
            throw new NotEnoughOperatorsException("Drop requires one operand!");
    }
    /**
     * Delete the last element in the stack
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
     * Duplicate the penultimate element from the stack
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
     * Swap the last element and penultimate element
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



