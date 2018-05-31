package com.jjs.present.service;

import com.jjs.present.calculus.Posterior;
import com.jjs.present.type.PosteriorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PosteriorFactory {
    @Autowired
    @Qualifier("uniformPosterior")
    private Posterior uniformPosterior;

    @Autowired
    @Qualifier("betaBinomialPosterior")
    private Posterior betaBinomialPosterior;

    public Posterior getPosterior(PosteriorType posteriorType) {
        switch (posteriorType) {
            case UNIFORM:
                return uniformPosterior;
            case BETA_BINOMIAL:
                return betaBinomialPosterior;
        }

        return null;
    }
}
