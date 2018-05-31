package com.jjs.present.calculus;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component("betaBinomialPosterior")
public class BetaBinomialPosterior implements Posterior {

    @Override
    public BigDecimal posterior(int population, int nthTest, int xthDefect, int defectItem, int hyperParameterA, int hyperParameterB) {
        BigDecimal front = JJSMath.combination(population - nthTest, xthDefect - defectItem);

        return front.multiply(JJSMath.betaBinomial(hyperParameterA + xthDefect, hyperParameterB + population - xthDefect)
                .divide(JJSMath.betaBinomial(hyperParameterA + defectItem, hyperParameterB + nthTest - defectItem), 15, RoundingMode.CEILING));
    }
}
