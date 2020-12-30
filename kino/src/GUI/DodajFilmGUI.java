package GUI;

import podstawowe.Film;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class DodajFilmGUI {

    private JPanel panel1;
    private JTextField nameFilmTx;
    private JTextField rokProdukcjiTx;
    private JTextField gatunekTx;
    private JTextField opisTx;
    private JCheckBox a900CheckBox;
    private JCheckBox a1200CheckBox;
    private JCheckBox a1600CheckBox;
    private JCheckBox a1800CheckBox1;
    private JCheckBox a2000CheckBox1;
    private JCheckBox a2200CheckBox;
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
        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Film nowy = new Film(nameFilmTx.getText(), Integer.parseInt(rokProdukcjiTx.getText()), opisTx.getText(), )
                // co zrobic przy wybieraniu kilku godzin na raz

            }
        });
        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

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

    public static void main(String[] args) {
        JFrame frame = new JFrame("DodajFilmGUI");
        frame.setContentPane(new DodajFilmGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
