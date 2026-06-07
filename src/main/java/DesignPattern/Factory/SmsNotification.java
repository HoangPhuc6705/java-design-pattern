package DesignPattern.Factory;

public class SmsNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sms: " + message);
    }
}
