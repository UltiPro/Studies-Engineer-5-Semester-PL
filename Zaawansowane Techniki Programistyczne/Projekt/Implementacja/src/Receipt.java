import java.util.LinkedList;

public interface Receipt {
    void SettlementMethod(Order order);

    double Settle(LinkedList<Product> products);

    void WriteToFile();

    void SetId(int id);

    void SetPrice(double price);
}