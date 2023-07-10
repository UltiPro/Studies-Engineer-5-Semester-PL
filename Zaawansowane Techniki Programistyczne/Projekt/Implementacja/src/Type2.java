import java.util.LinkedList;

public class Type2 extends Element {
    public int count;
    public int idCategory;
    public LinkedList<Product> products = new LinkedList<Product>();

    public Type2(int id, String name, int idCategory) {
        this.id = id;
        this.name = name;
        this.idCategory = idCategory;
    }

    public Type2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String PrintDescription() {
        return ("Type of Product: " + name);
    }

    @Override
    public void List() {
        for (Product product : products) {
            product.PrintDescription();
            product.List();
        }
    }

    @Override
    public String toString() {
        return name;
    }
}