package all;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class WyswietlListeFilmow extends JFrame {

    WyswietlListeFilmow(){
        Frame frame = new Frame();

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        model.addColumn("tytul");
        model.addColumn("gatunek");
        model.addColumn("rok produkcji");
        model.addColumn("opis");
        model.addColumn("godzina");
        model.addColumn("data");

        File file = new File("filmy.txt");
        try {
            Scanner in = new Scanner(file);
            in.nextLine();
            while (in.hasNext()){
                String line = in.nextLine();
                String[] line2 = line.split(",");
                System.out.println(Arrays.toString(line2));
                model.addRow(line2);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        table.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(table);
        frame.add(sp);
        frame.setSize(500, 200);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new WyswietlListeFilmow();
    }
}
