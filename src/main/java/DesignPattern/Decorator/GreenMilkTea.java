package DesignPattern.Decorator;

public class GreenMilkTea implements MilkTea {
    @Override
    public double getCost() {
        return 32000; // 32k VND
    }

    @Override
    public String getDescription() {
        return "Trà sữa xanh";
    }
}
