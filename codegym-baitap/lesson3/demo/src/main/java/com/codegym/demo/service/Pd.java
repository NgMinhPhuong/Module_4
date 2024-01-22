package com.codegym.demo.service;

import org.springframework.stereotype.Service;

@Service
public class Pd implements  IPd{
    String name = "service";

    @Override
    public String toString() {
        return "Pd{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void eat() {
        System.out.println("mam");
    }
}
