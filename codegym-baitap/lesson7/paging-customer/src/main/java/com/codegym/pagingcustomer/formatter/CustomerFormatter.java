package com.codegym.pagingcustomer.formatter;

import com.codegym.pagingcustomer.model.Customer;

import com.codegym.pagingcustomer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;


@Component
public class CustomerFormatter implements Formatter<Customer> {
    private final ICustomerService iCustomerService;

    @Autowired
    public CustomerFormatter(ICustomerService iCustomerService){
        this.iCustomerService = iCustomerService;
    }
    @Override
    public Customer parse(String text, Locale locale) throws ParseException {
        return iCustomerService.findById(Long.parseLong(text)).get();
    }

    @Override
    public String print(Customer object, Locale locale) {
        return null;
    }
}
