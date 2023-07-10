class TableDataInt implements Table {
    private int data;

    public String toString() {
        return Integer.toString(data);
    }

    public Table makeCopy() {
        TableDataInt obj = null;
        try {
            obj = (TableDataInt) super.clone();
            obj.data = rnd.nextInt(100);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}