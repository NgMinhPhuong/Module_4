package com.example.testanotation.model;


import com.example.testanotation.annotation.NameConstraint;

import javax.validation.Constraint;
import javax.validation.constraints.NotEmpty;

public class Test {

    private Long id;
    @NameConstraint(message = "dada")
    private String name;
    public Test(){}

    public Test(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
