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

    
    /** Return a sublist of n element
     * @param n  
     * @return List<ComplexNumber>
     */
    public List<ComplexNumber> asList(int n){
        Iterator<ComplexNumber> itr=this.stack.iterator();
        List<ComplexNumber> list_temp=new ArrayList<ComplexNumber>();
        for(int i=0;i<n && itr.hasNext();i++){
            list_temp.add(itr.next());
        }
        return list_temp;
    }
}

