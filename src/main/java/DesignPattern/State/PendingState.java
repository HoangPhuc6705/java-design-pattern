package DesignPattern.State;

public class PendingState implements OrderState {
    @Override
    public void pay(OrderContext orderContext) {
        System.out.println("Đơn hàng đã được thanh toán, đang chờ xác thực");
    }

    @Override
    public void confirm(OrderContext orderContext) {
        System.out.println("Đơn hàng đã được xác nhận trước đó");
    }

    @Override
    public void ship(OrderContext orderContext) {
        orderContext.setOrderState(orderContext.getShippedState());
        System.out.println("Don hang da ban giao cho don vi van chuyen va dang van chuyen");
    }

    @Override
    public void deliver(OrderContext orderContext) {
        System.out.println("Đơn hàng đang xác thực");
    }

    @Override
    public void cancel(OrderContext orderContext) {
        orderContext.setOrderState(orderContext.getCanceledState());
        System.out.println("Đơn hàng đã huỷ");
    }
}
