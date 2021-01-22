package GUI;

import all.WyswietlKlientow;
import all.WyswietlPracownikow;
import all.WyswietlRezerwacje;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenuGUI {
    private JFrame frameAdminMenu;
    public JPanel panel1;
    private JTextField adminNazwaTx;
    private JButton dodajPracownikaButton;
    private JButton wyświetlListęRezerwacjiButton;
    private JButton wylogujButton;
    private JButton wyświetlBazęDanychPracownikówButton;
    private JButton wyświetlBazęDanychKlientówButton;

    public AdminMenuGUI() {
        frameAdminMenu = new JFrame("AdminMenuGUI");
        frameAdminMenu.add(panel1);
        frameAdminMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAdminMenu.pack();
        frameAdminMenu.setVisible(true);
        adminNazwaTx.setText("admin");

        dodajPracownikaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameAdminMenu.dispose();
                new DodajPracownikaGUI();
            }
        });

        wyświetlListęRezerwacjiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WyswietlRezerwacje("admin");
                frameAdminMenu.dispose();
            }
        });
        wyświetlBazęDanychPracownikówButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WyswietlPracownikow();
                frameAdminMenu.dispose();
            }
        });
        wyświetlBazęDanychKlientówButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WyswietlKlientow();
                frameAdminMenu.dispose();
            }
        });
        wylogujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameAdminMenu.dispose();
                new LoggerGUI();
            }
        });

    }

    public static void main(String[] args) {
      new AdminMenuGUI();
    }
}
