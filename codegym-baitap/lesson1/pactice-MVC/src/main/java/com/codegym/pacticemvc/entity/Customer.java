package com.codegym.pacticemvc.entity;

import lombok.Data;

@Data
public class Customer {
    String id;
    String name;
    String  email;
    String address;

    public Customer(String id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }
}
