package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {
    JTextField textField;
    JButton b1,b2;
    String pin;
        Withdrawl( String pin) {
            this.pin = pin;
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("New folder/atm2.png"));
            Image i2=i1.getImage().getScaledInstance(1550,790, Image.SCALE_DEFAULT);
            ImageIcon i3=new ImageIcon(i2);
            JLabel l3=new JLabel(i3);
            l3.setBounds(0,0,1550,790);
            add(l3);

            JLabel l1=new JLabel("MAXIMUM WITHDRAWL IS 10,000");
            l1.setForeground(Color.white);
            l1.setFont(new Font("System", Font.BOLD, 16));
            l1.setBounds(460,165,700,35);
            l3.add(l1);

            JLabel l2=new JLabel("PLEASE ENTER YOUR AMOUNT");
            l2.setForeground(Color.white);
            l2.setFont(new Font("System", Font.BOLD, 16));
            l2.setBounds(460,210,400,35);
            l3.add(l2);

            textField=new JTextField();
            textField.setBounds(460,250,320,25);
            textField.setBackground(new Color(65,125,128));
            textField.setForeground(Color.white);
            textField.setFont(new Font("Raleway",Font.BOLD,22));
            l3.add(textField);

            b1=new JButton("WITHDRAW");
            b1.setBounds(700,345,150,35);
            b1.setBackground(new Color(65,125,128));
            b1.setForeground(Color.white);
            b1.addActionListener(this);
            l3.add(b1);

            b2=new JButton("BACK");
            b2.setBounds(700,390,150,35);
            b2.setBackground(new Color(65,125,128));
            b2.setForeground(Color.white);
            b2.addActionListener(this);
            l3.add(b2);

                setLayout(null);
                setSize(1550,830);
                setLocation(0,0);
                setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==b2) {
                setVisible(false);
                new main_Class(pin);
            }else {
            try{
        String amount=textField.getText();
           Date date=new Date();
           if(textField.getText().equals("")){
               JOptionPane.showMessageDialog(null,"Please enter the Amount you want to Withdraw");
           }else{
               con c=new con();
               ResultSet resultSet=c.statement.executeQuery("select * from bank where pin='"+pin+"'");
               int balance =0;
               while(resultSet.next()){
                   if(resultSet.getString("type").equals("Deposit")){
                       balance+=Integer.parseInt(resultSet.getString("amount"));
                   }else {
                       balance-=Integer.parseInt(resultSet.getString("amount"));
                   }
               }
               if(balance<Integer.parseInt(amount)){
                   JOptionPane.showMessageDialog(null,"Insufficient Balance");
                   return;
               }
               c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Withdrawl','"+amount+"')");
               JOptionPane.showMessageDialog(null,"Rs. "+amount+" Debited Successfully");
               setVisible(false);
               new main_Class(pin);
           }
            }catch (Exception ex){
                ex.printStackTrace();
            }

    }}

    public static void main(String[] args) {
            new Withdrawl("");
    }
}
