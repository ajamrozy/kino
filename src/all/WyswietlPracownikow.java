package all;
import GUI.AdminMenuGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WyswietlPracownikow extends Thread{
    private JTable table1;
    private JFrame frame;
    private ArrayList<String[]> lista;
    private JButton wyjdz;
    private JButton usun;

    public WyswietlPracownikow() {

        frame = new JFrame("Baza pracowników");
        wyjdz = new JButton("Wyjdź");
        usun = new JButton("Usuń pracownika");
        budujTabele();
        start();

        table1.setPreferredScrollableViewportSize(new Dimension(450, 150));
        table1.setFillsViewportHeight(true);

        JScrollPane scroll = new JScrollPane(table1);



        wyjdz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminMenuGUI();
                frame.dispose();
            }
        });

        usun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList loginy = new ArrayList();
                for(int i=0; i<lista.size(); i++){
                    if(table1.getValueAt(i, 7).equals(Boolean.TRUE)){
                        loginy.add(table1.getValueAt(i, 4));
                    }
                }
                System.out.println(loginy);

                File plik1 = new File("src\\dane\\pracownicy.txt");
                File plik2 = new File("src\\dane\\bazaPracownikow.txt");
                StringBuffer newContent = new StringBuffer();
                StringBuffer newContent2 = new StringBuffer();
                try {
                    Scanner in1 = new Scanner(plik1);
                    Scanner in2 = new Scanner(plik2);
                    while(in1.hasNextLine()){
                        String line = in1.nextLine();
                        for(int i=0; i<loginy.size(); i++){
                            if(!line.split(" ")[0].equals(loginy.get(i))){
//                                in1.nextLine().replace(in1.nextLine(),"\n");
                                newContent.append(line);
                                newContent.append("\n");
                            }
                        }
                    }
                    while(in2.hasNextLine()){
                        String line2 = in2.nextLine();
                        for(int i=0; i<loginy.size(); i++){
                            if(!line2.split(",")[3].equals(loginy.get(i))){
//                                in1.nextLine().replace(in1.nextLine(),"\n");
                                newContent2.append(line2);
                                newContent2.append("\n");
                            }
                        }
                    }
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                FileWriter removeLine = null;
                FileWriter removeLine2 = null;
                try {
                    removeLine = new FileWriter(plik1);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    removeLine2 = new FileWriter(plik2);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                BufferedWriter change = new BufferedWriter(removeLine);
                PrintWriter replace = new PrintWriter(change);
                replace.write(newContent.toString());
                replace.close();

                BufferedWriter change2 = new BufferedWriter(removeLine2);
                PrintWriter replace2 = new PrintWriter(change2);
                replace2.write(newContent2.toString());
                replace2.close();

                frame.dispose();
                new WyswietlPracownikow();
            }
        });

        JPanel btnPnl = new JPanel(new BorderLayout());
        JPanel bottom = new JPanel();
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();

        btnPnl.add(wyjdz, BorderLayout.WEST);
        btnPnl.add(usun, BorderLayout.EAST);
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
    public void budujTabele(){
        String [] kolumny = {"Lp", "Imię", "Nazwisko", "email", "Login", "Haslo", "Start stazu"};
        File plik = new File("src\\dane\\bazaPracownikow.txt");
//        File plik = new File("/home/anita/kino_git/kino/kino/src/dane/bazaPracownikow.txt");
        lista = new ArrayList<>();
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
//        System.out.println(lista.size());

        for(int i=0; i<lista.size(); i++){
            dane[i][0] = String.valueOf(i+1);
            for(int j=1; j<7; j++){
                dane[i][j] = lista.get(i)[j-1];
            }
        }

        DefaultTableModel model = new DefaultTableModel(dane, kolumny);
        Object[] check = new Object[lista.size()];
        for(int i =0; i<lista.size(); i++) check[i] = false;
        model.addColumn("Check", check);
        table1 = new JTable(model){
            public boolean isCellEditable(int dane, int kolumny){
                switch (kolumny) {
                    case 7:
                        return true;
                    default:
                        return false;
                }
            }
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 7:
                        return Boolean.class;
                    default:
                        return String.class;
                }
            }

        };
    }

    public void refresh(){
        Boolean x = false;
        for(int i=0; i<table1.getRowCount(); i++){
            if(table1.getValueAt(i, 7).equals(Boolean.TRUE)) x = true;
        }
        if(x) usun.setEnabled(true);
        else usun.setEnabled(false);
    }

    public void run(){
        while (true){
            refresh();
            try {
                Thread.sleep(200);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        new WyswietlPracownikow();
    }

}