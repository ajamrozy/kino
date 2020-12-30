package GUI;

import podstawowe.Klient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class DodajKlientaGUI {
    public JPanel panel1;
    private JTextField nameTxDKG;
    private JTextField nazwiskoTxGKG;
    private JTextField emailTxDKG;
    private JPasswordField password1;
    private JPasswordField password2;
    private JButton anulujButton;
    private JButton zatwierdźButton;

    //Klient klient = new Klient("a", "b", "c", "aaaaaa");

    public DodajKlientaGUI() {
        zatwierdźButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Klient nowy = new Klient(nameTxDKG.getText(), nazwiskoTxGKG.getText(), emailTxDKG.getText(), password1.getText());
                //System.out.println(nowy.toString());
                File plik = new File("klienci.txt");
                try {
                    Writer out = new BufferedWriter(new FileWriter(plik, true));
                    String dane = emailTxDKG.getText() + " " + password1.getText();
                    out.append("\n"+dane);
                    out.close();
                    System.out.println("Nowe konto stworzone!");
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

            }
        });
    }





    public static void main(String[] args) {
        JFrame frame = new JFrame("DodajKlientaGUI");
        frame.setContentPane(new DodajKlientaGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
