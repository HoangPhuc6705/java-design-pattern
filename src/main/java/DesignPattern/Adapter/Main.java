package DesignPattern.Adapter;

public class Main {
    public static void main(String[] args) {
        StripeSdk sdk = new StripeSdk();
        StripeAdapter adapter = new StripeAdapter(sdk);
        adapter.pay(10000);
    }
}
