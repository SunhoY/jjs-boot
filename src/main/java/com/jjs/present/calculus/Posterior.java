package com.jjs.present.calculus;

import java.math.BigDecimal;

public interface Posterior {
    BigDecimal posterior(int population, int nthTest, int xthDefect, int defectItem, int hyperParameterA, int hyperParameterB);
}
