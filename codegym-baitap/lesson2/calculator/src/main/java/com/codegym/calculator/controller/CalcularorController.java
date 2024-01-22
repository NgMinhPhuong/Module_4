package com.codegym.calculator.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@CrossOrigin
public class CalcularorController {
    @GetMapping("/")
    public String show(){
        return "index";
    }

    @ResponseBody
    @PostMapping("/getResult")
    public String calcu(@RequestParam double one, @RequestParam double two, @RequestParam String action){

        switch (action){
            case "+":
                return (one + two) + "";
            case "-":
                return (one - two) + "";
            case "*":
                return (one * two) + "";
            case "/":
                return (one / two) + "";
        }
        return null;
    }
}
