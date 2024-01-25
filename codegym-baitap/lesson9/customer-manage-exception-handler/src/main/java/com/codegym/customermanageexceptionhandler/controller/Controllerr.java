package com.codegym.customermanageexceptionhandler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controllerr {
    @GetMapping("")
    public void index() throws Exception {
        throw new Exception("lỗi");
    }


    @ExceptionHandler(Exception.class)
    public String check(Exception e){
        return "/error";
    }
}
