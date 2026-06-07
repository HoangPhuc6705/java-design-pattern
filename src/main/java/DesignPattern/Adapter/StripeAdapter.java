package DesignPattern.Adapter;

public class StripeAdapter implements PaymentProcessor {
    private final StripeSdk stripeSdk;

    public StripeAdapter(StripeSdk stripeSdk) {
        this.stripeSdk = stripeSdk;
    }

    @Override
    public void pay(double amount) {
        this.stripeSdk.makePayment("USD", amount);
    }
}
