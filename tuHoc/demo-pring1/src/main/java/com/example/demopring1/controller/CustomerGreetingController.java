package com.example.demopring1.controller;


import com.example.demopring1.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/v1")
public class CustomerGreetingController {
    private static final String greetingTemplace = "Hello, %s %s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "gender",defaultValue = "0") boolean gender,
                             @RequestParam(value = "customerName", defaultValue = "empty") String name){
        return Greeting.builder()
                .id(counter.incrementAndGet())
                .content(String.format(greetingTemplace, gender ? "Mr." : "Ms.",name))
                .build();
    }

    @GetMapping("/value")
    public String test(){
        return "abc";
    }
}
