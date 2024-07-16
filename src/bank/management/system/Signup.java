package bank.management.system;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class Signup extends JFrame implements ActionListener {
    Random ran =new Random();
    long first4=(ran.nextLong()%9000L)+1000L;
    String first= " "+Math.abs(first4);

    JTextField textNamme,textFname,textEmail,textAdd,textCity,textPin,textState;
    JDateChooser dateChooser;
    JRadioButton r1,r2,r3,m1,m2,m3;
    JButton next;

    Signup(){
        super("APPLICATION FORM");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("New folder/bank.png"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(25,10,100,100);
        add(image);

        JLabel label1=new JLabel("APPLICATION FORM NO."+first);
        label1.setBounds(160,20,600,40);
        label1.setFont(new Font("Raleway",Font.BOLD,38));
        add(label1);

        JLabel label2=new JLabel("Page 1");
        label2.setFont(new Font("Raleway",Font.BOLD,22));
        label2.setBounds(380,70,600,30);
        add(label2);

        JLabel label3=new JLabel("Personal Details");
        label3.setFont(new Font("Raleway",Font.BOLD,22));
        label3.setBounds(335,100,600,30);
        add(label3);

        JLabel labelName=new JLabel("Name :");
        labelName.setFont(new Font("Raleway",Font.BOLD,20));
        labelName.setBounds(100,190,100,30);
        add(labelName);

        textNamme=new JTextField();
        textNamme.setFont(new Font("Raleway",Font.BOLD,14));
        textNamme.setBounds(300,190,400,30);
        add(textNamme);

        JLabel labelFname=new JLabel("Father's Name :");
        labelFname.setFont(new Font("Raleway",Font.BOLD,20));
        labelFname.setBounds(100,240,200,30);
        add(labelFname);

        textFname=new JTextField();
        textFname.setFont(new Font("Raleway",Font.BOLD,14));
        textFname.setBounds(300,240,400,30);
        add(textFname);

        JLabel labelDOB=new JLabel("Date of Birth :");
        labelDOB.setFont(new Font("Raleway",Font.BOLD,20));
        labelDOB.setBounds(100,290,250,30);
        add(labelDOB);

        dateChooser=new JDateChooser();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(300,290,200,30);
        add(dateChooser);

        JLabel labelgen=new JLabel("Gender");
        labelgen.setFont(new Font("Raleway",Font.BOLD,20));
        labelgen.setBounds(100,340,200,30);
        add(labelgen);

        r1=new JRadioButton("Male");
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        r1.setBackground(new Color(222,255,228));
        r1.setBounds(300,340,60,30);
        add(r1);

        r2=new JRadioButton("Female");
        r2.setFont(new Font("Raleway",Font.BOLD,14));
        r2.setBackground(new Color(222,255,228));
        r2.setBounds(370,340,80,30);
        add(r2);

        r3=new JRadioButton("Others");
        r3.setFont(new Font("Raleway",Font.BOLD,14));
        r3.setBackground(new Color(222,255,228));
        r3.setBounds(460,340,80,30);
        add(r3);

        ButtonGroup buttonGroup= new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        buttonGroup.add(r3);


        JLabel labelEmail=new JLabel("Email :");
        labelEmail.setFont(new Font("Raleway",Font.BOLD,20));
        labelEmail.setBounds(100,390,200,30);
        add(labelEmail);

        textEmail=new JTextField();
        textEmail.setFont(new Font("Raleway",Font.BOLD,14));
        textEmail.setBounds(300,390,400,30);
        add(textEmail);

        JLabel labelMsg=new JLabel("Marital Status :");
        labelMsg.setFont(new Font("Raleway",Font.BOLD,20));
        labelMsg.setBounds(100,440,250,30);
        add(labelMsg);

        m1=new JRadioButton("Married");
        m1.setFont(new Font("Raleway",Font.BOLD,14));
        m1.setBackground(new Color(222,255,228));
        m1.setBounds(300,440,80,30);
        add(m1);

        m2=new JRadioButton("Unmarried");
        m2.setFont(new Font("Raleway",Font.BOLD,14));
        m2.setBackground(new Color(222,255,228));
       m2.setBounds(385,440,100,30);
       add(m2);

        m3=new JRadioButton("Others");
        m3.setFont(new Font("Raleway",Font.BOLD,14));
        m3.setBackground(new Color(222,255,228));
        m3.setBounds(485,440,80,30);
        add(m3);

       ButtonGroup buttonGroup2= new ButtonGroup();
       buttonGroup2.add(m1);
       buttonGroup2.add(m2);
       buttonGroup2.add(m3);

        JLabel labeladdr=new JLabel("Address :");
        labeladdr.setFont(new Font("Raleway",Font.BOLD,20));
        labeladdr.setBounds(100,490,200,30);
        add(labeladdr);

        textAdd=new JTextField();
        textAdd.setFont(new Font("Raleway",Font.BOLD,14));
        textAdd.setBounds(300,490,400,30);
        add(textAdd);

        JLabel labelcity=new JLabel("City :");
        labelcity.setFont(new Font("Raleway",Font.BOLD,20));
        labelcity.setBounds(100,540,200,30);
        add(labelcity);

        textCity=new JTextField();
        textCity.setFont(new Font("Raleway",Font.BOLD,14));
        textCity.setBounds(300,540,400,30);
        add(textCity);

        JLabel labelpin=new JLabel("PIN Code :");
        labelpin.setFont(new Font("Raleway",Font.BOLD,20));
        labelpin.setBounds(100,590,200,30);
        add(labelpin);

        textPin=new JTextField();
        textPin.setFont(new Font("Raleway",Font.BOLD,14));
        textPin.setBounds(300,590,200,30);
        add(textPin);

        JLabel labelstate=new JLabel("State :");
        labelstate.setFont(new Font("Raleway",Font.BOLD,20));
        labelstate.setBounds(100,640,200,30);
        add(labelstate);

        textState=new JTextField();
        textState.setFont(new Font("Raleway",Font.BOLD,14));
        textState.setBounds(300,640,400,30);
        add(textState);

        next=new JButton("Next");
        next.setFont(new Font("Ralewy",Font.BOLD,14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,710,80,30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(new Color(222,255,228));
        setLayout(null);
        setSize(850,800);
        setLocation(360,15);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String formno=first;
        String name=textNamme.getText();
        String fname=textFname.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(r1.isSelected()){
            gender="Male";
        }else if(r2.isSelected()){
            gender="Female";
        }else if(r3.isSelected()){
            gender="Other";
        }
        String email=textEmail.getText();
        String marital=null;
        if(m1.isSelected()){
            marital="Married";
        }else if(m2.isSelected()){
            marital="Unmarried";
        }else if(m3.isSelected()){
            marital="Other";
        }
        String addr=textAdd.getText();
        String city=textCity.getText();
        String pincode=textPin.getText();
        String state=textState.getText();
        try{
        if(textNamme.getText().equals("")||textFname.getText().equals("")||((JTextField)dateChooser.getDateEditor().getUiComponent()).getText().equals("")||gender==null||textEmail.getText().equals("")||marital==null||textAdd.getText().equals("")||textCity.getText().equals("")||textPin.getText().equals("")||textState.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Fill all the fields!");
        }else{
            con con1=new con();
            String q="Insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+addr+"','"+city+"','"+pincode+"','"+state+"')";
            con1.statement.executeUpdate(q);
            new Signup2(formno);
            setVisible(false);
        }
        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
