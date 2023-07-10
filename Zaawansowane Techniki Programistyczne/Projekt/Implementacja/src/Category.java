import java.util.LinkedList;

public class Category extends Element {
    public int idDepartment;
    public LinkedList<Type2> type2s = new LinkedList<Type2>();

    public Category(int id, String name, int idDepartment) {
        this.id = id;
        this.name = name;
        this.idDepartment = idDepartment;
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String PrintDescription() {
        return ("Category: " + name);
    }

    @Override
    public void List() {
        for (Type2 type2 : type2s) {
            type2.PrintDescription();
            type2.List();
        }
    }

    @Override
    public String toString() {
        return name;
    }
}