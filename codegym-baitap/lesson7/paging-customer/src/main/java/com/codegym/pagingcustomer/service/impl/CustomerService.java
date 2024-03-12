package com.codegym.pagingcustomer.service.impl;

import com.codegym.pagingcustomer.model.Customer;
import com.codegym.pagingcustomer.repository.ICustomerRepository;
import com.codegym.pagingcustomer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAllByName(Pageable pageable, String name) {
        return iCustomerRepository.findAllByFirstNameContaining(pageable, name);
    }

    @Override
    public Page<Customer> findById(Pageable pageable, Long id) {
        return iCustomerRepository.findById(pageable, id);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {

        return iCustomerRepository.findAll(pageable);
    }


}
