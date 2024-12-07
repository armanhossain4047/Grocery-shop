/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Source;

import com.mysql.jdbc.PreparedStatement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Rajmahal eXPRESS
 */
public class SupplierDue extends javax.swing.JFrame {

    /**
     * Creates new form SupplierDue
     */
    public SupplierDue() {
        initComponents();
        intilize();
    }
    private JTable jTable1;

    private void intilize() {

        jTable1 = new JTable(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Date", "InvoiceNo", "SupplierName", "Barcode", "ItemName", "GroupName", "Qty", "Rate", "Vat", "SalePrice", "Status", "User"}
        ));
        JScrollPane scrollPane = new JScrollPane(jTable1);
        this.add(scrollPane); // Add table to the frame/panel

        ////////////////Supplier Code Start /////////////////
        try {
            suppliercmb.addItem("Select");
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement = (Statement) connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `accountinfo` WHERE AccountType = 'Supplier'");
            while (result.next()) {
                suppliercmb.addItem(result.getString(3));
            }
            result.next();
            connection.close();

            statement.close();

        } catch (Exception ex) {
        }

        ////////////////Supplier Code End   /////////////////
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        suppliercmb = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        DueAmount = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableSp = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Supplier Payment Detail", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 102, 102))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Name Of Supplier");

        suppliercmb.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        suppliercmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppliercmbActionPerformed(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(230, 255, 255));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        DueAmount.setBackground(new java.awt.Color(255, 229, 255));
        DueAmount.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        DueAmount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("All Supplier Print");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Due Amount");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Chq. Amount");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("From Date");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("To Date");

        jButton2.setBackground(new java.awt.Color(0, 153, 153));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Show");
        jButton2.setBorder(null);

        jButton3.setBackground(new java.awt.Color(0, 204, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Print");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("0.00");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("0.00");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("0.00");

        TableSp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TableSp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Entry Date", "Invoice No", "Description", "Debit", "Credit", "Balance"
            }
        ));
        TableSp.setRowHeight(25);
        TableSp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableSpMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableSp);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(492, 492, 492)
                        .addComponent(jLabel2)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(suppliercmb, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(DueAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 952, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(522, 522, 522)
                        .addComponent(jLabel6)
                        .addGap(132, 132, 132)
                        .addComponent(jLabel7)
                        .addGap(122, 122, 122)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel4)
                        .addGap(10, 10, 10)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5)
                        .addGap(8, 8, 8)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suppliercmb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DueAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 35, Short.MAX_VALUE))
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

        setSize(new java.awt.Dimension(1004, 564));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void suppliercmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppliercmbActionPerformed
        DefaultTableModel model = (DefaultTableModel) TableSp.getModel();
        model.setRowCount(0);

////////////////Opening Supplier Code Start /////////////////
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement = (Statement) connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `accountinfo` WHERE AccountType = 'Supplier' and LadgerName = '" + suppliercmb.getSelectedItem().toString() + "'");
            while (result.next()) {
                model.addRow(new Object[]{result.getString(1), "None", "Opening Blance", "0", result.getString(6), result.getString(6)});
            }
            result.next();
            connection.close();
            statement.close();
        } catch (Exception ex) {
        }
        ////////////////Opening Supplier Code End   /////////////////////
        //////////////// Supplier Statement  Code Start /////////////////
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement = (Statement) connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `supplier_statement` WHERE Name = '" + suppliercmb.getSelectedItem().toString() + "'");
            while (result.next()) {
                model.addRow(new Object[]{result.getString(1), result.getString(2), result.getString(4), result.getString(5), result.getString(6), result.getString(7)});
            }
            result.next();
            connection.close();

            statement.close();

        } catch (Exception ex) {
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement = (Statement) connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `ladger` WHERE AccountType = 'Supplier' and Name = '" + suppliercmb.getSelectedItem().toString() + "'");
            while (result.next()) {
                DueAmount.setText(result.getString(5));
            }
            result.next();
            connection.close();

            statement.close();

        } catch (Exception ex) {
        }

        //////////////// Supplier Statement Code End   /////////////////
    }//GEN-LAST:event_suppliercmbActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // Load JDBC driver (assuming this is only needed once per application session)
            Class.forName("com.mysql.jdbc.Driver");

            // Establish database connection
            java.sql.Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");

            // Load JasperDesign from JRXML file
            File jrxmlFile = new File("src\\Report\\AllSupplierPrint.jrxml");  // Adjust path as necessary
            JasperDesign jd = JRXmlLoader.load(jrxmlFile.getAbsolutePath());

            // Set parameters if needed
            HashMap<String, Object> para = new HashMap<>();
            // para.put("invoiceno", InvoiceNo); // Uncomment and set parameters if needed

            // Compile JasperReport
            JasperReport jr = JasperCompileManager.compileReport(jd);

            // Fill the report
            JasperPrint jp = JasperFillManager.fillReport(jr, para, connection);

            // Display report in a JFrame
            JRViewer viewer = new JRViewer(jp);
            JFrame frame = new JFrame("Invoice");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.add(viewer);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Full screen
            frame.setVisible(true);

        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Error generating report: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            // Log the exception
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            // Log the exception
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        java.sql.Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");

            File jrxmlFile = new File("src/Report/SupplierStatement.jrxml");
            if (!jrxmlFile.exists()) {
                JOptionPane.showMessageDialog(null, "Report file not found!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JasperDesign jd = JRXmlLoader.load(jrxmlFile.getAbsolutePath());
            HashMap<String, Object> para = new HashMap<>();
            // para.put("ParameterName", value); // Add parameters if needed

            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, para, connection);

            JRViewer viewer = new JRViewer(jp);
            JFrame frame = new JFrame("Invoice");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.add(viewer);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);

        } catch (JRException | ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }//GEN-LAST:event_jButton3ActionPerformed


    private void TableSpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableSpMouseClicked
        /*
        String selectedDate = TableSp.getValueAt(TableSp.getSelectedRow(), 0).toString();
        String selectedInvoiceNo = TableSp.getValueAt(TableSp.getSelectedRow(), 1).toString();

        String selectedSupplierName = suppliercmb.getSelectedItem().toString();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", ""); PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(
                "SELECT `Date`, `InvoiceNo`, `SupplierName`, `Barcode`, `ItemName`, `GroupName`, `Qty`, `Rate`, `Vat`, `SalePrice`, `Status`, `User` "
                + "FROM `purchase_statement` WHERE `Date` = ? AND `InvoiceNo` = ? AND `SupplierName` = ?")) {

            preparedStatement.setString(1, selectedDate);
            preparedStatement.setString(3, selectedSupplierName);
            preparedStatement.setString(2, selectedInvoiceNo);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                PurchaseShow purchaseShow = new PurchaseShow();
                purchaseShow.setVisible(true);

                DefaultTableModel tableModel = (DefaultTableModel) purchaseShow.getTable1().getModel();
                tableModel.setRowCount(0); // Clear existing rows

                while (resultSet.next()) {
                    Object[] rowData = {
                        resultSet.getString("Date"),
                        resultSet.getString("InvoiceNo"),
                        resultSet.getString("SupplierName"),
                        resultSet.getString("Barcode"),
                        resultSet.getString("ItemName"),
                        resultSet.getString("GroupName"),
                        resultSet.getInt("Qty"),
                        resultSet.getDouble("Rate"),
                        resultSet.getDouble("Vat"),
                        resultSet.getDouble("SalePrice"),
                        resultSet.getString("Status"),
                        resultSet.getString("User")
                    };
                    tableModel.addRow(rowData);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
         */

        // Get selected values from the table and combo box
        String selectedDate = TableSp.getValueAt(TableSp.getSelectedRow(), 0).toString();
        String selectedInvoiceNo = TableSp.getValueAt(TableSp.getSelectedRow(), 1).toString();
        String selectedSupplierName = suppliercmb.getSelectedItem().toString();

        // Query for `purchase_statement`
        String purchaseStatementQuery = "SELECT `Date`, `InvoiceNo`, `SupplierName`, `Barcode`, `ItemName`, `GroupName`, `Qty`, `Rate`, `Vat`, `SalePrice`, `Status`, `User` "
                + "FROM `purchase_statement` WHERE `Date` = ? AND `InvoiceNo` = ? AND `SupplierName` = ?";

        // Query for `return_purchase`
        String returnPurchaseQuery = "SELECT `cdate`, `Memo`, `Barcode`, `item`, `brand`, `rate`, `Qty`, `price`, `User`, `supllier`, `Reasone` "
                + "FROM `return_purchase` WHERE 1";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", ""); PreparedStatement purchaseStatement = (PreparedStatement) connection.prepareStatement(purchaseStatementQuery); PreparedStatement returnStatement = (PreparedStatement) connection.prepareStatement(returnPurchaseQuery)) {

            // Set parameters for the `purchase_statement` query
            purchaseStatement.setString(1, selectedDate);
            purchaseStatement.setString(2, selectedInvoiceNo);
            purchaseStatement.setString(3, selectedSupplierName);

            // Open PurchaseShow frame
            PurchaseShow purchaseShow = new PurchaseShow();
            purchaseShow.setVisible(true);

            // Get the table model for `jTable1`
            DefaultTableModel tableModel = (DefaultTableModel) purchaseShow.getTable1().getModel();
            tableModel.setRowCount(0); // Clear existing rows

            // Execute the `purchase_statement` query and add results to the table
            try (ResultSet purchaseResultSet = purchaseStatement.executeQuery()) {
                while (purchaseResultSet.next()) {
                    Object[] rowData = {
                        purchaseResultSet.getString("Date"),
                        purchaseResultSet.getString("InvoiceNo"),
                        purchaseResultSet.getString("SupplierName"),
                        purchaseResultSet.getString("Barcode"),
                        purchaseResultSet.getString("ItemName"),
                        purchaseResultSet.getString("GroupName"),
                        purchaseResultSet.getInt("Qty"),
                        purchaseResultSet.getDouble("Rate"),
                        purchaseResultSet.getDouble("Vat"),
                        purchaseResultSet.getDouble("SalePrice"),
                        purchaseResultSet.getString("Status"),
                        purchaseResultSet.getString("User")
                    };
                    tableModel.addRow(rowData);
                }
            }
            PurchaseReturnShow PurchaseReturnShow = new PurchaseReturnShow();
            PurchaseReturnShow.setVisible(true);
            // Execute the `return_purchase` query and add results to the table
            try (ResultSet returnResultSet = returnStatement.executeQuery()) {
                while (returnResultSet.next()) {
                    Object[] rowData = {
                        returnResultSet.getString("cdate"),
                        returnResultSet.getString("Memo"),
                        returnResultSet.getString("Barcode"),
                        returnResultSet.getString("item"),
                        returnResultSet.getString("brand"),
                        returnResultSet.getDouble("rate"),
                        returnResultSet.getInt("Qty"),
                        returnResultSet.getDouble("price"),
                        returnResultSet.getString("User"),
                        returnResultSet.getString("supllier"),
                        returnResultSet.getString("Reasone")
                    };
                    tableModel.addRow(rowData);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_TableSpMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SupplierDue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SupplierDue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SupplierDue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SupplierDue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SupplierDue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DueAmount;
    private javax.swing.JTable TableSp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> suppliercmb;
    // End of variables declaration//GEN-END:variables
}
