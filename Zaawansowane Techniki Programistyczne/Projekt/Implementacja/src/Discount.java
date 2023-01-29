import java.util.LinkedList;
public class Discount extends Addition {
    public int id;
    public String discountCode;
    public LinkedList<Discount> discounts = new LinkedList<Discount>();
    public Discount() {}
    public Discount(Order order) {
        super(order);
    }
    public Discount(int id, String discountCode) {
        this.id = id;
        this.discountCode = discountCode;
    }
    public Discount GetElement(int index){
        for(Discount discount : discounts) {
            if (index == discount.id)
                return discount;
        }
        return null;
    }
    @Override
    public String OrderDescription() {
        return super.OrderDescription() + ", Your code for next shopping is 'sale10%'";
    }
    @Override
    public int Price() {
        return super.Price();
    }
    @Override
    public String toString() {
        return "["+id+"] - "+discountCode;
    }
}
