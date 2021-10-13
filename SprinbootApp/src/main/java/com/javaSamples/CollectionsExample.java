package com.javaSamples;

import java.util.*;
import java.util.function.IntConsumer;

public class CollectionsExample {

    public static void main(String... args) throws Exception {

        List<String> list1 = new ArrayList<String>(Arrays.asList("A", "B", "C"));
        List<String> list2 = new ArrayList<String>(Arrays.asList("B", "C", "D", "E", "F"));


        /*System.out.println(new ArrayListExamples().intersection(list1, list2));
        System.out.println(new ArrayListExamples().union(list1, list2));*/

        //otherApproach();

        //Iterate over a list using forEach and lambda
        //list1.forEach((k)->{System.out.println(k);});

        //Iterate over a Map
        Map<String,String> gfg = new HashMap<String,String>();


        // enter name/url pair
        gfg.put("GFG", "geeksforgeeks.org");
        gfg.put("Practice", "practice.geeksforgeeks.org");
        gfg.put("Code", "code.geeksforgeeks.org");
        gfg.put("Quiz", "quiz.geeksforgeeks.org");

        Map<String,String> abc = new HashMap<String,String>();


        // enter name/url pair
        abc.put("ABC", "geeksforgeeks.org");
        abc.put("Practice", "practice.geeksforgeeks.org");
        abc.put("ABCD", "code.geeksforgeeks.org");
        abc.put("Quiz", "quiz.geeksforgeeks.org");


        Map<String, String> intersection = new HashMap();
        for (String key: gfg.keySet())
        {
            if (abc.containsKey(key)) {
                intersection.put(key, gfg.get(key));
            }
        }

intersection.size(); System.out.println(gfg.keySet().size());
        //Approach1 using for loop and entryset()
        for (Map.Entry<String, String> entry: intersection.entrySet()) {
            System.out.println((String)entry.getKey()+(String)entry.getValue());

        }

        //PPROACH 2
       intersection.forEach((k,v)->{System.out.println(k+v+":::");});

        /*LinkedList<String> ll = new LinkedList<>(Arrays.asList("a", "b", "c", "x","y","z"));
        //ll.get(1);
        Spliterator<String> itr = ll.stream().spliterator();
        itr.forEachRemaining(i->{System.out.println(i);});*/


       /* IntConsumer displayNextInt = i -> System.out.println("Next Int Value: " + (i+1));  // lambda
        IntConsumer displaySquare = i -> System.out.println("Int Square Value: " + (i*i)); // lambda
        IntConsumer displayBoth = displayNextInt.andThen(displaySquare);
        displayBoth.accept(25);*/
    }

    public static void otherApproach() {
        //other approach if we allow duplicates
        Collection<String> col1 = new ArrayList<String>(); // {a, b, c}
// Collection<String> col1 = new TreeSet<String>();
        col1.add("a");
        col1.add("b");
        col1.add("c");

        Collection<String> col2 = new ArrayList<String>(); // {b, c, d, e}
// Collection<String> col2 = new TreeSet<String>();
        col2.add("b");
        col2.add("c");
        col2.add("d");
        col2.add("e");

        col1.addAll(col2);

        System.out.println(col1);

        col1.retainAll(col2);

        System.out.println(col1);
    }

    public <T> List<T> union(List<T> list1, List<T> list2) {
        Set<T> set = new HashSet<T>();

        set.addAll(list1);
        set.addAll(list2);

        return new ArrayList<T>(set);
    }

    public <T> List<T> intersection(List<T> list1, List<T> list2) {
        List<T> list = new ArrayList<T>();

        for (T t : list1) {
            if(list2.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }
}