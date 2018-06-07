package com.jjs.present.service;

import com.jjs.present.calculus.Posterior;
import com.jjs.present.dto.PosteriorForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PosteriorService {
    @Autowired
    private PosteriorFactory posteriorFactory;

    public int findN(PosteriorForm form) {
        BigDecimal confidenceLevel = new BigDecimal(form.getConfidenceLevel());
        int population = form.getPopulation();
        for (int i = 1; i <= population; ++i) {
            if (posteriorSummationAtN(form, i).compareTo(confidenceLevel) < 1) {
                continue;
            }

            return i;
        }

        return population;
    }


    public BigDecimal posteriorSummationAtN(PosteriorForm form, int n) {
        Posterior posterior = posteriorFactory.getPosterior(form.getPosteriorType());

        BigDecimal sum = BigDecimal.ZERO;
        int xBegin = form.getDefectiveItem();
        int xEnd = form.getMaximumDefectItem();

        for (int i = xBegin; i <= xEnd; ++i) {
            sum = sum.add(posterior.posterior(form.getPopulation(), n, i, form.getDefectiveItem(),
                    form.getHyperParameterA(), form.getHyperParameterB()));
        }

        return sum;
    }
}
