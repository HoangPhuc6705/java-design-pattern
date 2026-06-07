package DesignPattern.Strategy;

public class EconomyShipping implements ShippingStrategy {
    @Override
    public double calculate(double weight) {
        return weight * 1.1;
    }
}
