/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Source;

import com.mysql.jdbc.ResultSetMetaData;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class ProfitAnalysis extends javax.swing.JFrame {

    /**
     * Creates new form ProfitAnalysis
     */
    public ProfitAnalysis() {
        initComponents();
        intilize();
    }

    private void intilize() {

        ////////////////Memo profit Table Code Start /////////////////
        try {
            String Query = "SELECT purchase_statement.Date, purchase_statement.InvoiceNo, SUM(purchase_statement.Qty) AS Total_Qty, SUM(return_purchase.Qty) AS Return_Qty, SUM(purchase_statement.Qty - return_purchase.Qty) AS Stock_Qty, SUM((purchase_statement.Qty - return_purchase.Qty) * purchase_statement.Rate) AS Total_Rate, SUM((purchase_statement.Qty - return_purchase.Qty) * purchase_statement.SalePrice) AS Total_SaleRate, SUM(((purchase_statement.Qty - return_purchase.Qty) * purchase_statement.SalePrice) - ((purchase_statement.Qty - return_purchase.Qty) * purchase_statement.Rate)) AS Total_Profit FROM purchase_statement INNER JOIN return_purchase ON purchase_statement.Barcode = return_purchase.Barcode GROUP BY purchase_statement.InvoiceNo";
            DefaultTableModel model = (DefaultTableModel) memoprofitTable.getModel();
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement = (Statement) connection.createStatement();
            ResultSet result = statement.executeQuery(Query);
            while (result.next()) {
                model.addRow(new Object[]{result.getString(1), result.getString(2), result.getString(7), result.getString(6), result.getString(8)});
            }
            result.next();
            connection.close();

            statement.close();

        } catch (Exception ex) {
        }

        ////////////////Memo profit Table Code End   /////////////////
        
        ////////////////Day profit Table Code Start /////////////////
        try {
            String Query = "SELECT purchase_statement.Date, purchase_statement.InvoiceNo, SUM(purchase_statement.Qty) AS Total_Qty, SUM(return_purchase.Qty) AS Return_Qty, SUM(purchase_statement.Qty - return_purchase.Qty) AS Stock_Qty, SUM((purchase_statement.Qty - return_purchase.Qty) * purchase_statement.Rate) AS Total_Rate, SUM((purchase_statement.Qty - return_purchase.Qty) * purchase_statement.SalePrice) AS Total_SaleRate, SUM(((purchase_statement.Qty - return_purchase.Qty) * purchase_statement.SalePrice) - ((purchase_statement.Qty - return_purchase.Qty) * purchase_statement.Rate)) AS Total_Profit FROM purchase_statement INNER JOIN return_purchase ON purchase_statement.Barcode = return_purchase.Barcode GROUP BY purchase_statement.Date";
            DefaultTableModel model = (DefaultTableModel) dayprofittable.getModel();
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement = (Statement) connection.createStatement();
            ResultSet result = statement.executeQuery(Query);
            while (result.next()) {
                model.addRow(new Object[]{result.getString(1), result.getString(7), result.getString(6), result.getString(8)});
            }
            result.next();
            connection.close();

            statement.close();

        } catch (Exception ex) {
        }

        ////////////////Day profit Table Code End   /////////////////
        
        ////////////////Monthly profit Table Code Start /////////////////
        try {
            String Query = "SELECT YEAR(purchase_statement.Date) AS Year, CASE WHEN MONTH(purchase_statement.Date) = 1 THEN 'January' WHEN MONTH(purchase_statement.Date) = 2 THEN 'February' WHEN MONTH(purchase_statement.Date) = 3 THEN 'March' WHEN MONTH(purchase_statement.Date) = 4 THEN 'April' WHEN MONTH(purchase_statement.Date) = 5 THEN 'May' WHEN MONTH(purchase_statement.Date) = 6 THEN 'June' WHEN MONTH(purchase_statement.Date) = 7 THEN 'July' WHEN MONTH(purchase_statement.Date) = 8 THEN 'August' WHEN MONTH(purchase_statement.Date) = 9 THEN 'September' WHEN MONTH(purchase_statement.Date) = 10 THEN 'October' WHEN MONTH(purchase_statement.Date) = 11 THEN 'November' WHEN MONTH(purchase_statement.Date) = 12 THEN 'December' END AS Month, SUM(purchase_statement.Qty) AS Total_Qty, SUM(COALESCE(return_purchase.Qty, 0)) AS Return_Qty, SUM(purchase_statement.Qty - COALESCE(return_purchase.Qty, 0)) AS Stock_Qty, SUM((purchase_statement.Qty - COALESCE(return_purchase.Qty, 0)) * purchase_statement.Rate) AS Total_Rate, SUM((purchase_statement.Qty - COALESCE(return_purchase.Qty, 0)) * purchase_statement.SalePrice) AS Total_SaleRate, SUM(((purchase_statement.Qty - COALESCE(return_purchase.Qty, 0)) * purchase_statement.SalePrice) - ((purchase_statement.Qty - COALESCE(return_purchase.Qty, 0)) * purchase_statement.Rate)) AS Total_Profit FROM purchase_statement LEFT JOIN return_purchase ON purchase_statement.Barcode = return_purchase.Barcode GROUP BY Year, Month;";
            DefaultTableModel model = (DefaultTableModel) monthprofittable.getModel();
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement = (Statement) connection.createStatement();
            ResultSet result = statement.executeQuery(Query);
            while (result.next()) {
                
                model.addRow(new Object[]{result.getString(1), result.getString(2), result.getString(7), result.getString(6),result.getString(8)});
            }
            result.next();
            connection.close();

            statement.close();

        } catch (Exception ex) {
        }

        ////////////////Monthly profit Table Code End   /////////////////
        
        
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.png")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        memoprofitTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        monthprofittable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        dayprofittable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Purchase Profit Analysis", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(0, 102, 102))); // NOI18N

        memoprofitTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Memo No", "Total Price", "Cost Price", "Gross Profit"
            }
        ));
        jScrollPane1.setViewportView(memoprofitTable);

        monthprofittable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Month", "Year", "Total Price", "Cost Price", "Gross Profit"
            }
        ));
        jScrollPane2.setViewportView(monthprofittable);

        dayprofittable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Total Price", "Cost Price", "Gross Profit"
            }
        ));
        jScrollPane3.setViewportView(dayprofittable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Profit Per Day");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Profit Per Month");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Profit Per Memo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ProfitAnalysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfitAnalysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfitAnalysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfitAnalysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfitAnalysis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dayprofittable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable memoprofitTable;
    private javax.swing.JTable monthprofittable;
    // End of variables declaration//GEN-END:variables
}
