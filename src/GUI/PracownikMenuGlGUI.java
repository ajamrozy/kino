package GUI;

import podstawowe.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PracownikMenuGlGUI {
    private JFrame framePracownikMenu;
    public JPanel panel1;
    private JTextField nameTx;
    private JButton dodajFilmButton;
    private JButton usuńFilmButton;
    private JButton wyświetlListęRezerwacjiButton;
    private JButton wylogujButton;

   // Pracownik pracownik = new Pracownik("aaaaa", 13D);
    public PracownikMenuGlGUI() {
        framePracownikMenu = new JFrame("PracownikMenuGlGUI");
        framePracownikMenu.add(panel1);
        framePracownikMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePracownikMenu.pack();
        framePracownikMenu.setVisible(true);

        dodajFilmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                framePracownikMenu.dispose();
                new DodajFilmGUI();
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
                framePracownikMenu.dispose();
                new LoggerGUI();
            }
        });

   //     nameTx.setText(pracownik.getNickname());
    }

    public static void main(String[] args) {
        new PracownikMenuGlGUI();
    }
}
