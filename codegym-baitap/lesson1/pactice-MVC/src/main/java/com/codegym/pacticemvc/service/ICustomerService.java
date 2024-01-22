package com.codegym.pacticemvc.service;

import com.codegym.pacticemvc.entity.Customer;

import java.util.List;

public interface ICustomerService {
    void add(Customer customer);
    void delete(String id);
    void update(Customer customer);

    List<Customer> getAll();
}
