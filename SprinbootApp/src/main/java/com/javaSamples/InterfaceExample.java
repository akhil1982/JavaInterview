package com.javaSamples;

public class InterfaceExample implements A, B{
    @Override
    public void display() {
        System.out.println("Hello World");
    }

    public static void main(String[] args){
        A a = new InterfaceExample();
        a.display();

        B b = new InterfaceExample();
        b.display();
    }
}

interface A {
    public void display();
}

interface B {
    public void display();
}
