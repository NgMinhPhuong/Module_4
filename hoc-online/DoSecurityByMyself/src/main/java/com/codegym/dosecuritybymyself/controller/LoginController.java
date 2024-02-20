package com.codegym.dosecuritybymyself.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    //@PreAuthorize("hasAnyAuthority({'ROLE_ADMIN','ROLE_USER'})")
    @GetMapping("/hello")
    public String index(){
        return "/views/index";
    }

    @GetMapping("/login")
    public String login(){
        return "/views/loginn";
    }

    @PostMapping ("/test")
    public String test(){
        System.out.println("hello");
        return "/views/test";
    }
}
