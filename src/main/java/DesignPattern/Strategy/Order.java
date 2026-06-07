package DesignPattern.Strategy;

public class Order {
    private double weight;
    private ShippingStrategy shippingStrategy;
    private double price;

    public Order(double weight, double price) {
        this.weight = weight;
        this.price = price;
    }

    public void setShippingStrategy(ShippingStrategy shippingStrategy) {
        this.shippingStrategy = shippingStrategy;
    }

    public double calculateTotalShippingFee() {
        return shippingStrategy.calculate(this.weight) * price;
    }

}
