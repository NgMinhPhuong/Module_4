package com.example.testsocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testController {
    @GetMapping
    public String test(){
        return "/index";
    }
    @GetMapping("/get")
    public String get(){
        return "/get";
    }
}
