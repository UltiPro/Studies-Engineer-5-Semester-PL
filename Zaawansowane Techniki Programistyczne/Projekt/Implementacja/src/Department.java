import java.util.LinkedList;

public class Department extends Element {
    public int idWarehouse;
    public LinkedList<Category> categories = new LinkedList<Category>();
    public Department(int id, String name, int idWarehouse){
        this.name = name;
        this.id = id;
        this.idWarehouse = idWarehouse;
    }
    public Department(int id, String name){
        this.name = name;
        this.id = id;
    }
    @Override
    public String PrintDescription() {
        return ("Department: " + name);
    }
    @Override
    public void List() {
        for (Category category : categories) {
            category.PrintDescription();
            category.List();
        }
    }
    @Override
    public String toString() {
        return name;
    }
}