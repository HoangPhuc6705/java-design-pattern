package DesignPattern.Adapter;

public class StripeSdk {
    public void makePayment(String currency, double val) {
        System.out.println("Paid: " + val + " " + currency);
    }
}
