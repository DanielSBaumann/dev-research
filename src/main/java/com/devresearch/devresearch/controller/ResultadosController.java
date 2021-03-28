package com.devresearch.devresearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/resultado")
public class ResultadosController {

    @GetMapping
    public ModelAndView show() {
        return new ModelAndView("chart");
    }
}
