package com.jjs.present.calculus;

import com.jjs.present.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component("betaBinomialPosterior")
public class BetaBinomialPosterior implements Posterior {

    private static final Logger logger = LoggerFactory.getLogger(BetaBinomialPosterior.class);

    private final JJSMath jjsMath;

    @Autowired
    public BetaBinomialPosterior(JJSMath jjsMath) {
        this.jjsMath = jjsMath;
    }

    @Override
    public BigDecimal posterior(int population, int nthTest, int xthDefect, int defectItem, int hyperParameterA, int hyperParameterB) {
        BigDecimal front = jjsMath.combination(population - nthTest, xthDefect - defectItem);

        BigDecimal bunja = front.multiply(jjsMath.betaBinomial(hyperParameterA + xthDefect, hyperParameterB + population - xthDefect));
        BigDecimal bunmo = jjsMath.betaBinomial(hyperParameterA + defectItem, hyperParameterB + nthTest - defectItem);

        return bunja.divide(bunmo, Constant.SCALE, RoundingMode.CEILING);
    }
}
