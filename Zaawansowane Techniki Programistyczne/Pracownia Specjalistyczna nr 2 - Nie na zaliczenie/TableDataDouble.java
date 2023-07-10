class TableDataDouble implements Table {
    private double data;

    public String toString() {
        return Double.toString(data);
    }

    public Table makeCopy() {
        TableDataDouble obj = null;
        try {
            obj = (TableDataDouble) super.clone();
            obj.data = rnd.nextDouble();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}