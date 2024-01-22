package com.codegym.customermanagementstoredprocedure.controller;

import com.codegym.customermanagementstoredprocedure.model.Customer;
import com.codegym.customermanagementstoredprocedure.service.ICustomerService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("customers", iCustomerService.findAll());
        return "/index";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("customer", new Customer());
        return "/create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Customer customer){
        iCustomerService.saveWithStoredProcedure(customer);
        return "redirect:/";
    }
}
