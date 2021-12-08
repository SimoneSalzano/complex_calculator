package it.unisa.diem.softwareengineering.assignment2021;
import java.lang.Math;
import java.lang.ArithmeticException;



public class ComplexOperations{
    

    
    /**
     * Return the sum between two complex numbers
     * @param complex1
     * @param complex2
     * @return ComplexNumber
     */
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
    
    
    /** 
     * Return the subtraction between two complex numbers
     * @param complex1  first operand
     * @param complex2  second operand
     * @return ComplexNumber
     */
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

    
    /** 
     * Return the multiplication between two complex numbers
     * @param complex1
     * @param complex2
     * @return ComplexNumber
     */
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

    
    /**  
     * Return the division between two complex numbers
     * @param complex1  first operan
     * @param complex2  second operan
     * @return ComplexNumber    
     * @throws ArithmeticException Throws exceptio if second operand is 0 (Division by 0)
     */
    public static ComplexNumber div(ComplexNumber complex1, ComplexNumber complex2) throws ArithmeticException{
        double a=complex1.getReal();
        double b=complex1.getImm();

        double c=complex2.getReal();
        double d=complex2.getImm();
        //a+bj  c+dj
        //(ac+bd)/(c^2+d^2)+j(bc-ad)/(c^2+d^2)
        if((c*c+d*d)==0){
            throw new ArithmeticException("Division by 0");
        }
        double realTot=(a*c+b*d)/(c*c+d*d);
        double immTot=(b*c-a*d)/(c*c+d*d);

        ComplexNumber complexResult=new ComplexNumber(realTot, immTot);
        return complexResult;
    }

    
    /** 
     * Return the negative complex number
     * @param complex1
     * @return ComplexNumber
     */
    public static ComplexNumber inv(ComplexNumber complex1){
        double a=complex1.getReal();
        double b=complex1.getImm();

        double realTot=-a;
        double immTot=-b;

        ComplexNumber complexResult=new ComplexNumber(realTot, immTot);
        return complexResult;
    }
    
    /** 
     * Return the square root of a complex number. The solution is calculated assuming k=0
     * @param complex1
     * @return ComplexNumber
     */
    public static ComplexNumber sqrt(ComplexNumber complex1){
        double mod=mod(complex1);
        double arg=arg(complex1);
        double realTot=Math.round((Math.sqrt(mod)*Math.cos(arg/2))*1000d)/1000d;
        double immTot=Math.round((Math.sqrt(mod)*Math.sin(arg/2))*1000d)/1000d;
        ComplexNumber complexResult=new ComplexNumber(realTot, immTot);
        return complexResult;
    }

    
    /** 
     * return the magnitude of a complex number
     * @param complex1
     * @return double
     */
    public static double mod(ComplexNumber complex1){
        double a=complex1.getReal();
        double b=complex1.getImm();

        double mod=Math.sqrt(a*a+b*b);
        return mod;
    }

    
    /** 
     * return the argument of a complex number
     * @param complex1
     * @return double
     * @throws ArithmeticException
     */
    public static double arg(ComplexNumber complex1) throws ArithmeticException{
        double a=complex1.getReal();
        double b=complex1.getImm();
        
        if(a==0 && b>0){
            return (Math.PI/2*1000d);
        }
        if(a==0 && b<0){
            return (-Math.PI/2);
        }
        if(a==0 && b==0){
            throw new ArithmeticException("Arg of 0 isn't defined");
        }
        if(a<0 && b>=0){
            return (Math.atan(b/a)+Math.PI);
        }
        if(a<0 && b<0){
            return (Math.atan(b/a)-Math.PI);
        } 
        
        return (Math.atan(b/a));
    }
    /**
     * Return the power of a complex number, where the base is the first parameter and the exponent is the second parameter.
     * @param complex1
     * @param exponent
     * @return ComplexNumber
     */
    
    public static ComplexNumber pow(ComplexNumber complex1,ComplexNumber exponent){
        if(exponent.getImm()==0){  
            if(complex1.getImm()==0 && complex1.getReal()==0){
                throw new ArithmeticException("Can't compute the power of a complex number with both real and immaginary parts equal to 0") ;      
            }else {
            double realExponent = exponent.getReal();
            double module = ComplexOperations.mod(complex1);
            double phase= ComplexOperations.arg(complex1);           
            module = Math.pow(module, realExponent); 
            phase = phase * realExponent;
                
            double real = module * Math.cos(phase);
            double imm = module * Math.sin(phase);
                
            return new ComplexNumber(real,imm);
            }
        }else {
            throw new IllegalArgumentException("The exponent is a complex number. It must be a real number!");
        }
    }
    /**
     * Return the exponential value of the input complex number.
     * @param complex
     * @return ComplexNumber
     */
    
    public static ComplexNumber exp(ComplexNumber complex){
        double real = complex.getReal();
        double imm = complex.getImm();
        double exponent= Math.E;
        
        double exp_real = Math.pow(exponent,real)*Math.cos(imm);
        double exp_imm = Math.pow(exponent, real)*Math.sin(imm);
        
        return new ComplexNumber(exp_real,exp_imm);   
    }

    
}
