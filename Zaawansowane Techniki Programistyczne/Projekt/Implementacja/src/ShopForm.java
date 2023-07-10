import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.event.*;

import static java.lang.Double.parseDouble;

public class ShopForm extends JFrame {
    public ShopForm() {
        initComponents();
    }

    private void comboDepartmentItemStateChanged(ItemEvent e) {
        if (e != null && e.getSource().toString() != null && e.getStateChange() == ItemEvent.SELECTED) {
            setComboCategory();
        }
    }

    private void comboCategoryItemStateChanged(ItemEvent e) {
        if (e != null && e.getSource().toString() != null && e.getStateChange() == ItemEvent.SELECTED) {
            setComboType();
        }
    }

    private void comboTypeItemStateChanged(ItemEvent e) {
        if (e != null && e.getSource().toString() != null && e.getStateChange() == ItemEvent.SELECTED) {
            refreshProductsList();
        }
    }

    private void sendingBoxStateChanged(ChangeEvent e) {
        refreshProductsList();
    }

    private void initComponents() {
        comboDepartment = new JComboBox();
        comboCategory = new JComboBox();
        comboType = new JComboBox();
        JScrollPane scrollPane1 = new JScrollPane();
        productsList = new JList();
        addOrderBtn = new JButton();
        findBtn = new JButton();
        JScrollPane scrollPane2 = new JScrollPane();
        orderList = new JList();
        setOrderBtn = new JButton();
        removeOrderBtn = new JButton();
        deliveryBox = new JCheckBox();
        JButton logOut = new JButton();

        // ======== this ========
        setResizable(false);
        setBackground(new Color(102, 102, 102));
        var contentPane = getContentPane();

        comboDepartment.addItemListener(e -> comboDepartmentItemStateChanged(e));

        comboCategory.addItemListener(e -> comboCategoryItemStateChanged(e));

        comboType.addItemListener(e -> comboTypeItemStateChanged(e));

        // ======== scrollPane1 ========
        {
            scrollPane1.setViewportView(productsList);
        }

        addOrderBtn.setText("Add to Order");
        addOrderBtn.setBackground(new Color(0, 0, 102));
        addOrderBtn.setForeground(Color.white);

        findBtn.setText("Find");
        findBtn.setBackground(new Color(0, 0, 102));
        findBtn.setForeground(Color.white);

        // ======== scrollPane2 ========
        {
            scrollPane2.setViewportView(orderList);
        }

        setOrderBtn.setText("Place an order");
        setOrderBtn.setBackground(new Color(0, 0, 102));
        setOrderBtn.setForeground(Color.white);

        removeOrderBtn.setText("Remove an order");
        removeOrderBtn.setBackground(new Color(0, 0, 102));
        removeOrderBtn.setForeground(Color.white);

        deliveryBox.setText("Express Delivery (+5 PLN)");
        deliveryBox.addChangeListener(e -> sendingBoxStateChanged(e));

        logOut.setText("Logout");

        logOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new LoginForm("Shop");
                frame.setVisible(true);
                dispose();
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(comboDepartment, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(39, 39, 39)
                                                .addComponent(comboCategory, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(52, 52, 52)
                                                .addComponent(comboType, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout
                                                .createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addGroup(contentPaneLayout.createSequentialGroup()
                                                        .addComponent(addOrderBtn)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(findBtn))
                                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 370,
                                                        GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(removeOrderBtn)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 138,
                                                        Short.MAX_VALUE)
                                                .addComponent(setOrderBtn))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(deliveryBox)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 123,
                                                        Short.MAX_VALUE)
                                                .addComponent(logOut)
                                                .addGap(11, 11, 11)))
                                .addContainerGap()));
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(comboDepartment, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comboType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comboCategory, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deliveryBox)
                                        .addComponent(logOut))
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 311,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(scrollPane2))
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(addOrderBtn)
                                        .addComponent(findBtn)
                                        .addComponent(setOrderBtn)
                                        .addComponent(removeOrderBtn))
                                .addContainerGap(15, Short.MAX_VALUE)));
        pack();
        setLocationRelativeTo(getOwner());
    }

    private JComboBox comboDepartment;
    private JComboBox comboCategory;
    private JComboBox comboType;
    private JList productsList;
    private JButton addOrderBtn;
    private JButton findBtn;
    private JList orderList;
    private JButton setOrderBtn;
    private JButton removeOrderBtn;
    private JCheckBox deliveryBox;
    // JFormDesigner - End of variables declaration //GEN-END:variables

    Library library = new Library();
    private final DefaultComboBoxModel<String> comboDepartmentBoxModel = new DefaultComboBoxModel<>();
    private final DefaultComboBoxModel<String> comboCategoryBoxModel = new DefaultComboBoxModel<>();
    private final DefaultComboBoxModel<String> ComboType = new DefaultComboBoxModel<>();
    private final DefaultListModel<String> ProductsList = new DefaultListModel<>();
    private final DefaultListModel<String> OrdersList = new DefaultListModel<>();
    public static Order order = new Order();

    public void setComboDepartment() {
        comboDepartmentBoxModel.removeAllElements();

        for (Department d : library.selectDepartment()) {
            comboDepartmentBoxModel.addElement(d.toString());
        }

        comboDepartment.setModel(comboDepartmentBoxModel);
        setComboCategory();
    }

    public void setComboCategory() {
        comboCategoryBoxModel.removeAllElements();
        Object department;
        int index = 0;
        department = comboDepartment.getModel().getElementAt(comboDepartment.getSelectedIndex());

        for (Department d : library.selectDepartment()) {
            if (department.equals(d.name))
                index = d.id;
        }

        for (Category c : library.selectCategory()) {
            if (c.idDepartment == index)
                comboCategoryBoxModel.addElement(c.toString());
        }

        comboCategory.setModel(comboCategoryBoxModel);
        setComboType();
    }

    public void setComboType() {
        ComboType.removeAllElements();
        Object category;
        int index = 0;
        category = comboCategory.getModel().getElementAt(comboCategory.getSelectedIndex());

        for (Category c : library.selectCategory()) {
            if (category != null && category.equals(c.name))
                index = c.id;
        }

        for (Type2 t : library.selectType()) {
            if (t.idCategory == index)
                ComboType.addElement(t.toString());
        }

        comboType.setModel(ComboType);
        refreshProductsList();
    }

    public void refreshProductsList() {
        ProductsList.clear();
        Object type;
        int index = 0;
        type = comboType.getModel().getElementAt(comboType.getSelectedIndex());

        for (Type2 t : library.selectType()) {
            if (type != null && type.equals(t.name))
                index = t.id;
        }

        for (Product p : library.selectProduct()) {
            if (p.idType == index && p.idWarehouse != 0 && p.count > 0) {
                ProductsList.addElement(p.name + " , count: " + p.count + " , price: " + p.price);
            }
        }

        productsList.setModel(ProductsList);
    }

    public void refreshOrderList() {
        OrdersList.clear();
        refreshProductsList();

        for (Product p : order.products) {
            OrdersList.addElement(p.PrintDescription());
        }

        orderList.setModel(OrdersList);
    }

    public ShopForm(String title) {
        super(title);
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setComboDepartment();
        refreshProductsList();
        order.products.clear();
        refreshOrderList();
        order.toPay = 0;

        addOrderBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object product;
                Product productOrder = null;
                String productName;
                boolean added = false;
                int[] indices = productsList.getSelectedIndices();

                for (int index : indices) {
                    product = productsList.getModel().getElementAt(index);
                    productName = product.toString();
                    String[] split = productName.split("\\s+");
                    for (Product p : library.selectProduct()) {
                        if (split[0].equals(p.name)) {
                            productOrder = p;
                        }
                    }
                }

                if (order.products.isEmpty()) {
                    added = true;
                    if (productOrder != null)
                        productOrder.count = 1;
                    order.AddToOrder(productOrder);
                } else {

                    for (Product p : order.products) {
                        if (productOrder != null && productOrder.name.equals(p.name) && p.idWarehouse != 0) {
                            if (productOrder.count > p.count) {
                                p.count++;
                                added = true;
                            } else {
                                order.addedProducts.add(productOrder);
                            }
                        }
                    }
                }

                if (productOrder != null && !added && !order.addedProducts.contains(productOrder)) {
                    productOrder.count = 1;
                    order.AddToOrder(productOrder);
                }

                refreshOrderList();
                refreshProductsList();
            }
        });

        findBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel<String> model = new DefaultListModel<>();
                Product productOrder = null;
                boolean added = false;
                JTextField name = new JTextField(15);
                JPanel my = new JPanel();
                JPanel myPanel1 = new JPanel();
                JPanel myPanel2 = new JPanel();
                my.setLayout(new BoxLayout(my, BoxLayout.PAGE_AXIS));
                my.add(myPanel1);
                my.add(myPanel2);
                myPanel1.add(new JLabel("Name:"));
                myPanel1.add(name);
                JList list = new JList();
                JButton button = new JButton("Find");
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        model.clear();
                        for (Product p : library.selectProduct()) {
                            if (name.getText().equals(p.name) && p.idWarehouse != 0)
                                model.addElement(p.name + " , count: " + p.count + " , price: " + p.price);
                        }
                        list.setModel(model);
                    }
                });
                myPanel1.add(button);
                list.setPreferredSize(new Dimension(200, 100));
                JScrollPane sp = new JScrollPane(list);
                myPanel2.add(sp);

                int result = JOptionPane.showConfirmDialog(null, my, "Find product.", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    String[] split = name.getText().split("\\s+");

                    for (Product p : library.selectProduct()) {
                        if (split[0].equals(p.name) && p.idWarehouse != 0) {
                            productOrder = p;
                        }
                    }

                    if (order.products.isEmpty()) {
                        added = true;
                        productOrder.count = 1;
                        order.AddToOrder(productOrder);
                    } else {
                        for (Product p : order.products) {
                            if (productOrder.name.equals(p.name) && p.idWarehouse != 0) {
                                if (productOrder.count > p.count) {
                                    p.count++;
                                    added = true;
                                } else {
                                    order.addedProducts.add(productOrder);
                                }
                            }
                        }
                    }

                    if (!added && !order.addedProducts.contains(productOrder)) {
                        productOrder.count = 1;
                        order.AddToOrder(productOrder);
                    }
                }

                refreshOrderList();
                refreshProductsList();
            }
        });

        setOrderBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double toPay = order.toPay;
                int billId = 0;
                LinkedList<Discount> discount = new LinkedList<Discount>();

                for (Discount z : library.selectDiscount()) {
                    discount.add(z);
                }
                for (Product p : order.products) {
                    toPay = toPay + (p.count * p.price);
                }

                JPanel rabat = new JPanel();
                rabat.add(new JLabel("Kod:"));
                JTextField kod = new JTextField(15);
                rabat.add(kod);
                int result_dane = JOptionPane.showConfirmDialog(null, rabat, "Write discount code.",
                        JOptionPane.OK_CANCEL_OPTION);
                if (result_dane == JOptionPane.OK_OPTION) {

                    if (library.findDiscount(kod.getText())) {
                        double percent;
                        percent = parseDouble(kod.getText().substring(0, 2));
                        toPay -= toPay * (percent / 100);
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect discount code!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }

                order.toPay = toPay;
                DefaultComboBoxModel<String> comboList = new DefaultComboBoxModel<>();
                comboList.addElement("Receipt");
                comboList.addElement("Invoice for person");
                comboList.addElement("Invoice for firm");

                JComboBox comboBox = new JComboBox(comboList);

                JPanel myPanel = new JPanel();
                myPanel.add(comboBox);

                int result = JOptionPane.showConfirmDialog(null, myPanel, "Choose kind of bill.",
                        JOptionPane.OK_CANCEL_OPTION);

                FactoryBill factoryBill = new FactoryBill();
                FactoryInvoiceForFirm factoryFirm = new FactoryInvoiceForFirm();
                FactoryInvoiceForPerson factoryPerson = new FactoryInvoiceForPerson();

                if (result == JOptionPane.OK_OPTION) {
                    if (comboBox.getSelectedItem().equals("Receipt")) {
                        library.insertReceipt(toPay);
                        for (Bill p : library.selectReceipt()) {
                            billId = p.id;
                        }
                        order.numberOfOrder = billId;
                        Bill p;
                        p = factoryBill.CreateFactory();
                        p.SetPrice(order.toPay);
                        p.SetId(order.numberOfOrder);
                        p.WriteToFile();
                        order.SetBill(p);
                        library.insertOrder(order.toPay, 0, order.numberOfOrder);
                        JFrame frame = new DetailForm("Summary");
                        frame.setVisible(true);
                        dispose();
                    }

                    if (comboBox.getSelectedItem().equals("Invoice for person")) {
                        JPanel dane = new JPanel();
                        dane.add(new JLabel("Name:"));
                        JTextField name = new JTextField(15);
                        dane.add(name);
                        dane.add(new JLabel("Surname:"));
                        JTextField surname = new JTextField(15);
                        dane.add(surname);
                        int result_dane1 = JOptionPane.showConfirmDialog(null, dane, "Choose kind of bill.",
                                JOptionPane.OK_CANCEL_OPTION);
                        if (result == JOptionPane.OK_OPTION) {
                            library.insertInvoiceForPerson(name.getText(), surname.getText(), order.toPay);
                            for (InvoiceForPerson f : library.selectInvoiceForPerson()) {
                                billId = f.id;
                            }
                            order.numberOfOrder = billId;
                            InvoiceForPerson p;
                            p = factoryPerson.CreateFactory();
                            p.SetPrice(order.toPay);
                            p.SetId(order.numberOfOrder);
                            p.SetName(name.getText());
                            p.SetSurname(surname.getText());
                            p.WriteToFile();
                            order.SetBill(p);
                            library.insertOrder(order.toPay, 0, order.numberOfOrder);
                            JFrame frame = new DetailForm("Summary");
                            frame.setVisible(true);
                            dispose();
                        }
                    }

                    if (comboBox.getSelectedItem().equals("Invoice for firm")) {
                        JPanel dane = new JPanel();
                        dane.add(new JLabel("NIP:"));
                        JTextField nip = new JTextField(15);
                        dane.add(nip);
                        int result_dane2 = JOptionPane.showConfirmDialog(null, dane, "Choose kind of bill.",
                                JOptionPane.OK_CANCEL_OPTION);
                        if (result == JOptionPane.OK_OPTION) {
                            library.insertInvoiceForFirm(toPay, parseDouble(nip.getText()));
                            for (InvoiceForFirm f : library.selectInvoiceForFirm()) {
                                billId = f.id;
                            }
                            order.toPay = order.toPay * 0.77;
                            order.idReceipt = billId;
                            InvoiceForFirm p;
                            p = factoryFirm.CreateFactory();
                            p.SetPrice(order.toPay);
                            p.SetId(order.idReceipt);
                            p.SetNip(parseDouble(nip.getText()));
                            p.WriteToFile();
                            order.SetBill(p);
                            library.insertOrder(order.toPay, 0, order.numberOfOrder);
                            JFrame frame = new DetailForm("Summary");
                            frame.setVisible(true);
                            dispose();
                        }
                    }
                }
            }
        });

        removeOrderBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object product;
                String productName;
                int[] indices = orderList.getSelectedIndices();
                for (int index : indices) {
                    product = orderList.getModel().getElementAt(index);
                    productName = product.toString();
                    String[] split = productName.split("\\s+");
                    for (Product p : library.selectProduct()) {
                        if (split[0].equals(p.name)) {
                            order.RemoveFromOrder(split[0]);
                        }
                    }
                }
                refreshOrderList();
            }
        });

        deliveryBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    order.toPay += 5;
                }
            }
        });
    }
}