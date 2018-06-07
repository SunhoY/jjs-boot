package com.jjs.present.calculus;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class FactorialData {
    private BigDecimal[] factorialArray = new BigDecimal[100000];

    public FactorialData() {
        for(int i = 0; i < factorialArray.length; ++i) {
            factorialArray[i] = BigDecimal.ZERO;
        }
    }

    public BigDecimal getFactorialData(int index) {
        return factorialArray[index];
    }

    public void putFactorialData(int index, BigDecimal value) {
        factorialArray[index] = value;
    }
}
