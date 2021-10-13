package com.javaSamples;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class StringSample {
        static int count = 0;
        public static void main(String[] args) {
//            if(count < 3){
//                count++;
//                main(null);
//            }else{
//                return;
//            }
//            System.out.println("Hello World!");
//
//            String str = new String("Automation");
//            str = reverse(str);
//            System.out.println(str);
            //countWords();
            palindrome();
           // fibonacci();
            //sort();
        }

        private static String reverse (String str) {

            char[] arr= str.toCharArray();
            char[] newarr = new char[arr.length];
            for (int i=0, j=arr.length-1; i< arr.length; i++,j--) {
                newarr[i]=arr[j];
            }
            String str1 = "";
            for(int i = 0;i< newarr.length;i++){
                str1=str1.concat(newarr[i]+"");
            }
            return str1;
        }

        private static void countWords(){
            String str = "This this is is done by Saket Saket";
            String[] split = str.split(" ");

            HashMap<String,Integer> map = new HashMap<String,Integer>();
            for (int i=0; i<split.length; i++) {
                if (map.containsKey(split[i])) {
                    int count = map.get(split[i]);
                    map.put(split[i], count+1);
                }
                else {
                    map.put(split[i], 1);
                }
            }
            System.out.println(map);
        }

        private static void palindrome(){
            String str = "MALAYALAM";
            char[] arr = str.toCharArray();
            char[] newar = new char[arr.length];
            for(int i=0, j= arr.length-1;i< arr.length;i++,j--) {
                newar[i]=arr[j];
            }
            String reverse = "";
            for(int i=0;i<newar.length;i++) {
                reverse = reverse.concat(newar[i]+"");
            }
            if(str.equals(reverse)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

        private static void fibonacci(){
            int a=0, b=1, temp;
            System.out.print(a+" ");
            for(int i=0;i<=10;i++) {
                temp = a+b;
                a=b;
                b=temp;
                System.out.print(a+" ");
            }
        }

        private static void sort(){
            String str = "akhilsyal";

            char[] arr = str.toCharArray();
int[] iarr = new int[3];
iarr[0]=1;iarr[1]=2;iarr[2]=3;
            if (iarr[0] == 1){
                System.out.println("here");
            }

            char temp;
            for (int i=0;i< arr.length;i++){
                for(int j=i+1;j< arr.length;j++) {
                    if (arr[i] > arr[j]) {
                        temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }

            for(char c:arr){
                System.out.print(c+" ");
            }
        }


    }





