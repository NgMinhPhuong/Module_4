package com.codegym.showfood.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FoodController {

    @GetMapping("/")
    public String show(){
        return "index";
    }
    @GetMapping("/chose")
    public ModelAndView chose(@RequestParam String[] type){
        System.out.println(type);
        return new ModelAndView("result", "type", type);

    }
}
