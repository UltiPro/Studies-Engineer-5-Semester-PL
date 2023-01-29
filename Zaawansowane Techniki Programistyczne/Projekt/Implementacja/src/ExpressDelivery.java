public class ExpressDelivery extends Addition {
    public ExpressDelivery(Order order) {
        super(order);
    }
    @Override
    public String OrderDescription() {
        return super.OrderDescription() + ", Express Delivery";
    }
    @Override
    public int Price() {
        return super.Price() + 5;
    }
}
