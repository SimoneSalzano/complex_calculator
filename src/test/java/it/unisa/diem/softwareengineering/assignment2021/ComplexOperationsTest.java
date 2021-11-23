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

        assertEquals(expected12,ComplexOperations.sum(complex1, complex2));
        assertEquals(expected13,ComplexOperations.sum(complex1, complex3));
        assertEquals(expected14,ComplexOperations.sum(complex1, complex4));
        assertEquals(expected15,ComplexOperations.sum(complex1, complex5));

        assertEquals(expected23,ComplexOperations.sum(complex2, complex3));
        assertEquals(expected24,ComplexOperations.sum(complex2, complex4));
        assertEquals(expected25,ComplexOperations.sum(complex2, complex5));

        assertEquals(expected34,ComplexOperations.sum(complex3, complex4));
        assertEquals(expected35,ComplexOperations.sum(complex3, complex5));

        assertEquals(expected45,ComplexOperations.sum(complex4, complex5));
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

        assertEquals(expected12,ComplexOperations.sub(complex1, complex2));
        assertEquals(expected13,ComplexOperations.sub(complex1, complex3));
        assertEquals(expected14,ComplexOperations.sub(complex1, complex4));
        assertEquals(expected15,ComplexOperations.sub(complex1, complex5));

        assertEquals(expected23,ComplexOperations.sub(complex2, complex3));
        assertEquals(expected24,ComplexOperations.sub(complex2, complex4));
        assertEquals(expected25,ComplexOperations.sub(complex2, complex5));

        assertEquals(expected34,ComplexOperations.sub(complex3, complex4));
        assertEquals(expected35,ComplexOperations.sub(complex3, complex5));

        assertEquals(expected45,ComplexOperations.sub(complex4, complex5));
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

        assertEquals(expected12, ComplexOperations.mul(complex1, complex2));
        assertEquals(expected13,ComplexOperations.mul(complex1, complex3));
        assertEquals(expected14,ComplexOperations.mul(complex1, complex4));
        assertEquals(expected15,ComplexOperations.mul(complex1, complex5));

        assertEquals(expected23,ComplexOperations.mul(complex2, complex3));
        assertEquals(expected24,ComplexOperations.mul(complex2, complex4));
        assertEquals(expected25,ComplexOperations.mul(complex2, complex5));

        assertEquals(expected34,ComplexOperations.mul(complex3, complex4));
        assertEquals(expected35,ComplexOperations.mul(complex3, complex5));

        assertEquals(expected45,ComplexOperations.mul(complex4, complex5));
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

        assertEquals(expected12,ComplexOperations.div(complex1, complex2));
        assertEquals(expected13,ComplexOperations.div(complex1, complex3));
        assertEquals(expected14,ComplexOperations.div(complex1, complex4));
        assertEquals(expected15,ComplexOperations.div(complex1, complex5));

        assertEquals(expected23,ComplexOperations.div(complex2, complex3));
        assertEquals(expected24,ComplexOperations.div(complex2, complex4));
        assertEquals(expected25,ComplexOperations.div(complex2, complex5));

        assertEquals(expected34,ComplexOperations.div(complex3, complex4));
        assertEquals(expected35,ComplexOperations.div(complex3, complex5));

        assertEquals(expected45,ComplexOperations.div(complex4, complex5));

        assertThrows(ArithmeticException.class, () -> ComplexOperations.div(complex1, complex6));

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
        double expected5=-1.571;

        assertEquals(expected1,Math.round(arg1*1000d)/1000d);
        assertEquals(expected2,Math.round(arg2*1000d)/1000d);
        assertEquals(expected3,Math.round(arg3*1000d)/1000d);
        assertEquals(expected4,Math.round(arg4*1000d)/1000d);
        assertEquals(expected5,Math.round(arg5*1000d)/1000d);
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

        assertEquals(expected1,Math.round(mod1*1000d)/1000d);
        assertEquals(expected2,Math.round(mod2*1000d)/1000d);
        assertEquals(expected3,Math.round(mod3*1000d)/1000d);
        assertEquals(expected4,Math.round(mod4*1000d)/1000d);
        assertEquals(expected5,Math.round(mod5*1000d)/1000d);
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

        assertEquals(expected1,complex1);
        assertEquals(expected2,complex2);
        assertEquals(expected3,complex3);
        assertEquals(expected4,complex4);
        assertEquals(complex5,expected5);
    }

    
}
