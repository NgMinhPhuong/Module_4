package com.codegym.pacticemvc.controller;

import com.codegym.pacticemvc.service.ICustomerService;
import com.codegym.pacticemvc.service.impl.CustomerService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

    ICustomerService iCustomerService;

    @Autowired
    public CustomerController(ICustomerService iCustomerService){
        this.iCustomerService = iCustomerService;
    }

    @GetMapping("/customer")
        public ModelAndView showList(){
            ModelAndView modelAndView = new ModelAndView("list");
            modelAndView.addObject("customers", iCustomerService.getAll());
            return modelAndView;
        }
}
