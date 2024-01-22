package com.codegym.demo.controller;

import com.codegym.demo.service.IPd;
import com.codegym.demo.service.Pd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class PdController {
    @Autowired
    IPd iPd;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PdController pdController = context.getBean(PdController.class);
        pdController.iPd.eat();
    }

}