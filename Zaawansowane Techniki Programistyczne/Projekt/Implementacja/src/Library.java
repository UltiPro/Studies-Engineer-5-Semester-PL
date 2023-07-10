import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Library implements Proxy {
    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:library.db";
    private Connection connection;
    private Statement statement;

    public Library() {
        try {
            Class.forName(Library.DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("There is no JDBC driver");
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(DB_URL);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.err.println("Connection Problem with SQLite");
            e.printStackTrace();
        }
    }

    public boolean insertDepartament(String name) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Dzial values (NULL,?);");
            preparedStatement.setString(1, name);
            preparedStatement.execute();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public List<Department> selectDepartment() {
        List<Department> departmentsList = new LinkedList<Department>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Dzial");
            int id;
            String name;
            while (resultSet.next()) {
                id = resultSet.getInt("id_dzial");
                name = resultSet.getString("nazwa");
                departmentsList.add(new Department(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return departmentsList;
    }

    public boolean insertInvoiceForPerson(String name, String surname, double price) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into FakturaNaOsobeFizyczna values (NULL,?,?,?);");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, String.valueOf(price));
            preparedStatement.execute();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public List<InvoiceForPerson> selectInvoiceForPerson() {
        List<InvoiceForPerson> invoiceForPersonList = new LinkedList<InvoiceForPerson>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM FakturaNaOsobeFizyczna");
            int id;
            double price;
            String name, surname;
            while (resultSet.next()) {
                id = resultSet.getInt("id_fakturyfiz");
                name = resultSet.getString("imie");
                surname = resultSet.getString("nazwisko");
                price = resultSet.getDouble("cena");
                invoiceForPersonList.add(new InvoiceForPerson(id, name, surname, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return invoiceForPersonList;
    }

    public boolean insertInvoiceForFirm(double NIP, double price) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into FakturaNaFirme values (NULL,?,?);");
            preparedStatement.setString(1, String.valueOf(NIP));
            preparedStatement.setString(2, String.valueOf(price));
            preparedStatement.execute();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public List<InvoiceForFirm> selectInvoiceForFirm() {
        List<InvoiceForFirm> invoiceForFirmList = new LinkedList<InvoiceForFirm>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM FakturaNaFirme");
            int id;
            double price;
            double NIP;
            while (resultSet.next()) {
                id = resultSet.getInt("id_faktury");
                price = resultSet.getDouble("cena");
                NIP = resultSet.getDouble("NIP");
                invoiceForFirmList.add(new InvoiceForFirm(id, price, NIP));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return invoiceForFirmList;
    }

    public boolean insertCategory(String name, int idDepartament) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into Kategoria values (NULL,?,?);");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, String.valueOf(idDepartament));
            preparedStatement.execute();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public List<Category> selectCategory() {
        List<Category> categoryList = new LinkedList<Category>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Kategoria");
            int id;
            String name;
            int idDepartment;
            while (resultSet.next()) {
                id = resultSet.getInt("id_kategorii");
                name = resultSet.getString("nazwa");
                idDepartment = resultSet.getInt("id_dzialu");
                categoryList.add(new Category(id, name, idDepartment));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return categoryList;
    }

    public boolean insertWarehouseOfComplaint(String name) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into MagazynReklamacji values (NULL,?);");
            preparedStatement.setString(1, name);
            preparedStatement.execute();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public boolean deleteWarehouseOfComplaint(String name) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from MagazynReklamacji where nazwa = ?");
            preparedStatement.setString(1, String.valueOf(name));
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<ComplaintWarehouse> selectWarehouseComplaint() {
        List<ComplaintWarehouse> complaintWarehouse = new LinkedList<ComplaintWarehouse>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM MagazynReklamacji");
            int id;
            String name;
            while (resultSet.next()) {
                id = resultSet.getInt("id_magazynurekl");
                name = resultSet.getString("nazwa");
                complaintWarehouse.add(new ComplaintWarehouse(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return complaintWarehouse;
    }

    public boolean insertWarehouseOfSales(String name) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into MagazynSprzedazy values (NULL,?);");
            preparedStatement.setString(1, name);
            preparedStatement.execute();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public boolean deleteWarehouseOfSales(String name) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from MagazynSprzedazy where nazwa = ?");
            preparedStatement.setString(1, String.valueOf(name));
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<SalesWarehouse> selectWarehouseOfSales() {
        List<SalesWarehouse> SalesWarehouseList = new LinkedList<SalesWarehouse>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM MagazynSprzedazy");
            int id;
            String name;
            while (resultSet.next()) {
                id = resultSet.getInt("id_magazynusprz");
                name = resultSet.getString("nazwa");
                SalesWarehouseList.add(new SalesWarehouse(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return SalesWarehouseList;
    }

    public boolean insertReceipt(double cena) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Paragon values (NULL,?);");
            preparedStatement.setString(1, String.valueOf(cena));
            preparedStatement.execute();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public List<Bill> selectReceipt() {
        List<Bill> bills = new LinkedList<Bill>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Paragon");
            int id;
            double price;
            while (resultSet.next()) {
                id = resultSet.getInt("id_paragonu");
                price = resultSet.getDouble("cena");
                bills.add(new Bill(id, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return bills;
    }

    public boolean insertProduct(String name, double price, int typeId, int warehouseId, int orderId, int count) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into Produkt values (NULL,?,?,?,?,?,?);");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, String.valueOf(price));
            preparedStatement.setString(3, String.valueOf(typeId));
            preparedStatement.setString(4, String.valueOf(warehouseId));
            preparedStatement.setString(5, String.valueOf(orderId));
            preparedStatement.setString(6, String.valueOf(count));
            preparedStatement.execute();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public boolean deleteProduct(String name) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from Produkt where nazwa = ?");
            preparedStatement.setString(1, String.valueOf(name));
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateProduct(int id, String name, double price, int typeId, int warehouseId, int orderId,
            int count) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE Produkt SET nazwa=?,cena=?,id_typu=?,id_magazynu=?,id_zamowienia=?,ilosc=? WHERE id_produktu = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, String.valueOf(price));
            preparedStatement.setString(3, String.valueOf(typeId));
            preparedStatement.setString(4, String.valueOf(warehouseId));
            preparedStatement.setString(5, String.valueOf(orderId));
            preparedStatement.setString(6, String.valueOf(count));
            preparedStatement.setString(7, String.valueOf(id));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public LinkedList<Product> selectProduct() {
        LinkedList<Product> productsList = new LinkedList<Product>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Produkt");
            int id, count, typeId, warehouseId, orderId;
            double price;
            String name;
            while (resultSet.next()) {
                id = resultSet.getInt("id_produktu");
                name = resultSet.getString("nazwa");
                price = resultSet.getDouble("cena");
                count = resultSet.getInt("ilosc");
                typeId = resultSet.getInt("id_typu");
                warehouseId = resultSet.getInt("id_magazynu");
                orderId = resultSet.getInt("id_zamowienia");
                productsList.add(new Product.ProductBuilder()
                        .setId(id)
                        .setName(name)
                        .setPrice(price)
                        .setCount(count)
                        .setIdType(typeId)
                        .setIdWarehouse(warehouseId)
                        .setIdOrder(orderId)
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return productsList;
    }

    public boolean insertTyp(String name, int categoryId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Typ values (NULL,?,?);");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, String.valueOf(categoryId));
            preparedStatement.execute();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public List<Type2> selectType() {
        List<Type2> types = new LinkedList<Type2>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Typ");
            int id, price;
            String name;
            int categoryId;
            while (resultSet.next()) {
                id = resultSet.getInt("id_typu");
                name = resultSet.getString("nazwa");
                categoryId = resultSet.getInt("id_kategorii");
                types.add(new Type2(id, name, categoryId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return types;
    }

    public boolean insertUser(String name, String surname, String email, String password, int typ) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into Uzytkownik values (NULL,?,?,?,?,?);");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            preparedStatement.setInt(5, typ);
            preparedStatement.execute();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public boolean deleteUser(int id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from Uzytkownik where id_uzytkownika = ?");
            preparedStatement.setString(1, String.valueOf(id));
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<User> selectUser() {
        List<User> users = new LinkedList<User>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Uzytkownik");
            int id, accountType;
            String name, surname, email, password;
            while (resultSet.next()) {
                id = resultSet.getInt("id_uzytkownika");
                name = resultSet.getString("imie");
                surname = resultSet.getString("nazwisko");
                email = resultSet.getString("email");
                password = resultSet.getString("haslo");
                accountType = resultSet.getInt("typ_konta");
                users.add(new User(id, name, surname, email, password, accountType));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return users;
    }

    public boolean insertOrder(double toPay, int userId, int receitpId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into Zamowienie values (NULL,?,?,?);");
            preparedStatement.setString(1, String.valueOf(toPay));
            preparedStatement.setString(2, String.valueOf(userId));
            preparedStatement.setString(3, String.valueOf(receitpId));
            preparedStatement.execute();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public boolean deleteOrder(int id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from Zamowienie where id_zamowienia = ?");
            preparedStatement.setString(1, String.valueOf(id));
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Order> selectOrder() {
        List<Order> orders = new LinkedList<Order>();
        LinkedList<Product> temp = selectProduct();
        LinkedList<Product> products = new LinkedList<>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Zamowienie");
            // ResultSet resultSet1 = stat.executeQuery("SELECT * FROM Produkt WHERE
            // id_zamowienia" + id);
            int id, idUser, idReceipt;
            double price;
            while (resultSet.next()) {
                id = resultSet.getInt("id_zamowienia");
                price = resultSet.getDouble("dozaplaty");
                idUser = resultSet.getInt("id_uzytkownika");
                idReceipt = resultSet.getInt("id_rachunku");
                for (int i = 0; i < temp.size(); i++) {
                    if (temp.get(i).idOrder == id) {
                        products.add(temp.get(i));
                    }
                }
                orders.add(new Order(id, price, products, idUser, idReceipt));
                products.clear();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return orders;
    }

    public List<Discount> selectDiscount() {
        List<Discount> discount = new LinkedList<Discount>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Znizki");
            int id;
            String code;
            while (resultSet.next()) {
                id = resultSet.getInt("id_znizki");
                code = resultSet.getString("kodznizkowy");
                discount.add(new Discount(id, code));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return discount;
    }

    public boolean findDiscount(String discount) {
        if (discount == "winterSale")
            return true;
        return false;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}