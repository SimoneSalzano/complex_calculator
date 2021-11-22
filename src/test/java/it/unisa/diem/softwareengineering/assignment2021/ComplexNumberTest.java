package it.unisa.diem.softwareengineering.assignment2021;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;

public class ComplexNumberTest {

    ComplexNumber expected1,expected2,expected3,expected4,expected5;

    @BeforeAll
    public void setup() {
        expected1 = new ComplexNumber(3.8,4.8);
        expected2 = new ComplexNumber(3.0,4.0);
        expected3 = new ComplexNumber(-55.0,55.0);
        expected4 = new ComplexNumber(55.7,-55.7);
        expected5 = new ComplexNumber(-12.357, -12345.4);
    }


}
