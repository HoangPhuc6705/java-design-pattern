package DesignPattern.Factory;

public class Main {
    public static void main(String[] args) {
        String message = "Hello, world!";
        Notification n = NotificationFactory.create("sms");
        n.send(message);
        n = NotificationFactory.create("push");
        n.send(message);
    }
}
