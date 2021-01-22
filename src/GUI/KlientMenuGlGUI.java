package GUI;

import all.RezerwacjeKlienta;
import all.WyswietlListeFilmow;
import podstawowe.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KlientMenuGlGUI{
    private JFrame frameKlientMenu;
    private JPanel panel1;
    public JTextField nazwaKlientMenuGlGui;
    private JButton kupBiletButton;
    private JButton wyświetlMojeRezerwacjeButton;
    private JButton wylogujButton;
    public String login;


    public KlientMenuGlGUI(String login) {
        this.nazwaKlientMenuGlGui.setText(login);
        frameKlientMenu = new JFrame("KlientMenuGUI");
        frameKlientMenu.add(panel1);
        frameKlientMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameKlientMenu.pack();
        frameKlientMenu.setVisible(true);

//        login = nazwaKlientMenuGlGui.getText();
//        System.out.println(login);

        kupBiletButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new WyswietlListeFilmow(login);
                frameKlientMenu.dispose();
            }
        });
        wyświetlMojeRezerwacjeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new RezerwacjeKlienta(login);
                frameKlientMenu.dispose();
            }
        });
        wylogujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frameKlientMenu.dispose();
                new LoggerGUI();
            }
        });
    }


    public static void main(String[] args) {
        String login = "test";
        new KlientMenuGlGUI(login);
    }
}
