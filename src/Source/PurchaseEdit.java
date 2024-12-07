package Source;

import com.mysql.jdbc.PreparedStatement;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class PurchaseEdit extends javax.swing.JFrame {

    String Status;

    public PurchaseEdit() {
        initComponents();
        intilize();
    }

    private void intilize() {
        Supplier_Insert_All();
        //**================ Close Code start ===================**//
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                DefaultTableModel Model = (DefaultTableModel) purchaseTable.getModel();
                if (Model.getRowCount() > 0) {
                    try {
                        int rowCount = Model.getRowCount();
                        for (int x = 0; x < rowCount; x++) {
                            Login.HoldPurchase[x][0] = Model.getValueAt(x, 1).toString();
                            Login.HoldPurchase[x][1] = Model.getValueAt(x, 2).toString();
                            Login.HoldPurchase[x][2] = Model.getValueAt(x, 3).toString();
                            Login.HoldPurchase[x][3] = Model.getValueAt(x, 4).toString();
                            Login.HoldPurchase[x][4] = Model.getValueAt(x, 5).toString();
                            Login.HoldPurchase[x][5] = Model.getValueAt(x, 6).toString();
                            Login.HoldPurchase[x][6] = SupplierMemoNoTbl.getText();
                            Login.HoldPurchase[x][7] = SupplierNameJComboBox.getSelectedItem().toString();
                        }
                    } catch (Exception e1) {
                        System.out.println(e1.getMessage());
                    }
                }
            }
        });

        //**================ Search Product Code start ===================**//
        try {
            int Total_Search_Product_Count = 0;
            while (Login.HoldPurchase[Total_Search_Product_Count][0] != null) {
                Total_Search_Product_Count++;
            }
            for (int i = 0; i < Total_Search_Product_Count; i++) {
                Product_Insert_Into_Table(Login.HoldPurchase[i][0], Login.HoldPurchase[i][1], Login.HoldPurchase[i][2], Double.parseDouble(Login.HoldPurchase[i][3]), Double.parseDouble(Login.HoldPurchase[i][4]), Double.parseDouble(Login.HoldPurchase[i][5]));
                Finantial_Calculation();
                Login.HoldPurchase[i][0] = null;
            }
            if (Total_Search_Product_Count != 0) {
                supplier_insert(Login.HoldPurchase[1][6], Login.HoldPurchase[1][7]);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        purchaseTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        savebtn = new javax.swing.JButton();
        TotalAmountTbl = new java.awt.TextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        TraditionalCost = new javax.swing.JTextField();
        TraditionalDiscount = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        SalePriceTbl = new javax.swing.JTextField();
        BarcodeTbl = new javax.swing.JTextField();
        GrossProfitTbl = new javax.swing.JTextField();
        AmountTbl = new javax.swing.JTextField();
        VatTbl = new javax.swing.JTextField();
        SupplierNameJComboBox = new javax.swing.JComboBox<>();
        GroupNameComboBox = new javax.swing.JComboBox<>();
        ProductNameJComboBox = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        MRPTbl = new javax.swing.JTextField();
        AddBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        OldPriceTbl = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        MRP = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jCheckBox1 = new javax.swing.JCheckBox();
        SupplierMemoNoTbl = new javax.swing.JTextField();
        QtyTbl = new javax.swing.JTextField();
        PurchaseRateTbl = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        FreeTbl = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        lastqty = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        GrossProfitJLable = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        ReturnQtyjLabel = new javax.swing.JLabel();
        TotalQtyJLable = new javax.swing.JLabel();
        jLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Purchase");
        setExtendedState(6);
        setResizable(false);
        setState(6);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Purchase", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(204, 255, 255))); // NOI18N
        jPanel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jPanel2.setBackground(new java.awt.Color(234, 255, 255));
        jPanel2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel2AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        purchaseTable.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        purchaseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S/L", "Barcode", "Product Name", "Group Name", "Rate", "Qty", "MRP", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        purchaseTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                purchaseTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(purchaseTable);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Barcode", "Item Name", "Rate", "MRP"
            }
        ));
        jTable1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));

        jButton4.setBackground(new java.awt.Color(0, 102, 102));
        jButton4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Barcode Print");
        jButton4.setBorder(null);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel14.setText("Total");

        savebtn.setBackground(new java.awt.Color(0, 102, 102));
        savebtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        savebtn.setForeground(new java.awt.Color(255, 255, 255));
        savebtn.setText("Save (F6)");
        savebtn.setBorder(null);
        savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtnActionPerformed(evt);
            }
        });

        TotalAmountTbl.setBackground(new java.awt.Color(255, 255, 255));
        TotalAmountTbl.setEditable(false);
        TotalAmountTbl.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        TotalAmountTbl.addTextListener(new java.awt.event.TextListener() {
            public void textValueChanged(java.awt.event.TextEvent evt) {
                TotalAmountTblTextValueChanged(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 51, 0));
        jLabel26.setText("Traditional Cost");

        jLabel27.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 102, 102));
        jLabel27.setText("Traditional Discount");

        TraditionalCost.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TraditionalCost.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TraditionalCost.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TraditionalCostFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TraditionalCostFocusLost(evt);
            }
        });
        TraditionalCost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TraditionalCostMouseClicked(evt);
            }
        });
        TraditionalCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TraditionalCostKeyReleased(evt);
            }
        });

        TraditionalDiscount.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TraditionalDiscount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TraditionalDiscount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TraditionalDiscountMouseClicked(evt);
            }
        });
        TraditionalDiscount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TraditionalDiscountKeyReleased(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(0, 153, 204));
        jButton7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Recall");
        jButton7.setBorder(null);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(0, 153, 153));
        jButton8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Hold");
        jButton8.setBorder(null);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        DeleteBtn.setBackground(new java.awt.Color(255, 51, 51));
        DeleteBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DeleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        DeleteBtn.setText("Delete");
        DeleteBtn.setBorder(null);
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TraditionalCost, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TraditionalDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TotalAmountTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(savebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TotalAmountTbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(savebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TraditionalDiscount, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(TraditionalCost)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));

        SalePriceTbl.setBackground(new java.awt.Color(255, 153, 153));
        SalePriceTbl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        SalePriceTbl.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        SalePriceTbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SalePriceTblKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SalePriceTblKeyReleased(evt);
            }
        });

        BarcodeTbl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
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

        GrossProfitTbl.setEditable(false);
        GrossProfitTbl.setBackground(new java.awt.Color(255, 153, 153));
        GrossProfitTbl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        GrossProfitTbl.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        GrossProfitTbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                GrossProfitTblKeyReleased(evt);
            }
        });

        AmountTbl.setEditable(false);
        AmountTbl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AmountTbl.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        AmountTbl.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                AmountTblFocusGained(evt);
            }
        });
        AmountTbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AmountTblKeyReleased(evt);
            }
        });

        VatTbl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        VatTbl.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        SupplierNameJComboBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        SupplierNameJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Sylhet Enterprise", "Quick Ledger" }));
        SupplierNameJComboBox.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                SupplierNameJComboBoxAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        SupplierNameJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupplierNameJComboBoxActionPerformed(evt);
            }
        });
        SupplierNameJComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SupplierNameJComboBoxKeyPressed(evt);
            }
        });

        GroupNameComboBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        GroupNameComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        GroupNameComboBox.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                GroupNameComboBoxAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        GroupNameComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                GroupNameComboBoxFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                GroupNameComboBoxFocusLost(evt);
            }
        });
        GroupNameComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                GroupNameComboBoxMousePressed(evt);
            }
        });
        GroupNameComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GroupNameComboBoxActionPerformed(evt);
            }
        });

        ProductNameJComboBox.setBackground(new java.awt.Color(255, 204, 204));
        ProductNameJComboBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ProductNameJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Product Name" }));
        ProductNameJComboBox.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                ProductNameJComboBoxAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        ProductNameJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductNameJComboBoxActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Ledger Creator (F12)");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        MRPTbl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        MRPTbl.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        MRPTbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MRPTblKeyPressed(evt);
            }
        });

        AddBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AddBtn.setText("Add");
        AddBtn.setBorder(null);
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });
        AddBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AddBtnKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AddBtnKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 153));
        jLabel8.setText("Qty (F9)");

        OldPriceTbl.setBackground(new java.awt.Color(255, 153, 153));
        OldPriceTbl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        OldPriceTbl.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        OldPriceTbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                OldPriceTblKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 153));
        jLabel9.setText("Gross Profit%");

        MRP.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        MRP.setForeground(new java.awt.Color(0, 0, 153));
        MRP.setText("MRP");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 153));
        jLabel10.setText("Purchase Rate");

        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 153));
        jLabel20.setText("Old MRP");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 153));
        jLabel11.setText("Amount");

        jButton6.setBackground(new java.awt.Color(0, 153, 153));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Return");
        jButton6.setBorder(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 153));
        jLabel12.setText("Sale Price");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 153));
        jLabel13.setText("Vat%");

        jDateChooser1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jDateChooser1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jDateChooser1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jCheckBox1.setBackground(new java.awt.Color(204, 255, 204));
        jCheckBox1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jCheckBox1.setText("Auto Delivery");

        SupplierMemoNoTbl.setBackground(new java.awt.Color(255, 204, 255));
        SupplierMemoNoTbl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        SupplierMemoNoTbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SupplierMemoNoTbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupplierMemoNoTblActionPerformed(evt);
            }
        });
        SupplierMemoNoTbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SupplierMemoNoTblKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SupplierMemoNoTblKeyReleased(evt);
            }
        });

        QtyTbl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        QtyTbl.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        QtyTbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                QtyTblKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                QtyTblKeyReleased(evt);
            }
        });

        PurchaseRateTbl.setBackground(new java.awt.Color(204, 204, 255));
        PurchaseRateTbl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PurchaseRateTbl.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        PurchaseRateTbl.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PurchaseRateTblFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PurchaseRateTblFocusLost(evt);
            }
        });
        PurchaseRateTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PurchaseRateTblMousePressed(evt);
            }
        });
        PurchaseRateTbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PurchaseRateTblActionPerformed(evt);
            }
        });
        PurchaseRateTbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PurchaseRateTblKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PurchaseRateTblKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PurchaseRateTblKeyTyped(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 102, 102));
        jButton3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("New Product Setup (F5)");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Supplier Memo No.");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Supplier Name");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Invoice Date");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("Code No. (F1)");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 153));
        jLabel6.setText("Group Name");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 153));
        jLabel7.setText("Product Name Description");

        FreeTbl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        FreeTbl.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        FreeTbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FreeTblKeyPressed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Free Oty");

        jTextField1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTextField1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SupplierMemoNoTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(SupplierNameJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(QtyTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(GrossProfitTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(PurchaseRateTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(AmountTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel11)))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SalePriceTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(VatTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(OldPriceTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(BarcodeTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(GroupNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(ProductNameJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(MRP)
                                                .addComponent(MRPTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(FreeTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel17))))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SupplierNameJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SupplierMemoNoTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProductNameJComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GroupNameComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BarcodeTbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(MRP)
                        .addComponent(jLabel17))
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1)
                    .addComponent(QtyTbl, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(GrossProfitTbl, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(PurchaseRateTbl, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(AmountTbl, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(SalePriceTbl, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(VatTbl, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(OldPriceTbl, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(MRPTbl, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(FreeTbl, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(AddBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 51, 153));
        jLabel16.setText("Last Purchase Qty");

        lastqty.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lastqty.setForeground(new java.awt.Color(0, 51, 153));
        lastqty.setText("0.00");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 0));
        jLabel1.setText("Gross Profit%");

        GrossProfitJLable.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        GrossProfitJLable.setForeground(new java.awt.Color(51, 153, 0));
        GrossProfitJLable.setText("0.00");
        GrossProfitJLable.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                GrossProfitJLableVetoableChange(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 51, 0));
        jLabel24.setText("Return Amount");

        jLabel25.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 51, 0));
        jLabel25.setText("0.00");

        jLabel28.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 51, 0));
        jLabel28.setText("Return Qty");

        ReturnQtyjLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ReturnQtyjLabel.setForeground(new java.awt.Color(255, 51, 0));
        ReturnQtyjLabel.setText("0.00");

        TotalQtyJLable.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TotalQtyJLable.setForeground(new java.awt.Color(0, 0, 153));
        TotalQtyJLable.setText("0.00");
        TotalQtyJLable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TotalQtyJLableKeyPressed(evt);
            }
        });

        jLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel.setForeground(new java.awt.Color(0, 0, 153));
        jLabel.setText("Total Qty");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lastqty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GrossProfitJLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ReturnQtyjLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TotalQtyJLable, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TotalQtyJLable, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ReturnQtyjLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GrossProfitJLable, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastqty, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        setSize(new java.awt.Dimension(1521, 819));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SupplierCretor SupplierCretor = new SupplierCretor();
        SupplierCretor.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        NewproductEntry NewproductEntry = new NewproductEntry();
        NewproductEntry.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        PaddReturn PaddReturn = new PaddReturn();
        PaddReturn.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed
    void Supplier_Insert_All() {
        //**==============Supplier Name=================**//
        try {
            SupplierNameJComboBox.removeAllItems();
            SupplierNameJComboBox.addItem("Select");
            Class.forName("com.mysql.jdbc.Driver");
            Statement statement1;
            try (Connection connection1 = DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "")) {
                statement1 = connection1.createStatement();
                ResultSet result1 = statement1.executeQuery("SELECT * FROM `accountinfo` WHERE AccountType = 'Supplier'");
                while (result1.next()) {
                    String Name = result1.getString(3);
                    SupplierNameJComboBox.addItem(Name);
                }
            }
            statement1.close();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(this, e.getMessage());
        }
    }
    private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtnActionPerformed
        DefaultTableModel model = (DefaultTableModel) purchaseTable.getModel();
        int rowCount = model.getRowCount();
        if (rowCount == 0) {
            JOptionPane.showMessageDialog(this, "Table is Empty!");
        } else {
            try {
                Date selectedDate = jDateChooser1.getDate();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String date = dateFormat.format(selectedDate);

                int choice = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    //**===================Traditional Cost and DisCount============================**//
                    try {
                        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
                        PreparedStatement ps = (PreparedStatement) connection.prepareStatement("INSERT INTO `traditional_cost`(`invoiceNo`, `Cast`, `Discount`, `UserBy`) VALUES (?,?,?,?)");

                        ps.setString(1, SupplierMemoNoTbl.getText());
                        ps.setString(2, TraditionalCost.getText());
                        ps.setString(3, TraditionalDiscount.getText());
                        ps.setString(4, Login.UserBy);
                        ps.executeUpdate();
                    } catch (NumberFormatException | SQLException e) {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }

                    for (int x = 0; x < rowCount; x++) {
                        try {
                            Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
                            PreparedStatement ps = (PreparedStatement) connection.prepareStatement("INSERT INTO purchase_statement (Date,InvoiceNo,SupplierName,Barcode,ItemName,GroupName,Qty,Rate,SalePrice,Status,User) VALUES (?,?,?,?,?,?,?,?,?,?,?)");

                            ps.setString(1, date);
                            ps.setString(2, SupplierMemoNoTbl.getText());
                            ps.setString(3, SupplierNameJComboBox.getSelectedItem().toString());
                            ps.setString(4, model.getValueAt(x, 1).toString());
                            ps.setString(5, model.getValueAt(x, 2).toString());
                            ps.setString(6, model.getValueAt(x, 3).toString());
                            ps.setString(7, model.getValueAt(x, 5).toString());
                            ps.setString(8, model.getValueAt(x, 4).toString());
                            ps.setString(9, model.getValueAt(x, 6).toString());
                            ps.setString(10, Status);
                            ps.setString(11, Login.UserBy);
                            ps.executeUpdate();
                        } catch (NumberFormatException | SQLException e) {
                            JOptionPane.showMessageDialog(this, "Error fetching previous balance: " + e.getMessage());
                        }

                    }

                    // Supplier statement calculations
                    double previous_balance = 0.0;
                    try {
                        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
                        Statement statement = connection.createStatement();
                        ResultSet result = statement.executeQuery("SELECT * FROM ladger WHERE AccountType = 'Supplier' AND Name ='" + SupplierNameJComboBox.getSelectedItem().toString() + "'");
                        while (result.next()) {
                            String Pre_Balance = result.getString(5);
                            previous_balance = Double.parseDouble(Pre_Balance);
                        }
                    } catch (NumberFormatException | SQLException e) {
                        JOptionPane.showMessageDialog(this, "Error fetching previous balance: " + e.getMessage());
                    }

                    try {
                        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
                        PreparedStatement ps = (PreparedStatement) connection.prepareStatement("INSERT INTO supplier_statement (Date,InvoiceNO,Name,Description,Credit,Blance,User) VALUES (?,?,?,?,?,?,?)");

                        ps.setString(1, date);
                        ps.setString(2, SupplierMemoNoTbl.getText());
                        ps.setString(3, SupplierNameJComboBox.getSelectedItem().toString());
                        ps.setString(4, "Product Purchase");
                        ps.setDouble(5, Double.parseDouble(TotalAmountTbl.getText()));
                        ps.setString(6, Double.toString(previous_balance + Double.parseDouble(TotalAmountTbl.getText())));
                        ps.setString(7, Login.UserBy);
                        ps.executeUpdate();
                    } catch (NumberFormatException | SQLException e) {
                        JOptionPane.showMessageDialog(this, "Error updating supplier statement: " + e.getMessage());
                    }
                    JOptionPane.showMessageDialog(PurchaseEdit.this, "Product Purchased", "Done", JOptionPane.INFORMATION_MESSAGE);
                    while (model.getRowCount() > 0) {
                        model.removeRow(0);
                    }
                    All_TextBox_Clear();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Please Enter Date");
            }
        }

    }//GEN-LAST:event_savebtnActionPerformed
    void Clear() {
        AmountTbl.setText(null);
        QtyTbl.setText(null);
        BarcodeTbl.setText(null);
        GroupNameComboBox.setSelectedItem("Select");
        ProductNameJComboBox.setSelectedItem("Select");
        PurchaseRateTbl.setText(null);
        SalePriceTbl.setText(null);
        GrossProfitTbl.setText("N/A");

    }

    void Lock(String Supplier) {
        SupplierNameJComboBox.removeAllItems();
        SupplierNameJComboBox.addItem(Supplier);
        SupplierMemoNoTbl.setEditable(false);
    }
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F4)
            jButton1.requestFocus();
    }//GEN-LAST:event_formKeyPressed

    private void SupplierMemoNoTblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SupplierMemoNoTblKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F12) {
            jButton1.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            jButton3.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            SupplierNameJComboBox.showPopup();
    }//GEN-LAST:event_SupplierMemoNoTblKeyPressed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        DefaultTableModel model = (DefaultTableModel) purchaseTable.getModel();
        if (model.getRowCount() > 0) {
            JOptionPane.showMessageDialog(this, "Hold First Then Recall");
        } else {
            this.dispose();
            HoldPurchase window = new HoldPurchase();
            window.setVisible(true);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void BarcodeTblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BarcodeTblKeyReleased

    }//GEN-LAST:event_BarcodeTblKeyReleased

    private void ProductNameJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductNameJComboBoxActionPerformed
        int count = 0;
        Object selectedItem = ProductNameJComboBox.getSelectedItem();
        if (selectedItem != null) {
            if (selectedItem.toString().equals("Select")) {
                Clear();
            } else {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Statement statement;
                    try (Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "")) {
                        statement = (Statement) connection.createStatement();
                        ResultSet result = statement.executeQuery("SELECT * FROM `stock_enrty` WHERE ItemName='" + selectedItem.toString() + "'");
                        while (result.next()) {
                            GroupNameComboBox.setSelectedItem(result.getString(8));
                            BarcodeTbl.setText(result.getString(3));
                            Status = result.getString(14);
                            SalePriceTbl.setText(result.getString(13));
                            PurchaseRateTbl.setText(result.getString(10));
                            QtyTbl.requestFocus();

                            ////////////////////////////////////////////////
                            try {
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection connection1 = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
                                Statement statement1 = (Statement) connection1.createStatement();
                                ResultSet result1 = statement1.executeQuery("Select * from purchase WHERE Barcode ='" + BarcodeTbl.getText() + "'");
                                while (result1.next()) {
                                    PurchaseRateTbl.setText(result1.getString(8));
                                    SalePriceTbl.setText(result1.getString(10));
                                    lastqty.setText(result1.getString(7));
                                    Gross_Profit();
                                }
                            } catch (ClassNotFoundException | SQLException e34) {
                                JOptionPane.showMessageDialog(this, e34.getMessage());
                            }

                        }
                        result.next();
                    }
                    statement.close();
                } catch (HeadlessException | ClassNotFoundException | SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
        }

    }//GEN-LAST:event_ProductNameJComboBoxActionPerformed

    private void SupplierNameJComboBoxAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_SupplierNameJComboBoxAncestorAdded

    }//GEN-LAST:event_SupplierNameJComboBoxAncestorAdded

    private void GroupNameComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GroupNameComboBoxActionPerformed

    }//GEN-LAST:event_GroupNameComboBoxActionPerformed

    //**================Product Insert On Table Code start ===================**//
    void Product_Insert_Into_Table(String Barcode, String Product, String Group, double Rate, double Qty, double Mrp) {
        DefaultTableModel model = (DefaultTableModel) purchaseTable.getModel();
        int x;
        for (x = 0; x < model.getRowCount(); x++) {
            String barcodeFromTable = (String) model.getValueAt(x, 1);
            if (barcodeFromTable.equalsIgnoreCase(Barcode)) {
                model.setValueAt((Double) Rate, x, 4);
                model.setValueAt((Double) (Qty), x, 5);
                model.setValueAt((Double) Mrp, x, 6);
                model.setValueAt((Double) (Rate * Qty), x, 7);
                break;
            }
        }
        if (x == model.getRowCount()) {
            int serialNumber = model.getRowCount() + 1;
            model.addRow(new Object[]{serialNumber, Barcode, Product, Group, Rate, Qty, Mrp, String.format("%.2f", (Rate * Qty))});

        }
    }

    void supplier_insert(String Supplier_Memo, String Supplier_Name) {
        SupplierMemoNoTbl.setText(Supplier_Memo);
        SupplierNameJComboBox.setSelectedItem(Supplier_Name);
        SupplierMemoNoTbl.setEditable(false);

        SupplierNameJComboBox.addItem(Supplier_Name);

    }

    //**================ Finantial Calculation Code start ===================**//
    void Finantial_Calculation() {
        double Total_Rate_Amount = 0.0, Total_Buy_Rate = 0.0, Total_Qty = 0.0, Total_Sale_Mrp = 0.0;
        DefaultTableModel model = (DefaultTableModel) purchaseTable.getModel();
        for (int x = 0; x < model.getRowCount(); x++) {
            double Table_Total_Amount = Double.parseDouble(model.getValueAt(x, 7).toString());
            double Table_Total_Rate = Double.parseDouble(model.getValueAt(x, 4).toString());
            double Table_Total_Qty = Double.parseDouble(model.getValueAt(x, 5).toString());
            double Table_Total_Mrp = Double.parseDouble(model.getValueAt(x, 6).toString());
            Total_Rate_Amount += Table_Total_Amount;
            Total_Sale_Mrp += Table_Total_Mrp * Table_Total_Qty;
            Total_Qty += Table_Total_Qty;
        }
        TotalQtyJLable.setText(String.format("%.2f", Total_Qty));
        double gross_Profit = ((Total_Sale_Mrp - Total_Rate_Amount) / Total_Rate_Amount) * 100.0;
        GrossProfitJLable.setText(String.format("%.2f", gross_Profit));
        if (TraditionalCost.getText().equals("")) {
            TraditionalCost.setText("0");
        }
        if (TraditionalDiscount.getText().equals("")) {
            TraditionalDiscount.setText("0");
        }
        TotalAmountTbl.setText(String.format("%.2f", Total_Rate_Amount - Double.parseDouble(TraditionalDiscount.getText()) + Double.parseDouble(TraditionalCost.getText())));
    }

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        try {
            Supplier_Memo_Cheek();
            if (SupplierMemoNoTbl.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Input Supplier Memo No!");
            } else {
                if (SupplierNameJComboBox.getSelectedItem().toString().equals("Select")) {
                    JOptionPane.showMessageDialog(this, "Please Select Supplier!");
                } else {
                    if (BarcodeTbl.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Please Input Barcode!");
                    } else {
                        if (GroupNameComboBox.getSelectedItem().toString().equals("Select")) {
                            JOptionPane.showMessageDialog(this, "Please Select Group Name!");
                        } else {
                            if (ProductNameJComboBox.getSelectedItem().toString().equals("Select")) {
                                JOptionPane.showMessageDialog(this, "Please Select Product Name!");
                            } else {
                                if (QtyTbl.getText().isEmpty()) {
                                    JOptionPane.showMessageDialog(this, "Please Input Quantity!");
                                } else {
                                    Product_Insert_Into_Table(BarcodeTbl.getText(), ProductNameJComboBox.getSelectedItem().toString(), GroupNameComboBox.getSelectedItem().toString(), Double.parseDouble(PurchaseRateTbl.getText()), Double.parseDouble(QtyTbl.getText()), Double.parseDouble(SalePriceTbl.getText()));
                                    Finantial_Calculation();
                                    Clear();
                                    Lock(SupplierNameJComboBox.getSelectedItem().toString());
                                }
                            }
                        }
                    }
                }
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }


    }//GEN-LAST:event_AddBtnActionPerformed

    private void PurchaseRateTblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PurchaseRateTblKeyReleased
        try {
            Calculation(Double.parseDouble(QtyTbl.getText()), Double.parseDouble(PurchaseRateTbl.getText()));
            Gross_Profit();
        } catch (NumberFormatException e) {
        }
    }//GEN-LAST:event_PurchaseRateTblKeyReleased

    private void SalePriceTblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SalePriceTblKeyReleased
        Gross_Profit();
    }//GEN-LAST:event_SalePriceTblKeyReleased

    private void AmountTblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AmountTblKeyReleased

        try {
            String amountStr = AmountTbl.getText();
            if (amountStr != null && !amountStr.isEmpty()) {
                double amount = Double.parseDouble(amountStr);

                String qtyStr = QtyTbl.getText();
                if (qtyStr != null && !qtyStr.isEmpty()) {
                    double quantity = Double.parseDouble(qtyStr);

                    if (quantity != 0.0) { // Avoid division by zero
                        double value = amount / quantity;
                        PurchaseRateTbl.setText(String.format("%.2f", value)); // Set the value in PurchaseRateTbl as formatted string
                    } else {
                        // Handle division by zero case
                        JOptionPane.showMessageDialog(this, "Quantity cannot be zero!");
                    }
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input format!"); // Handle non-numeric input
        }


    }//GEN-LAST:event_AmountTblKeyReleased

    private void SupplierNameJComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SupplierNameJComboBoxKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            BarcodeTbl.requestFocus();
        }
    }//GEN-LAST:event_SupplierNameJComboBoxKeyPressed

    private void GroupNameComboBoxAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_GroupNameComboBoxAncestorAdded
        GroupNameComboBox.removeAllItems();
        GroupNameComboBox.addItem("Select");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Statement statement;
            try (Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "")) {
                statement = (Statement) connection.createStatement();
                ResultSet result = statement.executeQuery("SELECT * FROM `groupname`");
                String Name;
                while (result.next()) {
                    Name = result.getString(2);
                    GroupNameComboBox.addItem(Name);
                }
                result.next();
            }
            statement.close();

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_GroupNameComboBoxAncestorAdded

    private void SupplierNameJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupplierNameJComboBoxActionPerformed

    }//GEN-LAST:event_SupplierNameJComboBoxActionPerformed

    private void GroupNameComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_GroupNameComboBoxFocusGained

    }//GEN-LAST:event_GroupNameComboBoxFocusGained

    private void GroupNameComboBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_GroupNameComboBoxFocusLost

    }//GEN-LAST:event_GroupNameComboBoxFocusLost

    private void GroupNameComboBoxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GroupNameComboBoxMousePressed
        BarcodeTbl.setText(null);
    }//GEN-LAST:event_GroupNameComboBoxMousePressed

    void Gross_Profit() {
        if (SalePriceTbl.getText().equals("") || PurchaseRateTbl.getText().equals("")) {
            GrossProfitTbl.setText("N/A");
        } else {
            double gross_profit = ((Double.parseDouble(SalePriceTbl.getText()) - Double.parseDouble(PurchaseRateTbl.getText())) / Double.parseDouble(PurchaseRateTbl.getText())) * 100.0;
            GrossProfitTbl.setText(String.format("%.2f", gross_profit));
        }

    }

    void Calculation(double Qty, double Rate) {
        AmountTbl.setText(String.format("%.2f", Qty * Rate));
    }

    private void QtyTblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_QtyTblKeyReleased
        try {
            Calculation(Double.parseDouble(QtyTbl.getText()), Double.parseDouble(PurchaseRateTbl.getText()));
        } catch (NumberFormatException e) {
            // JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_QtyTblKeyReleased

    private void GrossProfitTblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GrossProfitTblKeyReleased

    }//GEN-LAST:event_GrossProfitTblKeyReleased

    private void PurchaseRateTblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PurchaseRateTblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PurchaseRateTblActionPerformed

    private void PurchaseRateTblKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PurchaseRateTblKeyTyped

    }//GEN-LAST:event_PurchaseRateTblKeyTyped

    private void PurchaseRateTblFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PurchaseRateTblFocusGained

    }//GEN-LAST:event_PurchaseRateTblFocusGained

    private void PurchaseRateTblFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PurchaseRateTblFocusLost

    }//GEN-LAST:event_PurchaseRateTblFocusLost

    private void AmountTblFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AmountTblFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_AmountTblFocusGained

    private void PurchaseRateTblMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PurchaseRateTblMousePressed

    }//GEN-LAST:event_PurchaseRateTblMousePressed
    private void updateSerialNumbers() {
        DefaultTableModel tableModel = (DefaultTableModel) purchaseTable.getModel();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            tableModel.setValueAt(String.valueOf(i + 1), i, 0); // Update serial number in the first column
        }
    }
    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        try {
            DefaultTableModel tableModel = (DefaultTableModel) purchaseTable.getModel();
            int selectedRow = purchaseTable.getSelectedRow();
            if (selectedRow != -1) {
                tableModel.removeRow(selectedRow);
                updateSerialNumbers();
                Finantial_Calculation();
            } else {
                JOptionPane.showMessageDialog(PurchaseEdit.this, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(PurchaseEdit.this, "Invalid data format.", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_DeleteBtnActionPerformed
    void Supplier_Memo_Cheek() {
        int memomultiplecheek = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connection = (java.sql.Connection) java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            java.sql.Statement statement = (java.sql.Statement) connection.createStatement();
            ResultSet result = statement.executeQuery("Select * From purchase_statement WHERE InvoiceNO = '" + SupplierMemoNoTbl.getText() + "'");
            while (result.next()) {
                memomultiplecheek = 1;
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Memo Multiple");
        }

        if (memomultiplecheek == 1) {
            JOptionPane.showMessageDialog(this, "Supllier No can't be same!");
            SupplierMemoNoTbl.setText(null);
        }
    }
    private void SupplierMemoNoTblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SupplierMemoNoTblKeyReleased

    }//GEN-LAST:event_SupplierMemoNoTblKeyReleased

    private void TraditionalDiscountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TraditionalDiscountMouseClicked
        TraditionalDiscount.setText(null);
    }//GEN-LAST:event_TraditionalDiscountMouseClicked

    private void TraditionalCostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TraditionalCostMouseClicked
        TraditionalCost.setText(null);
    }//GEN-LAST:event_TraditionalCostMouseClicked

    private void TraditionalDiscountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TraditionalDiscountKeyReleased
        Finantial_Calculation();
    }//GEN-LAST:event_TraditionalDiscountKeyReleased

    private void TraditionalCostKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TraditionalCostKeyReleased
        Finantial_Calculation();
    }//GEN-LAST:event_TraditionalCostKeyReleased

    private void QtyTblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_QtyTblKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            PurchaseRateTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            BarcodeTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F9)
            QtyTbl.requestFocus();
    }//GEN-LAST:event_QtyTblKeyPressed

    private void SalePriceTblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SalePriceTblKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            OldPriceTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            BarcodeTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F9)
            QtyTbl.requestFocus();
    }//GEN-LAST:event_SalePriceTblKeyPressed

    private void PurchaseRateTblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PurchaseRateTblKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            SalePriceTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            BarcodeTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F9)
            QtyTbl.requestFocus();
    }//GEN-LAST:event_PurchaseRateTblKeyPressed

    private void OldPriceTblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_OldPriceTblKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            MRPTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            BarcodeTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F9)
            QtyTbl.requestFocus();
    }//GEN-LAST:event_OldPriceTblKeyPressed

    private void MRPTblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MRPTblKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            AddBtn.doClick();
            BarcodeTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            BarcodeTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F9)
            QtyTbl.requestFocus();
    }//GEN-LAST:event_MRPTblKeyPressed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        DefaultTableModel model = (DefaultTableModel) purchaseTable.getModel();
        if (SupplierMemoNoTbl.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Input Supplier Memo No!");
        } else {
            if (SupplierNameJComboBox.getSelectedItem().toString().equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select Supplier!");
            } else {
                int choice = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    for (int x = 0; x < model.getRowCount(); x++) {
                        try {
                            Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
                            PreparedStatement ps = (PreparedStatement) connection.prepareStatement("INSERT INTO purchase_hold (InvoiceNo,SupplierName,Barcode,ItemName,GroupName,Qty,Rate,PC_Terminal,SalePrice,Status,User) VALUES (?,?,?,?,?,?,?,?,?,?,?)");

                            ps.setString(1, SupplierMemoNoTbl.getText());
                            ps.setString(2, SupplierNameJComboBox.getSelectedItem().toString());
                            ps.setString(3, model.getValueAt(x, 1).toString());
                            ps.setString(4, model.getValueAt(x, 2).toString());
                            ps.setString(5, model.getValueAt(x, 3).toString());
                            ps.setString(6, model.getValueAt(x, 5).toString());
                            ps.setString(7, model.getValueAt(x, 4).toString());
                            ps.setString(8, Login.Pc_Terminal);
                            ps.setString(9, model.getValueAt(x, 6).toString());
                            ps.setString(10, Status);
                            ps.setString(11, Login.UserBy);
                            ps.executeUpdate();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(this, e.getMessage()
                            );
                        }
                    }

                    while (model.getRowCount() > 0) {
                        model.removeRow(0);
                    }
                    All_TextBox_Clear();

                }
            }

        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void AddBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddBtnKeyPressed

        BarcodeTbl.requestFocus();


    }//GEN-LAST:event_AddBtnKeyPressed

    private void BarcodeTblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BarcodeTblKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int temp = 0;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Statement statement;
                try (Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "")) {
                    statement = (Statement) connection.createStatement();
                    ResultSet result = statement.executeQuery("SELECT * FROM `stock_enrty` WHERE Barcode ='" + BarcodeTbl.getText() + "'");
                    while (result.next()) {
                        temp = 1;
                        GroupNameComboBox.setSelectedItem(result.getString(8));
                        ProductNameJComboBox.setSelectedItem(result.getString(7));
                        SalePriceTbl.setText(result.getString(13));
                        PurchaseRateTbl.setText(result.getString(10));
                        QtyTbl.requestFocus();

                        ////////////////////////////////////////////////
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection connection1 = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
                            Statement statement1 = (Statement) connection1.createStatement();
                            ResultSet result1 = statement1.executeQuery("Select * from purchase WHERE Barcode ='" + BarcodeTbl.getText() + "'");
                            while (result1.next()) {
                                PurchaseRateTbl.setText(result1.getString(8));
                                SalePriceTbl.setText(result1.getString(10));
                                lastqty.setText(result1.getString(7));
                            }
                        } catch (ClassNotFoundException | SQLException e34) {
                            JOptionPane.showMessageDialog(this, e34);
                        }
                        Gross_Profit();
                    }
                    result.next();
                }
                statement.close();
                if (temp == 0) {
                    int choice = JOptionPane.showConfirmDialog(this, "Product Not Found, Are You Want Setup A New Product. ", "Confirmation", JOptionPane.YES_NO_OPTION);
                    if (choice == JOptionPane.YES_OPTION) {
                        java.awt.EventQueue.invokeLater(() -> {
                            new NewproductEntry().setVisible(true);
                        });
                    } else {
                        Clear();
                    }
                }
            } catch (HeadlessException | ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            QtyTbl.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            jTextField1.requestFocus();
        }
    }//GEN-LAST:event_BarcodeTblKeyPressed
    void All_TextBox_Clear() {
        Supplier_Insert_All();
        SupplierMemoNoTbl.setText(null);

        TraditionalDiscount.setText("0");
        TraditionalCost.setText("0");

        AmountTbl.setText(null);
        QtyTbl.setText(null);
        BarcodeTbl.setText(null);
        GroupNameComboBox.setSelectedItem("Select");
        ProductNameJComboBox.setSelectedItem("Select");
        PurchaseRateTbl.setText(null);
        SalePriceTbl.setText(null);
        GrossProfitTbl.setText("N/A");

        TotalAmountTbl.setText("0.0");

        TotalQtyJLable.setText("0.00");
        GrossProfitJLable.setText("0.00");
        lastqty.setText("0.00");
    }
    private void BarcodeTblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarcodeTblActionPerformed

    }//GEN-LAST:event_BarcodeTblActionPerformed

    private void purchaseTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_purchaseTableKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            DeleteBtn.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F9) {
            DefaultTableModel model = (DefaultTableModel) purchaseTable.getModel();
            int selectedRow = purchaseTable.getSelectedRow();
            if (selectedRow != -1) {
                Product_Insert_Into_Table(model.getValueAt(selectedRow, 1).toString(), model.getValueAt(selectedRow, 2).toString(), model.getValueAt(selectedRow, 3).toString(), Double.parseDouble(model.getValueAt(selectedRow, 4).toString()), Double.parseDouble(JOptionPane.showInputDialog(null, "Enter Qty:")), Double.parseDouble(model.getValueAt(selectedRow, 6).toString()));
                Finantial_Calculation();
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row");
            }
        }

    }//GEN-LAST:event_purchaseTableKeyPressed

    private void TraditionalCostFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TraditionalCostFocusGained

    }//GEN-LAST:event_TraditionalCostFocusGained

    private void TraditionalCostFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TraditionalCostFocusLost

    }//GEN-LAST:event_TraditionalCostFocusLost

    private void TotalQtyJLableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TotalQtyJLableKeyPressed

    }//GEN-LAST:event_TotalQtyJLableKeyPressed

    private void GrossProfitJLableVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_GrossProfitJLableVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_GrossProfitJLableVetoableChange

    private void TotalAmountTblTextValueChanged(java.awt.event.TextEvent evt) {//GEN-FIRST:event_TotalAmountTblTextValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalAmountTblTextValueChanged

    private void ProductNameJComboBoxAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_ProductNameJComboBoxAncestorAdded
        ProductNameJComboBox.removeAllItems();
        ProductNameJComboBox.addItem("Select");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Statement statement;
            ResultSet result;
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "")) {
                statement = connection.createStatement();
                result = statement.executeQuery("SELECT Itemname FROM `stock_enrty`");
                while (result.next()) {
                    ProductNameJComboBox.addItem(result.getString(1));
                }
            }
            statement.close();
            result.close();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_ProductNameJComboBoxAncestorAdded

    private void SupplierMemoNoTblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupplierMemoNoTblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SupplierMemoNoTblActionPerformed

    private void jDateChooser1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jDateChooser1AncestorAdded
        jDateChooser1.setDate(new java.util.Date());
    }//GEN-LAST:event_jDateChooser1AncestorAdded

    private void FreeTblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FreeTblKeyPressed

    }//GEN-LAST:event_FreeTblKeyPressed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            BarcodeTbl.requestFocus();
        }
        // Get the text entered in jTextField1
        String inputText = jTextField1.getText().trim();

        // Check if inputText is valid
        if (!inputText.equals("Select") && !inputText.isEmpty()) {
            try {
                // Load MySQL driver
                Class.forName("com.mysql.jdbc.Driver");

                // Establish connection to the database
                Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery("SELECT * FROM `stock_enrty` WHERE ItemName Like '%" + inputText + "%' OR Barcode Like '%" + inputText + "%'");

                // Use a DefaultTableModel to populate jTable1
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);  // Clear previous rows

                // Loop through the result set and populate the table
                while (result.next()) {
                    //String groupName = result.getString(8);
                    String barcode = result.getString(3);
                    String salePrice = result.getString(7);
                    String purchaseRate = result.getString(10);
                    String qty = result.getString(13);

                    // Add each row to the table model
                    model.addRow(new Object[]{barcode, salePrice, purchaseRate, qty});
                }

                // Close the connection
                result.close();
                statement.close();
                connection.close();

            } catch (ClassNotFoundException | SQLException e) {
                // Display error message in case of exception
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else {
            // Handle the case where the input is not valid
            //JOptionPane.showMessageDialog(this, "Please enter a valid item name.");
        }
        jTable1.setVisible(true); // This shows the table again

    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTextField1AncestorAdded


    }//GEN-LAST:event_jTextField1AncestorAdded

    private void jTable1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable1AncestorAdded
        //jTable1.setVisible(false); // This hides the table

    }//GEN-LAST:event_jTable1AncestorAdded

    private void AddBtnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddBtnKeyReleased
        BarcodeTbl.requestFocus();
    }//GEN-LAST:event_AddBtnKeyReleased

    private void jPanel1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel1AncestorAdded
    

    }//GEN-LAST:event_jPanel1AncestorAdded

    private void jPanel2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel2AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2AncestorAdded

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new PurchaseEdit().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JTextField AmountTbl;
    private javax.swing.JTextField BarcodeTbl;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JTextField FreeTbl;
    private javax.swing.JLabel GrossProfitJLable;
    private javax.swing.JTextField GrossProfitTbl;
    private javax.swing.JComboBox<String> GroupNameComboBox;
    private javax.swing.JLabel MRP;
    private javax.swing.JTextField MRPTbl;
    private javax.swing.JTextField OldPriceTbl;
    private javax.swing.JComboBox<String> ProductNameJComboBox;
    private javax.swing.JTextField PurchaseRateTbl;
    private javax.swing.JTextField QtyTbl;
    private javax.swing.JLabel ReturnQtyjLabel;
    private javax.swing.JTextField SalePriceTbl;
    private javax.swing.JTextField SupplierMemoNoTbl;
    private javax.swing.JComboBox<String> SupplierNameJComboBox;
    private java.awt.TextField TotalAmountTbl;
    private javax.swing.JLabel TotalQtyJLable;
    private javax.swing.JTextField TraditionalCost;
    private javax.swing.JTextField TraditionalDiscount;
    private javax.swing.JTextField VatTbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JCheckBox jCheckBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lastqty;
    private javax.swing.JTable purchaseTable;
    private javax.swing.JButton savebtn;
    // End of variables declaration//GEN-END:variables
}
