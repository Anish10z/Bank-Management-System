package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JLabel l3;
    JButton b1;
    String pin;
    BalanceEnquiry(String pin) {
        this.pin = pin;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("New folder/atm2.png"));
        Image i2=i1.getImage().getScaledInstance(1550, 790, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(0, 0, 1550, 790);
        add(l1);

        JLabel l2=new JLabel("Your Current Balance is Rs. ");
        l2.setFont(new Font("System",Font.BOLD,16));
        l2.setForeground(Color.WHITE);
        l2.setBounds(430,165,700,35);
        l1.add(l2);

         l3=new JLabel();
        l3.setFont(new Font("System",Font.BOLD,16));
        l3.setForeground(Color.WHITE);
        l3.setBounds(430,210,400,35);
        l1.add(l3);


        b1=new JButton("Back");
        b1.setBounds(700,390,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l1.add(b1);

        int balance =0;
        try{
            con c=new con();
            ResultSet rs=c.statement.executeQuery("Select * from bank where pin='"+pin+"'");
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                }else {
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }





        l3.setText(""+balance);

        setLayout(null);
        setSize(1550,830);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new main_Class(pin);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
