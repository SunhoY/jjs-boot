package com.jjs.present.calculus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component("betaBinomialPosterior")
public class BetaBinomialPosterior implements Posterior {

    private final JJSMath jjsMath;

    @Autowired
    public BetaBinomialPosterior(JJSMath jjsMath) {
        this.jjsMath = jjsMath;
    }

    @Override
    public BigDecimal posterior(int population, int nthTest, int xthDefect, int defectItem, int hyperParameterA, int hyperParameterB) {
        BigDecimal front = jjsMath.combination(population - nthTest, xthDefect - defectItem);

        return front.multiply(jjsMath.betaBinomial(hyperParameterA + xthDefect, hyperParameterB + population - xthDefect)
                .divide(jjsMath.betaBinomial(hyperParameterA + defectItem, hyperParameterB + nthTest - defectItem), 15, RoundingMode.CEILING));
    }
}
