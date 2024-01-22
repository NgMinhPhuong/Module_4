package com.codegym.customermanagementstoredprocedure.repository;


import com.codegym.customermanagementstoredprocedure.model.Customer;
import com.codegym.customermanagementstoredprocedure.service.CustomerService;

import java.util.List;

public interface ICustomerRepository {
    boolean saveWithStoredProcedure(Customer customer);
    List<Customer> findAll();
}
