package com.example.testsocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin
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
