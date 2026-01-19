package HOSPITAL;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


class Doctor extends Info implements Shifts {
    private static final long serialVersionUID = 7729971471872439392L;



    private String specialization;
    static int c = 0;
    private String shift;

    Doctor() {
        id = "Doctor-ID" + ++c;
    }

    Doctor(String name, String age, String address, String phoneNumber, String specialization,String gender) {
        super(name, age, address, phoneNumber,gender);
        this.specialization = specialization;
        id = "Doctor-ID" + ++c;
    }

    public void setSpecialization(String s){
        specialization = s;
    }
    public String getSpecialization(){
        return specialization;
    }

    public void inputDetails() {
        super.inputDetails();
        JFrame A = new JFrame("Further Information");

        A.setSize(400,500);
        A.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        A.setLayout(new BorderLayout());

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(5,2));
        p1.setBackground(Color.GRAY);
        JLabel l1 = new JLabel("Specialization");

        JTextField t1 = new JTextField();

        p1.add(l1);p1.add(t1);



        A.add(p1, BorderLayout.CENTER);

        JButton b1 = new JButton("Submit");
        A.add(b1,BorderLayout.SOUTH);
        A.setVisible(true);
        A.pack();

        b1.addActionListener(e -> {
            this.setSpecialization(t1.getText());
            JOptionPane.showMessageDialog(null, "Doctor Added!", "Great", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    // Shift methods
    public void assignShift(String shift) { this.shift = shift; }
    public String getShift() { return shift; }


    public void DisplayDetails(JFrame f){
        JLabel l1 = new JLabel("Specialization");
        JTextField t1  = new JTextField(getSpecialization());
        JLabel l2 = new JLabel("Shift");
        JTextField t2  = new JTextField(getShift());

        JPanel p1 = new JPanel(new GridLayout(2,2));
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        f.add(p1, BorderLayout.SOUTH);

        f.setVisible(true);

    }



    public void weeklyShifts(ArrayList<Doctor> doctor) {
        String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        JFrame f = new JFrame("Weekly Shifts");
        f.setSize(400, 500);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLayout(new BorderLayout());
        f.setBackground(Color.cyan);



        String schedule = "";


        for(int d =0; d< 7; d++){
            schedule =  schedule + "-----------"+ weekdays[d]+"----------\n";
            for(int i =0; i<doctor.size(); i++){
                schedule = schedule + (doctor.get(i).getName() + "-" + doctor.get(i).getId() + "-"+ doctor.get(i).getShift()) + "\n";
            }
        }
        JTextArea t1 =new JTextArea(schedule);


        t1.setBackground(new Color(200,130,250));
        JScrollPane pane = new JScrollPane(t1);
        pane.setBackground(new Color(190,170,250));
        f.add(pane);
        f.setVisible(true);
    }



    public void AssignShiftsToAll(ArrayList<Doctor> doctors){
        String[] shifts = {"Morning", "Evening", "Night"};
        int y;
        for(int i=0; i< doctors.size() ; i++){
            y = i%3; //Keeps the values between 0,2
            String currentShift = shifts[y];
            doctors.get(i).assignShift(currentShift);
        }
    }



    public void seeMyShift() {
        JFrame f =new JFrame();
        f.setSize(500,100);
        f.setLayout(new BorderLayout());
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

//        String myShift = getName() +"-"+getId()+"-"+getShift() ;
//        JLabel l1 = new JLabel(myShift);
        JLabel l1 = new JLabel(getName() +"-"+getId()+"-"+getShift()+ "Shift", SwingConstants.CENTER);
        l1.setFont(new Font("Arial", Font.BOLD, 24));
        l1.setOpaque(true);
        l1.setBackground(new Color(200,130,250));

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(190,170,250));
        p1.add(l1,Component.CENTER_ALIGNMENT);

        f.add(p1, BorderLayout.CENTER);
        f.setVisible(true);

    }


}
