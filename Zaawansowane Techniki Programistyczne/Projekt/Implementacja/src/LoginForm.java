import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.GroupLayout;

public class LoginForm extends JFrame {
    public LoginForm() {
        initComponents();
    }

    private void SignInMouseClickLabel(MouseEvent e) {
        JFrame frame = new SignInForm("Sign In.");
        frame.setVisible(true);
        dispose();
    }

    private void initComponents() {
        JLabel label1 = new JLabel();
        emailField = new JTextField();
        JLabel label2 = new JLabel();
        passwordField = new JPasswordField();
        JPanel panel1 = new JPanel();
        JLabel label3 = new JLabel();
        loginInBtn = new JButton();
        JLabel signInLabel = new JLabel();
        JLabel label4 = new JLabel();

        // ======== this ========
        setResizable(false);
        setName("this");
        var contentPane = getContentPane();

        // ---- label1 ----
        label1.setText("E-mail:");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 1f));
        label1.setName("label1");

        // ---- emailField ----
        emailField.setFont(emailField.getFont().deriveFont(emailField.getFont().getSize() + 4f));
        emailField.setName("emailField");

        // ---- label2 ----
        label2.setText("Password:");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 1f));
        label2.setName("label2");

        passwordField.setFont(passwordField.getFont().deriveFont(passwordField.getFont().getSize() + 4f));
        passwordField.setName("passwordField");

        // ======== panel1 ========
        {
            panel1.setName("panel1");
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                            "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",
                            javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
                            new java.awt.Font("Dia\u006cog", java.awt.Font.BOLD, 12), java.awt.Color.red),
                    panel1.getBorder()));
            panel1.addPropertyChangeListener(
                    new java.beans.PropertyChangeListener() {
                        @Override
                        public void propertyChange(java.beans.PropertyChangeEvent e) {
                            if ("\u0062ord\u0065r"
                                    .equals(e.getPropertyName()))
                                throw new RuntimeException();
                        }
                    });

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                            .addGap(0, 0, Short.MAX_VALUE));
            panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                            .addGap(0, 0, Short.MAX_VALUE));
        }

        // ---- label3 ----
        label3.setText("text");
        label3.setIcon(new ImageIcon(getClass().getResource("/warehouse.jpg")));
        label3.setName("label3");

        loginInBtn.setText("Login In");
        loginInBtn.setBackground(new Color(0, 0, 102));
        loginInBtn.setForeground(Color.white);
        loginInBtn.setName("loginInBtn");

        signInLabel.setText("You do not have an account? Register now!");
        signInLabel.setName("signInLabel");
        signInLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SignInMouseClickLabel(e);
            }
        });

        // ---- label4 ----
        label4.setText("Login In");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 11f));
        label4.setName("label4");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 455, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 72,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 72,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 246,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 122,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(loginInBtn)
                                        .addComponent(signInLabel)
                                        .addComponent(emailField, GroupLayout.PREFERRED_SIZE, 249,
                                                GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addGap(63, 63, 63)));
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(loginInBtn)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(signInLabel)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization //GEN-END:initComponents
    }

    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginInBtn;
    Library library = new Library();

    public LoginForm(String title) {
        super(title);
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        loginInBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Email, Password;
                Email = emailField.getText();
                Password = passwordField.getText();

                for (User u : library.selectUser()) {
                    if (u.email.equals(Email) && u.password.equals(Password)) {
                        if (u.accountType == 1) {
                            JFrame frame = new ShopForm("Shop");
                            frame.setVisible(true);
                            dispose();
                        } else {
                            JFrame frame = new StartForm("Start");
                            frame.setVisible(true);
                            dispose();
                        }
                    }
                }
            }
        });
    }
}