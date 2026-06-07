package DesignPattern.Decorator;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== THỬ NGHIỆM MILK TEA DECORATOR PATTERN ===");

        // Đơn hàng 1: Trà sữa đen + Trân châu
        MilkTea order1 = new BlackMilkTea();
        order1 = new Bubble(order1);
        System.out.println("Đơn hàng 1: " + order1.getDescription());
        System.out.println("Tổng tiền: " + order1.getCost() + " VND");
        System.out.println("---------------------------------------------");

        // Đơn hàng 2: Trà sữa xanh + Pudding + Kem cheese + Trân châu
        MilkTea order2 = new GreenMilkTea();
        order2 = new Pudding(order2);
        order2 = new CheeseFoam(order2);
        order2 = new Bubble(order2);
        System.out.println("Đơn hàng 2: " + order2.getDescription());
        System.out.println("Tổng tiền: " + order2.getCost() + " VND");
        System.out.println("---------------------------------------------");
    }
}
