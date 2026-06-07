package DesignPattern.Decorator;

public class Bubble extends MilkTeaDecorator {
    public Bubble(MilkTea milkTea) {
        super(milkTea);
    }

    @Override
    public double getCost() {
        return super.getCost() + 5000; // +5k VND
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Trân châu";
    }
}
