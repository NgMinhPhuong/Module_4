package com.example.testsocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin
public class testController {
    @MessageMapping("/myhandler")
    @SendTo("/handle")
    public String test(){
        System.out.println("dasd");
        return "/fds";
    }


    @GetMapping("/handle")
    public String handle(){
        System.out.println("cc");
        System.out.println("cc");
        System.out.println("cc");
        return "A";
    }
    @GetMapping("/get")
    public String get(){
        return "/get";
    }
}
