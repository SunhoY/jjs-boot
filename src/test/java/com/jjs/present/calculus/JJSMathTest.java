package com.jjs.present.calculus;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class JJSMathTest {

    private JJSMath jjsMath = new JJSMath(new FactorialData());

    @Test
    public void factorial() {
        assertEquals(new BigDecimal(1), jjsMath.factorial(0));
        assertEquals(new BigDecimal(1), jjsMath.factorial(1));
        assertEquals(new BigDecimal(2), jjsMath.factorial(2));
        assertEquals(new BigDecimal(6), jjsMath.factorial(3));
        assertEquals(new BigDecimal(24), jjsMath.factorial(4));

    }
}