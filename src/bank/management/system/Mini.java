package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

public class Mini extends JFrame implements ActionListener {
    String pin;
    JButton button;

    Mini(String pin) {
        this.pin = pin;

        JLabel label1 = new JLabel();
        label1.setBounds(20,140,400,230);
        add(label1);

        JLabel label2 = new JLabel("LAXMI CHIT FUND");
        label2.setFont(new Font("System", Font.BOLD, 15));
        label2.setBounds(120,20,200,20);
        add(label2);

        JLabel label3 = new JLabel();
        label3.setBounds(20,100,300,40);
        add(label3);

        JLabel label4 = new JLabel();
        label4.setBounds(20,400,300,20);
        add(label4);

        try {
            con c = new con();
            ResultSet rs = c.statement.executeQuery("Select * from login where pin_no='" + pin + "'");
            while (rs.next()) {
                label3.setText("Card No: " + rs.getString("card_no").substring(0,4) + "XXXXXXXX" + rs.getString("card_no").substring(12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            int balance = 0;
            con c = new con();
            ResultSet resultSet = c.statement.executeQuery("Select * from bank where pin='" + pin + "'");
            ArrayList<String> transactions = new ArrayList<>();

            while (resultSet.next()) {
                String transaction = resultSet.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("amount") + "<br><br>";
                transactions.add(transaction);

                if (resultSet.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }

            Collections.reverse(transactions); // Reverse the list to get latest transactions first

            StringBuilder latestTransactions = new StringBuilder("<html>");
            for (int i = 0; i < Math.min(7, transactions.size()); i++) {
                latestTransactions.append(transactions.get(i));
            }
            latestTransactions.append("</html>");

            label1.setText(latestTransactions.toString());
            label4.setText("Your Balance: " + balance);

        } catch (Exception e) {
            e.printStackTrace();
        }

        button = new JButton("Exit");
        button.setBounds(20,500,100,25);
        button.addActionListener(this);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        add(button);

        setLayout(null);
        setSize(400, 600);
        setLocation(25,20);
        getContentPane().setBackground(new Color(255,204,204));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new Mini("");
    }
}
