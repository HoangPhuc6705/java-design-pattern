package DesignPattern.State;

public class CanceledState implements OrderState{
    @Override
    public void pay(OrderContext orderContext) {
        System.out.println("Đơn hàng đã huỷ, phí thanh toán sẽ được hoàn trả");
    }

    @Override
    public void ship(OrderContext orderContext) {
        System.out.println("Không thể bàn giao cho đơn vị vận chuyển vì đơn hàng đã huỷ");
    }

    @Override
    public void confirm(OrderContext orderContext) {
        System.out.println("Đơn hàng đã huỷ");
    }

    @Override
    public void deliver(OrderContext orderContext) {
        System.out.println("Đơn hàng đã huỷ");
    }

    @Override
    public void cancel(OrderContext orderContext) {
        System.out.println("Đơn hàng đã huỷ");
    }
}
