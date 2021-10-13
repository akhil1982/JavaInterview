package com.spring.tutorials.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;


public class HelloWorld {

    private String message;

    private Employee emp;

    public HelloWorld(){}
    public HelloWorld(Employee emp){
        this.emp = emp;
    }

    public void setEmpName(String name){
        emp.setName(name);
    }

    public String getMessage() {
        System.out.println(emp.getName()+"::Your message::"+message);
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
