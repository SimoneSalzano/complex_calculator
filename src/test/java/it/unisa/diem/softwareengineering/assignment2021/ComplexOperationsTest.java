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
        ComplexNumber complex6=new ComplexNumber(-3.0, -5.0);
        ComplexNumber complex7=new ComplexNumber(0.0, 0.0);

        ComplexNumber expected12=new ComplexNumber(3.0, 16.0);
        ComplexNumber expected13=new ComplexNumber(15.0, 8.0);
        ComplexNumber expected14=new ComplexNumber(19.5, 10.0);
        ComplexNumber expected15=new ComplexNumber(5.0, 5.5);
        ComplexNumber expected16=new ComplexNumber(2.0, 5.0);
        ComplexNumber expected17=new ComplexNumber(5.0, 10.0);

        ComplexNumber expected23=new ComplexNumber(8.0, 4.0);
        ComplexNumber expected24=new ComplexNumber(12.5, 6.0);
        ComplexNumber expected25=new ComplexNumber(-2.0, 1.5);
        ComplexNumber expected26=new ComplexNumber(-5.0, 1.0);
        ComplexNumber expected27=new ComplexNumber(-2.0, 6.0);

        
        ComplexNumber expected34=new ComplexNumber(24.5, -2.0);
        ComplexNumber expected35=new ComplexNumber(10.0, -6.5);
        ComplexNumber expected36=new ComplexNumber(7.0, -7.0);
        ComplexNumber expected37=new ComplexNumber(10.0, -2.0);

        ComplexNumber expected45=new ComplexNumber(14.5, -4.5);
        ComplexNumber expected46=new ComplexNumber(11.5, -5.0);
        ComplexNumber expected47=new ComplexNumber(14.5, 0.0);

        ComplexNumber expected56=new ComplexNumber(-3.0, -9.5);
        ComplexNumber expected57= new ComplexNumber(0.0, -4.5);

        ComplexNumber expected67=new ComplexNumber(-3.0, -5.0);

        assertEquals(expected12,ComplexOperations.sum(complex1, complex2));
        assertEquals(expected13,ComplexOperations.sum(complex1, complex3));
        assertEquals(expected14,ComplexOperations.sum(complex1, complex4));
        assertEquals(expected15,ComplexOperations.sum(complex1, complex5));
        assertEquals(expected16,ComplexOperations.sum(complex1, complex6));
        assertEquals(expected17,ComplexOperations.sum(complex1, complex7));
        
        assertEquals(expected23,ComplexOperations.sum(complex2, complex3));
        assertEquals(expected24,ComplexOperations.sum(complex2, complex4));
        assertEquals(expected25,ComplexOperations.sum(complex2, complex5));
        assertEquals(expected26,ComplexOperations.sum(complex2, complex6));
        assertEquals(expected27,ComplexOperations.sum(complex2, complex7));

        assertEquals(expected34,ComplexOperations.sum(complex3, complex4));
        assertEquals(expected35,ComplexOperations.sum(complex3, complex5));
        assertEquals(expected36,ComplexOperations.sum(complex3, complex6));
        assertEquals(expected37,ComplexOperations.sum(complex3, complex7));

        assertEquals(expected45,ComplexOperations.sum(complex4, complex5));
        assertEquals(expected46,ComplexOperations.sum(complex4, complex6));
        assertEquals(expected47,ComplexOperations.sum(complex4, complex7));

        assertEquals(expected56,ComplexOperations.sum(complex5, complex6));
        assertEquals(expected57,ComplexOperations.sum(complex5, complex7));
        
        assertEquals(expected67,ComplexOperations.sum(complex6, complex7));
    }

    @Test
    public void testSub(){
        ComplexNumber complex1=new ComplexNumber(5.0,10.0);
        ComplexNumber complex2=new ComplexNumber(-2.0,6.0);
        ComplexNumber complex3=new ComplexNumber(10.0,-2.0);
        ComplexNumber complex4=new ComplexNumber(14.5,0.0);
        ComplexNumber complex5=new ComplexNumber(0.0, -4.5);
        ComplexNumber complex6=new ComplexNumber(-3.0, -5.0);
        ComplexNumber complex7=new ComplexNumber(0.0, 0.0);

        ComplexNumber expected12=new ComplexNumber(7.0, 4.0);
        ComplexNumber expected13=new ComplexNumber(-5.0, 12.0);
        ComplexNumber expected14=new ComplexNumber(-9.5, 10.0);
        ComplexNumber expected15=new ComplexNumber(5.0, 14.5);
        ComplexNumber expected16=new ComplexNumber(8.0, 15.0);
        ComplexNumber expected17=new ComplexNumber(5.0, 10.0);

        ComplexNumber expected23=new ComplexNumber(-12.0, 8.0);
        ComplexNumber expected24=new ComplexNumber(-16.5, 6.0);
        ComplexNumber expected25=new ComplexNumber(-2.0, 10.5);
        ComplexNumber expected26=new ComplexNumber(1.0, 11.0);
        ComplexNumber expected27=new ComplexNumber(-2.0, 6.0);

        
        ComplexNumber expected34=new ComplexNumber(-4.5, -2.0);
        ComplexNumber expected35=new ComplexNumber(10.0, 2.5);
        ComplexNumber expected36=new ComplexNumber(13.0, 3.0);
        ComplexNumber expected37=new ComplexNumber(10.0, -2.0);

        ComplexNumber expected45=new ComplexNumber(14.5, 4.5);
        ComplexNumber expected46=new ComplexNumber(17.5, 5.0);
        ComplexNumber expected47=new ComplexNumber(14.5, 0.0);

        ComplexNumber expected56=new ComplexNumber(3.0, 0.5);
        ComplexNumber expected57=new ComplexNumber(0.0, -4.5);

        ComplexNumber expected67=new ComplexNumber(-3.0, -5.0);


        assertEquals(expected12,ComplexOperations.sub(complex1, complex2));
        assertEquals(expected13,ComplexOperations.sub(complex1, complex3));
        assertEquals(expected14,ComplexOperations.sub(complex1, complex4));
        assertEquals(expected15,ComplexOperations.sub(complex1, complex5));
        assertEquals(expected16,ComplexOperations.sub(complex1, complex6));
        assertEquals(expected17,ComplexOperations.sub(complex1, complex7));

        assertEquals(expected23,ComplexOperations.sub(complex2, complex3));
        assertEquals(expected24,ComplexOperations.sub(complex2, complex4));
        assertEquals(expected25,ComplexOperations.sub(complex2, complex5));
        assertEquals(expected26,ComplexOperations.sub(complex2, complex6));
        assertEquals(expected27,ComplexOperations.sub(complex2, complex7));

        assertEquals(expected34,ComplexOperations.sub(complex3, complex4));
        assertEquals(expected35,ComplexOperations.sub(complex3, complex5));
        assertEquals(expected36,ComplexOperations.sub(complex3, complex6));
        assertEquals(expected37,ComplexOperations.sub(complex3, complex7));

        assertEquals(expected45,ComplexOperations.sub(complex4, complex5));
        assertEquals(expected46,ComplexOperations.sub(complex4, complex6));
        assertEquals(expected47,ComplexOperations.sub(complex4, complex7));
        
        assertEquals(expected56,ComplexOperations.sub(complex5, complex6));
        assertEquals(expected57,ComplexOperations.sub(complex5, complex7));

        assertEquals(expected67,ComplexOperations.sub(complex6, complex7));
    }

    @Test
    public void testMul(){
        ComplexNumber complex1=new ComplexNumber(5.0,10.0);
        ComplexNumber complex2=new ComplexNumber(-2.0,6.0);
        ComplexNumber complex3=new ComplexNumber(10.0,-2.0);
        ComplexNumber complex4=new ComplexNumber(14.5,0.0);
        ComplexNumber complex5=new ComplexNumber(0.0, -4.5);
        ComplexNumber complex6=new ComplexNumber(-3.0, -5.0);
        ComplexNumber complex7=new ComplexNumber(0.0, 0.0);

    
        ComplexNumber expected12=new ComplexNumber(-70.0, 10.0);
        ComplexNumber expected13=new ComplexNumber(70.0, 90.0);
        ComplexNumber expected14=new ComplexNumber(72.5, 145.0);
        ComplexNumber expected15=new ComplexNumber(45.0, -22.5);
        ComplexNumber expected16=new ComplexNumber(35.0, -55.0);
        ComplexNumber expected17=new ComplexNumber(0.0, 0.0);

        ComplexNumber expected23=new ComplexNumber(-8.0, +64.0);
        ComplexNumber expected24=new ComplexNumber(-29.0, 87.0);
        ComplexNumber expected25=new ComplexNumber(27.0, 9.0);
        ComplexNumber expected26=new ComplexNumber(36.0, -8.0);
        ComplexNumber expected27=new ComplexNumber(-0.0, 0.0);
        
        ComplexNumber expected34=new ComplexNumber(145.0, -29.0);
        ComplexNumber expected35=new ComplexNumber(-9.0, -45.0);
        ComplexNumber expected36=new ComplexNumber(-40.0, -44.0);
        ComplexNumber expected37=new ComplexNumber(0.0, 0.0);

        ComplexNumber expected45=new ComplexNumber(0.0, -65.25);
        ComplexNumber expected46=new ComplexNumber(-43.5, -72.5);
        ComplexNumber expected47=new ComplexNumber(0.0, 0.0);

        ComplexNumber expected56=new ComplexNumber(-22.5, 13.5);
        ComplexNumber expected57=new ComplexNumber(0.0, 0.0);

        ComplexNumber expected67=new ComplexNumber(0.0, -0.0);

        assertEquals(expected12, ComplexOperations.mul(complex1, complex2));
        assertEquals(expected13,ComplexOperations.mul(complex1, complex3));
        assertEquals(expected14,ComplexOperations.mul(complex1, complex4));
        assertEquals(expected15,ComplexOperations.mul(complex1, complex5));
        assertEquals(expected16,ComplexOperations.mul(complex1, complex6));
        assertEquals(expected17,ComplexOperations.mul(complex1, complex7));

        assertEquals(expected23,ComplexOperations.mul(complex2, complex3));
        assertEquals(expected24,ComplexOperations.mul(complex2, complex4));
        assertEquals(expected25,ComplexOperations.mul(complex2, complex5));
        assertEquals(expected26,ComplexOperations.mul(complex2, complex6));
        assertEquals(expected27,ComplexOperations.mul(complex2, complex7));

        assertEquals(expected34,ComplexOperations.mul(complex3, complex4));
        assertEquals(expected35,ComplexOperations.mul(complex3, complex5));
        assertEquals(expected36,ComplexOperations.mul(complex3, complex6));
        assertEquals(expected37,ComplexOperations.mul(complex3, complex7));

        assertEquals(expected45,ComplexOperations.mul(complex4, complex5));
        assertEquals(expected46,ComplexOperations.mul(complex4, complex6));
        assertEquals(expected47,ComplexOperations.mul(complex4, complex7));

        assertEquals(expected56,ComplexOperations.mul(complex5, complex6));
        assertEquals(expected57,ComplexOperations.mul(complex5, complex7));

        assertEquals(expected67,ComplexOperations.mul(complex6, complex7));
    }

    @Test
    public void testDiv(){
        ComplexNumber complex1=new ComplexNumber(5.0,10.0);
        ComplexNumber complex2=new ComplexNumber(-2.0,6.0);
        ComplexNumber complex3=new ComplexNumber(10.0,-2.0);
        ComplexNumber complex4=new ComplexNumber(14.5,0.0);
        ComplexNumber complex5=new ComplexNumber(0.0, -4.5);
        ComplexNumber complex6=new ComplexNumber(-3.0, -5.0);
        ComplexNumber complex7=new ComplexNumber(0.0, 0.0);

        ComplexNumber expected12=new ComplexNumber(1.25, -1.25);
        ComplexNumber expected13=new ComplexNumber(0.288, 1.058);
        ComplexNumber expected14=new ComplexNumber(0.345, 0.690);
        ComplexNumber expected15=new ComplexNumber(-2.222, 1.111);
        ComplexNumber expected16=new ComplexNumber(-1.912, -0.147);

        ComplexNumber expected23=new ComplexNumber(-0.308, 0.538);
        ComplexNumber expected24=new ComplexNumber(-0.138, 0.414);
        ComplexNumber expected25=new ComplexNumber(-1.333, -0.444);
        ComplexNumber expected26=new ComplexNumber(-0.706, -0.824);

        
        ComplexNumber expected34=new ComplexNumber(0.690, -0.138);
        ComplexNumber expected35=new ComplexNumber(0.444, 2.222);
        ComplexNumber expected36=new ComplexNumber(-0.588, 1.647);

        ComplexNumber expected45=new ComplexNumber(0.0, 3.222);
        ComplexNumber expected46=new ComplexNumber(-1.279, 2.132);
        
        ComplexNumber expected56=new ComplexNumber(0.662, 0.397);

        
        assertEquals(expected12,round3(ComplexOperations.div(complex1,complex2)));
        assertEquals(expected13,round3(ComplexOperations.div(complex1,complex3)));
        assertEquals(expected14,round3(ComplexOperations.div(complex1,complex4)));
        assertEquals(expected15,round3(ComplexOperations.div(complex1,complex5)));
        assertEquals(expected16,round3(ComplexOperations.div(complex1,complex6)));

        assertEquals(expected23,round3(ComplexOperations.div(complex2,complex3)));
        assertEquals(expected24,round3(ComplexOperations.div(complex2,complex4)));
        assertEquals(expected25,round3(ComplexOperations.div(complex2,complex5)));
        assertEquals(expected26,round3(ComplexOperations.div(complex2,complex6)));

        assertEquals(expected34,round3(ComplexOperations.div(complex3,complex4)));
        assertEquals(expected35,round3(ComplexOperations.div(complex3,complex5)));
        assertEquals(expected36,round3(ComplexOperations.div(complex3,complex6)));

        assertEquals(expected45,round3(ComplexOperations.div(complex4,complex5)));
        assertEquals(expected46,round3(ComplexOperations.div(complex4,complex6)));

        assertEquals(expected56,round3(ComplexOperations.div(complex5,complex6)));

        assertThrows(ArithmeticException.class, () -> ComplexOperations.div(complex1, complex7));

    }


    private ComplexNumber round3(ComplexNumber complex1){
        return new ComplexNumber(Math.round(complex1.getReal()*1000d)/1000d, Math.round(complex1.getImm()*1000d)/1000d);
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
        ComplexNumber complex1=round3(ComplexOperations.sqrt(new ComplexNumber(5.0,10.0)));
        ComplexNumber complex2=round3(ComplexOperations.sqrt(new ComplexNumber(-2.0,6.0)));
        ComplexNumber complex3=round3(ComplexOperations.sqrt(new ComplexNumber(10.0,-2.0)));
        ComplexNumber complex4=round3(ComplexOperations.sqrt(new ComplexNumber(14.5,0.0)));
        ComplexNumber complex5=round3(ComplexOperations.sqrt(new ComplexNumber(0.0, -4.5)));
        ComplexNumber complex6=round3(ComplexOperations.sqrt(new ComplexNumber(-3.0, -4.5)));


        ComplexNumber expected1=new ComplexNumber(2.844, 1.758);
        ComplexNumber expected2=new ComplexNumber(1.470, 2.040);
        ComplexNumber expected3=new ComplexNumber(3.178, -0.315);
        ComplexNumber expected4=new ComplexNumber(3.808, 0.0);
        ComplexNumber expected5=new ComplexNumber(1.5, -1.5);
        ComplexNumber expected6=new ComplexNumber(1.097, -2.050);

        assertEquals(expected1,complex1);
        assertEquals(expected2,complex2);
        assertEquals(expected3,complex3);
        assertEquals(expected4,complex4);
        assertEquals(complex5,expected5);
        assertEquals(complex6,expected6);
    }
    
    @Test
    public void testPow(){
        
        ComplexNumber complex1 = new ComplexNumber(0.0,0.0);
        ComplexNumber complex2 = new ComplexNumber(-3.0,-5.0);
        ComplexNumber complex3 = new ComplexNumber(-7.5,3.0);
        ComplexNumber complex4 = new ComplexNumber(8.3,-1.5);
        ComplexNumber complex5 = new ComplexNumber(4.0,3.2);
        
        ComplexNumber result21 = ComplexOperations.pow(complex2, new ComplexNumber(0.0,0.0));
        ComplexNumber result22 = ComplexOperations.pow(complex2, new ComplexNumber(5.0,0.0));
        ComplexNumber result23 = ComplexOperations.pow(complex2, new ComplexNumber(-3.0,0.0));
        ComplexNumber result24 = ComplexOperations.pow(complex2, new ComplexNumber(1.0,0.0));
        
        ComplexNumber result31 = ComplexOperations.pow(complex3, new ComplexNumber(-4.0,0.0));
        ComplexNumber result32 = ComplexOperations.pow(complex3, new ComplexNumber(2.0,0.0));
        ComplexNumber result33 = ComplexOperations.pow(complex3, new ComplexNumber(0.0,0.0));
        ComplexNumber result34 = ComplexOperations.pow(complex3, new ComplexNumber(-2.0,0.0));
        
        ComplexNumber result41 = ComplexOperations.pow(complex4, new ComplexNumber(0.0,0.0));
        ComplexNumber result42 = ComplexOperations.pow(complex4, new ComplexNumber(-2.0,0.0));
        ComplexNumber result43 = ComplexOperations.pow(complex4, new ComplexNumber(4.0,0.0));
        ComplexNumber result44 = ComplexOperations.pow(complex4, new ComplexNumber(2.5,0.0));
        
        ComplexNumber result51 = ComplexOperations.pow(complex5, new ComplexNumber(0.0,0.0));
        ComplexNumber result52 = ComplexOperations.pow(complex5, new ComplexNumber(3.0,0.0));
        ComplexNumber result53 = ComplexOperations.pow(complex5, new ComplexNumber(-4.0,0.0));
        ComplexNumber result54 = ComplexOperations.pow(complex5, new ComplexNumber(5.7,0.0));
                 
        ComplexNumber expected21 = new ComplexNumber(1.000,0.000);
        ComplexNumber expected22 = new ComplexNumber(-2868.000,6100.000);
        ComplexNumber expected23 = new ComplexNumber(0.005,0.000);
        ComplexNumber expected24 = new ComplexNumber(-3.0,-5.0);
        
        ComplexNumber expected31 = new ComplexNumber(0.000,0.000);
        ComplexNumber expected32 = new ComplexNumber(47.250,-45.000);
        ComplexNumber expected33 = new ComplexNumber(1.000,0.000);
        ComplexNumber expected34 = new ComplexNumber(0.011,0.011);
        
        ComplexNumber expected41 = new ComplexNumber(1.000,0.000);
        ComplexNumber expected42 = new ComplexNumber(0.013,0.005);
        ComplexNumber expected43 = new ComplexNumber(3820.880,-3318.672);
        ComplexNumber expected44 = new ComplexNumber(186.308,-89.305);
        
        ComplexNumber expected51 = new ComplexNumber(1.000,0.000);
        ComplexNumber expected52 = new ComplexNumber(-58.880,120.832);
        ComplexNumber expected53 = new ComplexNumber(-0.001,-0.000);
        ComplexNumber expected54 = new ComplexNumber(-8433.167,-7167.272);
        
        
        assertThrows(ArithmeticException.class,() -> ComplexOperations.pow(complex1, new ComplexNumber(-2.0,0.0)));
        assertThrows(ArithmeticException.class,() -> ComplexOperations.pow(complex1, new ComplexNumber(45.0,0.0)));
        assertThrows(ArithmeticException.class,() -> ComplexOperations.pow(complex1, new ComplexNumber(-5.0,0.0)));
        assertThrows(ArithmeticException.class,() -> ComplexOperations.pow(complex1, new ComplexNumber(32.0,0.0)));
        assertThrows(IllegalArgumentException.class,() -> ComplexOperations.pow(complex1,new ComplexNumber(2.0,-5.0)));
        assertThrows(IllegalArgumentException.class,() -> ComplexOperations.pow(complex1,new ComplexNumber(0.0,-5.0)));
         
        assertEquals(expected21,round3(result21));
        assertEquals(expected22,round3(result22));
        assertEquals(expected23,round3(result23));
        assertEquals(expected24,round3(result24));
 
        assertEquals(expected31,round3(result31));
        assertEquals(expected32,round3(result32));
        assertEquals(expected33,round3(result33));
        assertEquals(expected34,round3(result34));
        
        assertEquals(expected41,round3(result41));
        assertEquals(expected42,round3(result42));
        assertEquals(expected43,round3(result43));
        assertEquals(expected44,round3(result44));
        
        assertThrows(IllegalArgumentException.class,() -> ComplexOperations.pow(complex3,new ComplexNumber(2.0,-5.0)));
        assertThrows(IllegalArgumentException.class,() -> ComplexOperations.pow(complex2,new ComplexNumber(0.0,-5.0)));

    }
    
    @Test
    public void testExp(){
        ComplexNumber complex1 = new ComplexNumber(5.0,3.2);
        ComplexNumber complex2 = new ComplexNumber(-2.5,-4.0);
        ComplexNumber complex3 = new ComplexNumber(0.0,0.0);
        ComplexNumber complex4 = new ComplexNumber(0.0,5.5);
        ComplexNumber complex5 = new ComplexNumber(-2.5,0.0);
        ComplexNumber complex6 = new ComplexNumber(3.4,-2.7);
        
        ComplexNumber expected1 = new ComplexNumber(-148.160,-8.663);
        ComplexNumber expected2 = new ComplexNumber(-0.054,0.062);
        ComplexNumber expected3 = new ComplexNumber(1.000,0.000);
        ComplexNumber expected4 = new ComplexNumber(0.709,-0.706);
        ComplexNumber expected5 = new ComplexNumber(0.082,0.000);
        ComplexNumber expected6 = new ComplexNumber(-27.090,-12.806);
        
        ComplexNumber result1 = round3(ComplexOperations.exp(complex1));
        ComplexNumber result2 = round3(ComplexOperations.exp(complex2));
        ComplexNumber result3 = round3(ComplexOperations.exp(complex3));
        ComplexNumber result4 = round3(ComplexOperations.exp(complex4));
        ComplexNumber result5 = round3(ComplexOperations.exp(complex5));
        ComplexNumber result6 = round3(ComplexOperations.exp(complex6));
        
        assertEquals(expected1,result1);
        assertEquals(expected2,result2);
        assertEquals(expected3,result3);
        assertEquals(expected4,result4);
        assertEquals(expected5,result5);
        assertEquals(expected6,result6);
        
    }

    
}
