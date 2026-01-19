package HOSPITAL;

import javax.swing.*;
import java.awt.*;


//Interface for specializations and shifts of nurses and doctors
interface Shifts {

    void assignShift(String shift);
//    void weeklyShifts(ArrayList<Nurse> Nurse);
    public void seeMyShift();
}

//Patient
class Patient extends Info {

    private static final long serialVersionUID = 2994593488537213704L; // match old UID



     static int c= 0;
    MedicalHistory m= new MedicalHistory(); //tightly bound

    //Room ki class
    //Bed ki class

    Patient(){
        id ="Patient-ID-"+(++c);
    }
    Patient(String name,String age,String address,String phoneNumber,String gender){
        super(name,age,address,phoneNumber,gender);
        id  = "Patient-ID-"+(++c);

    }




    public void inputDetails() {

        super.inputDetails();
        //Need to add medical history


        JFrame A = new JFrame("Is the patient being admitted?");

        A.setSize(400,500);
        A.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        A.setLayout(new BorderLayout());

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(5,2));
        p1.setBackground(Color.GRAY);
        JLabel l1 = new JLabel("Is the patient being admitted:(y/n)");

        JTextField t1 = new JTextField();

        p1.add(l1);p1.add(t1);



        A.add(p1, BorderLayout.CENTER);

        JButton b1 = new JButton("Submit");
        A.add(b1,BorderLayout.SOUTH);
        A.setVisible(true);
        A.pack();

        b1.addActionListener(e -> {
            if(t1.getText().equalsIgnoreCase("y")){
                m.setMedicalHistory();
                m.setVitals();
            }
            JOptionPane.showMessageDialog(null, "Information Added!", "Great", JOptionPane.INFORMATION_MESSAGE);
            A.dispose();
        });
    }


    //Bro idr patient history aur vitals wala section banao
    public void DisplayDetails(JFrame f){
        JButton b1 = new JButton("Medical Details");
        f.add(b1, BorderLayout.SOUTH);
        f.setVisible(true);
        b1.addActionListener(e -> {
            m.displayVitals();
            m.displayMedicalHistory();
        });

    }
}
