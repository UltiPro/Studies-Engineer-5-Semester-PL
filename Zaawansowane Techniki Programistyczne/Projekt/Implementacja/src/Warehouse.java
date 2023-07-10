import java.util.LinkedList;

abstract class Warehouse {
    public int id;
    public String name;
    public LinkedList<Department> departments = new LinkedList<Department>();

    public Warehouse(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract String GetName();

    public abstract int GetSize();

    public abstract void Print();

    public abstract Product GetElement(String name);

    public abstract String GetProducts();
}