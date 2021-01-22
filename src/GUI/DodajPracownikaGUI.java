package GUI;

import podstawowe.Pracownik;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class DodajPracownikaGUI {
    private JFrame frameDodajPracownika;
    public JPanel panel1;
    private JTextField nameTxDKG;
    private JTextField nazwiskoTxGKG;
    private JTextField emailTxDKG;
    private JPasswordField password1;
    private JPasswordField password2;
    private JButton anulujButton;
    private JButton zatwierdźButton;
    private JTextField login;

    public DodajPracownikaGUI() {
        frameDodajPracownika = new JFrame("DodajPracownikaGUI");
        frameDodajPracownika.add(panel1);
        frameDodajPracownika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameDodajPracownika.pack();
        frameDodajPracownika.setVisible(true);

        zatwierdźButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pracownik nowy = new Pracownik(nameTxDKG.getText(), nazwiskoTxGKG.getText(), emailTxDKG.getText(), login.getText(), password1.getText(), LocalDate.now());
                File plik1 = new File("src\\dane\\pracownicy.txt");
                File plik2 = new File("src\\dane\\klienci.txt");
                File plik3 = new File("src\\dane\\bazaPracownikow.txt");
//                File plik1 = new File("/home/anita/kino_git/kino/kino/src/dane/pracownicy.txt");
//                File plik2 = new File("/home/anita/kino_git/kino/kino/src/dane/klienci.txt");
//                File plik3 = new File("/home/anita/kino_git/kino/kino/src/dane/bazaPracownikow.txt");

                if (!nameTxDKG.getText().equals("") && !nazwiskoTxGKG.getText().equals("") && !emailTxDKG.getText().equals("") && !login.getText().equals("") && !password1.getText().equals("")) {
                    int check = 0;
                    try {
                        Scanner in1 = new Scanner(plik1);
                        while (in1.hasNextLine()) {
                            if (in1.nextLine().split(" ")[0].equals(login.getText())) check = 1;
                        }
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                    try {
                        Scanner in2 = new Scanner(plik2);
                        while (in2.hasNextLine()) {
                            if (in2.nextLine().split(" ")[0].equals(login.getText())) check = 1;
                        }
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                    if (check == 1)
                        JOptionPane.showMessageDialog(null, "Podany login już istnieje!", "DodajPracownika", JOptionPane.PLAIN_MESSAGE);
                    else if (password1.getText().equals(password2.getText()) == false)
                        JOptionPane.showMessageDialog(null, "Hasła muszą być takie same!", "DodajPracownika", JOptionPane.PLAIN_MESSAGE);
                    else
                        try {
                            Writer out = new BufferedWriter(new FileWriter(plik1, true));
                            String dane = login.getText() + " " + password1.getText();
                            out.append("\n" + dane);
                            out.close();
                            JOptionPane.showMessageDialog(null, "Nowy pracownik dodany!", "DodajPracownika", JOptionPane.PLAIN_MESSAGE);
                            Writer out2 = new BufferedWriter(new FileWriter(plik3, true));
                            out2.append("\n" + nowy.getImie() + "," + nowy.getNazwisko() + "," + nowy.getMail() + "," + nowy.getLogin() + "," + nowy.getPassword() + "," + nowy.getStartStazu());
                            out2.close();
                            frameDodajPracownika.dispose();
                            new AdminMenuGUI();
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                }
                else
                    JOptionPane.showMessageDialog(null, "wszystkie pola są wymagane :)", "Dodaj Pracownika", JOptionPane.PLAIN_MESSAGE);
            }
        });
        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameDodajPracownika.dispose();
                new AdminMenuGUI();
            }
        });
    }

    public static void main(String[] args) {
       new DodajPracownikaGUI();
    }
}
