package DesignPattern.State;

public class OrderContext {
    private String name;

    private PendingState pendingState = new PendingState();
    private ShippedState shippedState = new ShippedState();
    private DeliveredState deliveredState = new DeliveredState();
    private PaidState paidState = new PaidState();
    private CanceledState canceledState = new CanceledState();
    private InitialState initialState = new InitialState();

    private OrderState orderState;

    public OrderContext(String name) {
        this.name = name;
        setOrderState(initialState);
    }

    public void setOrderState(OrderState state) {
        this.orderState = state;
    }

    public void pay() {
        this.orderState.pay(this);
    }

    public void confirm() {
        this.orderState.confirm(this);
    }

    public void ship() {
        this.orderState.ship(this);
    }

    public void deliver() {
        this.orderState.deliver(this);
    }

    public void cancel() {
        this.orderState.cancel(this);
    }

    public PendingState getPendingState() {
        return pendingState;
    }

    public ShippedState getShippedState() {
        return shippedState;
    }

    public DeliveredState getDeliveredState() {
        return deliveredState;
    }

    public PaidState getPaidState() {
        return paidState;
    }

    public CanceledState getCanceledState() {
        return canceledState;
    }
}
