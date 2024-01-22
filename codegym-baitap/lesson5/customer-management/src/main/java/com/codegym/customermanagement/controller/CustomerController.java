package com.codegym.customermanagement.controller;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @GetMapping("/customer")
    public String get(Model model){
        model.addAttribute("customers", iCustomerService.findAll());
        return "/index";
    }
}
