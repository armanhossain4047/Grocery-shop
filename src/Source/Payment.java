package Source;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Rajmahal eXPRESS
 */
public class Payment extends javax.swing.JFrame {

    public Payment() {
        initComponents();
        intilize();
    }
    private void intilize() {

        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.png")));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ReosoneCmb = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        ReciveCmb = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        AmountTbl = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        creditcmb = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        DecscriptionTbl = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        OkBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        InWordTbl = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Payment");
        jLabel7.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Reason");

        ReosoneCmb.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ReosoneCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Bank Account", "Bank Interest", "Carrying Charge", "CC Loan", "Customer", "Commision", "Discount", "Depreciation", "Daily Expenditure", "Daily Bank", "Entertainment", "Establishment", "Monthly Bills", "Other Expense", "Others (Income)", "Plain Loan", "Purchasing Extra Expenditure", "Servicing Charge", "Supplier", "Salary", "Yearly Bills" }));
        ReosoneCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReosoneCmbActionPerformed(evt);
            }
        });
        ReosoneCmb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ReosoneCmbKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Receiver");

        ReciveCmb.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ReciveCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        ReciveCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReciveCmbActionPerformed(evt);
            }
        });
        ReciveCmb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ReciveCmbKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Amount");

        AmountTbl.setBackground(new java.awt.Color(204, 255, 204));
        AmountTbl.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        AmountTbl.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        AmountTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AmountTblMouseEntered(evt);
            }
        });
        AmountTbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmountTblActionPerformed(evt);
            }
        });
        AmountTbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AmountTblKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AmountTblKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Acc. Credit");

        creditcmb.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        creditcmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Cash", "Card" }));
        creditcmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditcmbActionPerformed(evt);
            }
        });
        creditcmb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                creditcmbKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Description");

        DecscriptionTbl.setBackground(new java.awt.Color(204, 204, 255));
        DecscriptionTbl.setColumns(20);
        DecscriptionTbl.setRows(5);
        DecscriptionTbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DecscriptionTblKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(DecscriptionTbl);

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setText("Close");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        OkBtn.setBackground(new java.awt.Color(0, 102, 102));
        OkBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        OkBtn.setForeground(new java.awt.Color(204, 255, 255));
        OkBtn.setText("Ok");
        OkBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        OkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkBtnActionPerformed(evt);
            }
        });

        InWordTbl.setColumns(20);
        InWordTbl.setRows(5);
        jScrollPane2.setViewportView(InWordTbl);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("In Word");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AmountTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(OkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(creditcmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ReciveCmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ReosoneCmb, 0, 1, Short.MAX_VALUE))
                .addGap(12, 12, 12))
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReosoneCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReciveCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AmountTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(creditcmb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(52, 52, 52))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)
                        .addContainerGap())))
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

        setSize(new java.awt.Dimension(384, 503));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ReosoneCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReosoneCmbActionPerformed
        ReciveCmb.removeAllItems();
        ReciveCmb.addItem("Select");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement = (Statement) connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `accountinfo` WHERE AccountType  = '" + ReosoneCmb.getSelectedItem().toString() + "'");
            while (result.next()) {
                ReciveCmb.addItem(result.getString(3));
            }
            result.next();
            connection.close();
            statement.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }


    }//GEN-LAST:event_ReosoneCmbActionPerformed

    private void ReciveCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReciveCmbActionPerformed
        try {
            String select, Blance;
            select = ReciveCmb.getSelectedItem().toString();
            
            String Query = "SELECT * FROM `ladger` WHERE AccountType = '"+ReosoneCmb.getSelectedItem().toString()+ "' AND Name = '"+ReciveCmb.getSelectedItem().toString()+"'";
          
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection1 = DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement1 = connection1.createStatement();
            ResultSet result1 = statement1.executeQuery(Query);
            result1.next();
            Blance = result1.getString("Blance");
            AmountTbl.setText(Blance);
            connection1.close();
            statement1.close();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_ReciveCmbActionPerformed

    private void OkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkBtnActionPerformed
        try {
            if (ReosoneCmb.getSelectedItem().toString().equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select Reasone");
            } else if (ReciveCmb.getSelectedItem().toString().equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select Reciver");
            } else if (AmountTbl.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Enter Amount");
            } else if (creditcmb.getSelectedItem().toString().equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select Acc. Credit");
            } else {
                String query = "INSERT INTO paymentstatement (Reasone, Receiver, Amount, Credit, Description, Status,User) Values(?,?,?,?,?,?,?)";
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
                    java.sql.PreparedStatement ps = (java.sql.PreparedStatement) connection.prepareStatement(query);
                    ps.setString(1, ReosoneCmb.getSelectedItem().toString());
                    ps.setString(2, ReciveCmb.getSelectedItem().toString());
                    ps.setString(3, AmountTbl.getText());
                    ps.setString(4, creditcmb.getSelectedItem().toString());
                    ps.setString(5, DecscriptionTbl.getText());
                    ps.setString(6, "Payment");
                    ps.setString(7, Login.UserBy);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Payment Successfull");
                    AmountTbl.setText(null);
                    ReciveCmb.setSelectedItem("Select");
                } catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(this, "Payment Problmes" + e);
                }
            }
        } catch (Exception e12) {
            JOptionPane.showMessageDialog(this, "Enter Properly");
        }

    }//GEN-LAST:event_OkBtnActionPerformed

    private void AmountTblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmountTblActionPerformed


    }//GEN-LAST:event_AmountTblActionPerformed

    private void AmountTblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AmountTblMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_AmountTblMouseEntered

    private void creditcmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditcmbActionPerformed

    }//GEN-LAST:event_creditcmbActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void AmountTblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AmountTblKeyReleased
        try {
            // Get the input string from InWordTbl
            String inputString = AmountTbl.getText();

            // Check if the input string is empty
            if (inputString.isEmpty()) {
                // Handle the case where the input string is empty
                //System.out.println("Input string is empty.");
            } else {
                // Parse the input string into an integer
                int number = Integer.parseInt(inputString);

                // Create an instance of ConvertNumberInWords and convert the number to words
                ConvertNumberInWords obj1 = new ConvertNumberInWords();
                String result = obj1.convertNumberToWords(number);

                // Set the result in InWordTbl
                InWordTbl.setText(result);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Enter Amount Properly");
        } catch (Exception e) {
        }

    }//GEN-LAST:event_AmountTblKeyReleased

    private void ReosoneCmbKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ReosoneCmbKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
    ReciveCmb.requestFocus();
    }//GEN-LAST:event_ReosoneCmbKeyPressed

    private void ReciveCmbKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ReciveCmbKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
    AmountTbl.requestFocus();
    }//GEN-LAST:event_ReciveCmbKeyPressed

    private void AmountTblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AmountTblKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
    creditcmb.requestFocus();
    }//GEN-LAST:event_AmountTblKeyPressed

    private void creditcmbKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_creditcmbKeyPressed
      if (evt.getKeyCode()==KeyEvent.VK_ENTER)
    DecscriptionTbl.requestFocus();
    }//GEN-LAST:event_creditcmbKeyPressed

    private void DecscriptionTblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DecscriptionTblKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
    OkBtn.doClick();
    }//GEN-LAST:event_DecscriptionTblKeyPressed

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
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Payment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AmountTbl;
    private javax.swing.JTextArea DecscriptionTbl;
    private javax.swing.JTextArea InWordTbl;
    private javax.swing.JButton OkBtn;
    private javax.swing.JComboBox<String> ReciveCmb;
    private javax.swing.JComboBox<String> ReosoneCmb;
    private javax.swing.JComboBox<String> creditcmb;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
