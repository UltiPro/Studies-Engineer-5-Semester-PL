class TableDataBoolen implements Table {
    private boolean data;

    public String toString() {
        return Boolean.toString(data);
    }

    public Table makeCopy() {
        TableDataBoolen obj = null;
        try {
            obj = (TableDataBoolen) super.clone();
            obj.data = rnd.nextBoolean();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}