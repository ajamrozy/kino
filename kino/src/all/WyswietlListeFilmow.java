package all;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class WyswietlListeFilmow extends JFrame {

    public DefaultTableModel modelTabeli(){
        DefaultTableModel model = new DefaultTableModel(new Object[]{"tytul", "gatunek", "rok produkcji", "opis", "godzina", "data" }, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return JButton.class;
            }
            public boolean isCellEditable(int row, int col){
                return  false;
            }
        };
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

        model.addColumn("przejdź do rezerwacji", new JButton[]{new JButton("test")});
        return model;
    }


    WyswietlListeFilmow(){
        final JFrame frame = new JFrame("Wyswietl liste filmow");


        JPanel panel1 = new JPanel();
        frame.add(panel1);
        DefaultTableModel model = modelTabeli();
        JTable table = new JTable(model);

        TableCellRenderer tableRenderer;
        tableRenderer = table.getDefaultRenderer(JButton.class);
        table.setDefaultRenderer(JButton.class, new RenderJButton(tableRenderer));


        table.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(table);
        frame.add(sp);
        frame.setSize(500, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new WyswietlListeFilmow();
    }
}
