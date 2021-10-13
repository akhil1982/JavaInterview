package com.spring.tutorials.core;

import org.springframework.context.annotation.Scope;


public class Employee {

    private String name;

    public Employee(){}
    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
