public interface ProductBuilderInterface {
    public Product.ProductBuilder setId(int id);
    public Product.ProductBuilder setName(String name);
    public Product.ProductBuilder setPrice(double price);
    public Product.ProductBuilder setCount(int count);
    public Product.ProductBuilder setIdType(int idType);
    public Product.ProductBuilder setIdWarehouse(int idWarehouse);
    public Product.ProductBuilder setIdOrder(int idOrder);
}
