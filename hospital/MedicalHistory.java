package HOSPITAL;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class MedicalHistory implements Serializable {

    private static final long serialVersionUID = -626558669858659422L;


    private String gender;
    private String pastDisease ;
    private String pastAllergy ;
    private String pastsurgery ;
    private String pastmeds ;
    private String currentDisease;
    private String currentAllergy;
    private String currentsurgery;
    private String currentmeds;
    private String bp;
    private String pulse;
    private String sugar;
    private String weight;
    private String Temperature;

    public MedicalHistory() {}

    // Setters
    public void setGender(String gender) { this.gender = gender; }
    public void setPastDisease(String pastDisease) { this.pastDisease = pastDisease; }
    public void setPastAllergy(String pastAllergy) { this.pastAllergy = pastAllergy; }
    public void setPastsurgery(String pastsurgery) { this.pastsurgery = pastsurgery; }
    public void setPastmeds(String pastmeds) { this.pastmeds = pastmeds; }
    public void setCurrentDisease(String currentDisease) { this.currentDisease = currentDisease; }
    public void setCurrentAllergy(String currentAllergy) { this.currentAllergy = currentAllergy; }
    public void setCurrentsurgery(String currentsurgery) { this.currentsurgery = currentsurgery; }
    public void setCurrentmeds(String currentmeds) { this.currentmeds = currentmeds; }
    public void setBp(String bp) { this.bp = bp; }
    public void setPulse(String pulse) { this.pulse = pulse; }
    public void setSugar(String sugar) { this.sugar = sugar; }
    public void setWeight(String weight) { this.weight = weight; }
    public void setTemperature(String Temperature) { this.Temperature = Temperature; }

    // Getters
    public String getGender() { return gender; }
    public String getPastDisease() { return pastDisease; }
    public String getPastAllergy() { return pastAllergy; }
    public String getPastsurgery() { return pastsurgery; }
    public String getPastmeds() { return pastmeds; }
    public String getCurrentDisease() { return currentDisease; }
    public String getCurrentAllergy() { return currentAllergy; }
    public String getCurrentsurgery() { return currentsurgery; }
    public String getCurrentmeds() { return currentmeds; }
    public String getBp() { return bp; }
    public String getPulse() { return pulse; }
    public String getSugar() { return sugar; }
    public String getWeight() { return weight; }
    public String getTemperature() { return Temperature; }

    // Vitals as string
    public String getVitals() {
        return "\nbp=" + getBp() + "\npulse=" + getPulse() + "\nsugar=" + getSugar() +
                "\nweight=" + getWeight() + "\nTemperature=" + getTemperature() + "\n";
    }

    @Override
    public String toString() {
        return "======PATIENT MEDICAL HISTORY========\n" +
                "gender=" + getGender() + "\n" +
                "pastDisease=" + getPastDisease() + " pastAllergy=" + getPastAllergy() +
                " pastsurgery=" + getPastsurgery() + " pastmeds=" + getPastmeds() + "\n" +
                "currentDisease=" + getCurrentDisease() + " currentAllergy=" + getCurrentAllergy() +
                " currentsurgery=" + getCurrentsurgery() + " currentmeds=" + getCurrentmeds();
    }

    // GUI methods using getters/setters
    public void setVitals() {
        JFrame f = new JFrame("Set Vitals");
        f.setSize(300, 250);
        f.setLayout(new GridLayout(6, 2, 5, 5));

        JTextField bp = new JTextField(getBp());
        JTextField pulse = new JTextField(getPulse());
        JTextField sugar = new JTextField(getSugar());
        JTextField weight = new JTextField(getWeight());
        JTextField temperature = new JTextField(getTemperature());

        f.add(new JLabel("bp:")); f.add(bp);
        f.add(new JLabel("pulse:")); f.add(pulse);
        f.add(new JLabel("sugar:")); f.add(sugar);
        f.add(new JLabel("weight:")); f.add(weight);
        f.add(new JLabel("temperature:")); f.add(temperature);

        JButton save = new JButton("Save Vitals");
        save.addActionListener(e -> {
            setBp(bp.getText());
            setPulse(pulse.getText());
            setSugar(sugar.getText());
            setWeight(weight.getText());
            setTemperature(temperature.getText());
            JOptionPane.showMessageDialog(f, "Vitals saved successfully");
            f.dispose();
        });
        f.add(save);
        f.setVisible(true);
    }

    public void displayVitals() {
        JOptionPane.showMessageDialog(null, getVitals(), "Patient Vitals", JOptionPane.INFORMATION_MESSAGE);
    }

    public void setMedicalHistory() {
        JFrame f = new JFrame("Set Medical History");
        f.setSize(400, 400);
        f.setLayout(new GridLayout(11, 2, 5, 5));
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField gender = new JTextField(getGender());
        JTextField pastDisease = new JTextField(getPastDisease());
        JTextField pastAllergy = new JTextField(getPastAllergy());
        JTextField pastsurgery = new JTextField(getPastsurgery());
        JTextField pastmeds = new JTextField(getPastmeds());
        JTextField currentDisease = new JTextField(getCurrentDisease());
        JTextField currentAllergy = new JTextField(getCurrentAllergy());
        JTextField currentsurgery = new JTextField(getCurrentsurgery());
        JTextField currentmeds = new JTextField(getCurrentmeds());


        f.add(new JLabel("pastDisease:")); f.add(pastDisease);
        f.add(new JLabel("pastAllergy:")); f.add(pastAllergy);
        f.add(new JLabel("pastsurgery:")); f.add(pastsurgery);
        f.add(new JLabel("pastmeds:")); f.add(pastmeds);
        f.add(new JLabel("currentDisease:")); f.add(currentDisease);
        f.add(new JLabel("currentAllergy:")); f.add(currentAllergy);
        f.add(new JLabel("currentsurgery:")); f.add(currentsurgery);
        f.add(new JLabel("currentmeds:")); f.add(currentmeds);

        JButton save = new JButton("Save Medical History");
        save.addActionListener(e -> {

            setPastDisease(pastDisease.getText());
            setPastAllergy(pastAllergy.getText());
            setPastsurgery(pastsurgery.getText());
            setPastmeds(pastmeds.getText());
            setCurrentDisease(currentDisease.getText());
            setCurrentAllergy(currentAllergy.getText());
            setCurrentsurgery(currentsurgery.getText());
            setCurrentmeds(currentmeds.getText());
            JOptionPane.showMessageDialog(f, "Medical history saved successfully");
            f.dispose();
        });
        f.add(save);
        f.setVisible(true);
    }

    public void displayMedicalHistory() {
        JOptionPane.showMessageDialog(null, toString(), "Medical History", JOptionPane.INFORMATION_MESSAGE);
    }
}
