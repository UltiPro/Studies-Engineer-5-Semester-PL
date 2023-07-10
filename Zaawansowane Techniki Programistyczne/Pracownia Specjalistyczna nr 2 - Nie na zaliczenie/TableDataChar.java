class TableDataChar implements Table {
    private char data;

    public String toString() {
        return Character.toString(data);
    }

    public Table makeCopy() {
        TableDataChar obj = null;
        try {
            obj = (TableDataChar) super.clone();
            obj.data = (char) ('a' + rnd.nextInt(26));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}