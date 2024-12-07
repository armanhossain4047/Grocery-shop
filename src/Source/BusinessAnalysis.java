package Source;

import com.mysql.jdbc.PreparedStatement;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BusinessAnalysis extends javax.swing.JFrame {

    double EstablishmentDouble = 0.0, StockValueDouble = 0.0, CustomerDueDouble = 0.0, BankBlanceDouble = 0.0, AssestPlainLoanDouble = 0.0, SupplierDouble = 0.0, CCLoanDouble = 0.0, SalaryDouble = 0.0, BilsDueDouble = 0.0, AdvInvestmentDouble = 0.0, LiabilitiesPlainLoanDouble = 0.0, CCsLoanDouble = 0.0;
    double CashInHandDouble = 0.0;
    int RowCount = 0;

    public BusinessAnalysis() {
        initComponents();
        intilize();
    }

    private void intilize() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(currentDate);
        DailyReport obj = new DailyReport();
        Establishment();
        StockValue();
        CustomerDue();
        BankBlance();
        AssestPlainLoan();
        Supplier();
        CCLoan();
        CCLoan();
        BilsDue();
        CashInHandDouble = obj.Closing_Blance_For_Busniss(formattedDate);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", ""); Statement statement = connection.createStatement(); ResultSet result = statement.executeQuery("SELECT COUNT(*) AS Row FROM businessanalysis WHERE CDate = CURRENT_DATE;")) {
                if (result.next()) {
                    RowCount = Integer.parseInt(result.getString(1));
                }
                result.close();
                statement.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        if (RowCount == 0) {
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
                PreparedStatement ps = (PreparedStatement) connection.prepareStatement(" INSERT INTO `businessanalysis`(`Establishment`, `StockValue`, `CustomerDue`, `BankBalance`, `AssetPlainLoan` , `CashInHand` , `TotalAssist`,`SupplierDue`,`CCLoan`, `SalaryDue`, `BillDue`,`Position`, `TotalLiabilites`) VALUES  (?,?,?,?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1, String.format("%.2f", EstablishmentDouble));
                ps.setString(2, String.format("%.2f", StockValueDouble));
                ps.setString(3, String.format("%.2f", CustomerDueDouble));
                ps.setString(4, String.format("%.2f", BankBlanceDouble));
                ps.setString(5, String.format("%.2f", AssestPlainLoanDouble));
                ps.setString(6, String.format("%.2f", CashInHandDouble));
                ps.setString(7, String.format("%.2f", EstablishmentDouble + StockValueDouble + CustomerDueDouble + BankBlanceDouble + AssestPlainLoanDouble + CashInHandDouble));
                ps.setString(8, String.format("%.2f", SupplierDouble));
                ps.setString(9, String.format("%.2f", CCLoanDouble));
                ps.setString(10, String.format("%.2f", SalaryDouble));
                ps.setString(11, String.format("%.2f", BilsDueDouble));
                ps.setString(12, String.format("%.2f", EstablishmentDouble + StockValueDouble + CustomerDueDouble + BankBlanceDouble + AssestPlainLoanDouble + CashInHandDouble - SupplierDouble - CCLoanDouble - SalaryDouble - BilsDueDouble));
                ps.setString(13, String.format("%.2f", SupplierDouble + CCLoanDouble + SalaryDouble + BilsDueDouble));
                ps.executeUpdate();
            } catch (NumberFormatException | SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else {
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
                PreparedStatement ps = (PreparedStatement) connection.prepareStatement("UPDATE `businessanalysis` SET `Establishment` = ?, `StockValue` = ?, `CustomerDue` = ?, `BankBalance` = ?, `AssetPlainLoan` = ?, `CashInHand` = ?, `TotalAssist` = ?, `SupplierDue` = ? ,`CCLoan` = ?, `SalaryDue` = ?, `BillDue` = ? ,`Position` = ? , `TotalLiabilites` = ? WHERE CDate = CURRENT_DATE");
                ps.setString(1, String.format("%.2f", EstablishmentDouble));
                ps.setString(2, String.format("%.2f", StockValueDouble));
                ps.setString(3, String.format("%.2f", CustomerDueDouble));
                ps.setString(4, String.format("%.2f", BankBlanceDouble));
                ps.setString(5, String.format("%.2f", AssestPlainLoanDouble));
                ps.setString(6, String.format("%.2f", CashInHandDouble));
                ps.setString(7, String.format("%.2f", EstablishmentDouble + StockValueDouble + CustomerDueDouble + BankBlanceDouble + AssestPlainLoanDouble + CashInHandDouble));
                ps.setString(8, String.format("%.2f", SupplierDouble));
                ps.setString(9, String.format("%.2f", CCLoanDouble));
                ps.setString(10, String.format("%.2f", SalaryDouble));
                ps.setString(11, String.format("%.2f", BilsDueDouble));
                ps.setString(12, String.format("%.2f", EstablishmentDouble + StockValueDouble + CustomerDueDouble + BankBlanceDouble + AssestPlainLoanDouble + CashInHandDouble - SupplierDouble - CCLoanDouble - SalaryDouble - BilsDueDouble));
                ps.setString(13, String.format("%.2f", SupplierDouble + CCLoanDouble + SalaryDouble + BilsDueDouble));

                ps.executeUpdate();
            } catch (NumberFormatException | SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }

        }

        /// Table Insert ////
        All_Table_Insert();

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

        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        AssetsTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        AssetsLiabilities = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        LiabilitiesTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        AssetsTbl = new javax.swing.JLabel();
        PositionTbl = new javax.swing.JLabel();
        LiabilitiesTbl = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setExtendedState(6);
        setResizable(false);
        setState(6);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Assets", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        AssetsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Establishment", "Stock Value", "Customer Due", "Bank Balance", "Assets Plain Loan", "Cash in Hand", "Total Assets"
            }
        ));
        jScrollPane3.setViewportView(AssetsTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liabilities", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        AssetsLiabilities.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Asset", "Liabilities", "Position"
            }
        ));
        jScrollPane4.setViewportView(AssetsLiabilities);

        LiabilitiesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Supplier", "Adv. & Invest", "Plain Loan", "CCS Loan", "CC Loan", "Salary", "Bills Due", "Total Liabilities"
            }
        ));
        jScrollPane5.setViewportView(LiabilitiesTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 51));
        jLabel1.setText("Assets :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 51));
        jLabel2.setText("Liabilities :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 51));
        jLabel3.setText("Position :");

        AssetsTbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AssetsTbl.setForeground(new java.awt.Color(0, 153, 51));
        AssetsTbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        AssetsTbl.setText("0.00");

        PositionTbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        PositionTbl.setForeground(new java.awt.Color(0, 153, 51));
        PositionTbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        PositionTbl.setText("0.00");

        LiabilitiesTbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LiabilitiesTbl.setForeground(new java.awt.Color(0, 153, 51));
        LiabilitiesTbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LiabilitiesTbl.setText("0.00");

        jSeparator1.setForeground(new java.awt.Color(0, 153, 102));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(26, 26, 26))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(11, 11, 11)))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AssetsTbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LiabilitiesTbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PositionTbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jSeparator1))
                .addGap(83, 83, 83))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(AssetsTbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(15, 15, 15)
                                .addComponent(LiabilitiesTbl, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PositionTbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26)))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
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

        setSize(new java.awt.Dimension(869, 670));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    @SuppressWarnings("empty-statement")

    void Establishment() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", ""); Statement statement = connection.createStatement(); ResultSet result = statement.executeQuery("SELECT COALESCE(SUM(Blance),0) FROM `ladger` WHERE AccountType = 'Establishment'")) {;
                if (result.next()) {
                    EstablishmentDouble = Double.parseDouble(result.getString(1));
                }
                result.close();
                statement.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void StockValue() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", ""); Statement statement = connection.createStatement(); ResultSet result = statement.executeQuery("SELECT COALESCE(SUM(Qty*Rate),0) FROM `purchase`")) {
                if (result.next()) {
                    StockValueDouble = Double.parseDouble(result.getString(1));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void CustomerDue() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", ""); Statement statement = connection.createStatement(); ResultSet result = statement.executeQuery("SELECT COALESCE(SUM(Blance),0) FROM `ladger` WHERE AccountType = 'Customer'")) {
                if (result.next()) {
                    CustomerDueDouble = Double.parseDouble(result.getString(1));
                }
                result.close();
                statement.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void BankBlance() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", ""); Statement statement = connection.createStatement(); ResultSet result = statement.executeQuery("SELECT COALESCE(SUM(Blance),0) FROM `ladger` WHERE AccountType = 'Bank Account'")) {
                if (result.next()) {
                    BankBlanceDouble = Double.parseDouble(result.getString(1));
                }
                result.close();
                statement.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void AssestPlainLoan() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", ""); Statement statement = connection.createStatement(); ResultSet result = statement.executeQuery("SELECT COALESCE(SUM(Blance),0) FROM `ladger` WHERE AccountType = 'Plain Loan'")) {
                if (result.next()) {
                    AssestPlainLoanDouble = Double.parseDouble(result.getString(1));
                }
                result.close();
                statement.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void Supplier() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", ""); Statement statement = connection.createStatement(); ResultSet result = statement.executeQuery("SELECT COALESCE(SUM(Blance),0) FROM `ladger` WHERE AccountType = 'Supplier'")) {
                if (result.next()) {
                    SupplierDouble = Double.parseDouble(result.getString(1));
                }
                result.close();
                statement.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void AdvInvestment() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", ""); Statement statement = connection.createStatement(); ResultSet result = statement.executeQuery("SELECT COALESCE(SUM(Blance),0) FROM `ladger` WHERE AccountType = 'Customer'")) {
                if (result.next()) {
                    AdvInvestmentDouble = Double.parseDouble(result.getString(1));
                }
                result.close();
                statement.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void LiabilitiesPlainLoan() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", ""); Statement statement = connection.createStatement(); ResultSet result = statement.executeQuery("SELECT COALESCE(SUM(Blance),0) FROM `ladger` WHERE AccountType = 'Plain Loan'")) {
                if (result.next()) {
                    LiabilitiesPlainLoanDouble = Double.parseDouble(result.getString(1));
                }
                result.close();
                statement.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void CCSLoan() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", ""); Statement statement = connection.createStatement(); ResultSet result = statement.executeQuery("SELECT COALESCE(SUM(Blance),0) FROM `ladger` WHERE AccountType = 'Customer'")) {
                if (result.next()) {
                    CCsLoanDouble = Double.parseDouble(result.getString(1));
                }
                result.close();
                statement.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void CCLoan() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", ""); Statement statement = connection.createStatement(); ResultSet result = statement.executeQuery("SELECT COALESCE(SUM(Blance),0) FROM `ladger` WHERE AccountType = 'CC Loan'")) {
                if (result.next()) {
                    CCLoanDouble = Double.parseDouble(result.getString(1));
                }
                result.close();
                statement.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void Salary() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", ""); Statement statement = connection.createStatement(); ResultSet result = statement.executeQuery("SELECT COALESCE(SUM(Blance),0) FROM `ladger` WHERE AccountType = 'Salary'")) {
                if (result.next()) {
                    SalaryDouble = Double.parseDouble(result.getString(1));
                }
                result.close();
                statement.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void BilsDue() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", ""); Statement statement = connection.createStatement(); ResultSet result = statement.executeQuery("SELECT COALESCE(SUM(Blance),0) FROM `ladger` WHERE AccountType = 'Monthly Bills'")) {
                if (result.next()) {
                    BilsDueDouble = Double.parseDouble(result.getString(1));
                }
                result.close();
                statement.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void All_Table_Insert() {
        ////Assist Table Code Strt/////
        DefaultTableModel model = (DefaultTableModel) AssetsTable.getModel();
        DefaultTableModel model1 = (DefaultTableModel) LiabilitiesTable.getModel();
        DefaultTableModel model2 = (DefaultTableModel) AssetsLiabilities.getModel();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connection = (java.sql.Connection) java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            java.sql.Statement statement = (java.sql.Statement) connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `businessanalysis`");
            while (result.next()) {
                model.addRow(new Object[]{result.getString("CDate"), result.getString("Establishment"), result.getString("StockValue"), result.getString("CustomerDue"), result.getString("BankBalance"), result.getString("AssetPlainLoan"), result.getString("CashInHand"), result.getString("TotalAssist")});
                model1.addRow(new Object[]{result.getString("CDate"), result.getString("SupplierDue"), "0", "0", "0", "0", "0", "0", result.getString("TotalLiabilites")});

            }
        } catch (ClassNotFoundException | SQLException e) {

        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connection = (java.sql.Connection) java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            java.sql.Statement statement = (java.sql.Statement) connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT CDate, TotalAssist, TotalLiabilites, (TotalAssist-TotalLiabilites)as Position FROM `businessanalysis`");
            while (result.next()) {
                model2.addRow(new Object[]{result.getString("CDate"), result.getString(2), result.getString(3), result.getString(4)});

            }
        } catch (Exception e) {

        }
        try {

            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connection = (java.sql.Connection) java.sql.DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            java.sql.Statement statement = (java.sql.Statement) connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT TotalAssist, TotalLiabilites, (TotalAssist-TotalLiabilites) FROM businessanalysis ORDER BY TotalAssist ASC LIMIT 1");
            while (result.next()) {
                AssetsTbl.setText(result.getString(1));
                LiabilitiesTbl.setText(result.getString(2));
                PositionTbl.setText(result.getString(3));
            }
        } catch (Exception e) {

        }
    }

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
            java.util.logging.Logger.getLogger(BusinessAnalysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BusinessAnalysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BusinessAnalysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BusinessAnalysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BusinessAnalysis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AssetsLiabilities;
    private javax.swing.JTable AssetsTable;
    private javax.swing.JLabel AssetsTbl;
    private javax.swing.JTable LiabilitiesTable;
    private javax.swing.JLabel LiabilitiesTbl;
    private javax.swing.JLabel PositionTbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
