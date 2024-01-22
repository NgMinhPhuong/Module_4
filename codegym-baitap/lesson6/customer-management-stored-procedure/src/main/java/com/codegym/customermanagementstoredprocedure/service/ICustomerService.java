package com.codegym.customermanagementstoredprocedure.service;


import com.codegym.customermanagementstoredprocedure.model.Customer;

import java.util.List;

public interface ICustomerService {
    boolean saveWithStoredProcedure(Customer customer);
    List<Customer> findAll();
}