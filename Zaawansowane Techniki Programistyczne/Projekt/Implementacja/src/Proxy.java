import java.util.LinkedList;
import java.util.List;

public interface Proxy {
    public boolean insertDepartament(String name);
    public List<Department> selectDepartment();
    public boolean insertInvoiceForPerson(String name, String surname, double price);
    public List<InvoiceForPerson> selectInvoiceForPerson();
    public boolean insertInvoiceForFirm(double NIP, double price);
    public List<InvoiceForFirm> selectInvoiceForFirm();
    public boolean insertCategory(String name, int idDepartament);
    public List<Category> selectCategory();
    public boolean insertWarehouseOfComplaint(String name);
    public boolean deleteWarehouseOfComplaint(String name);
    public List<ComplaintWarehouse> selectWarehouseComplaint();
    public boolean insertWarehouseOfSales(String name);
    public boolean deleteWarehouseOfSales(String name);
    public List<SalesWarehouse> selectWarehouseOfSales();
    public boolean insertReceipt(double cena);
    public List<Bill> selectReceipt();
    public boolean insertProduct(String name, double price, int typeId, int warehouseId, int orderId, int count);
    public boolean deleteProduct(String name);
    public boolean updateProduct(int id, String name, double price, int typeId, int warehouseId, int orderId, int count);
    public LinkedList<Product> selectProduct();
    public boolean insertTyp(String name, int categoryId);
    public List<Type2> selectType();
    public boolean insertUser(String name, String surname, String email, String password, int typ);
    public boolean deleteUser(int id);
    public List<User> selectUser();
    public boolean insertOrder(double toPay, int userId, int receitpId);
    public boolean deleteOrder(int id);
    public List<Order> selectOrder();
    public List<Discount> selectDiscount();
    public boolean findDiscount(String discount);
    public void closeConnection();
}
