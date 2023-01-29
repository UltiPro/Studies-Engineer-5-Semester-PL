import java.util.LinkedList;

public class SalesWarehouse extends Warehouse {
    public LinkedList<Product> parts = new LinkedList<Product>();
    public SalesWarehouse(int id, String name) {
        super(id,name);
    }
    @Override
    public String GetName() { return name; }
    @Override
    public int GetSize() {
        return parts.size();
    }
    @Override
    public void Print() {
        for (Product product : parts) {
            product.PrintDescription();
        }
    }
    @Override
    public Product GetElement(String name) {
        for(Product product : parts){
            if(product.name == name)
                return product;
        }
        return null;
    }
    @Override
    public String GetProducts() {
        for(Product product : parts){
            return product.name;
        }
        return null;
    }
}