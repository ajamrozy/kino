package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenuGUI {
    private JFrame frameAdminMenu;
    public JPanel panel1;
    private JTextField textField1;
    private JButton dodajPracownikaButton;
    private JButton wyświetlListęRezerwacjiButton;
    private JButton wylogujButton;
    private JButton usuńPracownikaButton;
    private JButton wyświetlBazęDanychPracownikówButton;
    private JButton wyświetlBazęDanychKlientówButton;

    public AdminMenuGUI() {
        frameAdminMenu = new JFrame("AdminMenuGUI");
        frameAdminMenu.add(panel1);
        frameAdminMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAdminMenu.pack();
        frameAdminMenu.setVisible(true);

        dodajPracownikaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameAdminMenu.dispose();
                new DodajPracownikaGUI();
            }
        });
        usuńPracownikaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        wyświetlListęRezerwacjiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        wyświetlBazęDanychPracownikówButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        wyświetlBazęDanychKlientówButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
