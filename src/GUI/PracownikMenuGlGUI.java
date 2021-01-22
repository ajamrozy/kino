package GUI;

import all.WyswietlRezerwacje;
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
    public String login;

   // Pracownik pracownik = new Pracownik("aaaaa", 13D);
    public PracownikMenuGlGUI(String login) {
        framePracownikMenu = new JFrame("PracownikMenuGlGUI");
        framePracownikMenu.add(panel1);
        framePracownikMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePracownikMenu.pack();
        framePracownikMenu.setVisible(true);
        this.login = login;
        nameTx.setText(login);

        dodajFilmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                framePracownikMenu.dispose();
                new DodajFilmGUI(login);
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
                new WyswietlRezerwacje(login);
                framePracownikMenu.dispose();
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
        new PracownikMenuGlGUI("test");
    }
}
