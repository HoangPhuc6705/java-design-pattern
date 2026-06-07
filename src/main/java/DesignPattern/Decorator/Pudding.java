package DesignPattern.Decorator;

public class Pudding extends MilkTeaDecorator {
    public Pudding(MilkTea milkTea) {
        super(milkTea);
    }

    @Override
    public double getCost() {
        return super.getCost() + 7000; // +7k VND
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Pudding";
    }
}
