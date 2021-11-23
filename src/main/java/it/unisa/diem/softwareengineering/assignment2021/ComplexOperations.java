package it.unisa.diem.softwareengineering.assignment2021;
import java.lang.Math;
import java.lang.ArithmeticException;



public class ComplexOperations{
    
    public static ComplexNumber sum(ComplexNumber complex1, ComplexNumber complex2){
        double a=complex1.getReal();
        double b=complex1.getImm();

        double c=complex2.getReal();
        double d=complex2.getImm();

        double realTot=a+c;
        double immTot=b+d;

        ComplexNumber complexResult=new ComplexNumber(realTot, immTot);
        return complexResult;
    }
    
    public static ComplexNumber sub(ComplexNumber complex1, ComplexNumber complex2){
        double a=complex1.getReal();
        double b=complex1.getImm();

        double c=complex2.getReal();
        double d=complex2.getImm();

        double realTot=a-c;
        double immTot=b-d;

        ComplexNumber complexResult=new ComplexNumber(realTot, immTot);
        return complexResult;
    }

    public static ComplexNumber mul(ComplexNumber complex1, ComplexNumber complex2){
        double a=complex1.getReal();
        double b=complex1.getImm();

        double c=complex2.getReal();
        double d=complex2.getImm();
        //(a+bj)(c+dj)=ac-bd+j(da+bc)
        double realTot=a*c-b*d;
        double immTot=a*d+b*c;
        
        ComplexNumber complexResult=new ComplexNumber(realTot, immTot);
        return complexResult;
    }

    public static ComplexNumber div(ComplexNumber complex1, ComplexNumber complex2) throws ArithmeticException{
        double a=complex1.getReal();
        double b=complex1.getImm();

        double c=complex2.getReal();
        double d=complex2.getImm();
        //a+bj  c+dj
        //(ac+bd)/(c^2+d^2)+j(bc-ad)/(c^2+d^2)
        if((c*c+d*d)==0){
            throw new ArithmeticException("Divide by 0");
        }
        double realTot=(a*c+b*d)/(c*c+d*d);
        double immTot=(b*c-a*d)/(c*c+d*d);

        ComplexNumber complexResult=new ComplexNumber(realTot, immTot);
        return complexResult;
    }

    public static ComplexNumber inv(ComplexNumber complex1){
        double a=complex1.getReal();
        double b=complex1.getImm();

        double realTot=-a;
        double immTot=-b;

        ComplexNumber complexResult=new ComplexNumber(realTot, immTot);
        return complexResult;
    }

    public static ComplexNumber sqrt(ComplexNumber complex1, int index){
        double mod=mod(complex1);
        double arg=arg(complex1);

        double realTot=Math.pow(mod,1/2)*(Math.cos(arg/2));
        double immTot=Math.pow(mod,1/2)*(Math.sin(arg/2));
        ComplexNumber complexResult=new ComplexNumber(realTot, immTot);
        return complexResult;
    }

    public static double mod(ComplexNumber complex1){
        double a=complex1.getReal();
        double b=complex1.getImm();

        
        double mod=Math.sqrt(a*a+b*b);
        return mod;
    }

    public static double arg(ComplexNumber complex1) throws ArithmeticException{
        double a=complex1.getReal();
        double b=complex1.getImm();
        
        if(a==0 && b>0){
            return Math.PI/2;
        }
        if(a==0 && b<0){
            return -Math.PI/2;
        }
        if(a==0 && b==0){
            throw new ArithmeticException("Arg of 0 isn't defined");
        }
        if(a>0){
            return Math.atan(b/a);
        }
        if(a<0 && b>=0){
            return (Math.atan(b/a)+Math.PI);
        }
        //if(a<0 && b<0){
        return (Math.atan(b/a)-Math.PI);
    }


    
}
