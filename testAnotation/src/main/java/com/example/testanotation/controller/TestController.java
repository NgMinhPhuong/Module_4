package com.example.testanotation.controller;

import com.example.testanotation.model.Test;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TestController {
    @GetMapping
    public void tets(@Valid Test test, BindingResult bindingResult){
        Test test1 = new Test(2L,"");
        if (bindingResult.hasErrors()){
            int a = 2;
        }
    }
}
