import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Created by Alexander on 14.3.2017.
 */
public class FrappForm {
    private JButton clickMeButton;
    private JPanel panel1;
    private JList list1;
    private JButton takkaFráButton;


    public FrappForm() {
        clickMeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection con = Connect.Connection();
                Statement stmt = null;
                try {
                    stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Flug");
                    print(rs);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }


            }
        });
        takkaFráButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection con = Connect.Connection();
                Statement stmt = null;
                try {
                    stmt = con.createStatement();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                String sql = "UPDATE Flug SET Saeti = Saeti - 1 WHERE rowid = 1";



                /*"SELECT Saeti " +
                                "FROM Flug" +
                                " WHERE Til = 'kefflavík' AND Fra = 'alicante'";*/
            }
        });
    }

    public void print(ResultSet rs) {
        DefaultListModel list = new DefaultListModel();
        String fin = "";

        try {
            while (rs.next()){
                String s = rs.getString("Fra");
                fin += "Frá: " + s;
                s = rs.getString("Til");
                fin += " Til: " + s;
                s = rs.getString("Klukkan");
                fin += " Kl: " + s;
                s = rs.getString("Dagur");
                fin += " Dagur: " +s;
                s = rs.getString("Saeti");
                fin += " Sæti: " + s;
                list.addElement(fin);
                fin = "";
            }
            list1.setModel(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {
        JFrame adal = new JFrame("FrappForm");
        adal.setContentPane(new FrappForm().panel1);
        adal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adal.pack();
        adal.setVisible(true);
    }
}
