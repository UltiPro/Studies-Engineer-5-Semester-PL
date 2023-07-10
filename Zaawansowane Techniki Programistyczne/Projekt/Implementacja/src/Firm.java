import javax.swing.*;
import javax.swing.JFrame;
import java.util.LinkedList;

//singleton
final class Firm {
    private static Firm firm = null;
    public LinkedList<Product> products = new LinkedList<Product>();

    private Firm() {
    }

    public static Firm getInstance() {
        if (firm == null)
            firm = new Firm();
        return firm;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new LoginForm("Login in");
            }
        });
        Library library = new Library();
        Firm firm;
        firm = Firm.getInstance();
        firm.products = library.selectProduct();
        library.closeConnection();
    }
}