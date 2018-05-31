package com.jjs.present.calculus;

import java.math.BigDecimal;

public class JJSMath {
    private static int SCALE = 15;

    public static BigDecimal factorial(int n) {
        BigDecimal fac = BigDecimal.ONE;

        for (int i = 1; i <= n; i++) {
            fac = fac.multiply(BigDecimal.valueOf(i));
        }
        return fac;
    }

    public static BigDecimal combination(int n, int k) {
        return factorial(n).divide(
                factorial(k).multiply(factorial(n - k)), SCALE, BigDecimal.ROUND_FLOOR);
    }

    public static BigDecimal betaBinomial(int first, int second) {
        return factorial(first - 1).multiply(factorial(second - 1)).divide(factorial(first + second - 1), SCALE, BigDecimal.ROUND_CEILING);
    }
}
