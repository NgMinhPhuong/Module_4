package com.codegym.convertmoney.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConvertController {

    @GetMapping("/convert")
    public ModelAndView convert(){
        ModelAndView modelAndView = new ModelAndView("index");

        return modelAndView;
    }
    @PostMapping("/convert")
    public ModelAndView covert(@RequestParam int money){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("money", money);
        modelAndView.addObject("result", money * 24);
        return modelAndView;
    }
}
