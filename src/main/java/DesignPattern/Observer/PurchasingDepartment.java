package DesignPattern.Observer;

public class PurchasingDepartment implements Observer {
    @Override
    public void update(String productName, int stockCount) {
        System.out.println("Updating product: " + productName + " has count is " + stockCount);
    }
}
