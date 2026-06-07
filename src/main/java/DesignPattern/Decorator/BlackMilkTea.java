package DesignPattern.Decorator;

public class BlackMilkTea implements MilkTea {
    @Override
    public double getCost() {
        return 30000; // 30k VND
    }

    @Override
    public String getDescription() {
        return "Trà sữa đen";
    }
}
