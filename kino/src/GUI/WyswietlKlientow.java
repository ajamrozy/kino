package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WyswietlKlientow extends JPanel{
    private JTable table1;

    public WyswietlKlientow() {

        String [] kolumny = {"Lp", "Imię", "Nazwisko", "email", "Login", "Haslo"};
        File plik = new File("kino\\src\\dane\\bazaKlientow.txt");
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
            dane[i][0] = String.valueOf(i+1);
            for(int j=1; j<6; j++){
                dane[i][j] = lista.get(i)[j-1];
            }
        }

        table1 = new JTable(dane, kolumny);
        table1.setPreferredScrollableViewportSize(new Dimension(450, 150));
        table1.setFillsViewportHeight(true);

        JScrollPane scroll = new JScrollPane(table1);
        add(scroll);

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("BazaKlientow");
        WyswietlKlientow b = new WyswietlKlientow();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 250);
        frame.setVisible(true);
        frame.add(b);

    }

}
