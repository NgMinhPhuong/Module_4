package com.codegym.practicecart.service;

import com.codegym.practicecart.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);
}
