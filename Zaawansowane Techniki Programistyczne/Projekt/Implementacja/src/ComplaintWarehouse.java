import java.util.LinkedList;

public class ComplaintWarehouse extends Warehouse {
    public LinkedList<Product> toComplaint = new LinkedList<Product>();
    public ComplaintWarehouse(int id, String name) {
        super(id,name);
    }
    @Override
    public String GetName() { return name; }
    @Override
    public int GetSize() {
        return toComplaint.size();
    }
    @Override
    public void Print() {
        for (Product product : toComplaint) {
            product.PrintDescription();
        }
    }
    @Override
    public Product GetElement(String name) {
        for(Product product : toComplaint){
            if(product.name == name)
                return product;
        }
        return null;
    }
    @Override
    public String GetProducts() {
        for(Product product : toComplaint){
            return product.name;
        }
        return null;
    }
}
