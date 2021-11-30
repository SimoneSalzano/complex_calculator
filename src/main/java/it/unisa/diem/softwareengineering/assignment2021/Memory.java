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
     */
    public void dup(){
        if(this.size()>=1){
            this.push(this.top());
        }
    }
    /**
     * Delete the last element in the stack
     */
    public void drop(){
        if(this.size()>=1){
            this.pop();
        }
    }
    /**
     * Duplicate the penultimate element from the stack
     */
    public void over(){
        if(this.size()>=2){
            ComplexNumber last = this.pop();
            ComplexNumber penultimate = this.pop();
            this.push(penultimate);
            this.push(last);
            this.push(penultimate);
        }
    }
    /**
     * Swap the last element and penultimate element
     */
    public void swap(){
        if(this.size()>=2){
            ComplexNumber last = this.pop();
            ComplexNumber penultimate = this.pop();
            this.push(last);
            this.push(penultimate);
        }
    }
}



