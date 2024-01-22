package com.codegym.pacticemvc.service.impl;

import com.codegym.pacticemvc.entity.Customer;
import com.codegym.pacticemvc.service.ICustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    public static ArrayList<Customer> listCustomer;
    static {
        listCustomer = new ArrayList<>();
        listCustomer.add(new Customer("1", "hùng", "hung123@gmail.com", "Tp.HCM"));
        listCustomer.add(new Customer("2", "huy", "huy123@gmail.com", "Tp.HCM"));
        listCustomer.add(new Customer("3", "lâm", "lam123@gmail.com", "Tp.HCM"));
        listCustomer.add(new Customer("4", "phú", "phu123@gmail.com", "Tp.HCM"));
        listCustomer.add(new Customer("5", "an", "an123@gmail.com", "Tp.HCM"));
    }

    @Override
    public void add(Customer customer) {
        listCustomer.add(customer);
    }

    @Override
    public void delete(String id) {
        listCustomer.remove(Integer.parseInt(id));
    }

    @Override
    public void update(Customer customer) {
        listCustomer.get(Integer.parseInt(customer.getId())).setId(customer.getId());
        listCustomer.get(Integer.parseInt(customer.getId())).setName(customer.getName());
        listCustomer.get(Integer.parseInt(customer.getId())).setEmail(customer.getEmail());
        listCustomer.get(Integer.parseInt(customer.getId())).setAddress(customer.getAddress());
    }

    @Override
    public List<Customer> getAll() {
        return listCustomer;
    }
}
