public class Product extends Element {
    public int id;
    public String name;
    public double price = 0;
    public int count = 0;
    public int idType;
    public int idWarehouse;
    public int idOrder;

    private Product(int id, String name, double price, int count, int idType, int idWarehouse, int idOrder) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.idType = idType;
        this.idWarehouse = idWarehouse;
        this.idOrder = idOrder;
    }

    public static class ProductBuilder implements ProductBuilderInterface {
        private int id;
        private String name;
        private double price;
        private int count;
        private int idType;
        private int idWarehouse;
        private int idOrder;

        public ProductBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public ProductBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        public ProductBuilder setCount(int count) {
            this.count = count;
            return this;
        }

        public ProductBuilder setIdType(int idType) {
            this.idType = idType;
            return this;
        }

        public ProductBuilder setIdWarehouse(int idWarehouse) {
            this.idWarehouse = idWarehouse;
            return this;
        }

        public ProductBuilder setIdOrder(int idOrder) {
            this.idOrder = idOrder;
            return this;
        }

        public Product build() {
            return new Product(id, name, price, count, idType, idWarehouse, idOrder);
        }
    }

    public double getPrice() {
        return this.price;
    }

    public int getCount() {
        return this.count;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String PrintDescription() {
        return (name + ", price: " + price + " , count: " + count);
    }

    @Override
    public String toString() {
        return "[" + id + "] - " + name + " - " + price + "-" + idOrder;
    }

    @Override
    public void List() {
    }
}