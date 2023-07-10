class RealData implements Data {
    public int[] table;

    public RealData(int size) {
        table = new int[size];
    }

    public int get(int index) {

        return table[index];
    }

    public void set(int index, int value) {
        table[index] = value;
    }

    public int size() {
        return table.length;
    }
}