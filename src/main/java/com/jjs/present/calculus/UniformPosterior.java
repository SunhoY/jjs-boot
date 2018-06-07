package com.jjs.present.calculus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("uniformPosterior")
public class UniformPosterior implements Posterior {
    private final JJSMath jjsMath;

    @Autowired
    public UniformPosterior(JJSMath jjsMath) {
        this.jjsMath = jjsMath;
    }

    @Override
    public BigDecimal posterior(int population, int nthTest, int xthDefect, int defectItem, int hyperParameterA, int hyperParameterB) {
        BigDecimal first = jjsMath.combination(xthDefect, defectItem);
        BigDecimal second = jjsMath.combination(population - xthDefect, nthTest - defectItem);
        BigDecimal bottom = jjsMath.combination(population + 1, nthTest + 1);
        return first.multiply(second).divide(bottom, 40, BigDecimal.ROUND_CEILING);
    }
}
