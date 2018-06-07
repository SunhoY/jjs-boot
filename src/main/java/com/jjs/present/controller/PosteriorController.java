package com.jjs.present.controller;

import com.jjs.present.dto.PosteriorForm;
import com.jjs.present.service.PosteriorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PosteriorController {
    private static final Logger logger = LoggerFactory.getLogger(PosteriorController.class);

    @Autowired
    private PosteriorService posteriorService;

    @RequestMapping("/posterior")
    public int calculatePosterior(@RequestBody PosteriorForm form) {
        int solution = posteriorService.findN(form);

        logger.info("REQUEST: {}", form.toString());
        logger.info("RESPONSE: {}", solution);

        return solution;
    }
}
