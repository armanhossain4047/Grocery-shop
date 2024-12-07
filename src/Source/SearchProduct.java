package Source;

import com.mysql.cj.xdevapi.Table;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.model.Model;

public class SearchProduct extends javax.swing.JFrame {

    public SearchProduct() {
        initComponents();
        intilize();
    }

    private void intilize() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                DSale window = new DSale();
                window.setVisible(true);
            }
        });

        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        AutoAddComboBox = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        BarcodeTbl = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Search_Table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setExtendedState(6);
        setState(6);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 204, 255));

        jPanel2.setBackground(new java.awt.Color(249, 249, 249));

        AutoAddComboBox.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AutoAddComboBox.setForeground(new java.awt.Color(0, 153, 102));
        AutoAddComboBox.setSelected(true);
        AutoAddComboBox.setText("Show Zero Balance (Ctrl A)");
        AutoAddComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutoAddComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Press F1  to Sale");
        jLabel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jLabel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jLabel1KeyReleased(evt);
            }
        });

        BarcodeTbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BarcodeTbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BarcodeTbl)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(AutoAddComboBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 957, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BarcodeTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AutoAddComboBox)
                    .addComponent(jLabel1))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        Search_Table.setAutoCreateRowSorter(true);
        Search_Table.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Search_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S/N", "Code No", "Product Name & Description", "Rate", "Qty", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Search_Table.setAutoscrolls(false);
        Search_Table.setGridColor(new java.awt.Color(255, 204, 204));
        Search_Table.setRequestFocusEnabled(false);
        Search_Table.setRowHeight(25);
        Search_Table.setSelectionBackground(new java.awt.Color(153, 0, 0));
        Search_Table.setSelectionForeground(new java.awt.Color(204, 255, 255));
        Search_Table.setShowGrid(false);
        Search_Table.setShowHorizontalLines(true);
        Search_Table.setShowVerticalLines(true);
        Search_Table.setSurrendersFocusOnKeystroke(true);
        Search_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Search_TableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Search_TableMousePressed(evt);
            }
        });
        Search_Table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Search_TableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(Search_Table);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1282, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(703, 703, 703))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(123, 123, 123)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                    .addContainerGap()))
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

        setSize(new java.awt.Dimension(1308, 826));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

    }//GEN-LAST:event_formKeyPressed

    private void BarcodeTblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarcodeTblActionPerformed

    }//GEN-LAST:event_BarcodeTblActionPerformed

    private void BarcodeTblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BarcodeTblKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            jLabel1.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            Search_Table.requestFocus();
        }

    }//GEN-LAST:event_BarcodeTblKeyPressed

    private void BarcodeTblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BarcodeTblKeyReleased
        DefaultTableModel model = (DefaultTableModel) Search_Table.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        try {
            String ModifiedQuery = BarcodeTbl.getText().replace(" ", "%");
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connection = (java.sql.Connection) java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            java.sql.Statement statement = (java.sql.Statement) connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM purchase WHERE ItemName Like '%" + ModifiedQuery + "%' OR Barcode Like '%" + ModifiedQuery + "%'");
            while (result.next()) {
                if (AutoAddComboBox.isSelected()) {
                    String Demo[] = new String[6];
                    int serialNumber = model.getRowCount() + 1;
                    model.addRow(new Object[]{serialNumber, result.getString(4), result.getString(5), result.getString(10), result.getString(7), result.getString(10)});
                }
            }
            result.next();
            connection.close();
            statement.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_BarcodeTblKeyReleased

    private void AutoAddComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutoAddComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AutoAddComboBoxActionPerformed

    private void Search_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Search_TableMouseClicked
        try {
            int serial = 0;
            while (Login.SearchProduct[serial][0] != null) {
                serial++;
            }
            DefaultTableModel Model = (DefaultTableModel) Search_Table.getModel();
            int selectedRow = Search_Table.getSelectedRow();
            Login.SearchProduct[serial][0] = Model.getValueAt(selectedRow, 1).toString();
            Login.SearchProduct[serial][1] = Model.getValueAt(selectedRow, 2).toString();
            Login.SearchProduct[serial][2] = Model.getValueAt(selectedRow, 3).toString();
            Login.SearchProduct[serial][3] = "1.0";
            Login.SearchProduct[serial][4] = Model.getValueAt(selectedRow, 5).toString();
            this.dispose();
            DSale window = new DSale();
            window.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_Search_TableMouseClicked

    private void Search_TableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Search_TableMousePressed

    }//GEN-LAST:event_Search_TableMousePressed

    private void Search_TableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Search_TableKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                int serial = 0;
                while (Login.SearchProduct[serial][0] != null) {
                    serial++;
                }
                DefaultTableModel Model = (DefaultTableModel) Search_Table.getModel();
                int selectedRow = Search_Table.getSelectedRow();
                Login.SearchProduct[serial][0] = Model.getValueAt(selectedRow, 1).toString();
                Login.SearchProduct[serial][1] = Model.getValueAt(selectedRow, 2).toString();
                Login.SearchProduct[serial][2] = Model.getValueAt(selectedRow, 3).toString();
                Login.SearchProduct[serial][3] = "1.0";
                Login.SearchProduct[serial][4] = Model.getValueAt(selectedRow, 5).toString();
                this.dispose();
                DSale window = new DSale();
                window.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {

            BarcodeTbl.setText(null);
            BarcodeTbl.requestFocus();
        }
    }//GEN-LAST:event_Search_TableKeyPressed

    private void jLabel1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel1AncestorAdded

    }//GEN-LAST:event_jLabel1AncestorAdded

    private void jLabel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel1KeyPressed

    }//GEN-LAST:event_jLabel1KeyPressed

    private void jLabel1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel1KeyReleased
        DSale DSale = new DSale();
        DSale.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1KeyReleased
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox AutoAddComboBox;
    private javax.swing.JTextField BarcodeTbl;
    private javax.swing.JTable Search_Table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
