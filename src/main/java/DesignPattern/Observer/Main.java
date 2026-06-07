package DesignPattern.Observer;

public class Main {
    public static void main(String[] args) {
        PurchasingDepartment p1 = new PurchasingDepartment();
        SalesDepartment s1 = new SalesDepartment();
        ProductInventory pi = new ProductInventory("Ram 16gb ddr5 4700Mhz", 10);
        pi.attach(p1);
        pi.attach(s1);


        pi.setStockCount(50);
        pi.setStockCount(5);


    }
}
