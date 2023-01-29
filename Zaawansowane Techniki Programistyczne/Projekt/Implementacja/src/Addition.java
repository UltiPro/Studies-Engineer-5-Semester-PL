public abstract class Addition extends Order {
    private Order order;
    public Addition() {}
    public Addition(Order order){
        this.order = order;
    }
    public String OrderDescription(){
        return order.OrderDescription();
    }
    public int Price(){
        return order.Price();
    }
}
