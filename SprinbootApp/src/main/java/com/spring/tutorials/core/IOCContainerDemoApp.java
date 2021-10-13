package com.spring.tutorials.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCContainerDemoApp {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        HelloWorld hello = ((HelloWorld)context.getBean("helloWorld"));
        hello.setEmpName("Akhil");
        HelloWorld hello1 = ((HelloWorld)context.getBean("helloWorldone"));
        hello1.setEmpName("Syal");
        System.out.println(hello.getMessage());
        System.out.println(hello1.getMessage());
    }
}
