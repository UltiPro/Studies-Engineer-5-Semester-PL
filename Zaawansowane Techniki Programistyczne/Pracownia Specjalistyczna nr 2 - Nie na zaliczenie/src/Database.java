import javax.swing.table.*;
import java.util.*;

class Database extends AbstractTableModel {
    private List<TableHeader> headers;
    private List<List<Table>> data;

    public Database() {
        headers = new ArrayList<TableHeader>();
        data = new ArrayList<List<Table>>();
    }

    public void addRow() {
        List<Table> row = new ArrayList<Table>();
        for (TableHeader col : headers)
            row.add(col.createTableData()); // wywołanie metody fabrykującej
        data.add(row);
        fireTableStructureChanged();
    }

    public void addCol(TableHeader type) {
        headers.add(type);
        for (List<Table> row : data)
            row.add(type.createTableData()); // wywołanie metody fabrykującej
        fireTableStructureChanged();
    }

    public int getRowCount() {
        return data.size();
    }

    public int getColumnCount() {
        return headers.size();
    }

    public String getColumnName(int column) {
        return headers.get(column).toString();
    }

    public Object getValueAt(int row, int column) {
        return data.get(row).get(column);
    }
}