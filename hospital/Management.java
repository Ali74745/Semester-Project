package HOSPITAL;


import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

class Management {
    //Menu in management class, asks for a password,
    // if password matches the password of the admin,
    // hand him powers of admin and let them add doctors
    // and nurses and patients, see and alter details of all the people,
    // if the password matches that of a doctor, let them see the patient details(vitals and med history only)
    // and doctor schedule, if the password matches nurses'(vitals and med history only),
    // let them see the patient details and nurses schedule

//
//    public static Patient searchPatients(ArrayList<Patient> p, String nameORid){
//        for(Patient patient: p){
//            if(patient.getName().equalsIgnoreCase(nameORid) || (patient.getId().equalsIgnoreCase(nameORid))){
//                return patient;
//            }
//        }
//        return null;
//    }
//
//    public static Nurse searchNurses(ArrayList<Nurse> n, String nameORid){
//        for(Nurse nurse: n){
//            if(nurse.getName().equalsIgnoreCase(nameORid) || (nurse.getId().equalsIgnoreCase(nameORid))){
//                return nurse;
//            }
//        }
//        return null;
//    }
//
//    public static Doctor searchDoctor(ArrayList<Doctor> d, String nameORid){
//        for(Doctor doctor: d){
//            if(doctor.getName().equalsIgnoreCase(nameORid) || (doctor.getId().equalsIgnoreCase(nameORid))){
//                return doctor;
//            }
//        }
//        return null;
//    }


    public static Patient searchPatients(ArrayList<Patient> p, String nameORid) {
        for (Patient patient : p) {
            if ((patient.getName()!= null&&patient.getName().equalsIgnoreCase(nameORid)) ||
                    (patient.getId()!= null&&patient.getId().equalsIgnoreCase(nameORid))) {
                return patient;
            }
        }
        return null;
    }

    public static Nurse searchNurses(ArrayList<Nurse> n, String nameORid) {
        for (Nurse nurse : n) {
            if ((nurse.getName()!=null &&nurse.getName().equalsIgnoreCase(nameORid)) ||
                    (nurse.getId()!=null &&nurse.getId().equalsIgnoreCase(nameORid))) {
                return nurse;
            }
        }
        return null;
    }

    public static Doctor searchDoctor(ArrayList<Doctor> d, String nameORid) {
        for (Doctor doctor : d) {
            if ((doctor.getName() != null && doctor.getName().equalsIgnoreCase(nameORid)) ||
                    (doctor.getId() != null && doctor.getId().equalsIgnoreCase(nameORid))) {
                return doctor;
            }
        }
        return null;
    }


    //All static values need to be up to date
    public static void setStaticsBack(ArrayList<Patient> p, ArrayList<Doctor> d, ArrayList<Nurse> n){
            int a = p.get( p.size ()-1).c;
            Patient.c=a;

            int a1 = d.get(d.size() -1).c;
            Doctor.c=a1;

            int a2 = n.get(n.size()-1).c;
            Nurse.c =a2 ;

    }


    public static void showAdminMenu() {
        JFrame A = new JFrame("Admin");
        A.setVisible(true);
        A.setSize(1500, 900);
        A.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        A.setLayout(new GridLayout(5, 1));

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

//        p1.setBackground(Color.GRAY);
//        p2.setBackground(Color.GRAY);
//        p3.setBackground(Color.GRAY);

        JRadioButton r1 = new JRadioButton("Add a New Patient");
        JRadioButton r2 = new JRadioButton("View Patient Details");
        JRadioButton r4 = new JRadioButton("View Doctor Details");
        JRadioButton r3 = new JRadioButton("View Nurse Details");


        p1.add(r2);
        p1.add(r3);
        p1.add(r4);


        JRadioButton r5 = new JRadioButton("Add a New Nurse");
        JRadioButton r6 = new JRadioButton("Add a New Doctor");
        JRadioButton r7 = new JRadioButton("Remove Nurse");
        JRadioButton r8 = new JRadioButton("Remove Doctor");
        JRadioButton r9 = new JRadioButton("Discharge a Patient");

        p2.add(r1);
        p2.add(r5);
        p2.add(r6);
        p3.add(r7);
        p3.add(r8);
        p3.add(r9);

        ButtonGroup b = new ButtonGroup();
        b.add(r1);
        b.add(r2);
        b.add(r3);
        b.add(r4);
        b.add(r5);
        b.add(r6);
        b.add(r7);
        b.add(r8);
        b.add(r9);

        JLabel label = new JLabel("Welcome Back", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 36));

        A.add(label);
        A.add(p1, BorderLayout.CENTER);
        A.add(p2, BorderLayout.CENTER);
        A.add(p3, BorderLayout.CENTER);

        JButton b1 = new JButton("Next");
        JButton b2 = new JButton("Save");


        //-------------------------------------------

//background image
        JPanel backgroundPanel = new JPanel() {
            Image bg = new ImageIcon(getClass().getResource("bg.jpg")).getImage();


            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new GridLayout(5, 1));

        p1.setOpaque(false);
        p2.setOpaque(false);
        p3.setOpaque(false);
        label.setOpaque(false);

        backgroundPanel.add(label);
        backgroundPanel.add(p1);
        backgroundPanel.add(p2);
        backgroundPanel.add(p3);
//        backgroundPanel.add(b1, BorderLayout.SOUTH);
//        backgroundPanel.add(b2, BorderLayout.SOUTH);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setOpaque(false);
        bottomPanel.add(b1);
        bottomPanel.add(b2);

        backgroundPanel.add(bottomPanel);

        A.setContentPane(backgroundPanel);



        //------------------------------------------------------------


//        A.pack();

        b1.addActionListener(e -> {
            if (r1.isSelected()) {
                addPatient();

            } else if (r2.isSelected()) {
                displayNurseOrDoctorOrPatientDetails(3);
            } else if (r3.isSelected()) {
                displayNurseOrDoctorOrPatientDetails(1); //1 or 2 decides if nurse is called or doc
            } else if (r4.isSelected()) {
                displayNurseOrDoctorOrPatientDetails(2);
            } else if (r5.isSelected()) {
                addNurse();
            } else if (r6.isSelected()) {
                addDoctor();
            } else if (r7.isSelected()) {
                removeNurseOrDoctorOrPatient(1);//Put in place in order to restrict the number of functions
                // bro remove nurses aur doctors ka jo case ha if key sath krlo
            } else if (r8.isSelected()) {
                removeNurseOrDoctorOrPatient(2);
            } else if (r9.isSelected()) {
                removeNurseOrDoctorOrPatient(3);
            }

        });

        b2.addActionListener(e -> {
            try {
                saveData(patientList,doctorList,nurseList);
                JOptionPane.showMessageDialog(null, "Saved Successfully");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public static void showNurseMenu(Nurse N) {
        JFrame A = new JFrame("Nurse Portal");
        A.setVisible(true);
        A.setSize(1300, 900);
        A.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        A.setLayout(new GridLayout(1, 1));

        JPanel p1 = new JPanel();


//        p1.setBackground(Color.GRAY);
        p1.setLayout(new GridLayout(7, 2));

        JRadioButton r1 = new JRadioButton("View Patient History(Enter Patient ID)");
        JRadioButton r2 = new JRadioButton("View Patient Vitals(Enter Patient ID)");
        JRadioButton r3 = new JRadioButton("View My Shift");
        JRadioButton r4 = new JRadioButton("Weekly Schedule");
        JRadioButton r5 = new JRadioButton("Input Vitals(Patient ID)");
        JRadioButton r6 = new JRadioButton("Input Medical History(Patient ID)");


        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JTextField t3 = new JTextField();
        JTextField t4 = new JTextField();


        ButtonGroup b = new ButtonGroup();
        b.add(r1);
        b.add(r2);
        b.add(r5);
        b.add(r6);
        b.add(r3);
        b.add(r4);


        p1.add(r1);
        p1.add(t1);
        p1.add(r2);
        p1.add(t2);
        p1.add(r5); //Input vitals h
        p1.add(t3);
        p1.add(r6); //Input medical history
        p1.add(t4);


        p1.add(r3);
        p1.add(r4);


        //------------------------------------------------


        JPanel backgroundPanel = new JPanel() {
            Image bg = new ImageIcon(getClass().getResource("corridor.jpg")).getImage();


            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new GridLayout(2, 1)); // adjust as needed


//        A.add(p1, BorderLayout.CENTER);


//        JButton b1 = new JButton("Submit");
//        A.add(b1,BorderLayout.SOUTH);
//        A.pack();

        backgroundPanel.add(p1);
        A.setContentPane(backgroundPanel);

        JButton b1 = new JButton("Next");
        JButton b2 = new JButton("Save");
        p1.add(b1, new BorderLayout(50, 50));
        p1.add(b2, new BorderLayout(50, 50));
        p1.setOpaque(false);
        //----------------------------------


//        A.pack();
        b1.addActionListener(e -> {
            if (r1.isSelected()) {
                Patient p = searchPatients(patientList, t1.getText());
                if (p == null) {
                    JOptionPane.showMessageDialog(null, "No Patient with this name or ID");

                } else {
                    p.m.displayMedicalHistory();
                }
//                p.showMedicalHistory();
            } else if (r2.isSelected()) {
                Patient p = searchPatients(patientList, t2.getText());
                if (p == null) {
                    JOptionPane.showMessageDialog(null, "No Patient with this name or ID");

                } else {
                    p.m.displayVitals();
                }
//             patient vitals

            } else if (r3.isSelected()) {

                N.AssignShiftsToAll(nurseList);
                N.seeMyShift();
//              mein shift
            } else if (r4.isSelected()) {

                N.AssignShiftsToAll(nurseList);
                N.weeklyShifts(nurseList);
//             weekly shift
            } else if (r5.isSelected()) {
                Patient p = searchPatients(patientList, t3.getText());
                if (p == null) {
                    JOptionPane.showMessageDialog(null, "No Patient with this name or ID");

                } else {
                    p.m.setVitals();

                }

            } else if (r6.isSelected()) {
                Patient p = searchPatients(patientList, t4.getText());
                if (p == null) {
                    JOptionPane.showMessageDialog(null, "No Patient with this name or ID");

                } else {
                    p.m.setMedicalHistory();

                }

            }

        });

        b2.addActionListener(e -> {
            try {
                saveData(patientList,doctorList,nurseList);
                JOptionPane.showMessageDialog(null,"Saved Successfully!");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }


    public static void showDoctorMenu(Doctor d) {
        JFrame A = new JFrame("Doctor Portal");
        A.setVisible(true);
        A.setSize(1400, 900);
        A.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        A.setLayout(new GridLayout(5, 1));

        JPanel p1 = new JPanel();

        p1.setBackground(Color.GRAY);
        p1.setLayout(new GridLayout(4, 2));

        JRadioButton r1 = new JRadioButton("View Patient History");
        JRadioButton r2 = new JRadioButton("View Patient Vitals");
        JRadioButton r3 = new JRadioButton("Weekly Schedule");
        JRadioButton r4 = new JRadioButton("View My Shift");


        ButtonGroup b = new ButtonGroup();
        b.add(r1);
        b.add(r2);
        b.add(r3);
        b.add(r4);

        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();


        p1.add(r1);
        p1.add(t1);
        p1.add(r2);
        p1.add(t2);
        p1.add(r3);
        p1.add(r4);

        //------------------------------------------------


        JPanel backgroundPanel = new JPanel() {
            Image bg = new ImageIcon(getClass().getResource("corridor.jpg")).getImage();


            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new GridLayout(2, 1)); // adjust as needed


//        A.add(p1, BorderLayout.CENTER);


//        JButton b1 = new JButton("Submit");
//        A.add(b1,BorderLayout.SOUTH);
//        A.pack();

        backgroundPanel.add(p1);
        A.setContentPane(backgroundPanel);

        JButton b1 = new JButton("Next");
        JButton b2 = new JButton("Save");
        p1.add(b1, new BorderLayout(50, 50));
        p1.add(b2, new BorderLayout(50, 50));
        p1.setOpaque(false);
        //----------------------------------

        A.add(p1, BorderLayout.CENTER);


//        A.pack();

        b1.addActionListener(e -> {
            if (r1.isSelected()) {
                Patient p = searchPatients(patientList, t1.getText());
                if (p != null) {
                    p.m.displayMedicalHistory();
                }
            } else if (r2.isSelected()) {
                Patient p = searchPatients(patientList, t2.getText());
                if (p != null) {
                    p.m.displayVitals();
                }
//             patient vitals

            } else if (r3.isSelected()) {

                d.AssignShiftsToAll(doctorList);
                d.weeklyShifts(doctorList);

//              my shift
            } else if (r4.isSelected()) {
                d.AssignShiftsToAll(doctorList);
                d.seeMyShift();
//             weekly shift
            }
        });

        b2.addActionListener(e -> {
            try {
                saveData(patientList,doctorList,nurseList);
                JOptionPane.showMessageDialog(null,"Saved Successfully!");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }


    //adding new objects
    //Patient?
    public static void addNurse() {
        Nurse n = new Nurse();
        n.inputDetails();
        nurseList.add(n);
        n.AssignShiftsToAll(nurseList);


    }

    public static void addDoctor() {
        Doctor d = new Doctor();
        d.inputDetails();
        doctorList.add(d);
        d.AssignShiftsToAll(doctorList);


    }

    public static void addPatient() {
        Patient p = new Patient();
        p.inputDetails();
        patientList.add(p);
//        try {
//            saveData(patientList, doctorList, nurseList); wont work
//        } catch (IOException e1) {
//            throw new RuntimeException(e1);
//        }


    }


    public static void removeNurseOrDoctorOrPatient(int d) {
        JFrame f = new JFrame();
        f.setSize(200, 100);
        f.setLayout(new BorderLayout());
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);

        JPanel p1 = new JPanel(new GridLayout(1, 2));
        JLabel l1 = new JLabel("Name/ID");
        JTextField t1 = new JTextField();

        p1.add(l1);
        p1.add(t1);

        f.add(p1, BorderLayout.NORTH);

        JButton b1 = new JButton("Submit");
        f.add(b1);
//            f.pack();

        b1.addActionListener(e -> {
            if (d==1) {
                Nurse n = searchNurses(nurseList, t1.getText());  //bhai exceptions b lagani idr to
                if (n== null) {
                    JOptionPane.showMessageDialog(null, "No Nurse with this name or ID");
                } else {
                    JOptionPane.showMessageDialog(null, "Data of Nurse " + n.getName() + " and " + n.getId() + " deleted successfully");
                    f.dispose();
                    nurseList.remove(n);
                }
            } else if (d==2) {
                Doctor b = searchDoctor(doctorList, t1.getText());
                if (b == null) {
                    JOptionPane.showMessageDialog(null, "No Doctor with this name or ID");
                } else {
                    JOptionPane.showMessageDialog(null, "Data of Doctor " + b.getName() + " and " + b.getId() + " deleted successfully");
                    f.dispose();
                    doctorList.remove(b);
                }
            } else if (d==3) {
                Patient p = searchPatients(patientList, t1.getText());
                if (p == null) {
                    JOptionPane.showMessageDialog(null, "No Patient with this name or ID");
                } else {
                    JOptionPane.showMessageDialog(null, "Data of " + p.getName() + " and " + p.getId() + " deleted successfully");
                    f.dispose();
                    patientList.remove(p);
                }
            }



        });
    }


    public static void displayNurseOrDoctorOrPatientDetails(int d) {  //Quite similar to the remove method as idk how to find a nurse and return it thru gui
        JFrame f = new JFrame();
        f.setSize(500, 600);
        f.setLayout(new BorderLayout());
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);

        JPanel p1 = new JPanel(new GridLayout(1, 2));
        JLabel l1 = new JLabel("Name/ID");
        JTextField t1 = new JTextField();

        p1.add(l1);
        p1.add(t1);

        f.add(p1, BorderLayout.NORTH);

        JButton b1 = new JButton("Submit");
        f.add(b1);
        f.pack();

        b1.addActionListener(e -> {
            if (d == 1) {
                Nurse n = searchNurses(nurseList, t1.getText());
                if (n == null) {
                    JOptionPane.showMessageDialog(null, "No Nurse with this name or ID");
                } else {
                    n.DisplayDetails();
                    f.dispose();
                }
            } else if (d == 2) {
                Doctor b = searchDoctor(doctorList, t1.getText());
                if (b == null) {
                    JOptionPane.showMessageDialog(null, "No Doctor with this name or ID");
                } else {
                    b.DisplayDetails();
                    f.dispose();
                }
            } else {
                Patient p = searchPatients(patientList, t1.getText());
                if (p == null) {
                    JOptionPane.showMessageDialog(null, "No Patient with this name or ID");
                } else {
                    p.DisplayDetails();
                    f.dispose();
                }
            }
        });


    }


    public static void main(String[] args) throws Exception {


        getData();

        setStaticsBack(patientList,doctorList,nurseList); //good

        nurseList.get(0).AssignShiftsToAll(nurseList); //code ma bar bar zarort par rhi
        doctorList.get(0).AssignShiftsToAll(doctorList);

        JFrame f = new JFrame("Hospital");
        f.setSize(900, 600);
        f.setLayout(new BorderLayout());
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel p1 = new JPanel(new GridLayout(2, 2));
        p1.setOpaque(false);

        JLabel l1 = new JLabel("Username");
        JLabel l2 = new JLabel("Password");

        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();


        JButton b1 = new JButton("Submit");


        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);

        f.add(p1, BorderLayout.CENTER);
        f.add(b1, BorderLayout.SOUTH);


//        JButton b1a = new JButton("Wanna book an Appointment with us?");
//        b1a.setPreferredSize(new Dimension(10,10));
//        b1a.setOpaque(false);
//
//        p1.add(b1a, BorderLayout.CENTER);
        p1.setOpaque(false);
        f.add(p1,BorderLayout.WEST);


        // ------------------------------------------------

        JPanel bg = new JPanel() {
            Image img = new ImageIcon(
                    Objects.requireNonNull(Management.class.getResource("/HOSPITAL/bg.jpg"))
            ).getImage();


            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };

// Set layout and content pane
        bg.setLayout(new BorderLayout());
        f.setContentPane(bg);

// Add the login panel and button
        bg.add(p1, BorderLayout.CENTER);
        bg.add(b1, BorderLayout.SOUTH);

        // --------------------------------------------------

        f.setVisible(true);

        //Finding me my object
        b1.addActionListener(e -> {

            if (t1.getText().equalsIgnoreCase("admin") && t2.getText().equals("123")) {
                f.dispose();
                showAdminMenu();

            } else if (t1.getText().equalsIgnoreCase("doc")) {
                Doctor d = searchDoctor(doctorList, t2.getText());
                if (d != null) {
                    f.dispose();
                    showDoctorMenu(d);
                }
            } else if (t1.getText().equalsIgnoreCase("nur")) {
                Nurse n = searchNurses(nurseList, t2.getText());
                if (n != null) {
                    f.dispose();
                    showNurseMenu(n);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Wrong Username or Password");
            }
        });



    }

    //New Problem,static counter is not saved



    //Saving and getting data
    public static void saveData(ArrayList<Patient> p, ArrayList<Doctor> d, ArrayList<Nurse> n) throws IOException {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("List.ser"));
            out.writeObject(p);
            out.close();
            ObjectOutputStream out1 = new ObjectOutputStream(new FileOutputStream("List1.ser"));
            out1.writeObject(d);
            out1.close();

            ObjectOutputStream out2 = new ObjectOutputStream(new FileOutputStream("List2.ser"));
            out2.writeObject(n);
            out2.close();
    }

    public static void getData() throws IOException, ClassNotFoundException {

            FileInputStream f2= new FileInputStream("List.ser");
            ObjectInputStream i = new ObjectInputStream(f2);

            patientList = (ArrayList<Patient>) i.readObject();
            i.close();
            f2.close();


            FileInputStream f = new FileInputStream("List1.ser");

            ObjectInputStream i1 = new ObjectInputStream(f);

            doctorList = (ArrayList<Doctor>) i1.readObject();
            i1.close(); f.close();


            FileInputStream f3= new FileInputStream("List2.ser");
            ObjectInputStream i2 = new ObjectInputStream(f3);

            nurseList = (ArrayList<Nurse>) i2.readObject();
            i2.close();f3.close();


    }


    //Had to put them in the class instead of main in order to make them accessible to all
    static ArrayList<Nurse> nurseList = new ArrayList<Nurse>();
    static ArrayList<Patient> patientList = new ArrayList<Patient>();
    static ArrayList<Doctor> doctorList = new ArrayList<Doctor>();

    static {
        patientList.add(new Patient("Alice", "25", "123 Main St", "555-1234", "Male"));
        patientList.add(new Patient("Bob", "30", "456 Oak St", "555-5678", "Male"));
        patientList.add(new Patient("Charlie", "40", "789 Pine St", "555-9012", "Male"));


        doctorList.add(new Doctor("Smith", "45", "101 Maple St", "555-1111","Cardiology", "Male"));
        doctorList.add(new Doctor("Jones", "38", "202 Elm St", "555-2222","Neurology", "Male"));


        nurseList.add(new Nurse("Nina", "28", "12 First St", "555-3333","male", "ICU"));
        nurseList.add(new Nurse("Nick", "32", "34 Second St", "555-4444","male", "Pediatrics"));
        nurseList.add(new Nurse("Nora", "26", "56 Third St", "555-5555","male", "ER"));
    }
}
//THE PROBLEMS
// 1.GUI WON'T RETURN OBJECTS
// 2.DATABASE OR FILING? filing.
// 3.MAKING RELATION BETWEEN MANAGEMENT AND MEDICAL HISTORY? HOW TO STORE MEDICAL HISTORY ALONG WITH PATIENT ARRAYLIST? Easy

//Things needed to be done today

//1. Polish Password , DONE.
//2. Add an add nurse and add doctor method ,DONE.
//3. Make a button for appointment
//4. Add a background picture, Done.
//5. Delete a nurse and doctor , DONE.
//6. Discharge a patient Done.