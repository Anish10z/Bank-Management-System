package bank.management.system;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_Class extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    main_Class(String pin){
  this.pin = pin;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("New folder/atm2.png"));
        Image i2=i1.getImage().getScaledInstance(1550,790, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3=new JLabel(i3);
        l3.setBounds(0,0,1550,790);
        add(l3);

        JLabel l1=new JLabel("Please Select Your Transaction");
        l1.setBounds(430,180,700,35);
        l1.setForeground(Color.white );
        l1.setFont(new Font("System",Font.BOLD,28));
        l3.add(l1);

        b1=new JButton("DEPOSIT");
        b1.setForeground(Color.white);
        b1.setBackground(new Color(65,125,128));
        b1.setBounds(410,255,150,35);
        b1.addActionListener(this);
        l3.add(b1);

        b2=new JButton("CASH WITHDRAWL");
        b2.setForeground(Color.white);
        b2.setBackground(new Color(65,125,128));
        b2.setBounds(700,255,150,35);
        b2.addActionListener(this);
        l3.add(b2);

        b3=new JButton("FAST CASH");
        b3.setForeground(Color.white);
        b3.setBackground(new Color(65,125,128));
        b3.setBounds(410,300,150,35);
        b3.addActionListener(this);
        l3.add(b3);

        b4=new JButton("MINI STATEMENT");
        b4.setForeground(Color.white);
        b4.setBackground(new Color(65,125,128));
        b4.setBounds(700,300,150,35);
        b4.addActionListener(this);
        l3.add(b4);

        b5=new JButton("PIN CHANGE");
        b5.setForeground(Color.white);
        b5.setBackground(new Color(65,125,128));
        b5.setBounds(410,345,150,35);
        b5.addActionListener(this);
        l3.add(b5);

        b6=new JButton("BALANCE ENQUIRY");
        b6.setForeground(Color.white);
        b6.setBackground(new Color(65,125,128));
        b6.setBounds(700,345,150,35);
        b6.addActionListener(this);
        l3.add(b6);

        b7=new JButton("EXIT");
        b7.setForeground(Color.white);
        b7.setBackground(new Color(65,125,128));
        b7.setBounds(700,390,150,35);
        b7.addActionListener(this);
        l3.add(b7);


        setLayout(null);
        setSize(1550,1000);
        setLocation(0,0);
        //setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            new Deposit(pin);
            setVisible(false);
        } else if (e.getSource()==b7) {
            System.exit(0);
        } else if (e.getSource()==b2) {
            new Withdrawl(pin);
            setVisible(false);
        }else if (e.getSource()==b6) {
            new BalanceEnquiry(pin);
            setVisible(false);
        } else if (e.getSource()==b3) {
            new FastCash(pin);
            setVisible(false);
        } else if (e.getSource()==b5) {
            new Pin(pin);
            setVisible(false);
        } else if (e.getSource()==b4) {
            new Mini(pin);


        }
    }

    public static void main(String[] args) {
        new main_Class("");
    }
}
