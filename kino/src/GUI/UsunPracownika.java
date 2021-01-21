package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsunPracownika {
    private JFrame frameUsunPracownika;
    private JPanel panel1;
    private JButton usuńButton;
    private JButton anulujButton;
    private JTextField textField1;

    public UsunPracownika() {

        frameUsunPracownika = new JFrame("UsunPracownika");
        frameUsunPracownika.add(panel1);
        frameUsunPracownika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameUsunPracownika.pack();
        frameUsunPracownika.setVisible(true);

        usuńButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        new UsunPracownika();
    }
}
