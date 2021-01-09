package all;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;


public class WyswietlListeFilmow extends JFrame {


    public DefaultTableModel modelTabeli(){
        DefaultTableModel model = new DefaultTableModel(new Object[]{"tytul", "gatunek", "rok produkcji", "opis", "godzina", "data" }, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return JButton.class;
            }
            public boolean isCellEditable(int row, int col){
                return false;
            }
        };
        ArrayList<JButton> test = new ArrayList<>();
        File file = new File("/home/anita/kino_git/kino/kino/src/dane/filmy.txt");
        try {
            Scanner in = new Scanner(file);
            in.nextLine();
            while (in.hasNext()){
                String line = in.nextLine();
                String[] line2 = line.split(",");
                System.out.println(Arrays.toString(line2));
                model.addRow(line2);
                JButton buttonPrzejdzDoSaliKinowej = new JButton(">");
                ActionListener odnosnikDoSali = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        new SalaKinowa();
                    }
                };
                buttonPrzejdzDoSaliKinowej.addActionListener(odnosnikDoSali);
                test.add(buttonPrzejdzDoSaliKinowej);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Object[] przyciski = test.toArray();
        model.addColumn("przejdź do rezerwacji", przyciski);

//        for (int i = 0; i < test.size(); i++) {
//
//            test.get(i).addActionListener(actionListener);
//        }
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

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("test");
            }
        };



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
