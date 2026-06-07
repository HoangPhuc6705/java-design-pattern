package DesignPattern.Decorator;

public class CheeseFoam extends MilkTeaDecorator {
    public CheeseFoam(MilkTea milkTea) {
        super(milkTea);
    }

    @Override
    public double getCost() {
        return super.getCost() + 10000; // +10k VND
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Kem cheese";
    }
}
