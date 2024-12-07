package Source;

import com.mysql.jdbc.PreparedStatement;
import com.toedter.calendar.JDateChooser;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mondrian.olap.DriverManager;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.toedter.calendar.JDateChooser;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;

public class DailyReport extends javax.swing.JFrame {

    public DailyReport() {
        initComponents();
        intilize();
    }

    void Total_Sale(String Date) {
        Total_Discount(Date);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection1 = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement1 = connection1.createStatement();
            ResultSet result1 = statement1.executeQuery("SELECT COALESCE(SUM(TotalBlance),0) FROM `invoice_count` WHERE Date ='" + Date + "'");
            if (result1.next()) {
                TotalSaleTbl.setText(String.format("%.2f", result1.getDouble(1) + Double.parseDouble(DiscountsTbl.getText())));
            }
            result1.close();
            statement1.close();
            connection1.close();

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void Sale_Return(String Date) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection1 = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement1 = connection1.createStatement();
            ResultSet result1 = statement1.executeQuery("SELECT COALESCE(SUM(Amount),0) FROM `sale_return` WHERE Date ='" + Date + "'");
            if (result1.next()) {
                saleretruntbl.setText(String.format("%.2f", result1.getDouble(1)));
            }
            result1.close();
            statement1.close();
            connection1.close();

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void Total_Discount(String Date) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection1 = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement1 = connection1.createStatement();
            ResultSet result1 = statement1.executeQuery("SELECT COALESCE(SUM(DiscountTk),0) FROM `invoice_count` WHERE Date ='" + Date + "'");
            if (result1.next()) {
                DiscountsTbl.setText(String.format("%.2f", result1.getDouble(1)));
            }
            result1.close();
            statement1.close();
            connection1.close();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void Net_Sale(String Date) {
        Total_Sale(Date);
        Sale_Return(Date);
        Total_Discount(Date);
        double Sale = Double.parseDouble(TotalSaleTbl.getText());
        double Discount = Double.parseDouble(DiscountsTbl.getText());
        double Return_Sale = Double.parseDouble(saleretruntbl.getText());
        NetSaleTbl.setText(String.format("%.2f", Sale - Discount - Return_Sale));
    }

    void Cash_Sale(String Date) {
        Sale_Return(Date);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection1 = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement1 = connection1.createStatement();
            ResultSet result1 = statement1.executeQuery("SELECT COALESCE(SUM(Cash),0) FROM `invoice_count` WHERE Date ='" + Date + "'");
            if (result1.next()) {
                Cashtbl.setText(String.format("%.2f", result1.getDouble(1) - Double.parseDouble(saleretruntbl.getText())));
            }
            result1.close();
            statement1.close();
            connection1.close();

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void Digital_Sale(String Date) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection1 = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement1 = connection1.createStatement();
            ResultSet result1 = statement1.executeQuery("SELECT COALESCE(SUM(Digital_Paid),0) FROM `invoice_count` WHERE Date = '" + Date + "'");
            if (result1.next()) {
                cardtbl.setText(String.format("%.2f", result1.getDouble(1)));
            }
            result1.close();
            statement1.close();
            connection1.close();

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void Profit(String Date) {
        Net_Sale(Date);
        double sale_return_purchase_Rate = 0.0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection1 = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement1 = connection1.createStatement();
            ResultSet result1 = statement1.executeQuery("SELECT COALESCE( SUM(purchase.Rate*sale_return.Qty),0) AS Profit FROM `sale_return` LEFT JOIN purchase ON sale_return.Barcode=purchase.Barcode WHERE sale_return.Date ='" + Date + "'");
            if (result1.next()) {
                sale_return_purchase_Rate = Double.parseDouble(result1.getString(1));
            }
            result1.close();
            statement1.close();
            connection1.close();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection1 = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement1 = connection1.createStatement();
            ResultSet result1 = statement1.executeQuery("SELECT COALESCE( SUM(purchase.Rate*invaudit.Qty),0) AS Profit FROM `invaudit` LEFT JOIN purchase ON invaudit.Barcode=purchase.Barcode WHERE invaudit.Date ='" + Date + "'");
            if (result1.next()) {
                ProfitCalculate.setText(String.format("%.2f", Double.parseDouble(NetSaleTbl.getText()) - Double.parseDouble(result1.getString(1)) + sale_return_purchase_Rate));
            }
            result1.close();
            statement1.close();
            connection1.close();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }

    void Opening_Blance(String Date) {
        double recive = 0.0, sale = 0.0, pre_sale_return = 0.0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection1 = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement1 = connection1.createStatement();
            ResultSet result1 = statement1.executeQuery("SELECT COALESCE(SUM(Amount),0) FROM `sale_return` WHERE Date Between  '2024-01-01' AND '" + Date + "' - INTERVAL 1 DAY");
            if (result1.next()) {
                pre_sale_return = result1.getDouble(1);
            }
            result1.close();
            statement1.close();
            connection1.close();

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection1 = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement1 = connection1.createStatement();
            ResultSet result1 = statement1.executeQuery("SELECT COALESCE((SELECT SUM(Amount) FROM paymentstatement WHERE Credit='Cash' AND Status='Payment' AND Date Between  '2024-01-01' AND '" + Date + "' - INTERVAL 1 DAY), 0) as Payment, COALESCE(SUM(Amount), 0) as recive, COALESCE(SUM(Amount), 0) - COALESCE((SELECT SUM(Amount) FROM paymentstatement WHERE Credit='Cash' AND Status='Payment' AND Date between '2024-01-01' and '" + Date + "' - INTERVAL 1 DAY), 0) as CashBalance FROM paymentstatement WHERE Credit='Cash' AND Status='Recive' AND Date Between  '2024-01-01' AND '" + Date + "' - INTERVAL 1 DAY;");
            if (result1.next()) {
                recive = result1.getDouble(3);
            }
            result1.close();
            statement1.close();
            connection1.close();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection1 = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement1 = connection1.createStatement();
            ResultSet result1 = statement1.executeQuery("SELECT COALESCE(SUM(Cash), 0) AS Total FROM invoice_count WHERE Date between '2024-01-01' and '" + Date + "' - INTERVAL 1 DAY;");
            if (result1.next()) {
                sale = result1.getDouble(1);
            }
            result1.close();
            statement1.close();
            connection1.close();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        OpeningBalance.setText(String.format("%.2f", recive + sale - pre_sale_return));
    }

    void Closing_Blance(String Date) {
        double payment = 0.0, sale = 0.0, sale_return = 0.0;
        Sale_Return(Date);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connection1 = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            java.sql.Statement statement1 = connection1.createStatement();
            // String query = "SELECT COUNT(*) FROM invaudit";
            ResultSet result1 = statement1.executeQuery("SELECT COALESCE((SELECT SUM(Amount) FROM paymentstatement WHERE Credit='Cash' AND Status='Payment' AND Date Between  '2024-01-01' AND '" + Date + "'), 0) as Payment, COALESCE(SUM(Amount), 0) as recive, COALESCE(SUM(Amount), 0) - COALESCE((SELECT SUM(Amount) FROM paymentstatement WHERE Credit='Cash' AND Status='Payment' AND Date Between  '2024-01-01' AND '" + Date + "'), 0) as CashBalance FROM paymentstatement WHERE Credit='Cash' AND Status='Recive' AND Date Between  '2024-01-01' AND '" + Date + "';");
            if (result1.next()) {
                payment = result1.getDouble(3);
            }
            result1.close();
            statement1.close();
            connection1.close();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection1 = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement1 = connection1.createStatement();
            ResultSet result1 = statement1.executeQuery("SELECT COALESCE(SUM(Cash), 0) AS Total FROM invoice_count WHERE Date Between  '2024-01-01' AND '" + Date + "'");
            if (result1.next()) {
                sale = result1.getDouble(1);
            }
            result1.close();
            statement1.close();
            connection1.close();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection1 = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement1 = connection1.createStatement();
            ResultSet result1 = statement1.executeQuery("SELECT COALESCE(SUM(Amount),0) FROM `sale_return` WHERE Date Between  '2024-01-01' AND '" + Date + "'");
            if (result1.next()) {
                sale_return = result1.getDouble(1);
            }
            result1.close();
            statement1.close();
            connection1.close();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        closingbalance.setText(String.format("%.2f", payment + sale - sale_return));
    }

    double Closing_Blance_For_Busniss(String Date) {
        double payment = 0.0, sale = 0.0, sale_return = 0.0;
        Sale_Return(Date);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connection1 = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            java.sql.Statement statement1 = connection1.createStatement();
            // String query = "SELECT COUNT(*) FROM invaudit";
            ResultSet result1 = statement1.executeQuery("SELECT COALESCE((SELECT SUM(Amount) FROM paymentstatement WHERE Credit='Cash' AND Status='Payment' AND Date Between  '2024-01-01' AND '" + Date + "'), 0) as Payment, COALESCE(SUM(Amount), 0) as recive, COALESCE(SUM(Amount), 0) - COALESCE((SELECT SUM(Amount) FROM paymentstatement WHERE Credit='Cash' AND Status='Payment' AND Date Between  '2024-01-01' AND '" + Date + "'), 0) as CashBalance FROM paymentstatement WHERE Credit='Cash' AND Status='Recive' AND Date Between  '2024-01-01' AND '" + Date + "';");
            if (result1.next()) {
                payment = result1.getDouble(3);
            }
            result1.close();
            statement1.close();
            connection1.close();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection1 = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement1 = connection1.createStatement();
            ResultSet result1 = statement1.executeQuery("SELECT COALESCE(SUM(Cash), 0) AS Total FROM invoice_count WHERE Date Between  '2024-01-01' AND '" + Date + "'");
            if (result1.next()) {
                sale = result1.getDouble(1);
            }
            result1.close();
            statement1.close();
            connection1.close();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection1 = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement1 = connection1.createStatement();
            ResultSet result1 = statement1.executeQuery("SELECT COALESCE(SUM(Amount),0) FROM `sale_return` WHERE Date Between  '2024-01-01' AND '" + Date + "'");
            if (result1.next()) {
                sale_return = result1.getDouble(1);
            }
            result1.close();
            statement1.close();
            connection1.close();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        return payment + sale - sale_return;
    }

    void Due(String Date) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection1 = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement1 = connection1.createStatement();
            ResultSet result1 = statement1.executeQuery("SELECT COALESCE(SUM(DueAmount),0) FROM `invoice_count` WHERE Date ='" + Date + "'");
            if (result1.next()) {
                duetbl.setText(String.format("%.2f", result1.getDouble(1)));
            }
            result1.close();
            statement1.close();
            connection1.close();

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void Payment(String Date) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection1 = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement1 = connection1.createStatement();
            ResultSet result1 = statement1.executeQuery("SELECT COALESCE(SUM(Amount),0) FROM `paymentstatement` WHERE Status = 'Payment' AND Date ='" + Date + "'");
            if (result1.next()) {
                paymenttbl.setText(String.format("%.2f", result1.getDouble(1)));
            }
            result1.close();
            statement1.close();
            connection1.close();

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void Recive(String Date) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection1 = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement1 = connection1.createStatement();
            ResultSet result1 = statement1.executeQuery("SELECT COALESCE(SUM(Amount),0) FROM `paymentstatement` WHERE Status = 'Recive' AND Date ='" + Date + "'");
            if (result1.next()) {
                recivetbl.setText(String.format("%.2f", result1.getDouble(1)));
            }
            result1.close();
            statement1.close();
            connection1.close();

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void Payment_Statement(String Date) {
        try {
            DefaultTableModel model = (DefaultTableModel) paymenttable.getModel();
            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection1 = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement1 = connection1.createStatement();
            ResultSet result = statement1.executeQuery("SELECT * FROM `paymentstatement` WHERE Status= 'Payment' AND Date = '" + Date + "'");
            while (result.next()) {
                model.addRow(new Object[]{model.getRowCount() + 1, result.getString(6), result.getString(1), result.getString(2), result.getString(3), result.getString(5), result.getString(8)});
            }
            result.next();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    void Recive_Statement(String Date) {

        try {
            DefaultTableModel model = (DefaultTableModel) ReciveTbl.getModel();
            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection1 = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement1 = connection1.createStatement();
            ResultSet result = statement1.executeQuery("SELECT * FROM `paymentstatement` WHERE Status= 'Recive' AND Date = '" + Date + "'");
            while (result.next()) {
                model.addRow(new Object[]{model.getRowCount() + 1, result.getString(6), result.getString(1), result.getString(2), result.getString(3), result.getString(5), result.getString(8)});
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }

    void Sale_Statement(String Date) {

        try {
            DefaultTableModel model = (DefaultTableModel) Saletable.getModel();
            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection1 = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement1 = connection1.createStatement();
            ResultSet result = statement1.executeQuery("SELECT invoiceNo, TotalBlance, Cash, Digital_Paid, DueAmount, User FROM `invoice_count` WHERE Date = '" + Date + "'");
            while (result.next()) {
                model.addRow(new Object[]{model.getRowCount() + 1, result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6)});
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void Supplier_Statement(String Date) {
        try {
            DefaultTableModel model = (DefaultTableModel) PurchaseTbl.getModel();
            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection1 = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement1 = connection1.createStatement();
            ResultSet result = statement1.executeQuery("SELECT * FROM `supplier_statement` WHERE Date='" + Date + "'");
            while (result.next()) {
                model.addRow(new Object[]{model.getRowCount() + 1, result.getString(3), result.getString(7), Login.UserBy});
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void Sale_Return_Statement(String Date) {
        try {
            DefaultTableModel model = (DefaultTableModel) SaleReturnTbl.getModel();
            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection1 = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement1 = connection1.createStatement();
            ResultSet result = statement1.executeQuery("SELECT invoiceNo, Total_Return, User FROM `sale_return` WHERE Date = '" + Date + "' GROUP BY invoiceNo");
            while (result.next()) {
                model.addRow(new Object[]{model.getRowCount() + 1, result.getString(1), result.getString(2), result.getString(3)});
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void intilize() {

        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(currentDate);

//**========Method =========**//
        Total_Discount(formattedDate);
        Total_Sale(formattedDate);

        Sale_Return(formattedDate);
        Net_Sale(formattedDate);

        Cash_Sale(formattedDate);
        Digital_Sale(formattedDate);

        Profit(formattedDate);
        Due(formattedDate);

        Opening_Blance(formattedDate);
        Closing_Blance(formattedDate);

        Payment(formattedDate);
        Recive(formattedDate);

        Payment_Statement(formattedDate);
        Recive_Statement(formattedDate);

        Sale_Statement(formattedDate);
        Sale_Return_Statement(formattedDate);

        Supplier_Statement(formattedDate);

        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ReciveTbl = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        paymenttable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Saletable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        PurchaseTbl = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        TotalSaleTbl = new javax.swing.JLabel();
        NetSaleTbl = new javax.swing.JLabel();
        saleretruntbl = new javax.swing.JLabel();
        Cashtbl = new javax.swing.JLabel();
        DiscountsTbl = new javax.swing.JLabel();
        ProfitCalculate = new javax.swing.JLabel();
        cardtbl = new javax.swing.JLabel();
        Fromdate = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        OpeningBalance = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        closingbalance = new javax.swing.JLabel();
        recivetbl = new javax.swing.JLabel();
        duetbl = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        paymenttbl = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        SaleReturnTbl = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setExtendedState(6);
        setState(6);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Daily Report", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Show");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 153, 153));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Print");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Receipt", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        ReciveTbl.setBackground(new java.awt.Color(255, 232, 215));
        ReciveTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial No", "Date", "Credit Reason", "Credit From", "Amount", "Description", "User"
            }
        ));
        jScrollPane2.setViewportView(ReciveTbl);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Payment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        paymenttable.setBackground(new java.awt.Color(255, 232, 215));
        paymenttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial No", "Date", "Debit Reason", "Debit Receiver", "Amount", "Description", "User"
            }
        ));
        jScrollPane1.setViewportView(paymenttable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(0, 153, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sale", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(204, 255, 255))); // NOI18N

        Saletable.setBackground(new java.awt.Color(255, 232, 215));
        Saletable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial No", "Invoice Number", "Total Amount", "Cash Paid", "Digital Paid", "Due Amount", "User"
            }
        ));
        Saletable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaletableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(Saletable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(0, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Purchase", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        PurchaseTbl.setBackground(new java.awt.Color(255, 232, 215));
        PurchaseTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial No", "Supplier Name", "Amount", "User"
            }
        ));
        PurchaseTbl.setSelectionBackground(new java.awt.Color(204, 0, 51));
        jScrollPane3.setViewportView(PurchaseTbl);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Net Sale");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Discounts");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 51));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Cash Sale");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 0, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Card Sale");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 51));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Profit");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sale Return");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Total Sale");

        TotalSaleTbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TotalSaleTbl.setForeground(new java.awt.Color(0, 102, 102));
        TotalSaleTbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TotalSaleTbl.setText("0");

        NetSaleTbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        NetSaleTbl.setForeground(new java.awt.Color(0, 102, 51));
        NetSaleTbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NetSaleTbl.setText("0");

        saleretruntbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        saleretruntbl.setForeground(new java.awt.Color(255, 51, 0));
        saleretruntbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        saleretruntbl.setText("0");

        Cashtbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Cashtbl.setForeground(new java.awt.Color(0, 102, 51));
        Cashtbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Cashtbl.setText("0");

        DiscountsTbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        DiscountsTbl.setForeground(new java.awt.Color(255, 0, 0));
        DiscountsTbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DiscountsTbl.setText("0");

        ProfitCalculate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ProfitCalculate.setForeground(new java.awt.Color(0, 102, 51));
        ProfitCalculate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ProfitCalculate.setText("0");

        cardtbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cardtbl.setForeground(new java.awt.Color(102, 0, 102));
        cardtbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cardtbl.setText("0");

        Fromdate.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Fromdate.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                FromdateAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Date");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Closing BL");

        OpeningBalance.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        OpeningBalance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OpeningBalance.setText("0");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 102));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Received");

        closingbalance.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        closingbalance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        closingbalance.setText("0");

        recivetbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        recivetbl.setForeground(new java.awt.Color(0, 102, 102));
        recivetbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        recivetbl.setText("0");

        duetbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        duetbl.setForeground(new java.awt.Color(204, 0, 51));
        duetbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        duetbl.setText("0");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Opening BL");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 0, 51));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Due");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 0, 0));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Payment");

        paymenttbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        paymenttbl.setForeground(new java.awt.Color(204, 0, 0));
        paymenttbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paymenttbl.setText("0");

        jPanel6.setBackground(new java.awt.Color(255, 102, 102));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sale Return", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        SaleReturnTbl.setBackground(new java.awt.Color(255, 232, 215));
        SaleReturnTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial No", "Invoice Number", "Total Amount", "User"
            }
        ));
        jScrollPane5.setViewportView(SaleReturnTbl);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(TotalSaleTbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saleretruntbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(DiscountsTbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(2, 2, 2))
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(cardtbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Cashtbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(NetSaleTbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                            .addComponent(ProfitCalculate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(OpeningBalance, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addGap(1, 1, 1))
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(paymenttbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(recivetbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(duetbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                            .addComponent(closingbalance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Fromdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(closingbalance, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(duetbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recivetbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paymenttbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OpeningBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProfitCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NetSaleTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cashtbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardtbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DiscountsTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saleretruntbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TotalSaleTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Fromdate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        setSize(new java.awt.Dimension(1521, 808));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

//// Stard Code///
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement("INSERT INTO `daily_report` (Date,TotalSale, SaleReturn, Discounts, CardSale, CashSale, NetSale, Profit, OpeningBalance, Payment, Received, Due, ClosingBlance) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)");
            Date selectedDate = Fromdate.getDate();
            if (selectedDate != null) {
                ps.setDate(1, new java.sql.Date(selectedDate.getTime()));
            } else {
                ps.setNull(1, java.sql.Types.DATE);
            }
            ps.setString(2, TotalSaleTbl.getText());
            ps.setString(3, saleretruntbl.getText());
            ps.setString(4, DiscountsTbl.getText());
            ps.setString(5, cardtbl.getText());
            ps.setString(6, Cashtbl.getText());
            ps.setString(7, NetSaleTbl.getText());
            ps.setString(8, ProfitCalculate.getText());
            ps.setString(9, OpeningBalance.getText());
            ps.setString(10, paymenttbl.getText());
            ps.setString(11, recivetbl.getText());
            ps.setString(12, duetbl.getText());
            ps.setString(13, closingbalance.getText());

            // Execute update
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {

            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

        // print start//
        try {
            Date selectedDate = Fromdate.getDate();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String Date = dateFormat.format(selectedDate);
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            File jrxmlFile = new File("src\\Report\\DailyReportA4.jrxml");
            JasperDesign jd = JRXmlLoader.load(jrxmlFile.getAbsolutePath());
            HashMap<String, Object> para = new HashMap<>();
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, para, connection);
            JRViewer viewer = new JRViewer(jp);
            JFrame frame = new JFrame("Daily Report");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.add(viewer);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
        } catch (JRException ex) {

            JOptionPane.showMessageDialog(null, "Error generating report: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please Select Date");
        }
        //print end //

        Delete_DailyReport_Copy();
//// END Code /////

    }//GEN-LAST:event_jButton2ActionPerformed

    void Delete_DailyReport_Copy() {
        //**================ Invoice Print Code start ===================**//
        try {
            Connection connection1 = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            try (Statement statement = connection1.createStatement()) {
                String query = "DELETE FROM  daily_report";
                statement.executeUpdate(query);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Date selectedDate = Fromdate.getDate();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String Date = dateFormat.format(selectedDate);

            Total_Discount(Date);
            Total_Sale(Date);

            Sale_Return(Date);
            Net_Sale(Date);

            Cash_Sale(Date);
            Digital_Sale(Date);

            Profit(Date);
            Due(Date);

            Opening_Blance(Date);
            Closing_Blance(Date);

            Payment(Date);
            Recive(Date);

            Payment_Statement(Date);
            Recive_Statement(Date);

            Sale_Statement(Date);
            Sale_Return_Statement(Date);

            Supplier_Statement(Date);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please Select Date");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void FromdateAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_FromdateAncestorAdded

        Fromdate.setDate(new java.util.Date());


    }//GEN-LAST:event_FromdateAncestorAdded

    private void SaletableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaletableMouseClicked

        // Get the selected row from the table
        int selectedRow = Saletable.getSelectedRow();

        if (selectedRow != -1) {
            // Extract the InvoiceNumber from the selected row
            String InvoiceNumber = Saletable.getValueAt(selectedRow, 0).toString();

            // SQL query to fetch invoice details
            String query = "SELECT * FROM invoice_count WHERE InvoiceNo = ?";

            // Open the FindInvoice window and populate it with data
            try (Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", ""); PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query)) {

                // Set the parameter in the query
                preparedStatement.setString(1, InvoiceNumber);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Open the FindInvoice form and pass the InvoiceNumber
                    FindInvoice findInvoice = new FindInvoice();
                    findInvoice.populateComboBox(InvoiceNumber); // Ensure this method exists and works
                    findInvoice.setVisible(true);
                }
            } catch (SQLException e) {
                // Show an error message if a database error occurs
                e.printStackTrace();
                JOptionPane.showMessageDialog(this,
                        "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Handle the case where no row is selected
            JOptionPane.showMessageDialog(this,
                    "Please select a row!", "Warning", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_SaletableMouseClicked

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
            java.util.logging.Logger.getLogger(DailyReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DailyReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DailyReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DailyReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DailyReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cashtbl;
    private javax.swing.JLabel DiscountsTbl;
    private com.toedter.calendar.JDateChooser Fromdate;
    private javax.swing.JLabel NetSaleTbl;
    private javax.swing.JLabel OpeningBalance;
    private javax.swing.JLabel ProfitCalculate;
    private javax.swing.JTable PurchaseTbl;
    private javax.swing.JTable ReciveTbl;
    private javax.swing.JTable SaleReturnTbl;
    private javax.swing.JTable Saletable;
    private javax.swing.JLabel TotalSaleTbl;
    private javax.swing.JLabel cardtbl;
    private javax.swing.JLabel closingbalance;
    private javax.swing.JLabel duetbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable paymenttable;
    private javax.swing.JLabel paymenttbl;
    private javax.swing.JLabel recivetbl;
    private javax.swing.JLabel saleretruntbl;
    // End of variables declaration//GEN-END:variables
}
