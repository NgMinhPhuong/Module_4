package com.codegym.validateform.controller;

import com.codegym.validateform.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class FormController {
    @GetMapping("form")
    public String showForm(Model model){
        model.addAttribute("user",new User());
        return "/index";
    }

    @PostMapping("form")
    public String checkValidate(@ModelAttribute User user, BindingResult bindingResult){
        new User().validate(user, bindingResult);
        if(bindingResult.hasErrors()){
            return "/index";
        }
        return "/result";
    }
}
