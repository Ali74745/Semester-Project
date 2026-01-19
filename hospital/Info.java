package HOSPITAL;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;


abstract class Info implements Serializable {

    private static final long serialVersionUID = -6883446537976704882L;

    protected String name;
    protected String age;
    protected String address, phoneNumber;
    protected String id;
    protected String gender;
    Info(){}
    Info(String name, String age, String address, String phoneNumber,String gender){
        this.name = name;
        this.gender=gender;
        this.age=age;
        this.address = address;
        this.phoneNumber= phoneNumber;

    }

    //Setters
    public void setName(String name){
        this.name=name;
    }
    public void setAge(String age){
        this.age=age;
    }
    public void setGender(String gender){
        this.gender=gender;
    }

    public void setAddress(String address){
        this.address=address;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber= phoneNumber;
    }

    public void setId(String id){
        this.id = id;
    }

    //Getters
    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getId() {
        return id;
    }

    //Displaying details
    public String toString() {
        return "ID: " + getId() +
                "\nName: "+ getName()+
                "\nAddress: "+ getAddress()+
                "\nAge: "+getAge()+
                "\nPhone Number: "+getPhoneNumber()+
                "\nAddress: "+ getAddress();

    }

    //Inputting Details
    public void inputDetails()
    {
        JFrame A = new JFrame("Input Information");

        A.setSize(400,500);
        A.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        A.setLayout(new BorderLayout());

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(6,2));
        p1.setBackground(Color.GRAY);
        JLabel l1 = new JLabel("Name");
        JLabel l11 = new JLabel("Gender");
        JLabel l2 = new JLabel("Age");
        JLabel l3 = new JLabel("Phone Number");
        JLabel l4 = new JLabel("Address");
        JTextField t1 = new JTextField();
        JTextField t11 = new JTextField();
        JTextField t2 = new JTextField();
        JTextField t3 = new JTextField();
        JTextField t4 = new JTextField();

        p1.add(l1);p1.add(t1);
        p1.add(l11);p1.add(t11);

        p1.add(l2);p1.add(t2);

        p1.add(l3);p1.add(t3);

        p1.add(l4);p1.add(t4);

        A.add(p1, BorderLayout.CENTER);

        JButton b1 = new JButton("Submit");
        A.add(b1,BorderLayout.SOUTH);
        A.setVisible(true);
        A.pack();

        b1.addActionListener(e -> {
            setName(t1.getText());

            setAge((t2.getText()));  //Parse ?Bro Wrapper class
            setPhoneNumber(t3.getText());
            setAddress(t4.getText());
            A.dispose();//ahahaha
        });

    }


    public void DisplayDetails(){  //Probably need downcasting to get here
        JFrame f =new JFrame();
        f.setSize(500,600);
        f.setLayout(new BorderLayout());
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        JPanel p1  = new JPanel(new GridLayout(6,2));
        JLabel l1 = new JLabel("Name");
        JLabel l11 = new JLabel("Gender");
        JLabel l2 = new JLabel("ID");
        JLabel l3 = new JLabel("Age");
        JLabel l4 = new JLabel("Phone Number");
        JLabel l5 = new JLabel("Address");

        JTextField t1= new JTextField(getName());
        JTextField t11= new JTextField(getGender());
        JTextField t2= new JTextField(getId());
        JTextField t3= new JTextField(getAge());
        JTextField t4= new JTextField(getPhoneNumber());
        JTextField t5= new JTextField(getAddress());

        p1.setBackground(Color.LIGHT_GRAY);
        p1.add(l1);
        p1.add(t1);
        p1.add(l11);
        p1.add(t11);
        p1.add(l2);
        p1.add(t2);
        p1.add(l3);
        p1.add(t3);
        p1.add(l4);
        p1.add(t4);
        p1.add(l5);
        p1.add(t5);
        f.add(p1);

        if(this instanceof Nurse){
            ((Nurse) this).DisplayDetails(f); //Bro
        }else if(this instanceof Doctor){
            ((Doctor) this).DisplayDetails(f);
        }else{
            ((Patient)this).DisplayDetails(f);
        }

    }

}
