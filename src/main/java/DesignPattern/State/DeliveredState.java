package DesignPattern.State;

public class DeliveredState implements OrderState{
    @Override
    public void pay(OrderContext orderContext) {

    }

    @Override
    public void confirm(OrderContext orderContext) {
        System.out.println("Đơn hàng đã được giao thành công");
    }

    @Override
    public void ship(OrderContext orderContext) {

    }

    @Override
    public void deliver(OrderContext orderContext) {

    }

    @Override
    public void cancel(OrderContext orderContext) {

    }
}
