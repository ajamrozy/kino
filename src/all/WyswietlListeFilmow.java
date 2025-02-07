package all;

import GUI.KlientMenuGlGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class WyswietlListeFilmow extends  Thread{

    JTable table;
    public String login;

    public DefaultTableModel modelTabeli(){
        DefaultTableModel model = new DefaultTableModel(new Object[]{"tytul", "gatunek", "rok produkcji", "opis", "godzina", "data" }, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 6)
                    return Boolean.class;
                return String.class;
            }
            public boolean isCellEditable(int row, int col){
                return col == 6;
            }
        };
        ArrayList<Boolean> test = new ArrayList<>();
        File file = new File("src\\dane\\filmy.txt");
        try {
            Scanner in = new Scanner(file);
            in.nextLine();
            while (in.hasNext()){
                String line = in.nextLine();
                String[] line2 = line.split(",");
                model.addRow(line2);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Object[] przyciski = test.toArray();
        model.addColumn("przejdź do rezerwacji", przyciski);

        return model;
    }

    public ArrayList<ArrayList<String>> daneDoOtwarciaSaliKin() {
        ArrayList<ArrayList<String>> przechowywanieDanychDoSaliKin = new ArrayList<>();
        File file = new File("src\\dane\\filmy.txt");
        try {
            Scanner in = new Scanner(file);
            in.nextLine();
            while (in.hasNext()) {
                ArrayList<String> pomocnicza = new ArrayList<>();
                String line = in.nextLine();
                String[] line2 = line.split(",");
                pomocnicza.add(line2[0]);
                pomocnicza.add(line2[4]);
                pomocnicza.add(line2[5]);
                przechowywanieDanychDoSaliKin.add(pomocnicza);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return przechowywanieDanychDoSaliKin;
    }


    public WyswietlListeFilmow(String login){

        this.login = login;
        //naprawic wyswietlanie
        final JFrame frame = new JFrame(); //frame

        // JPanel panel0 = new JPanel();       // panel macierzysy
        JPanel panel1 = new JPanel();       //panel zawierajacy tabele i ekran
        JPanel panel2 = new JPanel(new BorderLayout());       //panel zawierajacy przyciski

        JButton zatwierdz = new JButton("Zatwierdz"); //przyciski
        JButton anulujWybor = new JButton("Anuluj wybor");
        JButton wyjdz = new JButton("Wyjdz");

        DefaultTableModel model = modelTabeli(); //tabela
        table = new JTable(model);

        JScrollPane sp = new JScrollPane(table); //scroll panel

        panel2.add(zatwierdz, BorderLayout.WEST);
        panel2.add(anulujWybor, BorderLayout.CENTER);
        panel2.add(wyjdz, BorderLayout.EAST);

        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();

        panel1.add(label1, BorderLayout.WEST);
        panel1.add(panel2, BorderLayout.CENTER);
        panel1.add(label2, BorderLayout.EAST);

        frame.add(sp, BorderLayout.CENTER);
        frame.add(panel1, BorderLayout.SOUTH);


        ArrayList<ArrayList<String>> przechowywanieDanychDoSaliKin = daneDoOtwarciaSaliKin();


        zatwierdz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int czyszczenie = table.getSelectedRow();
                String nazwaPliku;
                ArrayList<String> wybrany = przechowywanieDanychDoSaliKin.get(czyszczenie);
                String nazwaFilmu = wybrany.get(0);
                String godzinaFilmu = wybrany.get(1);
                String dataFilmu = wybrany.get(2);
                nazwaPliku = nazwaFilmu +  dataFilmu + godzinaFilmu + ".txt";
                ArrayList<String> daneFilmu = new ArrayList<>();
                daneFilmu.add(nazwaFilmu);
                daneFilmu.add(dataFilmu);
                daneFilmu.add(godzinaFilmu);
                System.out.println(daneFilmu);
                nazwaPliku = nazwaPliku.replaceAll("\\s+", "");
                System.out.println(nazwaPliku);
                new SalaKinowa("src\\dane\\filmy_sale\\"+nazwaPliku, login, daneFilmu);
                frame.dispose();
            }
        });
        anulujWybor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int czyszczenie = table.getSelectedRow();
                table.setValueAt(Boolean.FALSE, czyszczenie, 6);
                table.setEnabled(true);
            }
        });
        wyjdz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new KlientMenuGlGUI(login);
                frame.dispose();
            }
        });

        start();
        frame.setSize(500, 400);
        panel1.setSize(500, 50);
        panel2.setSize(500, 100);
//        sp.setLocation(0,51);
//        sp.setSize(500, 700);

        table.setBounds(0, 0, 500, 50);
        //sp.setBounds(0,0,50,50);
        panel1.setLocation(0,0);
        panel2.setLocation(0, 301);
        anulujWybor.setLocation(0, 301);
        zatwierdz.setLocation(100, 301);

        panel2.setVisible(true);
        frame.setSize(500, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public  void  refresh(JTable table){
        ArrayList<Object> warunek = new ArrayList<>();
        for (int i = 0; i < table.getRowCount(); i++) {
            warunek.add(table.getValueAt(i, 6));
        }
        if (warunek.contains(Boolean.TRUE)){
            table.setEnabled(false);
        }

    }
    public void run(){
        while (true){
            refresh(table);
            try {
                Thread.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String login = "test";
        new WyswietlListeFilmow(login);
    }
}
