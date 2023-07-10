import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.LinkedList;

public class InvoiceForFirm implements Receipt {
    public int id;
    public double priceToPay;
    public double NIP;

    InvoiceForFirm() {
    }

    InvoiceForFirm(int id, double priceToPay, double NIP) {
        this.priceToPay = priceToPay;
        this.NIP = NIP;
        this.id = id;
    }

    @Override
    public void SetPrice(double priceToPay) {
        this.priceToPay = priceToPay;
    }

    @Override
    public void SetId(int id) {
        this.id = id;
    }

    public void SetNip(double NIP) {
        this.NIP = NIP;
    }

    @Override
    public void SettlementMethod(Order order) { // useLess
        order.SetBill(this);
    }

    @Override
    public double Settle(LinkedList<Product> products) {
        priceToPay = 0;
        for (Product product : products) {
            priceToPay += product.getPrice();
        }
        return priceToPay;
    }

    @Override
    public String toString() {
        return "[" + id + "] - " + priceToPay + " - " + NIP;
    }

    @Override
    public void WriteToFile() {
        try {
            DecimalFormat df = new DecimalFormat("0.#");
            Date data = new Date();
            PrintWriter writer = new PrintWriter("invoice_firm" + id + ".txt");
            writer.println("Invoice for firm number " + id);
            writer.println("==============================");
            writer.println("NIP: " + df.format(NIP));
            writer.println("Price to pay: " + priceToPay + " PLN");
            writer.println("Operation date: " + data);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}