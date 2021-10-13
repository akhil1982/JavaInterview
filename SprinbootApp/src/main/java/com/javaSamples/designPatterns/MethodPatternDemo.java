package com.javaSamples.designPatterns;

public class MethodPatternDemo {
}


abstract class  NotificationFactory {

        public final void getNotification(){
            createNotification();
            validateNotification();

        }

        public abstract Notification createNotification();
        public abstract boolean validateNotification();

}

class SMSNotificationFactory extends NotificationFactory {

    @Override
    public Notification createNotification() {

        return null;
    }

    @Override
    public boolean validateNotification() {
        return false;
    }
}

interface MethodNotification {
    public void sendNow();
}

class MethodSMSNotification implements MethodNotification{

    @Override
    public void sendNow() {
        System.out.println("Sending SMS Notificaiton");
    }

}