package it.unisa.diem.softwareengineering.assignment2021;
import java.util.*;

public class Memory {
    private Deque<ComplexNumber> stack;

    public Memory(){
        this.stack=new ArrayDeque<ComplexNumber>();
    }

    public ComplexNumber pop(){
        return this.stack.pop();
    }

    public ComplexNumber top(){
        return this.stack.getLast();
    }

    public void push(ComplexNumber complex1){
        this.stack.push(complex1);
    }

    public int size(){
        return this.stack.size();
    }
    
    public boolean isEmpty(){
        return this.stack.size()==0;
    }

    public List<ComplexNumber> asList(int n){
        Iterator<ComplexNumber> itr=this.stack.descendingIterator();
        List<ComplexNumber> list_temp=new ArrayList<ComplexNumber>();
        for(int i=0;i<n && itr.hasNext();i++){
            list_temp.add(itr.next());
        }
        return list_temp;
    }
    


}

