/**
 * Created by Alexander on 13.3.2017.
 */
import javax.swing.*;
import java.sql.*;

public class Connect {
    //Connection conn = null;
    public static void Connection(){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:database.sqlite");
            JOptionPane.showMessageDialog(null, "connect");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
