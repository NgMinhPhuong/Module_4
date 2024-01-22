package com.codegym.productmanagementthymeleaf.service;

import com.codegym.productmanagementthymeleaf.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService{

    private static List<Product> list;
    static {
        list = new ArrayList<>();
        list.add(new Product("1","hung","a"));
        list.add(new Product("2","lam","b"));
        list.add(new Product("3","an","c"));
        list.add(new Product("4","phương","d"));
    }
    @Override
    public void add(Product product) {
        list.add(product);
    }

    @Override
    public void delete(String id) {
        list.removeIf(a -> a.getId().equals(id));
    }

    @Override
    public void update(Product product) {
        for(Product product1 : list){
            if(product1.getId().equals(product.getId())){
                product1.setId(product.getId());
                product1.setName(product.getName());
                product1.setDescription(product.getDescription());
                break;
            }
        }
    }

    @Override
    public List<Product> getAll() {
        return list;
    }

    @Override
    public Product get(String id) {
        for(Product product : list){
            if(product.getId().equals(id)){
                return product;
            }
        }
        return null;
    }
}
