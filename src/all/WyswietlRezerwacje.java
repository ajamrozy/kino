package all;

import GUI.AdminMenuGUI;
import GUI.PracownikMenuGlGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WyswietlRezerwacje extends JPanel{
    private JTable table1;
    private JFrame frame;
    public String login;

    public WyswietlRezerwacje(String login) {

        frame = new JFrame("Lista rezerwacji");
        this.login = login;

        String [] kolumny = {"Login", "Tytuł filmu", "Data filmu", "Godzina filmu", "Liczba biletów", "Data rezerwacji"};
        File plik = new File("src\\dane\\rezerwacje.txt");
        ArrayList<String[]> lista = new ArrayList<>();
        Scanner in = null;
        try {
            in = new Scanner(plik);
            while(in.hasNextLine()){
                String x = in.nextLine();
                String[] y = x.split(",");
                lista.add(y);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String[][] dane = new String[lista.size()][6];
        System.out.println(lista.size());

        for(int i=0; i<lista.size(); i++){
            for(int j=0; j<6; j++){
                dane[i][j] = lista.get(i)[j];
            }
        }

        table1 = new JTable(dane, kolumny){
            public boolean isCellEditable(int dane, int kolumny){
                return false;
            }
        };
        table1.setPreferredScrollableViewportSize(new Dimension(450, 150));
        table1.setFillsViewportHeight(true);

        JScrollPane scroll = new JScrollPane(table1);
        JButton wyjdz = new JButton("Wyjdź");

        wyjdz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(login == "admin") new AdminMenuGUI();
                else new PracownikMenuGlGUI(login);
                frame.dispose();
            }
        });

        JPanel btnPnl = new JPanel(new BorderLayout());
        JPanel bottom = new JPanel();
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();

        btnPnl.add(wyjdz, BorderLayout.CENTER);
        bottom.add(label1, BorderLayout.WEST);
        bottom.add(btnPnl, BorderLayout.CENTER);
        bottom.add(label2, BorderLayout.EAST);

        frame.add(scroll, BorderLayout.CENTER);
        frame.add(bottom, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500, 250);
        frame.setVisible(true);

    }


    public static void main(String[] args) {
        new WyswietlRezerwacje("test");
    }

}

