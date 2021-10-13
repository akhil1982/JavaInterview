package com.javaSamples;

import java.util.ArrayList;
import java.util.Arrays;

public class PassingInJava {

    public static void main (String[] args) {
        Dog adog = new Dog("Max");
        changeName(adog);
        System.out.println(adog.getName());

        //Arraylist example cloning

        ArrayList<String> list = new ArrayList<String>();
        list.add("Test1");
        list.add("Test2");
        list.add("Test3");
        list.add("Test4");

        ArrayList<String> v = (ArrayList<String>) list.clone();
        ////System.out.println(v);

        Object[] str =  Arrays.copyOf(list.toArray(), 10);
        ////System.out.println(Arrays.stream(str).iterator());

        String oldVal = list.set(2, "Newtest");
        //System.out.println(list+":"+oldVal);


    }

    public static void changeName (Dog dog) {
        dog.setName("Peter");
        dog = new Dog("Wolf");
        System.out.println(dog.getName());
    }

    //Arrays coding practise

}

class Dog {

    String name;

    public Dog(String name){
        this.name=name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
