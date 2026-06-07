package DesignPattern.Decorator;

public abstract class MilkTeaDecorator implements MilkTea {
    protected MilkTea milkTea;

    public MilkTeaDecorator(MilkTea milkTea) {
        this.milkTea = milkTea;
    }

    @Override
    public double getCost() {
        return milkTea.getCost();
    }

    @Override
    public String getDescription() {
        return milkTea.getDescription();
    }
}
