package GUI;

import podstawowe.Pracownik;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PracownikMenuGlGUI {
    public JPanel panel1;
    private JTextField nameTx;
    private JButton dodajFilmButton;
    private JButton usuńFilmButton;
    private JButton wyświetlListęRezerwacjiButton;
    private JButton wylogujButton;

    Pracownik pracownik = new Pracownik("aaaaa", 13D);
    public PracownikMenuGlGUI() {
        dodajFilmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        usuńFilmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        wyświetlListęRezerwacjiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        wylogujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        nameTx.setText(pracownik.getNickname());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PracownikMenuGlGUI");
        frame.setContentPane(new PracownikMenuGlGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
