package Source;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;

/**
 *
 * @author ARMAN HOSSAIN
 */
public class UpdateDatabase extends JFrame {
    int Problem_Found =0;

    void UpdateQty(String Barcode, int Qty) {
        int FinalQty = 0;
       try{
        try {
            String Query = "SELECT * FROM purchase WHERE Barcode = " + "'" + Barcode + "'";
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement = (Statement) connection.createStatement();
            ResultSet qtyresult = statement.executeQuery(Query);
            qtyresult.next();
            String QtyString = qtyresult.getString("Qty");
            int QtyInt = Integer.parseInt(QtyString);
            FinalQty = QtyInt - Qty;
            connection.close();
            statement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e + "Problems Update");
        }
        try {
            String FianlIntString = Integer.toString(FinalQty);
            String Query1 = "UPDATE purchase SET Qty = ? WHERE Barcode = ";
            String Query2 = Query1+"'"+Barcode+"'";
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection11 = DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            PreparedStatement psts = (PreparedStatement) connection11.prepareStatement(Query2);
            psts.setString(1, FianlIntString);
            psts.executeUpdate();
            System.out.println("hello");
        } catch (Exception e) {
            System.out.print(e);
            JOptionPane.showMessageDialog(this, e + "Problems Update1");
        }
        
    }catch(Exception e){
        JOptionPane.showMessageDialog(this, e);
    }
    }

    int updateblance(int number, String Reasone, String Reciver, int cheek) throws Exception {
        String AccountType = null, Name = null, Address = null, Mobile = null, Blance = null, TotalBlanceString = null;
        int Blance1, CurrentTotalBlance, TotalBlance = 0;
        String query1 = "SELECT * FROM ladger WHERE AccountType = ";
        String query2 = " and Name= ";
        String str2 = "'";
        String str3 = "'";
        String string = query1 + str2 + Reasone + str2 + query2 + str2 + Reciver + str2;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            Statement statement = (Statement) connection.createStatement();
            ResultSet result = statement.executeQuery(string);
            result.next();
            //Name = result.getString("Name");
            //Address = result.getString("Address");
            //Mobile = result.getString("Mobile");
            Blance = result.getString("Blance");
            CurrentTotalBlance = Integer.parseInt(Blance);
            if (cheek == 1) {
                TotalBlance = CurrentTotalBlance + number;
            } else {
                if (number <= CurrentTotalBlance) {
                    TotalBlance = CurrentTotalBlance - number;
                } else {
                       JOptionPane.showMessageDialog(this, "Cheek Blance");
                       return 0;
                }
            }
            connection.close();
            statement.close();
        } catch (Exception ex) {
        }
        String Query1 = "Update ladger set Blance=? Where AccountType= ";
        String string2 = "'";
        String string3 = "'";
        String Query = Query1 + str2 + Reasone + str2 + query2 + str2 + Reciver + str2;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.108/grocery_database", "root", "");
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(Query);
            ps.setString(1, Integer.toString(TotalBlance));
            ps.executeUpdate();
        } catch (Exception e) {
                                   JOptionPane.showMessageDialog(this, e);
        }
        return 1;
    }
}
