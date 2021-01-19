package all;
import GUI.AdminMenuGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WyswietlPracownikow extends JPanel{
    private JTable table1;
    private JFrame frame;

    public WyswietlPracownikow() {

        frame = new JFrame("Baza pracowników");

        String [] kolumny = {"Lp", "Imię", "Nazwisko", "email", "Login", "Haslo", "Start stazu"};
        File plik = new File("kino\\src\\dane\\bazaPracownikow.txt");
//        File plik = new File("/home/anita/kino_git/kino/kino/src/dane/bazaPracownikow.txt");
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

        String[][] dane = new String[lista.size()][7];
        System.out.println(lista.size());

        for(int i=0; i<lista.size(); i++){
            dane[i][0] = String.valueOf(i+1);
            for(int j=1; j<7; j++){
                dane[i][j] = lista.get(i)[j-1];
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
                new AdminMenuGUI();
                frame.dispose();
            }
        });

        JPanel btnPnl = new JPanel(new BorderLayout());
        btnPnl.add(wyjdz, BorderLayout.CENTER);

        frame.add(scroll, BorderLayout.CENTER);
        frame.add(btnPnl, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500, 250);
        frame.setVisible(true);


    }


    public static void main(String[] args) {
        new WyswietlPracownikow();
    }

}