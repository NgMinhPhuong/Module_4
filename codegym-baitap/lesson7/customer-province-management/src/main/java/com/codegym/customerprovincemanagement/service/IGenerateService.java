package com.codegym.customerprovincemanagement.service;

import com.codegym.customerprovincemanagement.model.Customer;
import com.codegym.customerprovincemanagement.model.Province;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IGenerateService<T>{
    Iterable<T> findAll();
    void save(T t);
    Optional<T> findById(Long id);
    void remove(Long id);
}
