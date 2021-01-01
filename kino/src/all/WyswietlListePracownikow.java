package all;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WyswietlListePracownikow extends JFrame{
    public WyswietlListePracownikow() {
        JFrame frame = new JFrame();
        JButton wyjdz = new JButton("wyjdz");

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        model.addColumn("nickname");
        model.addColumn("password");
        model.addColumn("staz");
        //model.addColumn("dodane filmy"); //tego nie wiem czy bedzie
        File file = new File("pracownicy.txt");
        try {
            Scanner in = new Scanner(file);
            in.nextLine();
            while (in.hasNext()){
                String line = in.nextLine();
                String[] line2 = line.split(" ");
                model.addRow(line2);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        table.setBounds(30, 40, 200, 300);
        frame.setSize(500, 200);
        JScrollPane sp = new JScrollPane(table);
        sp.add(wyjdz);
        frame.add(sp);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new WyswietlListePracownikow();
    }
}
