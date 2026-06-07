package DesignPattern.State;

public class Main {
    public static void main(String[] args) {


        OrderContext order = new OrderContext("Laptop Lenovo ThinkPad X1 Carbon gen 14");
        order.pay();
        order.confirm();
        order.ship();
        order.deliver();

        System.out.println("-".repeat(50));

        OrderContext order2 = new OrderContext("Laptop Lenovo LOQ");
        order2.pay();
        order2.cancel();
        order2.deliver();

    }
}
