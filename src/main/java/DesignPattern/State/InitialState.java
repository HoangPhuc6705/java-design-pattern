package DesignPattern.State;

public class InitialState implements OrderState{
    @Override
    public void pay(OrderContext orderContext) {
        System.out.println("Đã thanh toán thành công, vui lòng chờ xác nhận đơn hàng");
        orderContext.setOrderState(orderContext.getPaidState());
    }

    @Override
    public void confirm(OrderContext orderContext) {
        System.out.println("Chua thanh toan don hang");
    }

    @Override
    public void ship(OrderContext orderContext) {
        System.out.println("Chua thanh toan don hang");
    }

    @Override
    public void deliver(OrderContext orderContext) {
        System.out.println("Chua thanh toan don hang");
    }

    @Override
    public void cancel(OrderContext orderContext) {
        System.out.println("Chua thanh toan don hang");
    }
}
