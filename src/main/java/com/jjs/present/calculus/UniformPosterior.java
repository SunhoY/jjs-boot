package com.jjs.present.calculus;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("uniformPosterior")
public class UniformPosterior implements Posterior {
    @Override
    public BigDecimal posterior(int population, int nthTest, int xthDefect, int defectItem, int hyperParameterA, int hyperParameterB) {
        BigDecimal first = JJSMath.combination(xthDefect, defectItem);
        BigDecimal second = JJSMath.combination(population - xthDefect, nthTest - defectItem);
        BigDecimal bottom = JJSMath.combination(population + 1, nthTest + 1);
        return first.multiply(second).divide(bottom, 40, BigDecimal.ROUND_CEILING);
    }
}
