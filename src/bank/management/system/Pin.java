package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {
    JButton b1,b2;
    JPasswordField p1,p2;
    String pin;
    Pin(String pin){
        this.pin = pin;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("New folder/atm2.png"));
        Image i2=i1.getImage().getScaledInstance(1550,790,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3=new JLabel(i3);
        l3.setBounds(0,0,1550,790);
        add(l3);

        JLabel l1=new JLabel("CHANGE YOUR PIN");
        l1.setBounds(430,180,700,35);
        l1.setFont(new Font("System",Font.BOLD,24));
        l1.setForeground(Color.white);
        l3.add(l1);

        JLabel l2=new JLabel("New PIN: ");
        l2.setBounds(430,220,400,35);
        l2.setFont(new Font("System",Font.BOLD,16));
        l2.setForeground(Color.white);
        l3.add(l2);

        p1=new JPasswordField();
        p1.setBounds(430,260,220,35);
        p1.setBackground(new Color(65,125,128));
        p1.setFont(new Font("System",Font.BOLD,16));
        p1.setForeground(Color.white);
        l3.add(p1);

        JLabel l4=new JLabel("Re-Enter New PIN: ");
        l4.setBounds(430,310,400,35);
        l4.setFont(new Font("System",Font.BOLD,16));
        l4.setForeground(Color.white);
        l3.add(l4);

        p2=new JPasswordField();
        p2.setBounds(430,350,220,35);
        p2.setBackground(new Color(65,125,128));
        p2.setFont(new Font("System",Font.BOLD,16));
        p2.setForeground(Color.white);
        l3.add(p2);

        b1=new JButton("CHANGE");
        b1.setBounds(700,352,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        l3.add(b1);

        b2=new JButton("BACK");
        b2.setBounds(700,396,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        l3.add(b2);












        setLayout(null);
        setSize(1550,1000);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String pin1=p1.getText();
            String pin2=p2.getText();
            if (!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                return;
            }
            if(e.getSource()==b1){
                if(b1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter New PIN");
                    return;

                }
                if(p2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter New PIN");
                    return;
                }

                con conn=new con();
                String q1="update  bank set pin='"+pin1+"' where pin='"+pin+"'";
                String q2="update  login set pin_no='"+pin1+"' where pin_no='"+pin+"'";
                String q3="update  signupthree set pin_no='"+pin1+"' where pin_no='"+pin+"'";
                conn.statement.executeUpdate(q1);
                conn.statement.executeUpdate(q2);
                conn.statement.executeUpdate(q3);
                JOptionPane.showMessageDialog(null,"PIN UPDATED SUCCESSFULLY");
                setVisible(false);
                new Login();
            } else if (e.getSource()==b2) {
                new main_Class(pin);
                setVisible(false);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Pin("");
    }
}
