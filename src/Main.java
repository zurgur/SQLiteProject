import javax.swing.*;
import java.sql.*;

/**
 * Created by Alexander on 13.3.2017.
 */
public class Main {
   /* public static void main(String[] args){
        ResultSet rs = Connect.Connection();
        print(rs);
        JFrame adal = new JFrame("FrappForm");
        adal.setContentPane(new FrappForm().panel1);
        adal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adal.pack();
        adal.setVisible(true);

    }*/
    public static void print(ResultSet in) {
        try {
            while(in.next()){
                String st = in.getString("Til");
                System.out.println(st);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
