package DesignPattern.Factory;

public class NotificationFactory {
    public static Notification create(String type) {
        return switch (type.trim().toLowerCase()) {
            case "sms" -> new SmsNotification();
            case "push" -> new PushNotification();
            case "email" -> new EmailNotification();
            default -> throw new IllegalStateException("Unexpected value: " + type.trim().toLowerCase());
        };
    }
}
