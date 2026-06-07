package DesignPattern.State;

public class PaidState implements OrderState{
    @Override
    public void pay(OrderContext orderContext) {
        System.out.println("Đơn hàng đã được thanh toán");
    }

    @Override
    public void confirm(OrderContext orderContext) {
        orderContext.setOrderState(orderContext.getPendingState());
        System.out.println("Đơn hàng đã được xác nhận");
    }

    @Override
    public void ship(OrderContext orderContext) {
        System.out.println("Dang cho xac nhan");
    }

    @Override
    public void deliver(OrderContext orderContext) {
        System.out.println("Dang cho xac nhan");
    }

    @Override
    public void cancel(OrderContext orderContext) {
        orderContext.setOrderState(orderContext.getCanceledState());
        System.out.println("Đơn hàng đã huỷ");
    }
}
