import java.util.ArrayList;
import javax.swing.AbstractListModel;

class Baza extends AbstractListModel<Data> {
    private ArrayList<Data> array = new ArrayList<Data>();

    public void add(Data table) {
        array.add(table);
    }

    public void remove(int index) {
        array.remove(index);
    }

    public int getSize() {
        return array.size();
    }

    public Data getElementAt(int index) {
        return array.get(index);
    }
}