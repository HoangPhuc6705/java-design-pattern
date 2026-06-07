package DesignPattern.State;

public class ShippedState implements OrderState {
    @Override
    public void pay(OrderContext orderContext) {
        System.out.println("Don hang da thanh toan, dang van chuyen don hang");
    }

    @Override
    public void confirm(OrderContext orderContext) {
        System.out.println("Đơn hàng đã được giao cho đơn vị vận chuyển, không thể xác nhận lại");
    }

    @Override
    public void ship(OrderContext orderContext) {
        System.out.println("Don hang dang duoc van chuyen");
    }

    @Override
    public void deliver(OrderContext orderContext) {
        orderContext.setOrderState(orderContext.getDeliveredState());
        System.out.println("Don hang da duoc giao thanh cong");
    }

    @Override
    public void cancel(OrderContext orderContext) {
        System.out.println("Khong the huy don khi don hang dang van chuyen");
    }
}
