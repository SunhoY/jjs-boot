package com.jjs.present.calculus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static com.jjs.present.Constant.SCALE;

@Component
public class JJSMath {
    private final FactorialData factorialData;
    private static final Logger logger = LoggerFactory.getLogger(JJSMath.class);

    @Autowired
    public JJSMath(FactorialData factorialData) {
        this.factorialData = factorialData;
    }

    public BigDecimal factorial(int n) {
        return factorialRecursive(n);
    }

    private BigDecimal factorialRecursive(int n) {
        if (n <= 1) {
            factorialData.putFactorialData(n, BigDecimal.ONE);

            return BigDecimal.ONE;
        }

        BigDecimal answer = this.factorialData.getFactorialData(n);

        if (answer.equals(BigDecimal.ZERO)) {
            BigDecimal startValue = new BigDecimal(n);
            BigDecimal newAnswer = startValue.multiply(factorialRecursive(n - 1));

            factorialData.putFactorialData(n, newAnswer);

            return newAnswer;
        } else {
            return answer;
        }
    }

    public BigDecimal combination(int n, int k) {
        return factorial(n).divide(factorial(k).multiply(factorial(n - k)), SCALE, BigDecimal.ROUND_FLOOR);
    }

    public BigDecimal betaBinomial(int first, int second) {
        return factorial(first - 1).multiply(factorial(second - 1)).divide(factorial(first + second - 1), SCALE, BigDecimal.ROUND_CEILING);
    }
}
