/**
 * Created by Alexander on 13.3.2017.
 */
import javax.swing.*;
import java.sql.*;

public class Connect {
    //Connection conn = null;
    public static ResultSet Connection(){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:database.sqlite");
            Statement stmt =  con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Flug");
            return rs;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
