package DesignPattern.Observer;

public class SalesDepartment implements Observer{
    @Override
    public void update(String productName, int stockCount) {
        System.out.println("Updating " + productName + " has count is " + stockCount);
    }
}
