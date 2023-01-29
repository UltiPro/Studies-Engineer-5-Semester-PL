import java.util.Random;

interface Table extends Cloneable {
    final static Random rnd = new Random();

    public Table makeCopy();
}

class TableHeader {
    private String type;
    private Table table;

    public TableHeader(String type, Table table) {
        this.type = type;
        this.table = table;
    }

    public String toString() {
        return type;
    }

    public Table createTableData() {
        return table.makeCopy();
    }
}