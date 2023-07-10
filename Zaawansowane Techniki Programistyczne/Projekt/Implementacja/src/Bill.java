import java.io.FileNotFoundException;
import java.util.Date;
import java.util.LinkedList;
import java.io.PrintWriter;

public class Bill implements Receipt {
    public int id;
    public double price;

    public Bill(int id, double price) {
        this.id = id;
        this.price = price;
    }

    public Bill() {
    }

    @Override
    public void SetPrice(double price) {
        this.price = price;
    }

    @Override
    public void SetId(int id) {
        this.id = id;
    }

    @Override
    public void SettlementMethod(Order order) { // useless?
        order.SetBill(this);
    }

    @Override
    public double Settle(LinkedList<Product> products) {
        price = 0;
        for (Product product : products)
            price += product.getPrice();
        return price;
    }

    @Override
    public void WriteToFile() {
        try {
            Date data = new Date();
            PrintWriter writer = new PrintWriter("Receipt" + id + ".txt");
            writer.println("Receipt number " + id);
            writer.println("============================================================");
            writer.println("Price to pay: " + price + " PLN");
            writer.println("Operation date: " + data);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}