import java.util.LinkedList;

public class Order {
    public int idUser;
    public int numberOfOrder;
    public int idReceipt;
    Receipt receipt;
    public double toPay;
    public LinkedList<Product> products = new LinkedList<Product>();
    public LinkedList<Product> addedProducts = new LinkedList<Product>();
    public Order() { }
    public void PaymentMethod(Receipt receipt){
        this.receipt = receipt;
        this.receipt.SettlementMethod(this);
    }
    Order(int numberOfOrder, double toPay, LinkedList<Product> products, int idUser, int idReceipt){
        this.numberOfOrder = numberOfOrder;
        this.toPay = toPay;
        this.products = products;
        this.idUser = idUser;
        this.idReceipt = idReceipt;
    }
    public void AddToOrder(Product product){
        products.add(product);
    }
    public void RemoveFromOrder(String nameOfProduct){
        for(Product product : products){
            if(product.name.equals(nameOfProduct))
                products.remove(product);
        }
    }
    public int GetOrderNumber(){
        return numberOfOrder;
    }
    public double SetBill(Receipt receipt){
        toPay = 0;
        toPay = receipt.Settle(products);
        return toPay;
    }
    public String OrderDescription(){
        return "Order number: " + GetOrderNumber();
    }
    public int Price(){
        return 0;
    }
}