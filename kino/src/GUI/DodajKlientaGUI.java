package GUI;

import podstawowe.Klient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class DodajKlientaGUI {
    private JFrame frameDodajKlienta;
    public JPanel panel1;
    private JTextField nameTxDKG;
    private JTextField nazwiskoTxGKG;
    private JTextField emailTxDKG;
    private JPasswordField password1;
    private JPasswordField password2;
    private JButton anulujButton;
    private JButton zatwierdźButton;
    private JTextField login;

    //Klient klient = new Klient("a", "b", "c", "aaaaaa");

    public DodajKlientaGUI() {
        frameDodajKlienta = new JFrame("DodajKlientaGUI");
        frameDodajKlienta.add(panel1);
        frameDodajKlienta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameDodajKlienta.pack();
        frameDodajKlienta.setVisible(true);

        zatwierdźButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Klient nowy = new Klient(nameTxDKG.getText(), nazwiskoTxGKG.getText(), emailTxDKG.getText(), login.getText(), password1.getText());
                //System.out.println(nowy.toString());
                File plik1 = new File("kino\\src\\dane\\klienci.txt");
                File plik2 = new File("kino\\src\\dane\\pracownicy.txt");
                File plik3 = new File("kino\\src\\dane\\bazaKlientow.txt");
                int check = 0;
                try {
                    Scanner in1 = new Scanner(plik1);
                    while(in1.hasNextLine()) {
                        if (in1.nextLine().split(" ")[0].equals(login.getText())) check = 1;
                    }
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                try {
                    Scanner in2 = new Scanner(plik2);
                    while(in2.hasNextLine()) {
                        if (in2.nextLine().split(" ")[0].equals(login.getText())) check = 1;
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                if (check == 1)
                    JOptionPane.showMessageDialog(null, "Podany login już istnieje!", "DodajPracownika", JOptionPane.PLAIN_MESSAGE);
                else if(password1.getText().equals(password2.getText()) == false)
                    JOptionPane.showMessageDialog(null, "Hasła muszą być takie same!", "DodajPracownika", JOptionPane.PLAIN_MESSAGE);
                else
                try {
                    Writer out = new BufferedWriter(new FileWriter(plik1, true));
                    String dane = login.getText() + " " + password1.getText();
                    out.append("\n"+dane);
                    out.close();
                    JOptionPane.showMessageDialog(null, "Nowe konto stworzone!", "Nowe konto", JOptionPane.PLAIN_MESSAGE);
                    Writer out2 = new BufferedWriter(new FileWriter(plik3, true));
                    out2.append("\n" + nowy.getImie() + "," + nowy.getNazwisko() + "," + nowy.getMail() + "," + nowy.getLogin() + "," + nowy.getPassword());
                    out2.close();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frameDodajKlienta.dispose();
            }
        });
    }





    public static void main(String[] args) {
//        JFrame frame = new JFrame("DodajKlientaGUI");
//        frame.setContentPane(new DodajKlientaGUI().panel1);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
        new DodajKlientaGUI();

    }
}
