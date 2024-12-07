/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Source;

import com.mysql.jdbc.PreparedStatement;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Purchasereturn extends javax.swing.JFrame {

    public Purchasereturn() {
        initComponents();
        intilize();
    }

    private void intilize() {
        Supplier_Insert_All();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        suplliercmb = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        Barcodetbl = new javax.swing.JTextField();
        group = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        item = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rate = new javax.swing.JTextField();
        returnqty = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        returnreason = new javax.swing.JTextField();
        AddBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ReturnPurchaseTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        TotalPricetbl = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 243));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Purchase Return", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(0, 102, 102))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 102, 102))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Name Of Supplier");

        suplliercmb.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        suplliercmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        suplliercmb.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                suplliercmbAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        suplliercmb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suplliercmbMouseClicked(evt);
            }
        });
        suplliercmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suplliercmbActionPerformed(evt);
            }
        });
        suplliercmb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                suplliercmbKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Code No");

        Barcodetbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Barcodetbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        Barcodetbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BarcodetblMouseClicked(evt);
            }
        });
        Barcodetbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BarcodetblKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BarcodetblKeyReleased(evt);
            }
        });

        group.setEditable(false);
        group.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        group.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Group Name");

        item.setEditable(false);
        item.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        item.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Product Name & Description");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Rate");

        rate.setEditable(false);
        rate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        returnqty.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        returnqty.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        returnqty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                returnqtyKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Return Quantity");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Return Reason");

        returnreason.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        returnreason.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        returnreason.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                returnreasonKeyPressed(evt);
            }
        });

        AddBtn.setBackground(new java.awt.Color(0, 102, 102));
        AddBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AddBtn.setForeground(new java.awt.Color(204, 255, 255));
        AddBtn.setText("Add");
        AddBtn.setBorder(null);
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(suplliercmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Barcodetbl)
            .addComponent(group)
            .addComponent(item)
            .addComponent(rate)
            .addComponent(returnqty)
            .addComponent(returnreason)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(0, 75, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 143, Short.MAX_VALUE))
                    .addComponent(AddBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(suplliercmb, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Barcodetbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(group, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(0, 0, 0)
                .addComponent(item, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(rate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(0, 0, 0)
                .addComponent(returnqty, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(0, 0, 0)
                .addComponent(returnreason, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Product Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 102, 102))); // NOI18N

        ReturnPurchaseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S/N", "Code No", "Item Name", "Group Name", "Rate", "Oty", "Price", "Supplier Name", "Resoan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ReturnPurchaseTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ReturnPurchaseTableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ReturnPurchaseTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(ReturnPurchaseTable);

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 255, 255));
        jButton2.setText("Save");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        TotalPricetbl.setEditable(false);
        TotalPricetbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TotalPricetbl.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Total Amount");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TotalPricetbl, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TotalPricetbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void suplliercmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suplliercmbActionPerformed


    }//GEN-LAST:event_suplliercmbActionPerformed

    private void BarcodetblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BarcodetblKeyReleased

    }//GEN-LAST:event_BarcodetblKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int choice = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            DefaultTableModel model = (DefaultTableModel) ReturnPurchaseTable.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
                    java.sql.PreparedStatement ps = (java.sql.PreparedStatement) connection.prepareStatement("INSERT INTO return_purchase (Barcode,item,brand,rate,Qty,price,User,supllier,Reasone)Values(?,?,?,?,?,?,?,?,?)");
                    ps.setString(1, model.getValueAt(i, 1).toString());
                    ps.setString(2, model.getValueAt(i, 2).toString());
                    ps.setString(3, model.getValueAt(i, 3).toString());
                    ps.setString(4, model.getValueAt(i, 4).toString());
                    ps.setString(5, model.getValueAt(i, 5).toString());
                    ps.setString(6, String.format("%.2f", model.getValueAt(i, 6)));
                    ps.setString(7, Login.UserBy);
                    ps.setString(8, (String) model.getValueAt(i, 7).toString());
                    ps.setString(9, (String) model.getValueAt(i, 8).toString());
                    ps.executeUpdate();
                } catch (ClassNotFoundException | SQLException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }

            }
            if (model.getRowCount() > 0) {
                ///////////supplier statement start /////////
                double previous_blance = 0;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
                    Statement statement = (Statement) connection.createStatement();
                    ResultSet result = statement.executeQuery("SELECT * FROM `ladger` WHERE AccountType = 'Supplier' AND Name ='" + suplliercmb.getSelectedItem().toString() + "'");
                    while (result.next()) {
                        previous_blance = Double.parseDouble(result.getString(5));
                    }
                } catch (HeadlessException | ClassNotFoundException | SQLException e) {
                    JOptionPane.showMessageDialog(this, e);
                }

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    java.sql.Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
                    PreparedStatement ps = (PreparedStatement) connection.prepareStatement("INSERT INTO `supplier_statement` (Name,Description,Debit,Blance,User) Values (?,?,?,?,?)");

                    ps.setString(1, suplliercmb.getSelectedItem().toString());
                    ps.setString(2, "Purchase Return");
                    ps.setString(3, TotalPricetbl.getText());
                    ps.setString(4, Double.toString(previous_blance - Double.parseDouble(TotalPricetbl.getText())));
                    ps.setString(5, Login.UserBy);
                    ps.executeUpdate();
                } catch (HeadlessException | ClassNotFoundException | SQLException e) {
                    JOptionPane.showMessageDialog(this, "957" + e);
                }
                //////////supplier statement end /////////
                model.setRowCount(0);
                Supplier_Insert_All();
                Clear();
                TotalPricetbl.setText("0.00");
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed
    void Supplier_Insert_All() {
        try {
            suplliercmb.removeAllItems();
            suplliercmb.addItem("Select");
            Class.forName("com.mysql.jdbc.Driver");
            Statement statement;
            try (Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "")) {
                statement = (Statement) connection.createStatement();
                ResultSet result = statement.executeQuery("SELECT * FROM `accountinfo` WHERE AccountType = 'Supplier'");
                while (result.next()) {
                    suplliercmb.addItem(result.getString(3));
                }
                result.next();
            }
            statement.close();

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    private void suplliercmbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suplliercmbMouseClicked

    }//GEN-LAST:event_suplliercmbMouseClicked

    private void ReturnPurchaseTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ReturnPurchaseTableKeyReleased

    }//GEN-LAST:event_ReturnPurchaseTableKeyReleased

    private void BarcodetblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarcodetblMouseClicked

    }//GEN-LAST:event_BarcodetblMouseClicked
    void Purchase_Return_Insert(double AvableQty, double CurrentQty, double Rate) {
        DefaultTableModel model = (DefaultTableModel) ReturnPurchaseTable.getModel();
        if (AvableQty >= CurrentQty) {
            int x;
            for (x = 0; x < model.getRowCount(); x++) {
                if (model.getValueAt(x, 1).toString().equalsIgnoreCase(Barcodetbl.getText())) {
                    model.setValueAt((Double) CurrentQty, x, 5);
                    model.setValueAt((Double) (Rate * CurrentQty), x, 6);
                    break;
                }
            }
            if (x == model.getRowCount()) {
                model.insertRow(0, new Object[]{model.getRowCount() + 1, Barcodetbl.getText(), item.getText(), group.getText(), rate.getText(), (Double) CurrentQty, (Double) CurrentQty * Rate, suplliercmb.getSelectedItem().toString(), returnreason.getText()});
            }
            // Update the serial numbers to be in descending order
            for (int i = 0; i < model.getRowCount(); i++) {
                model.setValueAt(model.getRowCount() - i, i, 0); // Serial numbers should be 1, 2, 3, ...
            }
            Lock(suplliercmb.getSelectedItem().toString());
            Clear();

        } else {
            JOptionPane.showMessageDialog(this, "Return quantity can't be greater than stock quantity !!!!!");
        }
    } 
    void Lock(String Supplier) {
        suplliercmb.removeAllItems();
        suplliercmb.addItem(Supplier);
    }

    void Clear() {
        Barcodetbl.setText(null);
        item.setText(null);
        rate.setText(null);
        group.setText(null);
        returnreason.setText(null);
        returnqty.setText(null);
    }

    void Finantial_Calculation() {
        double Total_Rate = 0.0;
        DefaultTableModel model = (DefaultTableModel) ReturnPurchaseTable.getModel();
        for (int x = 0; x < model.getRowCount(); x++) {
            double Table_Rate = Double.parseDouble(model.getValueAt(x, 6).toString());
            Total_Rate += Table_Rate;
        }
        TotalPricetbl.setText(String.format("%.2f", Total_Rate));
    }
    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        DefaultTableModel model = (DefaultTableModel) ReturnPurchaseTable.getModel();
        if (suplliercmb.getSelectedItem().toString().equalsIgnoreCase("Select") || Barcodetbl.getText().isEmpty() || group.getText().isEmpty() || item.getText().isEmpty() || rate.getText().isEmpty() || returnqty.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields", "Quick ledger", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
                Statement statement = (Statement) connection.createStatement();
                ResultSet result = statement.executeQuery("SELECT * FROM `purchase` where Barcode = '" + Barcodetbl.getText() + "'");
                while (result.next()) {
                    Purchase_Return_Insert(Double.parseDouble(result.getString(7)), Double.parseDouble(returnqty.getText()), Double.parseDouble(result.getString(8)));
                    Finantial_Calculation();
                }
            } catch (ClassNotFoundException | NumberFormatException | SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_AddBtnActionPerformed

    private void suplliercmbKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_suplliercmbKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            Barcodetbl.requestFocus();
    }//GEN-LAST:event_suplliercmbKeyPressed

    private void returnqtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_returnqtyKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            returnreason.requestFocus();
    }//GEN-LAST:event_returnqtyKeyPressed

    private void returnreasonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_returnreasonKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            AddBtn.doClick();
    }//GEN-LAST:event_returnreasonKeyPressed

    private void suplliercmbAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_suplliercmbAncestorAdded
        Supplier_Insert_All();
    }//GEN-LAST:event_suplliercmbAncestorAdded

    private void BarcodetblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BarcodetblKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int product_found = 0;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
                Statement statement = (Statement) connection.createStatement();
                ResultSet result = statement.executeQuery("SELECT * FROM `purchase` where Barcode = '" + Barcodetbl.getText() + "'");
                while (result.next()) {
                    product_found = 1;
                    group.setText(result.getString(6));
                    item.setText(result.getString(5));
                    rate.setText(result.getString(8));
                    returnqty.setText(result.getString(7));
                    returnreason.requestFocus();
                }
                if (product_found == 0) {
                    JOptionPane.showMessageDialog(this, "Wrong Barcode!");
                }
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_BarcodetblKeyPressed
    private void updateSerialNumbers() {
        DefaultTableModel model = (DefaultTableModel) ReturnPurchaseTable.getModel();
        // Update the serial numbers to be in descending order
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(model.getRowCount() - i, i, 0); // Serial numbers should be 1, 2, 3, ...
        }
    }
    private void ReturnPurchaseTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ReturnPurchaseTableKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            DefaultTableModel DeleteModel = (DefaultTableModel) ReturnPurchaseTable.getModel();
            int selectedRow = ReturnPurchaseTable.getSelectedRow();
            if (selectedRow != -1) {
                DeleteModel.removeRow(selectedRow);
                updateSerialNumbers();
                Finantial_Calculation();
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row to delete.");
            }
        }
    }//GEN-LAST:event_ReturnPurchaseTableKeyPressed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Purchasereturn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JTextField Barcodetbl;
    private javax.swing.JTable ReturnPurchaseTable;
    private javax.swing.JTextField TotalPricetbl;
    private javax.swing.JTextField group;
    private javax.swing.JTextField item;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField rate;
    private javax.swing.JTextField returnqty;
    private javax.swing.JTextField returnreason;
    private javax.swing.JComboBox<String> suplliercmb;
    // End of variables declaration//GEN-END:variables
}
