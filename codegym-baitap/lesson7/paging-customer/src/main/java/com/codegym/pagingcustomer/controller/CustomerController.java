package com.codegym.pagingcustomer.controller;

import com.codegym.pagingcustomer.model.Customer;
import com.codegym.pagingcustomer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("/customers")
    public ModelAndView listCustomers(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "") String search){
        Page<Customer> customers;
        customers = iCustomerService.findAll(PageRequest.of(page, 2));
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("search", search);
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

}
