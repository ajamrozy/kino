package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;


public class DodajFilmGUI {

    private JFrame frame;
    private JPanel panel1;
    private JTextField nameFilmTx;
    private JTextField rokProdukcjiTx;
    private JTextField gatunekTx;
    private JTextField opisTx;
    private JCheckBox godzina9;
    private JCheckBox godzina12;
    private JCheckBox godzina16;
    private JCheckBox godzina18;
    private JCheckBox godzina20;
    private JCheckBox godzina22;
    private JComboBox comboBox1;
    private JButton anulujButton;
    private JButton dodajButton;
    private LocalDate today = LocalDate.now();
    private LocalDate tmrw = today.plus(1, ChronoUnit.DAYS);
    private LocalDate twoDays = today.plus(2, ChronoUnit.DAYS);
    private LocalDate threeDays = today.plus(3, ChronoUnit.DAYS);
    private LocalDate fourDays = today.plus(4, ChronoUnit.DAYS);
    private LocalDate fiveDays = today.plus(5, ChronoUnit.DAYS);
    private LocalDate sixDays = today.plus(6, ChronoUnit.DAYS);


    public DodajFilmGUI() {
        frame = new JFrame("DodajFilmGUI");
        frame.add(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(ktoreCheckboxWcisniete());
                ArrayList<String> listaH = ktoreCheckboxWcisniete();
                if (listaH.size() > 0){
                    File plik1 = new File("filmy.txt");
                    try {
                        Writer out = new BufferedWriter(new FileWriter(plik1, true));
                        for (int i = 0; i < listaH.size(); i++) {
                            String dane = nameFilmTx.getText() + ", " + gatunekTx.getText() + ", " + rokProdukcjiTx.getText() + ", " + opisTx.getText() + ", " + listaH.get(i) + ", " + comboBox1.getSelectedItem();
                            out.append("\n"+dane);
                        }
                        out.close();
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();

            }
        });
        comboBox1.addItem(today);
        comboBox1.addItem(tmrw);
        comboBox1.addItem(twoDays);
        comboBox1.addItem(threeDays);
        comboBox1.addItem(fourDays);
        comboBox1.addItem(fiveDays);
        comboBox1.addItem(sixDays);
    }

    public ArrayList<String> ktoreCheckboxWcisniete(){
        ArrayList<String> wynik = new ArrayList<>();
        HashMap<JCheckBox, String> godziny = new HashMap<JCheckBox, String>();
        godziny.put(godzina9, "9");
        godziny.put(godzina12, "12");
        godziny.put(godzina16, "16");
        godziny.put(godzina18, "18");
        godziny.put(godzina20, "20");
        godziny.put(godzina22, "22");

        if (godzina9.isSelected())
            wynik.add(godziny.get(godzina9));
        if (godzina12.isSelected())
            wynik.add(godziny.get(godzina12));
        if (godzina16.isSelected())
            wynik.add(godziny.get(godzina16));
        if (godzina18.isSelected())
            wynik.add(godziny.get(godzina18));
        if (godzina20.isSelected())
            wynik.add(godziny.get(godzina20));
        if (godzina22.isSelected())
            wynik.add(godziny.get(godzina22));

        return wynik;
    }

    public static void main(String[] args) {
        new DodajFilmGUI();
//        JFrame frame = new JFrame("DodajFilmGUI");
//        frame.setContentPane(new DodajFilmGUI().panel1);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
    }
}
