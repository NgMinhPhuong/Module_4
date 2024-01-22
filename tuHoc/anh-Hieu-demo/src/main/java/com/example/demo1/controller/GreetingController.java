package com.example.demo1.controller;

import com.example.demo1.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RestController;


@RestController

public class GreetingController {
    @Autowired
    Customer customer1;
    @GetMapping("/greeting")
    public Customer showGreeting(@ModelAttribute Customer customer, Model map){
        System.out.println(customer);
        System.out.println(customer1);
        return customer;

    }
}
