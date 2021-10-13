package com.javaSamples.designPatterns;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FactoryDemo {

    public static void main(String[] args){
        System.out.println("Enter the type of object ::");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            Notification notType = BeanFactory.getBean(reader.readLine());
            notType.send();
        }
        catch (Exception e) {
            System.out.println("Exception in getting bean -> "+e.getMessage());
        }
    }
}

final class BeanFactory {
    private static Map map = new HashMap();
    static {

        map.put("smsNotification", new SMSNotification());
        map.put("emailNotification", new EmailNotification());
        map.put("pushNotification", new PushNotification());
    }

    public static Notification getBean(String id) throws Exception{
        if (null == id) {
            throw new Exception("Id cannot be null");
        } else if (!map.containsKey(id)){
            throw new Exception("Bean with the given id :: "+id+" :: not found");
        } else {
            return (Notification) map.get(id);
        }
    }
}

interface Notification {
    public boolean send();
}

class SMSNotification implements Notification{

    @Override
    public boolean send() {
        System.out.println("Sending SMS Notification");
        return false;
    }
}

class EmailNotification implements Notification{

    @Override
    public boolean send() {
        System.out.println("Sending Email Notification");
        return false;
    }
}

class PushNotification implements Notification{

    @Override
    public boolean send() {
        System.out.println("Sending Push Notification");
        return false;
    }
}
