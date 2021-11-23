package it.unisa.diem.softwareengineering.assignment2021;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ComplexOperationsTest {


    @Test
    public void testSum(){
        ComplexNumber complex1=new ComplexNumber(5.0,10.0);
        ComplexNumber complex2=new ComplexNumber(-2.0,6.0);
        ComplexNumber complex3=new ComplexNumber(10.0,-2.0);
        ComplexNumber complex4=new ComplexNumber(14.5,0.0);
        ComplexNumber complex5=new ComplexNumber(0.0, -4.5);

        ComplexNumber expected12=new ComplexNumber(3.0, 16.0);
        ComplexNumber expected13=new ComplexNumber(15.0, 8.0);
        ComplexNumber expected14=new ComplexNumber(19.5, 10.0);
        ComplexNumber expected15=new ComplexNumber(5.0, 5.5);

        ComplexNumber expected23=new ComplexNumber(8.0, 4.0);
        ComplexNumber expected24=new ComplexNumber(12.5, 6.0);
        ComplexNumber expected25=new ComplexNumber(-2.0, 1.5);

        
        ComplexNumber expected34=new ComplexNumber(24.5, -2.0);
        ComplexNumber expected35=new ComplexNumber(10.0, -6.5);

        ComplexNumber expected45=new ComplexNumber(14.5, -4.5);

        assertEquals(ComplexOperations.sum(complex1, complex2), expected12);
        assertEquals(ComplexOperations.sum(complex1, complex3), expected13);
        assertEquals(ComplexOperations.sum(complex1, complex4), expected14);
        assertEquals(ComplexOperations.sum(complex1, complex5), expected15);

        assertEquals(ComplexOperations.sum(complex2, complex3), expected23);
        assertEquals(ComplexOperations.sum(complex2, complex4), expected24);
        assertEquals(ComplexOperations.sum(complex2, complex5), expected25);

        assertEquals(ComplexOperations.sum(complex3, complex4), expected34);
        assertEquals(ComplexOperations.sum(complex3, complex5), expected35);

        assertEquals(ComplexOperations.sum(complex4, complex5), expected45);
    }

    @Test
    public void testSub(){
        ComplexNumber complex1=new ComplexNumber(5.0,10.0);
        ComplexNumber complex2=new ComplexNumber(-2.0,6.0);
        ComplexNumber complex3=new ComplexNumber(10.0,-2.0);
        ComplexNumber complex4=new ComplexNumber(14.5,0.0);
        ComplexNumber complex5=new ComplexNumber(0.0, -4.5);

        ComplexNumber expected12=new ComplexNumber(7.0, 4.0);
        ComplexNumber expected13=new ComplexNumber(-5.0, 12.0);
        ComplexNumber expected14=new ComplexNumber(-9.5, 10.0);
        ComplexNumber expected15=new ComplexNumber(5.0, 14.5);

        ComplexNumber expected23=new ComplexNumber(-12.0, 8.0);
        ComplexNumber expected24=new ComplexNumber(-16.5, 6.0);
        ComplexNumber expected25=new ComplexNumber(-2.0, 10.5);

        
        ComplexNumber expected34=new ComplexNumber(-4.5, -2.0);
        ComplexNumber expected35=new ComplexNumber(10.0, 2.5);

        ComplexNumber expected45=new ComplexNumber(14.5, 4.5);

        assertEquals(ComplexOperations.sub(complex1, complex2), expected12);
        assertEquals(ComplexOperations.sub(complex1, complex3), expected13);
        assertEquals(ComplexOperations.sub(complex1, complex4), expected14);
        assertEquals(ComplexOperations.sub(complex1, complex5), expected15);

        assertEquals(ComplexOperations.sub(complex2, complex3), expected23);
        assertEquals(ComplexOperations.sub(complex2, complex4), expected24);
        assertEquals(ComplexOperations.sub(complex2, complex5), expected25);

        assertEquals(ComplexOperations.sub(complex3, complex4), expected34);
        assertEquals(ComplexOperations.sub(complex3, complex5), expected35);

        assertEquals(ComplexOperations.sub(complex4, complex5), expected45);
    }

    @Test
    public void testMul(){
        ComplexNumber complex1=new ComplexNumber(5.0,10.0);
        ComplexNumber complex2=new ComplexNumber(-2.0,6.0);
        ComplexNumber complex3=new ComplexNumber(10.0,-2.0);
        ComplexNumber complex4=new ComplexNumber(14.5,0.0);
        ComplexNumber complex5=new ComplexNumber(0.0, -4.5);
    

        ComplexNumber expected12=new ComplexNumber(-70.0, 10.0);
        ComplexNumber expected13=new ComplexNumber(70.0, 90.0);
        ComplexNumber expected14=new ComplexNumber(72.5, 145.0);
        ComplexNumber expected15=new ComplexNumber(45.0, -22.5);

        ComplexNumber expected23=new ComplexNumber(-8.0, +64.0);
        ComplexNumber expected24=new ComplexNumber(-29.0, 87.0);
        ComplexNumber expected25=new ComplexNumber(27.0, 9.0);

        
        ComplexNumber expected34=new ComplexNumber(145.0, -29.0);
        ComplexNumber expected35=new ComplexNumber(-9.0, -45.0);

        ComplexNumber expected45=new ComplexNumber(0.0, -65.25);

        assertEquals(ComplexOperations.mul(complex1, complex2), expected12);
        assertEquals(ComplexOperations.mul(complex1, complex3), expected13);
        assertEquals(ComplexOperations.mul(complex1, complex4), expected14);
        assertEquals(ComplexOperations.mul(complex1, complex5), expected15);

        assertEquals(ComplexOperations.mul(complex2, complex3), expected23);
        assertEquals(ComplexOperations.mul(complex2, complex4), expected24);
        assertEquals(ComplexOperations.mul(complex2, complex5), expected25);

        assertEquals(ComplexOperations.mul(complex3, complex4), expected34);
        assertEquals(ComplexOperations.mul(complex3, complex5), expected35);

        assertEquals(ComplexOperations.mul(complex4, complex5), expected45);
    }

    @Test
    public void testDiv(){
        ComplexNumber complex1=new ComplexNumber(5.0,10.0);
        ComplexNumber complex2=new ComplexNumber(-2.0,6.0);
        ComplexNumber complex3=new ComplexNumber(10.0,-2.0);
        ComplexNumber complex4=new ComplexNumber(14.5,0.0);
        ComplexNumber complex5=new ComplexNumber(0.0, -4.5);
        ComplexNumber complex6=new ComplexNumber(0.0, 0.0);

        ComplexNumber expected12=new ComplexNumber(1.25, -1.25);
        ComplexNumber expected13=new ComplexNumber(0.288, 1.058);
        ComplexNumber expected14=new ComplexNumber(0.345, 0.690);
        ComplexNumber expected15=new ComplexNumber(-2.222, 1.111);

        ComplexNumber expected23=new ComplexNumber(-0.308, 0.538);
        ComplexNumber expected24=new ComplexNumber(-0.138, 0.414);
        ComplexNumber expected25=new ComplexNumber(-1.333, -0.444);

        
        ComplexNumber expected34=new ComplexNumber(0.690, -0.138);
        ComplexNumber expected35=new ComplexNumber(0.444, 2.222);

        ComplexNumber expected45=new ComplexNumber(0.0, 3.222);

        assertEquals(ComplexOperations.div(complex1, complex2), expected12);
        assertEquals(ComplexOperations.div(complex1, complex3), expected13);
        assertEquals(ComplexOperations.div(complex1, complex4), expected14);
        assertEquals(ComplexOperations.div(complex1, complex5), expected15);

        assertEquals(ComplexOperations.div(complex2, complex3), expected23);
        assertEquals(ComplexOperations.div(complex2, complex4), expected24);
        assertEquals(ComplexOperations.div(complex2, complex5), expected25);

        assertEquals(ComplexOperations.div(complex3, complex4), expected34);
        assertEquals(ComplexOperations.div(complex3, complex5), expected35);

        assertEquals(ComplexOperations.div(complex4, complex5), expected45);

        assertThrows(ArithmeticException)
    }

    @Test
    public void testArg(){
        double arg1=ComplexOperations.arg(new ComplexNumber(5.0,10.0));
        double arg2=ComplexOperations.arg(new ComplexNumber(-2.0,6.0));
        double arg3=ComplexOperations.arg(new ComplexNumber(10.0,-2.0));
        double arg4=ComplexOperations.arg(new ComplexNumber(14.5,0.0));
        double arg5=ComplexOperations.arg(new ComplexNumber(0.0, -4.5));

        double expected1=1.107;
        double expected2=1.893;
        double expected3=-0.197;
        double expected4=0;
        double expected5=4.712;

        assertEquals(Math.round(arg1*1000d)/1000d, expected1);
        assertEquals(Math.round(arg2*1000d)/1000d, expected2);
        assertEquals(Math.round(arg3*1000d)/1000d, expected3);
        assertEquals(Math.round(arg4*1000d)/1000d, expected4);
        assertEquals(Math.round(arg5*1000d)/1000d, expected5);
    }

    @Test
    public void testMod(){
        double mod1=ComplexOperations.mod(new ComplexNumber(5.0,10.0));
        double mod2=ComplexOperations.mod(new ComplexNumber(-2.0,6.0));
        double mod3=ComplexOperations.mod(new ComplexNumber(10.0,-2.0));
        double mod4=ComplexOperations.mod(new ComplexNumber(14.5,0.0));
        double mod5=ComplexOperations.mod(new ComplexNumber(0.0, -4.5));

        double expected1=11.180;
        double expected2=6.325;
        double expected3=10.198;
        double expected4=14.5;
        double expected5=4.5;

        assertEquals(Math.round(mod1*1000d)/1000d, expected1);
        assertEquals(Math.round(mod2*1000d)/1000d, expected2);
        assertEquals(Math.round(mod3*1000d)/1000d, expected3);
        assertEquals(Math.round(mod4*1000d)/1000d, expected4);
        assertEquals(Math.round(mod5*1000d)/1000d, expected5);
    }
    
    @Test
    public void testSqrt(){
        ComplexNumber complex1=ComplexOperations.sqrt(new ComplexNumber(5.0,10.0));
        ComplexNumber complex2=ComplexOperations.sqrt(new ComplexNumber(-2.0,6.0));
        ComplexNumber complex3=ComplexOperations.sqrt(new ComplexNumber(10.0,-2.0));
        ComplexNumber complex4=ComplexOperations.sqrt(new ComplexNumber(14.5,0.0));
        ComplexNumber complex5=ComplexOperations.sqrt(new ComplexNumber(0.0, -4.5));

        ComplexNumber expected1=new ComplexNumber(2.844, 1.758);
        ComplexNumber expected2=new ComplexNumber(1.470, 2.040);
        ComplexNumber expected3=new ComplexNumber(3.178, -0.315);
        ComplexNumber expected4=new ComplexNumber(3.808, 0.0);
        ComplexNumber expected5=new ComplexNumber(1.5, -1.5);

        assertEquals(complex1, expected1);
        assertEquals(complex2, expected2);
        assertEquals(complex3, expected3);
        assertEquals(complex4, expected4);
        assertEquals(expected5, complex5);
    }

    
}
