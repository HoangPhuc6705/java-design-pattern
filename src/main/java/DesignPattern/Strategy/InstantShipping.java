package DesignPattern.Strategy;

public class InstantShipping implements ShippingStrategy{
    @Override
    public double calculate(double weight) {
        return weight * 2.2;
    }
}
