package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class LoggerGUI {
    private JPanel panel1;
    private JPasswordField textPassword;
    private JTextField textLogin;
    private JLabel powitanieLogger;
    private JTextField textUserLogin;
    private JPasswordField textUserPassword;
    private JButton zalogujButton;
    private JButton stwórzNoweKontoButton;
    private JButton zalogujUserButton;

    public LoggerGUI() {
        zalogujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File plik1 = new File("pracownicy.txt");
                File plik2 = new File("admini.txt");
                int check = 0;
                try {
                    Scanner in1 = new Scanner(plik1);
                    String dane = textLogin.getText() + " " + textPassword.getText();
                    while(in1.hasNextLine()){
                        if(dane.equals(in1.nextLine())) check = 1;
                    }
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                try {
                    Scanner in2 = new Scanner(plik2);
                    String dane = textLogin.getText() + " " + textPassword.getText();
                    while(in2.hasNextLine()){
                        if(dane.equals(in2.nextLine())) check = 2;
                    }
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                if(check == 1) System.out.println("Login successful as employee!");
                else if(check == 2) System.out.println("Login successful as admin!");
                else System.out.println("Login or password incorrect!");
            }
        });

        zalogujUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File plik = new File("klienci.txt");
                int check = 0;
                try {
                    Scanner in1 = new Scanner(plik);
                    String dane = textUserLogin.getText() + " " + textUserPassword.getText();
                    while(in1.hasNextLine()){
                        if(dane.equals(in1.nextLine())) check = 1;
                    }
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                String mess = "";
                if(check == 1) mess = "Login successful!";
                else mess = "Login or password incorrect!";
                String okno = JOptionPane.showInputDialog(mess);
            }
        });
        stwórzNoweKontoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                File plik = new File("C:\\Users\\hp\\IdeaProjects\\kino\\src\\dane\\klienci.txt");
//                try {
//                    Writer out = new BufferedWriter(new FileWriter(plik, true));
//                    String dane = textUserLogin.getText() + " " + textUserPassword.getText();
//                    out.append("\n"+dane);
//                    out.close();
//                    System.out.println("Nowe konto stworzone!");
//                } catch (FileNotFoundException fileNotFoundException) {
//                    fileNotFoundException.printStackTrace();
//                } catch (IOException ioException) {
//                    ioException.printStackTrace();
//                }
                JFrame nowa = new JFrame();
                nowa.setContentPane(new DodajKlientaGUI().panel1);
                nowa.setVisible(true);
                nowa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                nowa.pack();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("loggerGUI");
        frame.setContentPane(new LoggerGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
