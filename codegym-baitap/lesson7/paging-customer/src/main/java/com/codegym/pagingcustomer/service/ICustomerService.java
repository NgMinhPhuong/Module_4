package com.codegym.pagingcustomer.service;

import com.codegym.pagingcustomer.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {

    Page<Customer> findAllByName(Pageable pageable, String name);
    Page<Customer> findById(Pageable pageable, Long id);
    Optional<Customer> findById(Long id);
    Page<Customer> findAll(Pageable pageable);
}
