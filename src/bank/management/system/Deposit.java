package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String pin;
    JTextField textField;
    JButton b1,b2;
    Deposit(String pin){

        this.pin = pin;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("New folder/atm2.png"));
        Image i2=i1.getImage().getScaledInstance(1550,790, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3=new JLabel(i3);
        l3.setBounds(0,0,1550,790);
        add(l3);

        JLabel l1=new JLabel("ENTER AMOUNT YOUN WANT TO DEPOSIT");
        l1.setForeground(Color.white);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(460,165,400,35);
        l3.add(l1);

        textField=new JTextField();
        textField.setBounds(460,215,320,25);
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.white);
        textField.setFont(new Font("Raleway",Font.BOLD,22));
        l3.add(textField);

        b1=new JButton("Deposit");
        b1.setBounds(700,352,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        l3.add(b1);

        b2=new JButton("Back");
        b2.setBounds(700,396,150,35);
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
        try {


    String amount =textField.getText();
    Date date =new Date();
    if(e.getSource()==b1){
        if(textField.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter the Amount you want to Deposit");
        }else{
            con c=new con();
            String q="Insert  into bank values('"+pin+"','"+date+"','Deposit','"+amount+"')";
            c.statement.executeUpdate(q);
            JOptionPane.showMessageDialog(null,"Rs. "+amount+" Deposited Successfully");
            new main_Class(pin);
            setVisible(false);
        }
    } else if (e.getSource()==b2) {
        new main_Class(pin);
        setVisible(false);
    }
        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
