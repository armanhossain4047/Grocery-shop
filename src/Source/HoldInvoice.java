/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Source;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
public class HoldInvoice extends javax.swing.JFrame {

    public HoldInvoice() {
        initComponents();
        intilize();
    }

    private void intilize() {
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                DSale window = new DSale();
                window.setVisible(true);
            }
        });

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Statement statement;
            try (Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "")) {
                statement = (Statement) connection.createStatement();
                ResultSet result = statement.executeQuery("SELECT Date,CustomerName,SUM( price),User FROM `invtemp` WHERE PC_Terminal = '" + Login.Pc_Terminal + "' group by CustomerName;");
                ResultSetMetaData rsmd = (ResultSetMetaData) result.getMetaData();
                while (result.next()) {
                    model.addRow(new Object[]{result.getString(1), result.getString(2), result.getString(3), result.getString(4)});

                }
                result.next();
            }
            statement.close();

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setExtendedState(6);
        setResizable(false);
        setState(6);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Table.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Customer Name", "Amount", "Name"
            }
        ));
        Table.setRowHeight(25);
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        Table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Search");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1205, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        setSize(new java.awt.Dimension(1233, 696));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        int SelectedRow = Table.getSelectedRow();
        int x = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Statement statement;
            try (Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "")) {
                statement = (Statement) connection.createStatement();
                ResultSet result = statement.executeQuery("SELECT Barcode, Item, Sale_Rate, Qty, price FROM `invtemp` WHERE  CustomerName = '" + model.getValueAt(SelectedRow, 1) + "'");
                ResultSetMetaData rsmd = (ResultSetMetaData) result.getMetaData();
                while (result.next()) {
                    Login.SearchProduct[x][0] = result.getString(1);
                    Login.SearchProduct[x][1] = result.getString(2);
                    Login.SearchProduct[x][2] = result.getString(3);
                    Login.SearchProduct[x][3] = result.getString(4);
                    Login.SearchProduct[x++][4] = result.getString(5);
                }
                result.next();
            }
            statement.close();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        try {
            Connection connection1 = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            try (Statement statement = connection1.createStatement()) {
                statement.executeUpdate("DELETE FROM  invtemp WHERE CustomerName = '" + model.getValueAt(SelectedRow, 1) + "'");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        this.dispose();
        DSale window = new DSale();
        window.setVisible(true);
    }//GEN-LAST:event_TableMouseClicked

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            Table.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            Table.requestFocus();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void TableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TableKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            jTextField1.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            DefaultTableModel model = (DefaultTableModel) Table.getModel();
            int SelectedRow = Table.getSelectedRow();
            int x = 0;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Statement statement;
                try (Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "")) {
                    statement = (Statement) connection.createStatement();
                    ResultSet result = statement.executeQuery("SELECT Barcode, Item, Sale_Rate, Qty, price FROM `invtemp` WHERE  CustomerName = '" + model.getValueAt(SelectedRow, 1) + "'");
                    ResultSetMetaData rsmd = (ResultSetMetaData) result.getMetaData();
                    while (result.next()) {
                        Login.SearchProduct[x][0] = result.getString(1);
                        Login.SearchProduct[x][1] = result.getString(2);
                        Login.SearchProduct[x][2] = result.getString(3);
                        Login.SearchProduct[x][3] = result.getString(4);
                        Login.SearchProduct[x++][4] = result.getString(5);
                    }
                    result.next();
                }
                statement.close();
            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            try {
                Connection connection1 = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
                try (Statement statement = connection1.createStatement()) {
                    statement.executeUpdate("DELETE FROM  invtemp WHERE CustomerName = '" + model.getValueAt(SelectedRow, 1) + "'");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            this.dispose();
            DSale window = new DSale();
            window.setVisible(true);
        }
    }//GEN-LAST:event_TableKeyPressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoldInvoice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
