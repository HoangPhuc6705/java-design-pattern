package DesignPattern.Strategy;

public class Main {
    public static void main(String[] args) {
        Order order = new Order(10, 12000);
        order.setShippingStrategy(new EconomyShipping());
        System.out.println(order.calculateTotalShippingFee());
        order.setShippingStrategy(new InstantShipping());
        System.out.println(order.calculateTotalShippingFee());
        order.setShippingStrategy(new ExpressShipping());
        System.out.println(order.calculateTotalShippingFee());
    }
}
