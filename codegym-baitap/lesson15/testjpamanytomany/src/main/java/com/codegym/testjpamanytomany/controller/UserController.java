package com.codegym.testjpamanytomany.controller;

import com.codegym.testjpamanytomany.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {
    @Autowired
    IUserService iUserService;
    @GetMapping("/{id}")
    public String index(Model model, @PathVariable Long id){
        model.addAttribute("user", iUserService.findById(id));
        return "/index";
    }
}
