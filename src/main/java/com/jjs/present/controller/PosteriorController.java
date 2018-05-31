package com.jjs.present.controller;

import com.jjs.present.dto.PosteriorForm;
import com.jjs.present.service.PosteriorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PosteriorController {
    @Autowired
    private PosteriorService posteriorService;

    @RequestMapping("/posterior")
    public int calculatePosterior(@RequestBody PosteriorForm form) {
        return posteriorService.findN(form);
    }
}
