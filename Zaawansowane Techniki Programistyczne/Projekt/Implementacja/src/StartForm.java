import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartForm extends JFrame {
    private JPanel panel1;
    private JButton shop;
    private JButton adminPanel;

    public StartForm(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1);
        setSize(600, 450);
        setVisible(true);

        adminPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame = new AdminPanelForm("Admin Panel");
                frame.setVisible(true);
                dispose();
            }
        });

        shop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new ShopForm("Shop");
                frame.setVisible(true);
                dispose();
            }
        });
    }
}