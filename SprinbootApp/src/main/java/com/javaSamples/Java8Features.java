package com.javaSamples;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Features {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");

//        Iterator<String> itr = list.iterator();
//        while(itr.hasNext()) {
//            System.out.println(itr.next());
//        }

//        list.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                s=s.concat("hello");
//                System.out.println(s);
//            }
//        });
//
       //FunctionalSample s = new ChildSample();
        FunctionalSample.display();
       FunctionalSample f = ()-> {System.out.println("Display another object");};
        //f.displayAnother();

//        Thread t = new Thread(()->{System.out.println("new thread");});
//        t.start();

//        Stream.Builder<Employee> empBuilder = Stream.builder();
//        empBuilder.accept(new Employee("Emp1"));
//        empBuilder.accept(new Employee("Emp2"));
//        empBuilder.accept(new Employee("Emp3"));
//        Stream<Employee> empStream=empBuilder.build();
//
//        //empStream.forEach(e->{System.out.println(e.getName());});
//          empStream.map(e->{e.setName(e.getName()+" hello "); return e;}).collect(Collectors.toList());
//        //st2.forEach(e->{System.out.println(e.getName());});

        List<String> result = list.stream().filter(x->x.contains("2")).collect(Collectors.toList());
        result.forEach(x->System.out.println(x));

        List<Employee> employeeList = Arrays.asList(new Employee("Akhil", 38),
                new Employee("Rashmi", 34),
                new Employee("Ginni", 10));

        List<Employee> output =employeeList.stream().filter(x->x.getAge()>10).collect(Collectors.toList());//map(Employee::getEmployee).collect(Collectors.toList());
        System.out.println(output);
        System.out.println(employeeList.stream().map(Employee::getAge).collect(Collectors.toList()));

        String[] languages = {"Java", "Python", "JavaScript"};
        Arrays.stream(languages);


        Map<String, Employee> map1 = new HashMap<>();
        Map<String, Employee> map2 = new HashMap<>();

        Employee employee1 = new Employee("Henry", 31);
        map1.put(employee1.getName(), employee1);
        Employee employee2 = new Employee("Annie", 22);
        map1.put(employee2.getName(), employee2);
        Employee employee3 = new Employee( "John", 8);
        map1.put(employee3.getName(), employee3);

        Employee employee4 = new Employee( "George", 9);
        map2.put(employee4.getName(), employee4);
        Employee employee5 = new Employee( "Henry", 32);
        map2.put(employee5.getName(), employee5);

       Map<String, Employee> resultOne = Stream.concat(map1.entrySet().stream(), map2.entrySet().stream()).
                collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1,v2)->new Employee(v1.getName(), v2.getAge())));

       resultOne.forEach((k,v)->System.out.println(k+v));


    }

}

@FunctionalInterface
interface FunctionalSample {

    public String str="test";
    abstract void displayAnother() throws Exception;

    static void display() {
        System.out.println("Display this object");
    }

    default void displayThis(){ String str ;
    }
}


class Employee {

    private String name;
    private int age;

    public Employee(String name, int age){
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    Employee getEmployee(){
        return this;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}