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


    public FrappForm() {
        clickMeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultSet rs = Connect.Connection();
                print(rs);
            }
        });
    }

    public void print(ResultSet rs) {
        DefaultListModel list = new DefaultListModel();
        String fin = "";

        try {
            while (rs.next()){
                String s = rs.getString("Fra");
                fin += "frá: " + s;
                s = rs.getString("Til");
                fin += " til: " + s;
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
