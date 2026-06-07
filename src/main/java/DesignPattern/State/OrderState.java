package DesignPattern.State;

public interface OrderState {
    void pay(OrderContext orderContext);
    void ship(OrderContext orderContext);
    void confirm(OrderContext orderContext);
    void deliver(OrderContext orderContext);
    void cancel(OrderContext orderContext);
}
