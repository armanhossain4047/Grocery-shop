package Source;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.UIManager;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class DSale extends javax.swing.JFrame {

    public DSale() {
        initComponents();
        intilize();
    }

    private void intilize() {
        //**===============PC_Terminal=================**//
        PC_Terminal.setText(Login.Pc_Terminal);
//**================ Date and UserBy Code start ===================**//
        userby.setText(Login.UserBy);
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(currentDate);
        Datetbl.setText(formattedDate);

//**================ Close Code start ===================**//
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                DefaultTableModel model = (DefaultTableModel) Table.getModel();
                if (model.getRowCount() > 0) {
                    try {
                        DefaultTableModel Model = (DefaultTableModel) Table.getModel();
                        int rowCount = Model.getRowCount();
                        for (int x = 0; x < rowCount; x++) {
                            Login.SearchProduct[x][0] = Model.getValueAt(x, 1).toString();
                            Login.SearchProduct[x][1] = Model.getValueAt(x, 2).toString();
                            Login.SearchProduct[x][2] = Model.getValueAt(x, 3).toString();
                            Login.SearchProduct[x][3] = Model.getValueAt(x, 4).toString();
                            Login.SearchProduct[x][4] = Model.getValueAt(x, 5).toString();
                        }
                    } catch (Exception e1) {
                    }
                }
            }
        });

//**================ Search Product Code start ===================**//
        try {
            int Total_Search_Product_Count = 0;
            while (Login.SearchProduct[Total_Search_Product_Count][0] != null) {
                Total_Search_Product_Count++;
            }
            for (int i = 0; i < Total_Search_Product_Count; i++) {
                DefaultTableModel model = (DefaultTableModel) Table.getModel();
                Product_Insert(Login.SearchProduct[i][0], Login.SearchProduct[i][1], Double.parseDouble(Login.SearchProduct[i][2]), Double.parseDouble(Login.SearchProduct[i][3]));
                Login.SearchProduct[i][0] = null;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

//**================ Invoice Count Code start ===================**//
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection1 = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", ""); Statement statement1 = connection1.createStatement(); ResultSet result1 = statement1.executeQuery("SELECT COUNT(invoiceNo) AS counts FROM invoice_count")) {
                if (result1.next()) {
                    String formattedNumber = String.format("%010d", (result1.getInt(1)) + 1);
                    InvoiceNo.setText(PC_Terminal.getText() + "QL" + formattedNumber);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
//**================ Finantial Code start ===================**//
        Finantial_Calculation();

        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        userby = new javax.swing.JLabel();
        InvoiceNo = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        Datetbl = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        PC_Terminal = new javax.swing.JLabel();
        AvableQty = new javax.swing.JLabel();
        AvableQty1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        BarcodeTbl = new javax.swing.JTextField();
        ProductNameTbl = new javax.swing.JTextField();
        SalePriceTbl = new javax.swing.JTextField();
        AvableQtyTbl = new javax.swing.JTextField();
        QtyTbl = new javax.swing.JTextField();
        AutoAddComboBox = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ProductSearchBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        BlanceTbl = new javax.swing.JTextField();
        CashPaidTbl = new javax.swing.JTextField();
        DigitalMerchantCmb = new javax.swing.JComboBox<>();
        CashExchanceTbl = new javax.swing.JTextField();
        Due_TkTbl = new javax.swing.JTextField();
        DigitalPaidTbl = new javax.swing.JTextField();
        SaveBtn = new javax.swing.JButton();
        AutoPrintCheekBox = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        VatTbl = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        TotalSaleTbl = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        TotalSaleReturn = new javax.swing.JTextField();
        PercentDiscountTbl = new javax.swing.JTextField();
        Discount_tkTbl = new javax.swing.JTextField();
        HoldBtn = new javax.swing.JButton();
        RecallBtn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        CustomerIDTbl = new javax.swing.JTextField();
        CMobileTbl = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        CNameTbl = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        CAddressTbl = new javax.swing.JTextField();
        net = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        CustomerAddressTbl = new javax.swing.JTextField();
        CustomerNameCmb = new javax.swing.JComboBox<>();
        CustomerMobileTbl = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        Address = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        PreviousBlance = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        ReturnBarcodeTbl = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        ReturnTable = new javax.swing.JTable();
        Invoicetbl = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel37.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel37.setText("Previous Balance");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sale");
        setExtendedState(6);
        setResizable(false);
        setState(6);

        jPanel6.setBackground(new java.awt.Color(255, 204, 102));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setText("Cashier:");

        userby.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        userby.setForeground(new java.awt.Color(153, 0, 0));
        userby.setText("User By");

        InvoiceNo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        InvoiceNo.setText("QL00000000001");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setText("Invoice No. :");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rifat Logo-01.png"))); // NOI18N

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Kamal Bazar, Sylhet.");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("+880 1717 853158");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel35.setText("Date:");

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Ql LOGO No name-01.png"))); // NOI18N

        jLabel31.setFont(new java.awt.Font("Elephant", 0, 30)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(153, 51, 0));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("RIFAT MEGA MART");
        jLabel31.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel31AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        Datetbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Datetbl.setText("Date");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel38.setText("Terminal PC:");

        PC_Terminal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PC_Terminal.setText("P2");
        PC_Terminal.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                PC_TerminalVetoableChange(evt);
            }
        });

        AvableQty.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AvableQty.setForeground(new java.awt.Color(255, 51, 0));
        AvableQty.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AvableQty.setText("Avable Qty");

        AvableQty1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AvableQty1.setForeground(new java.awt.Color(255, 51, 0));
        AvableQty1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jLabel36)
                        .addGap(40, 40, 40))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel35))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(userby, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(AvableQty1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Datetbl, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(AvableQty)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(InvoiceNo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PC_Terminal)))
                        .addGap(58, 58, 58))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(Datetbl)
                            .addComponent(jLabel38)
                            .addComponent(PC_Terminal)
                            .addComponent(AvableQty))
                        .addGap(2, 2, 2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AvableQty1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27)
                        .addComponent(userby)
                        .addComponent(InvoiceNo)
                        .addComponent(jLabel30)))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(58, 201, 159));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 153)));

        BarcodeTbl.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        BarcodeTbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BarcodeTbl.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BarcodeTblFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                BarcodeTblFocusLost(evt);
            }
        });
        BarcodeTbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BarcodeTblActionPerformed(evt);
            }
        });
        BarcodeTbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BarcodeTblKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BarcodeTblKeyReleased(evt);
            }
        });

        ProductNameTbl.setEditable(false);
        ProductNameTbl.setBackground(new java.awt.Color(255, 255, 204));
        ProductNameTbl.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ProductNameTbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        SalePriceTbl.setEditable(false);
        SalePriceTbl.setBackground(new java.awt.Color(255, 255, 204));
        SalePriceTbl.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        SalePriceTbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        AvableQtyTbl.setEditable(false);
        AvableQtyTbl.setBackground(new java.awt.Color(255, 255, 204));
        AvableQtyTbl.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        AvableQtyTbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        QtyTbl.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        QtyTbl.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        QtyTbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        QtyTbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                QtyTblKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                QtyTblKeyReleased(evt);
            }
        });

        AutoAddComboBox.setSelected(true);
        AutoAddComboBox.setText("Auto Scan");
        AutoAddComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AutoAddComboBoxKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Barcode");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Item Name");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Quantity");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Sale Price");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("In Quantity");

        ProductSearchBtn.setBackground(new java.awt.Color(58, 201, 159));
        ProductSearchBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ProductSearchBtn.setText("Product Search (F2)");
        ProductSearchBtn.setToolTipText("");
        ProductSearchBtn.setBorder(null);
        ProductSearchBtn.setHideActionText(true);
        ProductSearchBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ProductSearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductSearchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ProductSearchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(AvableQtyTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(QtyTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AutoAddComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(ProductNameTbl)
                            .addComponent(BarcodeTbl)
                            .addComponent(SalePriceTbl, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BarcodeTbl, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ProductNameTbl, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SalePriceTbl, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AvableQtyTbl, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(QtyTbl)
                    .addComponent(AutoAddComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProductSearchBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 204)));

        BlanceTbl.setEditable(false);
        BlanceTbl.setBackground(new java.awt.Color(255, 255, 255));
        BlanceTbl.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        BlanceTbl.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        BlanceTbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BlanceTbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BlanceTblActionPerformed(evt);
            }
        });
        BlanceTbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BlanceTblKeyPressed(evt);
            }
        });

        CashPaidTbl.setBackground(new java.awt.Color(204, 255, 204));
        CashPaidTbl.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        CashPaidTbl.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        CashPaidTbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CashPaidTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CashPaidTblMouseClicked(evt);
            }
        });
        CashPaidTbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CashPaidTblKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CashPaidTblKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CashPaidTblKeyTyped(evt);
            }
        });

        DigitalMerchantCmb.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DigitalMerchantCmb.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                DigitalMerchantCmbAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        DigitalMerchantCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DigitalMerchantCmbActionPerformed(evt);
            }
        });
        DigitalMerchantCmb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DigitalMerchantCmbKeyPressed(evt);
            }
        });

        CashExchanceTbl.setEditable(false);
        CashExchanceTbl.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        CashExchanceTbl.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        CashExchanceTbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CashExchanceTbl.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                CashExchanceTblVetoableChange(evt);
            }
        });

        Due_TkTbl.setEditable(false);
        Due_TkTbl.setBackground(new java.awt.Color(255, 153, 153));
        Due_TkTbl.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        Due_TkTbl.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Due_TkTbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        DigitalPaidTbl.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        DigitalPaidTbl.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        DigitalPaidTbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        DigitalPaidTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DigitalPaidTblMouseClicked(evt);
            }
        });
        DigitalPaidTbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DigitalPaidTblKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DigitalPaidTblKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DigitalPaidTblKeyTyped(evt);
            }
        });

        SaveBtn.setBackground(new java.awt.Color(0, 153, 102));
        SaveBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        SaveBtn.setForeground(new java.awt.Color(204, 255, 255));
        SaveBtn.setText("Save (F5)");
        SaveBtn.setBorder(null);
        SaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBtnActionPerformed(evt);
            }
        });
        SaveBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SaveBtnKeyPressed(evt);
            }
        });

        AutoPrintCheekBox.setSelected(true);
        AutoPrintCheekBox.setText("Auto Print");

        jLabel18.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel18.setText("Sale Total");

        jLabel19.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel19.setText("Vat");

        jLabel20.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel20.setText("Sale Return");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setText("Dis. % (F6)");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setText("Balance");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setText("Cash Paid (F8)");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel13.setText("Discount");

        jLabel14.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel14.setText("Cash_Exchange");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel15.setText("Due Tk");

        VatTbl.setEditable(false);
        VatTbl.setBackground(new java.awt.Color(204, 255, 255));
        VatTbl.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        VatTbl.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        VatTbl.setText("0.0");
        VatTbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        VatTbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VatTblActionPerformed(evt);
            }
        });
        VatTbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                VatTblKeyReleased(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel16.setText("Digital Paid (F4)");

        TotalSaleTbl.setEditable(false);
        TotalSaleTbl.setBackground(new java.awt.Color(255, 255, 204));
        TotalSaleTbl.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        TotalSaleTbl.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TotalSaleTbl.setText("0.0");
        TotalSaleTbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TotalSaleTbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalSaleTblActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel17.setText("Digital Merchant Account");

        TotalSaleReturn.setEditable(false);
        TotalSaleReturn.setBackground(new java.awt.Color(255, 51, 51));
        TotalSaleReturn.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        TotalSaleReturn.setForeground(new java.awt.Color(204, 255, 255));
        TotalSaleReturn.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TotalSaleReturn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TotalSaleReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalSaleReturnActionPerformed(evt);
            }
        });

        PercentDiscountTbl.setEditable(false);
        PercentDiscountTbl.setBackground(new java.awt.Color(255, 204, 255));
        PercentDiscountTbl.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        PercentDiscountTbl.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        PercentDiscountTbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PercentDiscountTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PercentDiscountTblMouseClicked(evt);
            }
        });
        PercentDiscountTbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PercentDiscountTblActionPerformed(evt);
            }
        });
        PercentDiscountTbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PercentDiscountTblKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PercentDiscountTblKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PercentDiscountTblKeyTyped(evt);
            }
        });

        Discount_tkTbl.setEditable(false);
        Discount_tkTbl.setBackground(new java.awt.Color(255, 204, 204));
        Discount_tkTbl.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        Discount_tkTbl.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Discount_tkTbl.setText("0.0");
        Discount_tkTbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Discount_tkTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Discount_tkTblMouseClicked(evt);
            }
        });
        Discount_tkTbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Discount_tkTblKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Discount_tkTblKeyReleased(evt);
            }
        });

        HoldBtn.setBackground(new java.awt.Color(102, 102, 255));
        HoldBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        HoldBtn.setForeground(new java.awt.Color(255, 255, 255));
        HoldBtn.setText("Hold Invoice (F11)");
        HoldBtn.setBorder(null);
        HoldBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HoldBtnActionPerformed(evt);
            }
        });

        RecallBtn.setBackground(new java.awt.Color(51, 0, 255));
        RecallBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        RecallBtn.setForeground(new java.awt.Color(255, 255, 255));
        RecallBtn.setText("Recall (F12)");
        RecallBtn.setBorder(null);
        RecallBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecallBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CashPaidTbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BlanceTbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Discount_tkTbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PercentDiscountTbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TotalSaleReturn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VatTbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TotalSaleTbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DigitalMerchantCmb, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DigitalPaidTbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Due_TkTbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CashExchanceTbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AutoPrintCheekBox, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SaveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel17)
                .addGap(87, 87, 87))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HoldBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(RecallBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PercentDiscountTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TotalSaleTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(VatTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TotalSaleReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Discount_tkTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BlanceTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CashPaidTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(DigitalMerchantCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DigitalPaidTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Due_TkTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CashExchanceTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AutoPrintCheekBox, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HoldBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RecallBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        CustomerIDTbl.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        CustomerIDTbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerIDTblActionPerformed(evt);
            }
        });
        CustomerIDTbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CustomerIDTblKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CustomerIDTblKeyReleased(evt);
            }
        });

        CMobileTbl.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 255, 255));
        jLabel6.setText("Customer ID:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 255, 255));
        jLabel7.setText("Mobile:");

        CNameTbl.setBackground(new java.awt.Color(204, 255, 255));
        CNameTbl.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        CNameTbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CNameTblActionPerformed(evt);
            }
        });
        CNameTbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CNameTblKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 255, 255));
        jLabel8.setText("Customer Name:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 255, 255));
        jLabel9.setText("Address:");

        CAddressTbl.setBackground(new java.awt.Color(204, 255, 255));
        CAddressTbl.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        net.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        net.setForeground(new java.awt.Color(204, 255, 255));
        net.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        net.setText("00.00");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(204, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Net Amount");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CMobileTbl)
                    .addComponent(CustomerIDTbl))
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CNameTbl)
                    .addComponent(CAddressTbl))
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(net, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CustomerIDTbl)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CNameTbl)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(net, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CMobileTbl)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CAddressTbl))
                .addGap(5, 5, 5))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Table.setAutoCreateRowSorter(true);
        Table.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S/N", "Code No", "Product Name & Description", "Rate", "Qty (F9)", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.setAutoscrolls(false);
        Table.setGridColor(new java.awt.Color(0, 102, 102));
        Table.setRequestFocusEnabled(false);
        Table.setRowHeight(25);
        Table.setSelectionBackground(new java.awt.Color(153, 0, 0));
        Table.setSelectionForeground(new java.awt.Color(204, 255, 255));
        Table.setShowGrid(false);
        Table.setShowHorizontalLines(true);
        Table.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TableAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        Table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Table);
        if (Table.getColumnModel().getColumnCount() > 0) {
            Table.getColumnModel().getColumn(0).setResizable(false);
            Table.getColumnModel().getColumn(1).setResizable(false);
            Table.getColumnModel().getColumn(2).setResizable(false);
            Table.getColumnModel().getColumn(3).setResizable(false);
            Table.getColumnModel().getColumn(4).setResizable(false);
            Table.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        CustomerAddressTbl.setEditable(false);
        CustomerAddressTbl.setBackground(new java.awt.Color(153, 255, 255));
        CustomerAddressTbl.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        CustomerNameCmb.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        CustomerNameCmb.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                CustomerNameCmbAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        CustomerNameCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerNameCmbActionPerformed(evt);
            }
        });

        CustomerMobileTbl.setEditable(false);
        CustomerMobileTbl.setBackground(new java.awt.Color(153, 255, 255));
        CustomerMobileTbl.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel21.setText("Customer Name");

        Address.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Address.setText("Address");

        jLabel22.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel22.setText("Mobile");

        jLabel23.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 51, 0));
        jLabel23.setText("Previous Balance");

        PreviousBlance.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        PreviousBlance.setForeground(new java.awt.Color(255, 51, 0));
        PreviousBlance.setText("0.00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CustomerNameCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Address)
                    .addComponent(CustomerAddressTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CustomerMobileTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel23)
                        .addGap(18, 18, 18)
                        .addComponent(PreviousBlance, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel22))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Address)
                    .addComponent(jLabel22)
                    .addComponent(jLabel21))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(CustomerAddressTbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addComponent(CustomerNameCmb, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PreviousBlance, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(CustomerMobileTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 0, 0));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 204)));

        jLabel25.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 255, 255));
        jLabel25.setText("Return Product Code No(F7)");

        ReturnBarcodeTbl.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        ReturnBarcodeTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReturnBarcodeTblMouseClicked(evt);
            }
        });
        ReturnBarcodeTbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ReturnBarcodeTblKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ReturnBarcodeTblKeyReleased(evt);
            }
        });

        ReturnTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S/N", "Code No", "Product Name & Description", "Rate", "Qty", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ReturnTable.setGridColor(new java.awt.Color(255, 51, 0));
        ReturnTable.setShowVerticalLines(true);
        ReturnTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ReturnTableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ReturnTableKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(ReturnTable);

        Invoicetbl.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        Invoicetbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                InvoicetblKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                InvoicetblKeyReleased(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(204, 255, 255));
        jLabel28.setText("Invoice No: ");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ReturnBarcodeTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Invoicetbl, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReturnBarcodeTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Invoicetbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1324, 786));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TotalSaleTblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalSaleTblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalSaleTblActionPerformed

    private void TotalSaleReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalSaleReturnActionPerformed

    }//GEN-LAST:event_TotalSaleReturnActionPerformed

    private void RecallBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecallBtnActionPerformed
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        if (model.getRowCount() > 0) {
            JOptionPane.showMessageDialog(this, "Hold First Then Recall");
        } else {
            this.dispose();
            HoldInvoice HoldInvoice = new HoldInvoice();
            HoldInvoice.setVisible(true);
        }
    }//GEN-LAST:event_RecallBtnActionPerformed

    private void ProductSearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductSearchBtnActionPerformed
        try {
            DefaultTableModel Model = (DefaultTableModel) Table.getModel();
            int rowCount = Model.getRowCount();
            for (int x = 0; x < rowCount; x++) {
                String Barcode_sql = Model.getValueAt(x, 1).toString(); // Convert to String directly
                String ProductName_sql = Model.getValueAt(x, 2).toString(); // Convert to String directly
                String Rate_sql = Model.getValueAt(x, 3).toString(); // Convert to String directly
                String Qty_sql = Model.getValueAt(x, 4).toString();
                String Amount_sql = Model.getValueAt(x, 5).toString(); // Convert to String directly
                Login.SearchProduct[x][0] = Barcode_sql;
                Login.SearchProduct[x][1] = ProductName_sql;
                Login.SearchProduct[x][2] = Rate_sql;
                Login.SearchProduct[x][3] = Qty_sql;
                Login.SearchProduct[x][4] = Amount_sql;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        this.dispose();
        SearchProduct SearchProduct = new SearchProduct();
        SearchProduct.setVisible(true);
    }//GEN-LAST:event_ProductSearchBtnActionPerformed

    private void BarcodeTblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarcodeTblActionPerformed

    }//GEN-LAST:event_BarcodeTblActionPerformed

    private void BarcodeTblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BarcodeTblKeyPressed

//**================Product Code start ===================**//t
        try {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                try {
                    // Load the MySQL driver
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    // Establish a connection to the database
                    try (Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", ""); // Use PreparedStatement to prevent SQL injection
                             PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("SELECT * FROM purchase WHERE Barcode = ?")) {

                        // Set the parameter for the query
                        preparedStatement.setString(1, BarcodeTbl.getText());

                        // Execute the query
                        try (ResultSet result = preparedStatement.executeQuery()) {
                            if (result.next()) {
                                // Process the result
                                if (AutoAddComboBox.isSelected()) {
                                    Product_Insert(result.getString(4), result.getString(5), Double.parseDouble(result.getString(10)), 1.0);
                                    Finantial_Calculation();
                                    BarcodeTbl.setText(null);
                                    AvableQty1.setText(result.getString(7));
                                } else {
                                    // Populate fields with product details
                                    BarcodeTbl.setText(result.getString(4));
                                    ProductNameTbl.setText(result.getString(5));
                                    AvableQtyTbl.setText(result.getString(7));
                                    SalePriceTbl.setText(result.getString(10));
                                    QtyTbl.requestFocus();
                                }
                            } else {
                                UIManager.put("OptionPane.background", new Color(255, 51, 51)); // Change background color
                                UIManager.put("Panel.background", new Color(255, 51, 51)); // Change panel background color
                                UIManager.put("OptionPane.messageForeground", new Color(255, 255, 255));// Change message text color
                                UIManager.put("Button.background", new Color(255, 255, 255)); // Change button background color
                                UIManager.put("Button.foreground", new Color(0, 102, 102)); // Change button text color
                                JOptionPane.showMessageDialog(this, "Product Not Found");
                            }
                        }
                    }
                } catch (ClassNotFoundException e) {
                    JOptionPane.showMessageDialog(this, "Database driver not found: " + e.getMessage());
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Error parsing number: " + e.getMessage());
                }

            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

//**================ Key Action Code start ===================**//
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {

            BarcodeTbl.setText(null);
            BarcodeTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            ProductSearchBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F11) {
            HoldBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F12) {
            RecallBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F6) {

            PercentDiscountTbl.setText(null);
            PercentDiscountTbl.requestFocus();
            UIManager.put("OptionPane.background", new Color(153, 0, 51)); // Change background color
            UIManager.put("Panel.background", new Color(153, 0, 51)); // Change panel background color
            UIManager.put("OptionPane.messageForeground", new Color(255, 255, 255)); // Change message text color
            UIManager.put("Button.background", new Color(255, 255, 255)); // Change button background color
            UIManager.put("Button.foreground", new Color(0, 102, 102)); // Change button text color
            double Percentage = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter Percentage:"));
            Percentage_Tk_calculate(Percentage);
            Payment_System();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F4) {
            DigitalPaidTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F8) {
            CashPaidTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F7) {
            ReturnBarcodeTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            SaveBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_C) {
            CustomerIDTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            Table.requestFocus();
        }

        //t
        if (evt.getKeyCode() == KeyEvent.VK_F9) {
            DefaultTableModel model = (DefaultTableModel) Table.getModel();
            int selectedRow = Table.getSelectedRow();

            // Automatically select the first row if none is selected
            if (selectedRow == -1 && model.getRowCount() > 0) {
                selectedRow = 0;
                Table.setRowSelectionInterval(0, 0);
            }

            if (selectedRow != -1) {
                String qtyInput = JOptionPane.showInputDialog(null, "Enter Qty:");

                // Handle null or empty input
                if (qtyInput != null && !qtyInput.trim().isEmpty()) {
                    try {
                        double Qty = Double.parseDouble(qtyInput);
                        Product_Insert(
                                model.getValueAt(selectedRow, 1).toString(),
                                model.getValueAt(selectedRow, 2).toString(),
                                Double.parseDouble(model.getValueAt(selectedRow, 3).toString()),
                                Qty
                        );
                        Finantial_Calculation();

                        // Deselect the row after successful operation
                        Table.clearSelection();
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Please enter a valid quantity");
                        Table.clearSelection(); // Clear selection if input is invalid
                    }
                } else {
                    // If the user cancels or enters an empty input, clear the row selection
                    Table.clearSelection();
                    JOptionPane.showMessageDialog(this, "Quantity cannot be empty or action was cancelled");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row");
            }
        }

        //tt
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            DefaultTableModel DeleteModel = (DefaultTableModel) Table.getModel();
            int selectedRow = Table.getSelectedRow();
            if (selectedRow != -1) {
                DeleteModel.removeRow(selectedRow);
                Finantial_Calculation();
                updateSerialNumbers();
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row to delete.");
            }
        }

    }//GEN-LAST:event_BarcodeTblKeyPressed
    private void updateSerialNumbers() {
        DefaultTableModel model = (DefaultTableModel) Table.getModel();

        // Update the serial numbers to be in descending order
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(model.getRowCount() - i, i, 0); // Serial numbers should be 1, 2, 3, ...
        }

    }
    private void CNameTblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CNameTblActionPerformed

    }//GEN-LAST:event_CNameTblActionPerformed

    private void BarcodeTblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BarcodeTblKeyReleased

    }//GEN-LAST:event_BarcodeTblKeyReleased

    private void QtyTblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_QtyTblKeyReleased

    }//GEN-LAST:event_QtyTblKeyReleased

    private void TableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TableAncestorAdded

    }//GEN-LAST:event_TableAncestorAdded

    private void BarcodeTblFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BarcodeTblFocusLost

    }//GEN-LAST:event_BarcodeTblFocusLost

    private void BarcodeTblFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BarcodeTblFocusGained

    }//GEN-LAST:event_BarcodeTblFocusGained

    private void VatTblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VatTblKeyReleased
        double Totalamount = 0.0;
        try {
            DefaultTableModel Model = (DefaultTableModel) Table.getModel();
            int RowCount = Model.getRowCount();
            for (int y = 0; y < RowCount; y++) {
                Object amount = Model.getValueAt(y, 5);
                String Amount = amount.toString();
                Totalamount = Totalamount + Integer.parseInt(Amount);
            }
            TotalSaleTbl.setText(Double.toString(Totalamount));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_VatTblKeyReleased

    private void ReturnBarcodeTblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ReturnBarcodeTblKeyReleased

    }//GEN-LAST:event_ReturnBarcodeTblKeyReleased

    private void CustomerIDTblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CustomerIDTblKeyReleased
//**=================Discount card code Start ==================**//
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connection = (java.sql.Connection) java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            java.sql.Statement statement = (java.sql.Statement) connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM merbershipcard WHERE CardNo = '" + CustomerIDTbl.getText() + "'");
            while (result.next()) {
                CNameTbl.setText(result.getString(2));
                CAddressTbl.setText(result.getString(4));
                CMobileTbl.setText(result.getString(5));
                PercentDiscountTbl.setText(result.getString(7));
                Percentage_Tk_calculate(Double.parseDouble(result.getString(7)));
                Payment_System();
            }
        } catch (ClassNotFoundException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_CustomerIDTblKeyReleased

    private void CustomerNameCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerNameCmbActionPerformed
//**=================customer Due code Start ==================**//
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Statement statement;
            try (Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "")) {
                statement = (Statement) connection.createStatement();
                ResultSet result = statement.executeQuery("SELECT * FROM `ladger` WHERE AccountType = 'Customer' AND Name = '" + CustomerNameCmb.getSelectedItem().toString() + "'");
                ResultSetMetaData rsmd = (ResultSetMetaData) result.getMetaData();
                while (result.next()) {
                    CustomerAddressTbl.setText(result.getString("Address"));
                    CustomerMobileTbl.setText(result.getString("Mobile"));
                    PreviousBlance.setText(result.getString("Blance"));
                }
            }
            statement.close();
            if (CustomerNameCmb.getSelectedItem().toString().equals("Select")) {
                CustomerAddressTbl.setText(null);
                CustomerMobileTbl.setText(null);
                PreviousBlance.setText("0.00");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_CustomerNameCmbActionPerformed

    private void Discount_tkTblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Discount_tkTblKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            CashPaidTbl.requestFocus();
        }
        if (true) {
        }    }//GEN-LAST:event_Discount_tkTblKeyReleased

    private void CashPaidTblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CashPaidTblKeyReleased
        Payment_System();

    }//GEN-LAST:event_CashPaidTblKeyReleased

    private void DigitalMerchantCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DigitalMerchantCmbActionPerformed

    }//GEN-LAST:event_DigitalMerchantCmbActionPerformed

    private void DigitalPaidTblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DigitalPaidTblKeyReleased
        Payment_System();
    }//GEN-LAST:event_DigitalPaidTblKeyReleased

    private void HoldBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HoldBtnActionPerformed
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        if (CNameTbl.getText().equalsIgnoreCase("")) {
            CNameTbl.requestFocus();
            
        } else {
            int choice = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                for (int x = 0; x < model.getRowCount(); x++) {
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        java.sql.Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
                        PreparedStatement ps = (PreparedStatement) connection.prepareStatement("INSERT INTO `invtemp`(`CustomerName`,`Barcode`, `Item`, `Sale_Rate`, `Qty`, `price`, `User`,`PC_Terminal`) VALUES (?,?,?,?,?,?,?,?)");
                        ps.setString(1, CNameTbl.getText());
                        ps.setString(2, model.getValueAt(x, 1).toString());
                        ps.setString(3, model.getValueAt(x, 2).toString());
                        ps.setString(4, model.getValueAt(x, 3).toString());
                        ps.setString(5, model.getValueAt(x, 4).toString());
                        ps.setString(6, model.getValueAt(x, 5).toString());
                        ps.setString(7, Login.UserBy);
                        ps.setString(8, Login.Pc_Terminal);
                        ps.executeUpdate();
                    } catch (ClassNotFoundException | SQLException e) {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
                }
                Due_TkTbl.setText("0.0");
                BlanceTbl.setText("0.0");
                TotalSaleTbl.setText("0.0");
                DigitalPaidTbl.setText("");
                CMobileTbl.setText("");
                CustomerIDTbl.setText("");
                CAddressTbl.setText("");
                CNameTbl.setText("");
                CashPaidTbl.setText("");
                Discount_tkTbl.setText("0.0");
                PercentDiscountTbl.setText("");
                CashExchanceTbl.setText("0.0");
                DigitalMerchantCmb.setSelectedItem("Select");
                while (model.getRowCount() > 0) {
                    model.removeRow(0);
                }
            }
        BarcodeTbl.requestFocus();
        }
    }//GEN-LAST:event_HoldBtnActionPerformed

    private void TableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TableKeyReleased

    }//GEN-LAST:event_TableKeyReleased

    private void TableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TableKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F9) {
            DefaultTableModel model = (DefaultTableModel) Table.getModel();
            int selectedRow = Table.getSelectedRow();

            if (selectedRow != -1) {
                try {
                    // Show input dialog and parse the quantity
                    double Qty = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter Qty:"));

                    // Call your methods with the selected row data
                    Product_Insert(
                            model.getValueAt(selectedRow, 1).toString(),
                            model.getValueAt(selectedRow, 2).toString(),
                            Double.parseDouble(model.getValueAt(selectedRow, 3).toString()),
                            Qty
                    );
                    Finantial_Calculation();

                    // Deselect the current row after completing the operations
                    Table.clearSelection();

                    // Focus on BarcodeTbl after processing
                    BarcodeTbl.requestFocus();
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid quantity entered. Please try again.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row.");
            }
        }

        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            DefaultTableModel DeleteModel = (DefaultTableModel) Table.getModel();
            int selectedRow = Table.getSelectedRow();
            if (selectedRow != -1) {
                DeleteModel.removeRow(selectedRow);
                Finantial_Calculation();
                updateSerialNumbers();
                BarcodeTbl.requestFocus();
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row to delete.");
            }
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            BarcodeTbl.setText(null);
            BarcodeTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            ProductSearchBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F11) {
            HoldBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F12) {
            RecallBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F6) {
            PercentDiscountTbl.setText(null);
            PercentDiscountTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F4) {
            DigitalPaidTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F8) {
            CashPaidTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F7) {
            ReturnBarcodeTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            SaveBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_C) {
            CustomerIDTbl.requestFocus();
        }
    }//GEN-LAST:event_TableKeyPressed
    void Product_Sale_Confirm() {

        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        //**============== Digital Payment Add ==============**//
        if (Double.parseDouble(DigitalPaidTbl.getText()) > 0.0) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
                java.sql.PreparedStatement ps = (java.sql.PreparedStatement) connection.prepareStatement("INSERT INTO paymentstatement (Reasone, Receiver,Amount,Credit,Description,Status,User)Values(?,?,?,?,?,?,?)");
                ps.setString(1, "Bank Account");
                ps.setString(2, DigitalMerchantCmb.getSelectedItem().toString());
                ps.setString(3, DigitalPaidTbl.getText());
                ps.setString(4, DigitalMerchantCmb.getSelectedItem().toString());
                ps.setString(5, "Sale Payment");
                ps.setString(6, "Payment");
                ps.setString(7, Login.UserBy);
                ps.executeUpdate();
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(this, DigitalMerchantCmb.getSelectedItem().toString() + " Payment does not recive !!");
            }
        }
//**============== Invoice Mastert Insert Invoice Count Cheek Invoice Statement ==============**//
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", ""); PreparedStatement ps = (PreparedStatement) connection.prepareStatement("INSERT INTO `invoice_count`(`invoiceNo`, `CustomerName`, `DueAmount`, `DiscountTk`, `Cash`, `Digital_Payment`, `Digital_Paid`, `Paid_Tk`, `VAT`, `TotalBlance`,`Cash_Exchange`, `User`) VALUES  (?,?,?,?,?,?,?,?,?,?,?,?)")) {
                ps.setString(1, InvoiceNo.getText());
                ps.setString(2, CustomerNameCmb.getSelectedItem().toString());
                ps.setString(3, Due_TkTbl.getText());
                ps.setString(4, Discount_tkTbl.getText());
                ps.setString(5, Double.toString(Double.parseDouble(CashPaidTbl.getText()) - Double.parseDouble(CashExchanceTbl.getText())));
                ps.setString(6, DigitalMerchantCmb.getSelectedItem().toString());
                ps.setString(7, DigitalPaidTbl.getText());
                ps.setString(8, Double.toString(Double.parseDouble(CashPaidTbl.getText()) + Double.parseDouble(DigitalPaidTbl.getText())));
                ps.setString(9, VatTbl.getText());
                ps.setString(10, BlanceTbl.getText());
                ps.setString(11, CashExchanceTbl.getText());
                ps.setString(12, Login.UserBy);
                ps.executeUpdate();
            }
        } catch (ClassNotFoundException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }

//**====================Insert into Invaudit ========================**//
        for (int x = 0; x < model.getRowCount(); x++) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try (Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", ""); PreparedStatement ps = (PreparedStatement) connection.prepareStatement("INSERT INTO `invaudit`(`invoiceNo`, `Barcode`, `ProductName`, `Sale_Rate`, `Qty`, `Price`) VALUES (?,?,?,?,?,?)")) {
                    ps.setString(1, InvoiceNo.getText());
                    ps.setString(2, model.getValueAt(x, 1).toString());
                    ps.setString(3, model.getValueAt(x, 2).toString());
                    ps.setString(4, model.getValueAt(x, 3).toString());
                    ps.setString(5, model.getValueAt(x, 4).toString());
                    ps.setString(6, model.getValueAt(x, 5).toString());
                    ps.executeUpdate();
                }
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
//**============== Invoice Set From Database ==============**//
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection1 = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", ""); Statement statement1 = connection1.createStatement(); ResultSet result1 = statement1.executeQuery("SELECT COUNT(invoiceNo) AS counts FROM invoice_count")) {
                if (result1.next()) {
                    String formattedNumber = String.format("%010d", (result1.getInt(1) + 1));
                    InvoiceNo.setText(PC_Terminal.getText() + "QL" + formattedNumber);
                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    void Print_Invoice() {
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                java.sql.Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
                PreparedStatement ps = (PreparedStatement) connection.prepareStatement("INSERT INTO `invprint_" + Login.Pc_Terminal + "`(`SNo`, `invoiceNo`, `CName`, `DueAmount`, `Barcode`, `item`, `rate`, `qty`, `price`, `PaidAmount`, `DiscountTk`, `VAT`,`TotalSale`, `TotalBlance`, `Cash_Exchange`, `User`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                ps.setInt(1, i + 1);
                ps.setString(2, InvoiceNo.getText());
                ps.setString(3, CustomerNameCmb.getSelectedItem().toString());
                ps.setString(4, Due_TkTbl.getText());
                ps.setString(5, model.getValueAt(i, 1).toString());
                ps.setString(6, model.getValueAt(i, 2).toString());
                ps.setString(7, model.getValueAt(i, 3).toString());
                ps.setString(8, model.getValueAt(i, 4).toString());
                ps.setString(9, model.getValueAt(i, 5).toString());
                ps.setString(10, Double.toString(Double.parseDouble(CashPaidTbl.getText()) + Double.parseDouble(DigitalPaidTbl.getText())));
                ps.setString(11, Discount_tkTbl.getText());
                ps.setString(12, VatTbl.getText());
                ps.setString(13, TotalSaleTbl.getText());
                ps.setString(14, BlanceTbl.getText());
                ps.setString(15, CashExchanceTbl.getText());
                ps.setString(16, Login.UserBy);
                ps.executeUpdate();
            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
        Print_Customer_Copy();

    }

    void Print_Customer_Copy() {

        //write here jesper report Code//
        if (AutoPrintCheekBox.isSelected()) {
            // print start//
            try {
                // Load JDBC driver (assuming this is only needed once per application session)
                Class.forName("com.mysql.jdbc.Driver");

                // Establish database connection
                Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");

                // Load JasperDesign from JRXML file
                File jrxmlFile = new File("src/Report/Invoicep3.jrxml");  // Adjust path as necessary
                JasperDesign jd = JRXmlLoader.load(jrxmlFile.getAbsolutePath());

                // Set parameters if needed
                Map<String, Object> parameters = new HashMap<>();
                // parameters.put("invoiceno", InvoiceNo); // Uncomment and set parameters if needed

                // Compile JasperReport
                JasperReport jr = JasperCompileManager.compileReport(jd);

                // Fill the report
                JasperPrint jp = JasperFillManager.fillReport(jr, parameters, connection);

                // Print the report directly
                JasperPrintManager.printReport(jp, true); // true: show print dialog

                // Close the database connection
                connection.close();

            } catch (JRException ex) {
                ex.printStackTrace(); // Handle JasperReports exception
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace(); // Handle database exception
            }
            //print end //
        }

        Delete_Customer_Copy();
    }

    void Delete_Customer_Copy() {
        //**================ Invoice Print Code start ===================**//
        try {
            Connection connection1 = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            try (Statement statement = connection1.createStatement()) {
                String query = "DELETE FROM  invprint_" + Login.Pc_Terminal;
                statement.executeUpdate(query);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }


    private void SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBtnActionPerformed

        if (CashPaidTbl.getText().equalsIgnoreCase("")) {
            CashPaidTbl.setText("0.0");
        }
        if (DigitalPaidTbl.getText().equalsIgnoreCase("")) {
            DigitalPaidTbl.setText("0.0");
        }
        if (CashExchanceTbl.getText().equalsIgnoreCase("")) {
            CashExchanceTbl.setText("0.0");
        }

        //**==============Print Code Start================**// 
        if (Table.getRowCount() > 0 && AutoPrintCheekBox.isSelected()) {

            Print_Invoice();

        }

        if (Table.getRowCount() > 0) {
//**==================== Customer Due Calculation =========================**//
            if (Double.parseDouble(Due_TkTbl.getText()) > 0.0) {
                if (CustomerNameCmb.getSelectedItem().toString().equalsIgnoreCase("Select")) {
                    CustomerNameCmb.showPopup();
                } else {
                    double Total_Due = Double.parseDouble(Due_TkTbl.getText()) + Double.parseDouble(PreviousBlance.getText());
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        java.sql.Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
                        PreparedStatement ps = (PreparedStatement) connection.prepareStatement("INSERT INTO `customer_statement`(`Name`, `Address`, `Mobile`, `Debit`, `Credit`, `Balance`, `Description`, `InvoiceNO`) VALUES (?,?,?,?,?,?,?,?)");
                        ps.setString(1, CustomerNameCmb.getSelectedItem().toString());
                        ps.setString(2, CustomerAddressTbl.getText());
                        ps.setString(3, CustomerMobileTbl.getText());
                        ps.setString(4, "0");
                        ps.setString(5, Due_TkTbl.getText());
                        ps.setString(6, Double.toString(Total_Due));
                        ps.setString(7, "Sale");
                        ps.setString(8, InvoiceNo.getText());
                        ps.executeUpdate();
                    } catch (ClassNotFoundException | SQLException ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage());
                    }
                    Product_Sale_Confirm();
                    DSale_Clear();
                }
            } else if (Double.parseDouble(CashExchanceTbl.getText()) == 0.0 && Double.parseDouble(Due_TkTbl.getText()) == 0.0) {
                Product_Sale_Confirm();
                DSale_Clear();
            } else if (Double.parseDouble(CashExchanceTbl.getText()) > 0.0) {
                Login.ExchangeTk = CashExchanceTbl.getText();
                Product_Sale_Confirm();
                DSale_Clear();

            }
        }

//**==============Return Table Code Start================**//
        DefaultTableModel ReturnModel = (DefaultTableModel) ReturnTable.getModel();
        if (ReturnModel.getRowCount() > 0) {
            for (int x = 0; x < ReturnModel.getRowCount(); x++) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    java.sql.Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
                    PreparedStatement ps = (PreparedStatement) connection.prepareStatement("INSERT INTO `sale_return` (Barcode,	Item,	Rate,	Qty,	Amount,	invoiceNo,User,Total_Return) Values (?,?,?,?,?,?,?,?)");
                    ps.setString(1, ReturnModel.getValueAt(x, 1).toString());
                    ps.setString(2, ReturnModel.getValueAt(x, 2).toString());
                    ps.setString(3, ReturnModel.getValueAt(x, 3).toString());
                    ps.setString(4, ReturnModel.getValueAt(x, 4).toString());
                    ps.setString(5, ReturnModel.getValueAt(x, 5).toString());
                    ps.setString(6, Invoicetbl.getText());
                    ps.setString(7, Login.UserBy);
                    ps.setString(8, TotalSaleReturn.getText());
                    ps.executeUpdate();
                } catch (ClassNotFoundException | SQLException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
            }
            while (ReturnModel.getRowCount() > 0) {
                ReturnModel.removeRow(0);
            }
            DSale_Clear();
        }
        BarcodeTbl.requestFocus();
        ChangeTk window = new ChangeTk();
        window.setVisible(true);
    }//GEN-LAST:event_SaveBtnActionPerformed
    void DSale_Clear() {
        //**============Intitialize=============**//
        DefaultTableModel Model = (DefaultTableModel) Table.getModel();
        while (Model.getRowCount() > 0) {
            Model.removeRow(0);
        }
        Due_TkTbl.setText("0.0");
        net.setText("0.00");
        BlanceTbl.setText("0.0");
        TotalSaleTbl.setText("0.0");
        DigitalPaidTbl.setText("");
        CMobileTbl.setText("");
        CustomerIDTbl.setText("");
        CAddressTbl.setText("");
        CNameTbl.setText("");
        CashPaidTbl.setText("");
        Discount_tkTbl.setText("0.0");
        PercentDiscountTbl.setText("");
        CashExchanceTbl.setText("0.0");
        TotalSaleReturn.setText("0.0");
        Invoicetbl.setText("");
        ReturnBarcodeTbl.setText("");
        DigitalMerchantCmb.setSelectedItem("Select");
        CustomerNameCmb.setSelectedItem("Select");
        PreviousBlance.setText("0.0");
        CustomerMobileTbl.setText("");
        CustomerAddressTbl.setText("");
    }

    private void CashPaidTblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CashPaidTblKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            DigitalPaidTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            BarcodeTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            ProductSearchBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F11) {
            HoldBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F12) {
            RecallBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F6) {
            PercentDiscountTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F4) {
            DigitalPaidTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F8) {
            CashPaidTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F7) {
            ReturnBarcodeTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            SaveBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_C) {
            CustomerIDTbl.requestFocus();
        }
    }//GEN-LAST:event_CashPaidTblKeyPressed

    private void DigitalPaidTblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DigitalPaidTblKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            SaveBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            BarcodeTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            ProductSearchBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F11) {
            HoldBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F12) {
            RecallBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F6) {
            PercentDiscountTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F4) {
            DigitalPaidTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F8) {
            CashPaidTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F7) {
            ReturnBarcodeTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            SaveBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_C) {
            CustomerIDTbl.requestFocus();
        }
    }//GEN-LAST:event_DigitalPaidTblKeyPressed

    private void ReturnBarcodeTblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ReturnBarcodeTblKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            BarcodeTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            DefaultTableModel model = (DefaultTableModel) ReturnTable.getModel();
            int i;
            for (i = 0; i < ReturnTable.getRowCount(); i++) {
                if (model.getValueAt(i, 1).toString().equalsIgnoreCase(ReturnBarcodeTbl.getText())) {
                    JOptionPane.showMessageDialog(this, "This Product Also Inserted !!");
                    break;
                }
            }
            if (i == model.getRowCount()) {
                Return_Product();
            }

        }

        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            ProductSearchBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F11) {
            HoldBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F12) {
            RecallBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F6) {
            PercentDiscountTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F4) {
            DigitalPaidTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F8) {
            CashPaidTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F7) {
            ReturnBarcodeTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            SaveBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_C) {
            CustomerIDTbl.requestFocus();
        }
    }//GEN-LAST:event_ReturnBarcodeTblKeyPressed

    private void CashPaidTblKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CashPaidTblKeyTyped

    }//GEN-LAST:event_CashPaidTblKeyTyped

    private void DigitalPaidTblKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DigitalPaidTblKeyTyped

    }//GEN-LAST:event_DigitalPaidTblKeyTyped

    private void CashPaidTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CashPaidTblMouseClicked

    }//GEN-LAST:event_CashPaidTblMouseClicked

    private void DigitalPaidTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DigitalPaidTblMouseClicked

    }//GEN-LAST:event_DigitalPaidTblMouseClicked

    private void SaveBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SaveBtnKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            BarcodeTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            ProductSearchBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F11) {
            HoldBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F12) {
            RecallBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F6) {
            PercentDiscountTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F4) {
            DigitalPaidTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F8) {
            CashPaidTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F7) {
            ReturnBarcodeTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            SaveBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_C) {
            CustomerIDTbl.requestFocus();
        }

    }//GEN-LAST:event_SaveBtnKeyPressed

    private void CustomerIDTblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CustomerIDTblKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            BarcodeTbl.setText(null);
            BarcodeTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            ProductSearchBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F11) {
            HoldBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F12) {
            RecallBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F6) {
            PercentDiscountTbl.setText(null);
            PercentDiscountTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F4) {
            DigitalPaidTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F8) {
            CashPaidTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F7) {
            ReturnBarcodeTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            SaveBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_C) {
            CustomerIDTbl.requestFocus();
        }
    }//GEN-LAST:event_CustomerIDTblKeyPressed

    private void VatTblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VatTblActionPerformed

    }//GEN-LAST:event_VatTblActionPerformed

    private void ReturnTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ReturnTableKeyReleased

    }//GEN-LAST:event_ReturnTableKeyReleased

    private void InvoicetblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InvoicetblKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_InvoicetblKeyPressed

    private void InvoicetblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InvoicetblKeyReleased

    }//GEN-LAST:event_InvoicetblKeyReleased

    private void ReturnBarcodeTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReturnBarcodeTblMouseClicked
        if (Invoicetbl.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please Enter Invoice No");
            Invoicetbl.requestFocus();
        }
    }//GEN-LAST:event_ReturnBarcodeTblMouseClicked

    private void DigitalMerchantCmbKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DigitalMerchantCmbKeyPressed

    }//GEN-LAST:event_DigitalMerchantCmbKeyPressed

    private void jLabel31AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel31AncestorAdded

    }//GEN-LAST:event_jLabel31AncestorAdded

    private void AutoAddComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AutoAddComboBoxKeyPressed


    }//GEN-LAST:event_AutoAddComboBoxKeyPressed

    private void QtyTblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_QtyTblKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                if (!ProductNameTbl.getText().equalsIgnoreCase("")) {
                    Product_Insert(BarcodeTbl.getText(), ProductNameTbl.getText(), Double.parseDouble(SalePriceTbl.getText()), Double.parseDouble(QtyTbl.getText()));
                    Finantial_Calculation();
                    BarcodeTbl.setText(null);
                    QtyTbl.setText(null);
                    ProductNameTbl.setText(null);
                    AvableQtyTbl.setText(null);
                    SalePriceTbl.setText(null);
                    BarcodeTbl.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(this, "Wrong Barcode!");
                }
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_QtyTblKeyPressed

    private void CustomerNameCmbAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_CustomerNameCmbAncestorAdded
        CustomerNameCmb.addItem("Select");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Statement statement;
            try (Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "")) {
                statement = (Statement) connection.createStatement();
                ResultSet result = statement.executeQuery("SELECT * FROM `ladger` WHERE AccountType = 'Customer'");
                ResultSetMetaData rsmd = (ResultSetMetaData) result.getMetaData();
                while (result.next()) {
                    String Name = result.getString(2);
                    CustomerNameCmb.addItem(Name);
                }
                result.next();
            }
            statement.close();

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_CustomerNameCmbAncestorAdded

    private void Discount_tkTblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Discount_tkTblKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            CashPaidTbl.requestFocus();
        }

    }//GEN-LAST:event_Discount_tkTblKeyPressed

    private void BlanceTblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BlanceTblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BlanceTblActionPerformed

    private void Discount_tkTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Discount_tkTblMouseClicked
        UIManager.put("OptionPane.background", new Color(153, 0, 51)); // Change background color
        UIManager.put("Panel.background", new Color(153, 0, 51)); // Change panel background color
        UIManager.put("OptionPane.messageForeground", new Color(255, 255, 255)); // Change message text color
        UIManager.put("Button.background", new Color(255, 255, 255)); // Change button background color
        UIManager.put("Button.foreground", new Color(0, 102, 102)); // Change button text color
        double tk = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter Amount:"));
        Percentage_calculate(tk);
        Payment_System();
        BarcodeTbl.requestFocus();
    }//GEN-LAST:event_Discount_tkTblMouseClicked

    private void PercentDiscountTblKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PercentDiscountTblKeyTyped

    }//GEN-LAST:event_PercentDiscountTblKeyTyped

    private void PercentDiscountTblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PercentDiscountTblKeyReleased

    }//GEN-LAST:event_PercentDiscountTblKeyReleased

    private void PercentDiscountTblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PercentDiscountTblKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            BarcodeTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            ProductSearchBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F11) {
            HoldBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F12) {
            RecallBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F6) {
            PercentDiscountTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F4) {
            DigitalPaidTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F8) {
            CashPaidTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F7) {
            ReturnBarcodeTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            SaveBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_C) {
            CustomerIDTbl.requestFocus();
        }
    }//GEN-LAST:event_PercentDiscountTblKeyPressed

    private void PercentDiscountTblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PercentDiscountTblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PercentDiscountTblActionPerformed

    private void PercentDiscountTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PercentDiscountTblMouseClicked
        UIManager.put("OptionPane.background", new Color(153, 0, 51)); // Change background color
        UIManager.put("Panel.background", new Color(153, 0, 51)); // Change panel background color
        UIManager.put("OptionPane.messageForeground", new Color(255, 255, 255)); // Change message text color
        UIManager.put("Button.background", new Color(255, 255, 255)); // Change button background color
        UIManager.put("Button.foreground", new Color(0, 102, 102)); // Change button text color
        double Percentage = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter Percentage:"));
        Percentage_Tk_calculate(Percentage);
        Payment_System();
    }//GEN-LAST:event_PercentDiscountTblMouseClicked

    private void CashExchanceTblVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_CashExchanceTblVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_CashExchanceTblVetoableChange

    private void CNameTblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CNameTblKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            HoldBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            BarcodeTbl.requestFocus();
        }
    }//GEN-LAST:event_CNameTblKeyPressed

    private void ReturnTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ReturnTableKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F9) {
            DefaultTableModel model = (DefaultTableModel) ReturnTable.getModel();
            int selectedRow = ReturnTable.getSelectedRow();
            if (selectedRow != -1) {
                double Qty = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter Qty:"));
                Return_Product_Qty_Update(model.getValueAt(selectedRow, 1).toString(), model.getValueAt(selectedRow, 2).toString(), Double.parseDouble(model.getValueAt(selectedRow, 3).toString()), Qty);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row");
            }
        }
    }//GEN-LAST:event_ReturnTableKeyPressed

    private void DigitalMerchantCmbAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_DigitalMerchantCmbAncestorAdded
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Statement statement;
            try (Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "")) {
                statement = (Statement) connection.createStatement();
                ResultSet result = statement.executeQuery("SELECT LadgerName FROM `accountinfo` WHERE AccountType ='Bank Account' AND Bank_Permision = 'Allow'");
                ResultSetMetaData rsmd = (ResultSetMetaData) result.getMetaData();
                while (result.next()) {
                    DigitalMerchantCmb.addItem(result.getString(1));
                }
                result.next();
            }
            statement.close();

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_DigitalMerchantCmbAncestorAdded

    private void PC_TerminalVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_PC_TerminalVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_PC_TerminalVetoableChange

    private void CustomerIDTblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerIDTblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerIDTblActionPerformed

    private void BlanceTblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BlanceTblKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            BarcodeTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            ProductSearchBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F11) {
            HoldBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F12) {
            RecallBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F6) {
            PercentDiscountTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F4) {
            DigitalPaidTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F8) {
            CashPaidTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F7) {
            ReturnBarcodeTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            SaveBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_C) {
            CustomerIDTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            CashPaidTbl.requestFocus();
        }
    }//GEN-LAST:event_BlanceTblKeyPressed
//**=============Return Prodcut Insert Into Table ==============**//

    void Return_Product_Insert(String Barcode, String Product, double Sale_Rate, double Qty) {
        DefaultTableModel Model = (DefaultTableModel) ReturnTable.getModel();
        int Serial = Model.getRowCount() + 1;
        Model.addRow(new Object[]{Serial, Barcode, Product, Sale_Rate, Qty, Sale_Rate * Qty});
        Return_Finantial_Calculation();
    }

//**=============Return Calculation ==============**//
    void Return_Finantial_Calculation() {
        double Total_Sale_Return = 0.0;
        DefaultTableModel model = (DefaultTableModel) ReturnTable.getModel();
        for (int x = 0; x < model.getRowCount(); x++) {
            double Table_Return_Sale_Rate = Double.parseDouble(model.getValueAt(x, 5).toString());
            Total_Sale_Return += Table_Return_Sale_Rate;
            TotalSaleReturn.setText(Double.toString(Total_Sale_Return));
        }
    }
//**=============Return Prodcut Cheeking  ==============**//

    void Return_Product() {
        DefaultTableModel model = (DefaultTableModel) ReturnTable.getModel();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connection = (java.sql.Connection) java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            java.sql.Statement statement = (java.sql.Statement) connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT invaudit.Barcode, invaudit.ProductName, invaudit.Sale_Rate, invaudit.Qty AS SaleQty, COALESCE(sale_return.Qty, 0) AS ReturnQty, (invaudit.Qty - COALESCE(sale_return.Qty, 0)) AS CurrentQty, ((invaudit.Qty - COALESCE(sale_return.Qty, 0)) * invaudit.Sale_Rate) AS Amount FROM invaudit LEFT JOIN sale_return ON invaudit.invoiceNo = sale_return.invoiceNo AND invaudit.Barcode = sale_return.Barcode WHERE invaudit.Barcode = '" + ReturnBarcodeTbl.getText() + "' AND invaudit.invoiceNo = '" + Invoicetbl.getText() + "'");
            while (result.next()) {
                int serialNumber = model.getRowCount() + 1;
                if (Double.parseDouble(result.getString(6)) <= 0.0) {
                    JOptionPane.showMessageDialog(this, "This Product already Returned!!");
                } else {
                    Return_Product_Insert(result.getString(1), result.getString(2), Double.parseDouble(result.getString(3)), Double.parseDouble(result.getString(4)));
                    ReturnBarcodeTbl.setText(null);
                }
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e12) {
            JOptionPane.showMessageDialog(this, e12);
        }
    }

//**=============Return Prodcut Qty Update  ==============**//
    void Return_Product_Qty_Update(String Barcode, String Product, double Sale_Rate, double Qty) {
        DefaultTableModel model = (DefaultTableModel) ReturnTable.getModel();
        try {
            int SelectedRow = ReturnTable.getSelectedRow();
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connection = (java.sql.Connection) java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            java.sql.Statement statement = (java.sql.Statement) connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT invaudit.Barcode, invaudit.ProductName, invaudit.Sale_Rate, invaudit.Qty AS SaleQty, COALESCE(sale_return.Qty, 0) AS ReturnQty, (invaudit.Qty - COALESCE(sale_return.Qty, 0)) AS CurrentQty, ((invaudit.Qty - COALESCE(sale_return.Qty, 0)) * invaudit.Sale_Rate) AS Amount FROM invaudit LEFT JOIN sale_return ON invaudit.invoiceNo = sale_return.invoiceNo AND invaudit.Barcode = sale_return.Barcode WHERE invaudit.Barcode = '" + Barcode + "' AND invaudit.invoiceNo = '" + Invoicetbl.getText() + "'");
            while (result.next()) {
                int serialNumber = model.getRowCount() + 1;
                if (Double.parseDouble(result.getString(6)) >= Qty) {
                    model.setValueAt(Qty, SelectedRow, 4);
                    model.setValueAt((Double) (Sale_Rate * Qty), SelectedRow, 5);
                    Return_Finantial_Calculation();

                } else {
                    JOptionPane.showMessageDialog(this, "You Can Return Only " + Double.valueOf(result.getString(6)));
                }
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e12) {
            JOptionPane.showMessageDialog(this, e12);
        }
    }

//**================Product Insert Code start ===================**/
    void Product_Insert(String Barcode, String Product, double Sale_Rate, double Qty) {
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        /* for (int x = 0; x < model.getRowCount(); x++) {
            if (model.getValueAt(x, 1).toString().equalsIgnoreCase(Barcode)) {
                Qty = Qty + Double.parseDouble(model.getValueAt(x, 4).toString());
                break;
            }
        }*/
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Statement statement;
            try (Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "")) {
                statement = (Statement) connection.createStatement();
                ResultSet result = statement.executeQuery("SELECT Status, Qty FROM `purchase` WHERE Barcode ='" + Barcode + "'");
                while (result.next()) {
                    if (result.getString(1).equalsIgnoreCase("No")) {
                        if (Double.parseDouble(result.getString(2)) >= Qty) {
                            Product_Insert_Into_Table(Barcode, Product, Sale_Rate, Qty);
                        } else if (Double.parseDouble(result.getString(2)) == 0.0) {
                            JOptionPane.showMessageDialog(this, Product + " Out of Stock");
                        } else {
                            JOptionPane.showMessageDialog(this, Product + " Current Stock is -> " + Double.valueOf(result.getString(2)));
                        }
                    } else if (result.getString(1).equalsIgnoreCase("Yes")) {
                        Product_Insert_Into_Table(Barcode, Product, Sale_Rate, Qty);
                    }
                }
            }
            statement.close();
        } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    //**================Product Insert On Table Code start ===================**//
    void Product_Insert_Into_Table(String Barcode, String Product, double Sale_Rate, double Qty) {
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        int x;
        for (x = 0; x < model.getRowCount(); x++) {
            String barcodeFromTable = (String) model.getValueAt(x, 1);
            if (barcodeFromTable.equalsIgnoreCase(Barcode)) {
                model.setValueAt((Double) Qty, x, 4);
                model.setValueAt((Double) (Sale_Rate * Qty), x, 5);
                break;
            }
        }
        if (x == model.getRowCount()) {
            model.insertRow(0, new Object[]{model.getRowCount() + 1, Barcode, Product, Sale_Rate, Qty, (Sale_Rate * Qty)});
        }
        // Update the serial numbers to be in descending order
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(model.getRowCount() - i, i, 0); // Serial numbers should be 1, 2, 3, ...
        }
    }

//**================Product Qty Update Code start ===================**//
    void Product_Qty_Update(String Barcode, String Product, double Sale_Rate, double Qty) {
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        for (int x = 0; x < model.getRowCount(); x++) {
            String barcodeFromTable = (String) model.getValueAt(x, 1);
            if (barcodeFromTable.equalsIgnoreCase(Barcode)) {
                double Table_Sale_Rate = Double.parseDouble(model.getValueAt(x, 3).toString());
                model.setValueAt((Double) Qty, x, 4);
                model.setValueAt((Double) (Table_Sale_Rate * Qty), x, 5);
                break;
            }
        }
    }

    //**================ Percentage Calculation Code start ===================**//
    void Percentage_calculate(double tk) {
        try {
            double Vat = Double.parseDouble(VatTbl.getText());
            double TotalBlance_With_Vat = ((Double.parseDouble(TotalSaleTbl.getText()) * Vat) / 100) + Double.parseDouble(TotalSaleTbl.getText());

            Discount_tkTbl.setText(String.format("%.2f" + "", tk));
            PercentDiscountTbl.setText(String.format("%.2f", ((tk / TotalBlance_With_Vat) * 100.0)));
            Finantial_Calculation();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }

//**================ Percentage Calculation Code start ===================**//
    void Percentage_Tk_calculate(double percentage) {
        try {
            double Vat = Double.parseDouble(VatTbl.getText());
            double TotalBlance_With_Vat = ((Double.parseDouble(TotalSaleTbl.getText()) * Vat) / 100) + Double.parseDouble(TotalSaleTbl.getText());

            PercentDiscountTbl.setText(String.format("%.2f", percentage));
            Discount_tkTbl.setText(String.format("%.2f", ((percentage * TotalBlance_With_Vat) / 100.0)));
            Finantial_Calculation();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }

//**================ Finantial Calculation Code start ===================**//
    void Finantial_Calculation() {
///total sale///
        double Total_Sale = 0.0;
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        for (int x = 0; x < model.getRowCount(); x++) {
            double Table_Sale_Rate = Double.parseDouble(model.getValueAt(x, 3).toString());
            double Table_Qty = Double.parseDouble(model.getValueAt(x, 4).toString());
            Total_Sale += (Table_Sale_Rate * Table_Qty);
            TotalSaleTbl.setText(Double.toString(Total_Sale));
        }
        ///vat calculation
        double Vat = Double.parseDouble(VatTbl.getText());
        double TotalBlance_With_Vat = ((Total_Sale * Vat) / 100) + Total_Sale;

//==============Discount Calculation====================//
        double Discount = Double.parseDouble(Discount_tkTbl.getText());
        BlanceTbl.setText(Double.toString(TotalBlance_With_Vat - Discount));
        net.setText(Double.toString(TotalBlance_With_Vat - Discount));
        Due_TkTbl.setText(Double.toString(TotalBlance_With_Vat - Discount));
    }
//**================ Finantial Calculation Code start ===================**//

//**================ Payment System Code start ===================**//
    void Payment_System() {
        try {
            double Cash, Digital;
            double total_bal = Double.parseDouble(BlanceTbl.getText());
            if (CashPaidTbl.getText().equalsIgnoreCase("")) {
                Cash = 0.0;
            } else {
                Cash = Double.parseDouble(CashPaidTbl.getText());
            }
            if (DigitalPaidTbl.getText().equalsIgnoreCase("")) {
                Digital = 0.0;
            } else {
                Digital = Double.parseDouble(DigitalPaidTbl.getText());
            }
            double avl = total_bal - Cash - Digital;
            if (avl < 0.0) {
                Due_TkTbl.setText(Double.toString(0.0));
                CashExchanceTbl.setText(Double.toString(avl * (-1)));
            } else {
                Due_TkTbl.setText(Double.toString(avl));
                CashExchanceTbl.setText(Double.toString(0.0));
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
           new DSale().setVisible(true);
            
       });
        
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Address;
    private javax.swing.JCheckBox AutoAddComboBox;
    private javax.swing.JCheckBox AutoPrintCheekBox;
    private javax.swing.JLabel AvableQty;
    private javax.swing.JLabel AvableQty1;
    private javax.swing.JTextField AvableQtyTbl;
    private javax.swing.JTextField BarcodeTbl;
    private javax.swing.JTextField BlanceTbl;
    private javax.swing.JTextField CAddressTbl;
    private javax.swing.JTextField CMobileTbl;
    private javax.swing.JTextField CNameTbl;
    private javax.swing.JTextField CashExchanceTbl;
    private javax.swing.JTextField CashPaidTbl;
    private javax.swing.JTextField CustomerAddressTbl;
    private javax.swing.JTextField CustomerIDTbl;
    private javax.swing.JTextField CustomerMobileTbl;
    private javax.swing.JComboBox<String> CustomerNameCmb;
    private javax.swing.JLabel Datetbl;
    private javax.swing.JComboBox<String> DigitalMerchantCmb;
    private javax.swing.JTextField DigitalPaidTbl;
    private javax.swing.JTextField Discount_tkTbl;
    private javax.swing.JTextField Due_TkTbl;
    private javax.swing.JButton HoldBtn;
    private javax.swing.JLabel InvoiceNo;
    private javax.swing.JTextField Invoicetbl;
    private javax.swing.JLabel PC_Terminal;
    private javax.swing.JTextField PercentDiscountTbl;
    private javax.swing.JLabel PreviousBlance;
    private javax.swing.JTextField ProductNameTbl;
    private javax.swing.JButton ProductSearchBtn;
    private javax.swing.JTextField QtyTbl;
    private javax.swing.JButton RecallBtn;
    private javax.swing.JTextField ReturnBarcodeTbl;
    private javax.swing.JTable ReturnTable;
    private javax.swing.JTextField SalePriceTbl;
    private javax.swing.JButton SaveBtn;
    private javax.swing.JTable Table;
    private javax.swing.JTextField TotalSaleReturn;
    private javax.swing.JTextField TotalSaleTbl;
    private javax.swing.JTextField VatTbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel net;
    private javax.swing.JLabel userby;
    // End of variables declaration//GEN-END:variables
}
