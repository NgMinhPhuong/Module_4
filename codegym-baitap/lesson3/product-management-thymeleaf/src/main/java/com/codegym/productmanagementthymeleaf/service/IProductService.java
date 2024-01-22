package com.codegym.productmanagementthymeleaf.service;

import com.codegym.productmanagementthymeleaf.model.Product;

import java.util.List;

public interface IProductService {
    void add(Product product);
    void delete(String id);
    void update(Product product);
    List<Product> getAll();
    Product get(String id);
}
