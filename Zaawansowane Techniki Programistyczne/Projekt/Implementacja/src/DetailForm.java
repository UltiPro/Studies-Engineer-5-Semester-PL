import javax.swing.*;
import javax.swing.GroupLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetailForm extends JFrame {
    public DetailForm() {
        initComponents();
    }
    public static JLabel label1;
    private void initComponents() {
        JScrollPane scrollPane1 = new JScrollPane();
        orderList = new JList();
        goBackBtn = new JButton();
        priceLabel = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(orderList);
        }

        goBackBtn.setText("Go Back");

        priceLabel.setText("Price:");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(priceLabel, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(goBackBtn))
                                .addContainerGap(146, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(priceLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(goBackBtn)
                                                .addGap(0, 296, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
    }
    private JList orderList;
    private JButton goBackBtn;
    private JLabel priceLabel;
    private final DefaultListModel<String> orderList2 = new DefaultListModel<>();
    Library library = new Library();
    public void refreshOrderList(){
        orderList2.clear();
        for(Product p : ShopForm.order.products){
            orderList2.addElement(p.PrintDescription());
        }
        orderList.setModel(orderList2);
    }
    public DetailForm(String title) {
        super(title);

        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        refreshOrderList();
        int index = 0;

        for(Order order : library.selectOrder()){
            index = order.numberOfOrder;
        }
        ShopForm.order.numberOfOrder = index;

        priceLabel.setText("Price to pay: " + ShopForm.order.toPay);

        for(Product pFromDataBase : library.selectProduct()){
            for(Product p : ShopForm.order.products){
                if(pFromDataBase.name.equals(p.name)){
                    library.updateProduct(pFromDataBase.id, pFromDataBase.name, pFromDataBase.price, pFromDataBase.idType, pFromDataBase.idWarehouse, 0, pFromDataBase.count-p.count);
                    library.insertProduct(p.name, p.price, p.idType, 0, ShopForm.order.numberOfOrder, p.count);
                }
            }
        }
        goBackBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new ShopForm("Shop");
                frame.setVisible(true);
                dispose();
            }
        });

    }
}
