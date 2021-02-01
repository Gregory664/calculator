package com.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class APICalculatorTest {

    @Test
    void calc() {
        assertEquals(20.0, APICalculator.calculate("5*2+10"));
        assertEquals(15.0, APICalculator.calculate("10/2+10"));
        assertEquals(110.0, APICalculator.calculate("10*10+10"));
    }

    @Test
    void calc2() {
        assertEquals(5.0, APICalculator.calculate("(6+10-4)/(1+1*2)+1"));
        assertEquals(14.0, APICalculator.calculate("2+(3*4)"));
        assertEquals(17.0, APICalculator.calculate("4/2+3*5)"));
    }

    @Test
    void calc3() {
        assertEquals(35.0, APICalculator.calculate("10+5^2"));
        assertEquals(4.0, APICalculator.calculate("100/(3+2)^2)"));
        assertEquals(400.0, APICalculator.calculate("(100/(3+2))^2)"));
    }
}