package DesignPattern.Observer;

import java.util.ArrayList;
import java.util.List;

public class ProductInventory implements Subject {
    private String productName;
    private int stockCount;
    private List<Observer> observers;

    public ProductInventory(String productName, int stockCount) {
        observers = new ArrayList<>();
        this.productName = productName;
        this.stockCount = stockCount;
    }

    public void setStockCount(int count) {
        stockCount = count;
        notifyObserver();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observers.forEach(o -> {
            o.update(productName, stockCount);
        });
    }
}
