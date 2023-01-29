import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.LinkedList;

public class InvoiceForPerson implements Receipt {
    public int id;
    public String name;
    public String surname;
    public double priceToPay;
    InvoiceForPerson() {}
    InvoiceForPerson(int id, String name, String surname, double priceToPay){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.priceToPay = priceToPay;
    }
    @Override
    public void SetPrice(double priceToPay){
        this.priceToPay = priceToPay;
    }
    @Override
    public void SetId(int id){
        this.id = id;
    }
    public void SetName(String name){
        this.name = name;
    }
    public void SetSurname(String surname){
        this.surname = surname;
    }
    @Override
    public void SettlementMethod(Order order) {
        order.SetBill(this);
    }
    @Override
    public double Settle(LinkedList<Product> products) {
        priceToPay = 0;
        for (Product product : products){
            priceToPay += product.getPrice();
        }
        return priceToPay;
    }
    @Override
    public void WriteToFile(){
        try {
            Date data = new Date();
            PrintWriter writer = new PrintWriter("invoice_person" + id + ".txt");
            writer.println("Invoice for person number " + id);
            writer.println("============================================================");
            writer.println("Invoice for: " + name + " "+ surname);
            writer.println("Price to pay: " + priceToPay + " PLN");
            writer.println("Operation date: " + data);
            writer.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
