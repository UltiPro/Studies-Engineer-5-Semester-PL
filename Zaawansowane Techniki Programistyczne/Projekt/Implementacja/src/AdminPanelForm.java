import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanelForm extends JFrame {
    public int gigaIndex;

    public AdminPanelForm() {
        initComponents();
    }

    private void WarehouseListChanged(ListSelectionEvent e) {
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
            refreshProductList();
        }
    }

    private void productsListMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void comboWarehouseItemStateChanged(ItemEvent e) {
        if (e != null && e.getSource().toString() != null && e.getStateChange() == ItemEvent.SELECTED) {
            refreshProductList2();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY
        // //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - aaa
        JTabbedPane tabbedPane1 = new JTabbedPane();
        JPanel panel1 = new JPanel();
        JScrollPane scrollPane5 = new JScrollPane();
        warehouseSaleList = new JList();
        JScrollPane scrollPane6 = new JScrollPane();
        warehouseComplaintList = new JList();
        warehouseSaleBtn = new JButton();
        warehouseComplaintBtn = new JButton();
        deleteWarehouseSaleBtn = new JButton();
        deleteWarehouseComplaintBtn = new JButton();
        addDepartmentBtn = new JButton();
        addCategoryButton = new JButton();
        addTypeBtn = new JButton();
        addProductBtn = new JButton();
        JButton goBack = new JButton();
        JPanel panel2 = new JPanel();
        JScrollPane scrollPane2 = new JScrollPane();
        userList = new JList();
        removeUserBtn = new JButton();
        JLabel label1 = new JLabel();
        JButton goBack2 = new JButton();
        JPanel panel3 = new JPanel();
        JScrollPane scrollPane3 = new JScrollPane();
        productsList = new JList();
        addProductBtn2 = new JButton();
        comboWarehouse = new JComboBox();
        comboDepartment = new JComboBox();
        comboCategory = new JComboBox();
        comboType = new JComboBox();
        removeProductBtn2 = new JButton();
        JScrollPane scrollPane4 = new JScrollPane();
        productsComplaintList = new JList();
        removeProductBtn3 = new JButton();
        comboWarehouseSales = new JComboBox();
        JButton goBack3 = new JButton();
        JPanel panel4 = new JPanel();
        JScrollPane scrollPane1 = new JScrollPane();
        orderList = new JList();
        removeOrderBtn = new JButton();
        JLabel label2 = new JLabel();
        JButton goBack4 = new JButton();

        // ======== this ========
        var contentPane = getContentPane();

        // ======== tabbedPane1 ========
        {
            tabbedPane1.setBackground(new Color(0, 0, 102));
            tabbedPane1.setForeground(Color.white);

            // ======== panel1 ========
            {
                panel1.setBorder(new javax.swing.border.CompoundBorder(
                        new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                                "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax.swing.border.TitledBorder.CENTER,
                                javax.swing.border.TitledBorder.BOTTOM,
                                new java.awt.Font("D\u0069alog", java.awt.Font.BOLD, 12), java.awt.Color.red),
                        panel1.getBorder()));
                panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                    @Override
                    public void propertyChange(java.beans.PropertyChangeEvent e) {
                        if ("\u0062order".equals(e.getPropertyName()))
                            throw new RuntimeException();
                    }
                });

                // ======== scrollPane5 ========
                {

                    warehouseSaleList.addListSelectionListener(e -> WarehouseListChanged(e));
                    scrollPane5.setViewportView(warehouseSaleList);
                }

                // ======== scrollPane6 ========
                {
                    scrollPane6.setViewportView(warehouseComplaintList);
                }

                warehouseSaleBtn.setText("Add Sales Warehouse");
                warehouseSaleBtn.setBackground(new Color(0, 0, 102));
                warehouseSaleBtn.setForeground(Color.white);

                warehouseComplaintBtn.setText("Add Complaint Warehouse");
                warehouseComplaintBtn.setBackground(new Color(0, 0, 102));
                warehouseComplaintBtn.setForeground(Color.white);

                deleteWarehouseSaleBtn.setText("Delete");
                deleteWarehouseSaleBtn.setBackground(new Color(0, 0, 102));
                deleteWarehouseSaleBtn.setForeground(Color.white);

                deleteWarehouseComplaintBtn.setText("Delete");
                deleteWarehouseComplaintBtn.setBackground(new Color(0, 0, 102));
                deleteWarehouseComplaintBtn.setForeground(Color.white);

                addDepartmentBtn.setText("Add Department");
                addDepartmentBtn.setBackground(new Color(0, 0, 102));
                addDepartmentBtn.setForeground(Color.white);

                addCategoryButton.setText("Add Category");
                addCategoryButton.setBackground(new Color(0, 0, 102));
                addCategoryButton.setForeground(Color.white);

                addTypeBtn.setText("Add Type");
                addTypeBtn.setBackground(new Color(0, 0, 102));
                addTypeBtn.setForeground(Color.white);

                addProductBtn.setText("Add Product");
                addProductBtn.setBackground(new Color(0, 0, 102));
                addProductBtn.setForeground(Color.white);

                goBack.setText("Go Back");
                goBack.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame frame = new StartForm("Start");
                        frame.setVisible(true);
                        dispose();
                    }
                });

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                        panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(panel1Layout.createParallelGroup()
                                                .addComponent(scrollPane5, GroupLayout.PREFERRED_SIZE, 390,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                        .addComponent(warehouseSaleBtn)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(deleteWarehouseSaleBtn))
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                        .addComponent(addDepartmentBtn)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(addCategoryButton)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(addTypeBtn)))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panel1Layout.createParallelGroup()
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                        .addGroup(panel1Layout.createParallelGroup()
                                                                .addComponent(scrollPane6, GroupLayout.DEFAULT_SIZE,
                                                                        378, Short.MAX_VALUE)
                                                                .addGroup(panel1Layout.createSequentialGroup()
                                                                        .addComponent(warehouseComplaintBtn)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(deleteWarehouseComplaintBtn)
                                                                        .addGap(0, 103, Short.MAX_VALUE)))
                                                        .addContainerGap())
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                        .addComponent(addProductBtn)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 142,
                                                                Short.MAX_VALUE)
                                                        .addComponent(goBack)
                                                        .addGap(53, 53, 53)))));
                panel1Layout.setVerticalGroup(
                        panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(panel1Layout.createParallelGroup()
                                                .addComponent(scrollPane5, GroupLayout.PREFERRED_SIZE, 300,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addComponent(scrollPane6))
                                        .addGap(18, 18, 18)
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(warehouseSaleBtn)
                                                .addComponent(warehouseComplaintBtn)
                                                .addComponent(deleteWarehouseSaleBtn)
                                                .addComponent(deleteWarehouseComplaintBtn))
                                        .addGroup(panel1Layout.createParallelGroup()
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addGroup(panel1Layout
                                                                .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(addDepartmentBtn)
                                                                .addComponent(addCategoryButton)
                                                                .addComponent(addTypeBtn)
                                                                .addComponent(addProductBtn))
                                                        .addContainerGap(34, Short.MAX_VALUE))
                                                .addGroup(GroupLayout.Alignment.TRAILING,
                                                        panel1Layout.createSequentialGroup()
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                                        33, Short.MAX_VALUE)
                                                                .addComponent(goBack)
                                                                .addGap(19, 19, 19)))));
            }
            tabbedPane1.addTab("Warehouses", panel1);

            // ======== panel2 ========
            {
                // ======== scrollPane2 ========
                {
                    scrollPane2.setViewportView(userList);
                }

                removeUserBtn.setText("Delete User");
                removeUserBtn.setBackground(new Color(0, 0, 102));
                removeUserBtn.setForeground(Color.white);

                // ---- label1 ----
                label1.setText("E-mail, name, surname");

                goBack2.setText("Go Back");

                goBack2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame frame = new StartForm("Start");
                        frame.setVisible(true);
                        dispose();
                    }
                });

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                        panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(panel2Layout.createParallelGroup()
                                                .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 780,
                                                        Short.MAX_VALUE)
                                                .addGroup(panel2Layout.createSequentialGroup()
                                                        .addComponent(removeUserBtn)
                                                        .addContainerGap(652, Short.MAX_VALUE))
                                                .addGroup(panel2Layout.createSequentialGroup()
                                                        .addComponent(label1)
                                                        .addGap(0, 663, Short.MAX_VALUE))))
                                .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                        .addContainerGap(643, Short.MAX_VALUE)
                                        .addComponent(goBack2)
                                        .addGap(65, 65, 65)));
                panel2Layout.setVerticalGroup(
                        panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(label1)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 269,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(removeUserBtn)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                        .addComponent(goBack2)
                                        .addGap(22, 22, 22)));
            }
            tabbedPane1.addTab("Users", panel2);

            // ======== panel3 ========
            {
                // ======== scrollPane3 ========
                {

                    productsList.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            productsListMouseClicked(e);
                        }
                    });
                    scrollPane3.setViewportView(productsList);
                }

                addProductBtn2.setText("Add Product");
                addProductBtn2.setForeground(Color.white);
                addProductBtn2.setBackground(new Color(0, 0, 102));

                comboWarehouse.addItemListener(e -> comboWarehouseItemStateChanged(e));

                comboDepartment.addItemListener(e -> comboDepartmentItemStateChanged(e));

                comboCategory.addItemListener(e -> comboCategoryItemStateChanged(e));

                comboType.addItemListener(e -> comboTypeItemStateChanged(e));

                removeProductBtn2.setText("Remove Product");
                removeProductBtn2.setForeground(Color.white);
                removeProductBtn2.setBackground(new Color(0, 0, 102));

                // ======== scrollPane4 ========
                {
                    scrollPane4.setViewportView(productsComplaintList);
                }

                removeProductBtn3.setText("Remove Product");
                removeProductBtn3.setForeground(Color.white);
                removeProductBtn3.setBackground(new Color(0, 0, 102));

                goBack3.setText("Go Back");

                goBack3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame frame = new StartForm("Start");
                        frame.setVisible(true);
                        dispose();
                    }
                });
                GroupLayout panel3Layout = new GroupLayout(panel3);
                panel3.setLayout(panel3Layout);
                panel3Layout.setHorizontalGroup(
                        panel3Layout.createParallelGroup()
                                .addGroup(panel3Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(panel3Layout.createParallelGroup()
                                                .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 426,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGroup(panel3Layout.createSequentialGroup()
                                                        .addComponent(addProductBtn2)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(removeProductBtn2))
                                                .addGroup(panel3Layout.createSequentialGroup()
                                                        .addComponent(comboWarehouseSales, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(comboDepartment, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(comboCategory, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(comboType, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(panel3Layout.createParallelGroup()
                                                .addGroup(panel3Layout.createSequentialGroup()
                                                        .addGroup(panel3Layout.createParallelGroup()
                                                                .addGroup(panel3Layout.createSequentialGroup()
                                                                        .addComponent(comboWarehouse,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(0, 250, Short.MAX_VALUE))
                                                                .addComponent(scrollPane4, GroupLayout.DEFAULT_SIZE,
                                                                        330, Short.MAX_VALUE))
                                                        .addContainerGap())
                                                .addGroup(panel3Layout.createSequentialGroup()
                                                        .addComponent(removeProductBtn3)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 101,
                                                                Short.MAX_VALUE)
                                                        .addComponent(goBack3)
                                                        .addGap(53, 53, 53)))));
                panel3Layout.setVerticalGroup(
                        panel3Layout.createParallelGroup()
                                .addGroup(panel3Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(comboWarehouseSales, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(comboDepartment, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(comboCategory, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(comboType, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(comboWarehouse, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panel3Layout.createParallelGroup()
                                                .addGroup(panel3Layout.createSequentialGroup()
                                                        .addGap(3, 3, 3)
                                                        .addGroup(panel3Layout
                                                                .createParallelGroup(GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                .addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE,
                                                                        309, Short.MAX_VALUE)
                                                                .addComponent(scrollPane4, GroupLayout.DEFAULT_SIZE,
                                                                        309, Short.MAX_VALUE))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(panel3Layout
                                                                .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(addProductBtn2)
                                                                .addComponent(removeProductBtn2)
                                                                .addComponent(removeProductBtn3))
                                                        .addContainerGap(40, Short.MAX_VALUE))
                                                .addGroup(GroupLayout.Alignment.TRAILING,
                                                        panel3Layout.createSequentialGroup()
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                                        353, Short.MAX_VALUE)
                                                                .addComponent(goBack3)
                                                                .addGap(17, 17, 17)))));
            }
            tabbedPane1.addTab("Products", panel3);

            // ======== panel4 ========
            {
                // ======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(orderList);
                }

                removeOrderBtn.setText("Remove Order");
                removeOrderBtn.setForeground(Color.white);
                removeOrderBtn.setBackground(new Color(0, 0, 102));

                // ---- label2 ----
                label2.setText("Order number, price to pay");

                // ---- powrot4 ----
                goBack4.setText("Go Back");

                goBack4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame frame = new StartForm("Start");
                        frame.setVisible(true);
                        dispose();
                    }
                });

                GroupLayout panel4Layout = new GroupLayout(panel4);
                panel4.setLayout(panel4Layout);
                panel4Layout.setHorizontalGroup(
                        panel4Layout.createParallelGroup()
                                .addGroup(panel4Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(panel4Layout.createParallelGroup()
                                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 780,
                                                        Short.MAX_VALUE)
                                                .addGroup(panel4Layout.createSequentialGroup()
                                                        .addComponent(removeOrderBtn)
                                                        .addContainerGap(653, Short.MAX_VALUE))
                                                .addGroup(panel4Layout.createSequentialGroup()
                                                        .addComponent(label2)
                                                        .addGap(0, 587, Short.MAX_VALUE))))
                                .addGroup(GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                                        .addContainerGap(658, Short.MAX_VALUE)
                                        .addComponent(goBack4)
                                        .addGap(50, 50, 50)));
                panel4Layout.setVerticalGroup(
                        panel4Layout.createParallelGroup()
                                .addGroup(panel4Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(label2)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 274,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(removeOrderBtn)
                                        .addGap(18, 18, 18)
                                        .addComponent(goBack4)
                                        .addContainerGap(22, Short.MAX_VALUE)));
            }
            tabbedPane1.addTab("Orders", panel4);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tabbedPane1)
                                .addContainerGap()));
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addComponent(tabbedPane1, GroupLayout.Alignment.TRAILING));
        pack();
        setLocationRelativeTo(getOwner());
    }

    private JList warehouseSaleList;
    private JList warehouseComplaintList;
    private JButton warehouseSaleBtn;
    private JButton warehouseComplaintBtn;
    private JButton deleteWarehouseSaleBtn;
    private JButton deleteWarehouseComplaintBtn;
    private JButton addDepartmentBtn;
    private JButton addCategoryButton;
    private JButton addTypeBtn;
    private JButton addProductBtn;
    private JList userList;
    private JButton removeUserBtn;
    private JList productsList;
    private JButton addProductBtn2;
    private JComboBox comboWarehouse;
    private JComboBox comboDepartment;
    private JComboBox comboCategory;
    private JComboBox comboType;
    private JButton removeProductBtn2;
    private JList productsComplaintList;
    private JButton removeProductBtn3;
    private JComboBox comboWarehouseSales;
    private JList orderList;
    private JButton removeOrderBtn;
    // JFormDesigner - End of variables declaration //GEN-END:variables

    Library library = new Library();
    private final DefaultListModel<String> WarehouseSalesList = new DefaultListModel<>();
    private final DefaultListModel<String> WarehouseComplaintList = new DefaultListModel<>();
    private final DefaultListModel<String> ProductsList = new DefaultListModel<>();
    private final DefaultListModel<String> OrdersList = new DefaultListModel<>();
    private final DefaultListModel<String> ProductComplaintList = new DefaultListModel<>();
    private final DefaultListModel<String> UserList = new DefaultListModel<>();
    private final DefaultComboBoxModel<String> ComboWarehouseBoxModel = new DefaultComboBoxModel<>();
    private final DefaultComboBoxModel<String> ComboWarehouseSalesBoxModel = new DefaultComboBoxModel<>();
    private final DefaultComboBoxModel<String> ComboDepartmentBoxModel = new DefaultComboBoxModel<>();
    private final DefaultComboBoxModel<String> ComboCategoryBoxModel = new DefaultComboBoxModel<>();
    private final DefaultComboBoxModel<String> ComboTypeBoxModel = new DefaultComboBoxModel<>();

    public void refreshSalesList() {
        WarehouseSalesList.clear();

        for (Warehouse m : library.selectWarehouseOfSales()) {
            WarehouseSalesList.addElement(m.GetName());
        }

        warehouseSaleList.setModel(WarehouseSalesList);
    }

    public void refreshComplaintList() {
        WarehouseComplaintList.clear();

        for (Warehouse m : library.selectWarehouseComplaint()) {
            WarehouseComplaintList.addElement(m.GetName());
        }

        warehouseComplaintList.setModel(WarehouseComplaintList);
    }

    public void setComboWarehouse() {
        ComboWarehouseBoxModel.removeAllElements();

        for (Warehouse m : library.selectWarehouseComplaint()) {
            ComboWarehouseBoxModel.addElement(m.GetName());
        }

        comboWarehouse.setModel(ComboWarehouseBoxModel);
    }

    public void setComboWarehouseOfSales() {
        ComboWarehouseSalesBoxModel.removeAllElements();

        for (Warehouse m : library.selectWarehouseOfSales()) {
            ComboWarehouseSalesBoxModel.addElement(m.GetName());
        }

        comboWarehouseSales.setModel(ComboWarehouseSalesBoxModel);
    }

    public void setComboDepartment() {
        ComboDepartmentBoxModel.removeAllElements();

        for (Department d : library.selectDepartment()) {
            ComboDepartmentBoxModel.addElement(d.toString());
        }

        comboDepartment.setModel(ComboDepartmentBoxModel);
        setComboCategory();
    }

    public void setComboCategory() {
        ComboCategoryBoxModel.removeAllElements();
        Object department;
        int index = 0;
        department = comboDepartment.getModel().getElementAt(comboDepartment.getSelectedIndex());

        for (Department d : library.selectDepartment()) {
            if (department != null && department.equals(d.name))
                index = d.id;
        }

        for (Category k : library.selectCategory()) {
            if (k.idDepartment == index)
                ComboCategoryBoxModel.addElement(k.toString());
        }

        comboCategory.setModel(ComboCategoryBoxModel);
        setComboType();
    }

    public void setComboType() {
        ComboTypeBoxModel.removeAllElements();
        Object category;
        int index = 0;
        category = comboCategory.getModel().getElementAt(comboCategory.getSelectedIndex());

        for (Category k : library.selectCategory()) {
            if (category != null && category.equals(k.name))
                index = k.id;
        }

        for (Type2 t : library.selectType()) {
            if (t.idCategory == index)
                ComboTypeBoxModel.addElement(t.toString());
        }

        comboType.setModel(ComboTypeBoxModel);
        refreshProductList();
    }

    public void refreshProductList() {
        ProductsList.clear();
        Object type;
        int index = 0;
        type = comboType.getModel().getElementAt(comboType.getSelectedIndex());

        for (Type2 t : library.selectType()) {
            if (type != null && type.equals(t.name))
                index = t.id;
        }

        for (Product p : library.selectProduct()) {
            if (p.idType == index && p.idWarehouse != 0)
                ProductsList.addElement(p.name);
        }

        productsList.setModel(ProductsList);
    }

    public void refreshOrderList() {
        OrdersList.clear();

        for (Order order : library.selectOrder()) {
            OrdersList.addElement(order.numberOfOrder + " , " + order.toPay);
        }

        orderList.setModel(OrdersList);
    }

    public void refreshProductList2() {
        ProductComplaintList.clear();
        Object warehouse;
        int index = 0;
        warehouse = comboWarehouse.getModel().getElementAt(comboWarehouse.getSelectedIndex());

        for (Warehouse w : library.selectWarehouseComplaint()) {
            if (warehouse.equals(w.name))
                index = w.id;
        }

        for (Product p : library.selectProduct()) {
            if (p.idWarehouse == index && p.idType == 0)
                ProductComplaintList.addElement(p.name);
        }

        productsComplaintList.setModel(ProductComplaintList);
    }

    public void refreshUserList() {
        UserList.clear();

        for (User u : library.selectUser()) {
            UserList.addElement(u.email + " , " + u.name + " " + u.surname);
        }

        userList.setModel(UserList);
    }

    public AdminPanelForm(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        refreshSalesList();
        refreshComplaintList();
        setComboWarehouseOfSales();
        setComboWarehouse();
        setComboDepartment();
        refreshOrderList();
        refreshProductList2();
        refreshUserList();

        warehouseSaleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JTextField xField = new JTextField(15);
                JPanel myPanel = new JPanel();
                myPanel.add(new JLabel("Name:"));
                myPanel.add(xField);
                int result = JOptionPane.showConfirmDialog(null, myPanel, "Write Warehouse Name.",
                        JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    library.insertWarehouseOfSales(xField.getText());
                }

                refreshSalesList();
            }
        });

        warehouseComplaintBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JTextField xField = new JTextField(15);
                JPanel myPanel = new JPanel();
                myPanel.add(new JLabel("Name:"));
                myPanel.add(xField);
                int result = JOptionPane.showConfirmDialog(null, myPanel, "Write Warehouse Name.",
                        JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    library.insertWarehouseOfComplaint(xField.getText());
                }

                refreshComplaintList();
            }
        });

        deleteWarehouseSaleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object mag;
                int[] indices = warehouseSaleList.getSelectedIndices();

                for (int index : indices) {
                    mag = warehouseSaleList.getModel().getElementAt(index);
                    for (Warehouse m : library.selectWarehouseOfSales()) {
                        if (mag.equals(m.name))
                            library.deleteWarehouseOfSales(m.name);
                    }
                }

                refreshSalesList();
            }
        });

        addDepartmentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField xField = new JTextField(15);
                JPanel myPanel = new JPanel();
                myPanel.add(new JLabel("Name:"));
                myPanel.add(xField);
                int result = JOptionPane.showConfirmDialog(null, myPanel, "Write Department Name.",
                        JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    library.insertDepartament(xField.getText());
                }

                setComboDepartment();
            }
        });

        addCategoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = 0;
                JTextField xField = new JTextField(15);
                JComboBox comboBox = new JComboBox();

                ComboDepartmentBoxModel.removeAllElements();

                for (Department d : library.selectDepartment()) {
                    ComboDepartmentBoxModel.addElement(d.toString());
                }

                comboBox.setModel(ComboDepartmentBoxModel);

                for (int i = 0; i < comboBox.getModel().getSize(); i++)
                    System.out.println("comboboxy: " + comboBox.getModel().getElementAt(i));

                comboBox.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            System.out.println(e.getItem());
                            String tmp = (String) e.getItem();

                            for (Department department : library.selectDepartment()) {
                                if (tmp.equals(department.name)) {
                                    gigaIndex = department.id;
                                }
                            }
                        }
                    }
                });

                JPanel myPanel = new JPanel();
                myPanel.add(new JLabel("Name:"));
                myPanel.add(xField);
                myPanel.add(comboBox);

                int result = JOptionPane.showConfirmDialog(null, myPanel, "Write Category Name.",
                        JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    library.insertCategory(xField.getText(), gigaIndex);
                }

                setComboDepartment();
            }
        });

        addTypeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = 0;
                JTextField xField = new JTextField(15);
                JComboBox comboBox = new JComboBox();

                ComboCategoryBoxModel.removeAllElements();

                for (Category k : library.selectCategory()) {
                    ComboCategoryBoxModel.addElement(k.toString());
                }

                comboBox.setModel(ComboCategoryBoxModel);
                Object category;
                JPanel myPanel = new JPanel();
                myPanel.add(new JLabel("Name:"));
                myPanel.add(xField);
                myPanel.add(comboBox);

                int result = JOptionPane.showConfirmDialog(null, myPanel, "Write Category Name.",
                        JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    category = comboBox.getModel().getElementAt(comboBox.getSelectedIndex());
                    for (Category k : library.selectCategory()) {
                        if (category.equals(k.name))
                            index = k.id;
                    }
                    library.insertTyp(xField.getText(), index);
                }

                setComboDepartment();
            }
        });

        deleteWarehouseComplaintBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object warehouse;
                int[] indices = warehouseComplaintList.getSelectedIndices();

                for (int index : indices) {
                    warehouse = warehouseComplaintList.getModel().getElementAt(index);
                    for (Warehouse w : library.selectWarehouseComplaint()) {
                        if (warehouse.equals(w.name))
                            library.deleteWarehouseOfComplaint(w.name);
                    }
                }

                refreshComplaintList();
            }
        });

        addProductBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField name = new JTextField(15);
                JTextField price = new JTextField(15);
                JTextField count = new JTextField(15);
                JPanel myPanel = new JPanel();
                myPanel.add(new JLabel("Name:"));
                myPanel.add(name);
                myPanel.add(new JLabel("Price:"));
                myPanel.add(price);
                myPanel.add(new JLabel("Count:"));
                myPanel.add(count);

                Object warehouse, type;
                int indexWarehouse = 0, indexType = 0;
                warehouse = comboWarehouseSales.getModel().getElementAt(comboWarehouseSales.getSelectedIndex());
                type = comboType.getModel().getElementAt(comboType.getSelectedIndex());

                for (Warehouse w : library.selectWarehouseOfSales()) {
                    if (warehouse.equals(w.name))
                        indexWarehouse = w.id;
                }

                for (Type2 t : library.selectType()) {
                    if (type != null && type.equals(t.name))
                        indexType = t.id;
                }

                int result = JOptionPane.showConfirmDialog(null, myPanel, "Write Product Data.",
                        JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    library.insertProduct(name.getText(),
                            Integer.parseInt(price.getText()),
                            indexType,
                            indexWarehouse,
                            0,
                            Integer.parseInt(count.getText()));
                }

                refreshProductList();
            }
        });

        removeProductBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object prod;
                int[] indices = productsList.getSelectedIndices();

                for (int index : indices) {
                    prod = productsList.getModel().getElementAt(index);
                    for (Product p : library.selectProduct()) {
                        if (prod.equals(p.name))
                            library.deleteProduct(p.name);
                    }
                }

                refreshProductList();
            }
        });

        productsList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = 0;
                    JTextField nameField = new JTextField(15);
                    JTextField priceField = new JTextField(15);
                    JTextField countField = new JTextField(15);
                    JPanel myPanel = new JPanel();
                    myPanel.add(new JLabel("Name:"));
                    myPanel.add(nameField);
                    myPanel.add(new JLabel("Price:"));
                    myPanel.add(priceField);
                    myPanel.add(new JLabel("Count:"));
                    myPanel.add(countField);
                    Product product = null;

                    for (Product p : library.selectProduct()) {
                        if (productsList.getSelectedValue().equals(p.name)) {
                            nameField.setText(p.name);
                            priceField.setText(String.valueOf(p.price));
                            countField.setText(String.valueOf(p.count));
                            index = p.id;
                            product = p;
                        }
                    }

                    int result = JOptionPane.showConfirmDialog(null, myPanel, "Product Data.",
                            JOptionPane.OK_CANCEL_OPTION);

                    if (result == JOptionPane.OK_OPTION && product != null) {
                        product.name = nameField.getText();
                        product.price = Double.parseDouble(priceField.getText());
                        product.count = Integer.parseInt(countField.getText());
                        library.updateProduct(index, product.name, product.price, product.idType, product.idWarehouse,
                                product.idOrder, product.count);
                    }

                    refreshProductList();
                }
            }
        });

        addProductBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField name = new JTextField(15);
                JTextField count = new JTextField(15);
                JPanel myPanel = new JPanel();
                myPanel.add(new JLabel("Name:"));
                myPanel.add(name);
                myPanel.add(new JLabel("Count:"));
                myPanel.add(count);
                int indexWarehouse = 0;
                Object warehouse;
                int[] indices = warehouseComplaintList.getSelectedIndices();

                for (int index : indices) {
                    warehouse = warehouseComplaintList.getModel().getElementAt(index);
                    for (Warehouse m : library.selectWarehouseComplaint()) {
                        if (warehouse.equals(m.name))
                            indexWarehouse = m.id;
                    }
                }

                int result = JOptionPane.showConfirmDialog(null, myPanel, "Write Product Data.",
                        JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    library.insertProduct(name.getText(), 0, 0, indexWarehouse, 0, Integer.parseInt(count.getText()));
                }

                refreshProductList2();
            }
        });

        removeProductBtn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object prod;
                int[] indices = productsList.getSelectedIndices();

                for (int index : indices) {
                    prod = productsList.getModel().getElementAt(index);
                    for (Product product : library.selectProduct()) {
                        if (prod.equals(product.name))
                            library.deleteProduct(product.name);
                    }
                }

                refreshProductList2();
            }
        });

        removeOrderBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object order;
                String name;
                int[] indices = orderList.getSelectedIndices();
                for (int index : indices) {
                    order = orderList.getModel().getElementAt(index);
                    name = order.toString();
                    String[] splited = name.split("\\s+");
                    for (Order z : library.selectOrder()) {
                        if (Integer.parseInt(splited[0]) == z.numberOfOrder) {
                            library.deleteOrder(z.numberOfOrder);
                        }
                    }
                }
                refreshOrderList();
            }
        });

        productsComplaintList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = 0;
                    JTextField nameField = new JTextField(15);
                    JTextField countField = new JTextField(15);
                    JPanel myPanel = new JPanel();
                    myPanel.add(new JLabel("Name:"));
                    myPanel.add(nameField);
                    myPanel.add(new JLabel("Count:"));
                    myPanel.add(countField);
                    Product product = null;

                    for (Product productFor : library.selectProduct()) {
                        if (productsComplaintList.getSelectedValue().equals(productFor.name)) {
                            nameField.setText(productFor.name);
                            countField.setText(String.valueOf(productFor.count));
                            index = productFor.id;
                            System.out.println(index);
                            product = productFor;
                        }
                    }

                    int result = JOptionPane.showConfirmDialog(null, myPanel, "Product Data.",
                            JOptionPane.OK_CANCEL_OPTION);

                    if (result == JOptionPane.OK_OPTION && product != null) {
                        product.name = nameField.getText();
                        product.count = Integer.parseInt(countField.getText());
                        library.updateProduct(index, product.name, product.price, product.idType, product.idWarehouse,
                                product.idOrder, product.count);
                    }

                    refreshProductList2();
                }
            }
        });

        removeUserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object user;
                String nameTag, email, name, surname;
                int[] indices = userList.getSelectedIndices();

                for (int index : indices) {
                    user = userList.getModel().getElementAt(index);
                    nameTag = user.toString();
                    String[] splited = nameTag.split("\\s+");
                    email = splited[0];
                    name = splited[2];
                    surname = splited[3];
                    for (User u : library.selectUser()) {
                        if (u.name.equals(name) && u.surname.equals(surname) && u.email.equals(email)) {
                            library.deleteUser(u.id);
                        }
                    }
                }

                refreshUserList();
            }
        });
    }
}