package all;

import GUI.RezerwujGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class SalaKinowa{


    public DefaultTableModel modelTabeli(){
        ArrayList<Boolean> listaMiejscDoModelu = wczytajPlikStanMiejsc(); //pobranie listy miejsc z funkcji wczytajPlikStanMiejsc
        DefaultTableModel model = new DefaultTableModel(new Object[]{"kolumna 1", "kolumna2", "kolumna3",  "kolumna4", "kolumna5", "kolumna6", "kolumna7", "kolumna8"}, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return Boolean.class;
            }
        };

        int iterator = 0;  //budowa modelu na podstawie listy stanu miejsc
        while (iterator < 80){
            ArrayList<Boolean> rzadLista = new ArrayList<>();
            for (int i = 0; i < 8; i++) {
                rzadLista.add(listaMiejscDoModelu.get(i + iterator));
            }
            model.addRow(rzadLista.toArray());
            iterator += 8;
        }

//        for (int index = 0; index < 10; index++) {
//            model.addRow(new Object[]{Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,Boolean.FALSE});
//        }
        return model;
    }

    public Boolean zwracaBooleanDoListyStanuMiejsc(String zmiennaZPliku){
        if (zmiennaZPliku.equals("FALSE"))
            return Boolean.FALSE;
        return Boolean.TRUE;
    }

    public ArrayList<Boolean> wczytajPlikStanMiejsc(){
        File test = new File("test_siedzen.csv");
        ArrayList<String> listaStanuMiejscStr = new ArrayList<>(); //utworzenie listy ktora bedzie rzechowywac liste miejsc wczytana z pliku
        ArrayList<Boolean> listaStanuMiejscBool = new ArrayList<>(); //lista wynikowa na ktorej podstawie bedzie budowany model
        try {
            Scanner input = new Scanner(test);
            input.nextLine();
            while (input.hasNext()){
                String line = input.nextLine();
                String[] line2 = line.split(",");
                listaStanuMiejscStr.add(line2[2]);
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (String znaki : listaStanuMiejscStr){
            Boolean noweZnaki = zwracaBooleanDoListyStanuMiejsc(znaki);
            listaStanuMiejscBool.add(noweZnaki);
        }
        return listaStanuMiejscBool;
    }

    public int ileZaznaczonych(DefaultTableModel model){
        int ileSelected = 0;
        for (int i = 0; i < model.getColumnCount(); i++) {
            for (int j = 0; j < model.getRowCount(); j++) {
                if (model.getValueAt(j, i).equals(Boolean.TRUE))
                    ileSelected++;
            }
        }
        return ileSelected;
    }

    public void stanMiejsc(DefaultTableModel model){
        HashMap<ArrayList<Integer>, Boolean> stany = new HashMap<>();
        for (int i = 0; i < model.getColumnCount(); i++) {
            for (int j = 0; j < model.getRowCount(); j++) {
                if (model.getValueAt(j, i).equals(Boolean.TRUE)){
                    ArrayList<Integer> wspolrzedne = new ArrayList<>();
                    wspolrzedne.add(i + 1);
                    wspolrzedne.add(j + 1);
                    stany.put(wspolrzedne, true);
                }
            }
        }
    }

    public SalaKinowa(){
        final JFrame frame = new JFrame(); //frame

        // JPanel panel0 = new JPanel();       // panel macierzysy
        JPanel panel1 = new JPanel();       //panel zawierajacy tabele i ekran
        JPanel panel2 = new JPanel();       //panel zawierajacy przyciski

        ImageIcon imageIcon = new ImageIcon("ekran.png"); //ekran
        JLabel ekran = new JLabel(imageIcon);

        JButton zatwierdz = new JButton("Zatwierdz"); //przyciski
        JButton anuluj = new JButton("Anuluj");

        DefaultTableModel model = modelTabeli(); //tabela
        JTable table = new JTable(model);

        JScrollPane sp = new JScrollPane(table); //scroll panel

        zatwierdz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int test = ileZaznaczonych(model);
                stanMiejsc(model);
                System.out.println(test);
                RezerwujGUI nowy = new RezerwujGUI();
                nowy.setIleBiletow(test);

            }
        });

        anuluj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
            }
        });
        //NIC TU NIE DZIALA JAK NALEZY

        //add

//        panel0.add(panel1);
        panel1.add(ekran);
        panel1.add(sp);

        frame.setBackground(Color.yellow);
        panel1.setBackground(Color.BLUE);
        panel2.setBackground(Color.RED);
        table.setBackground(Color.GREEN);
        sp.setBackground(Color.CYAN);

        panel2.add(zatwierdz);
        panel2.add(anuluj);


        frame.add(panel2);
        frame.add(panel1);
//        frame.add(sp);

        //sety

        frame.setSize(500, 400);
        panel1.setSize(500, 50);
        panel2.setSize(500, 100);
//        sp.setLocation(0,51);
//        sp.setSize(500, 700);

        table.setBounds(0, 0, 500, 50);
        //sp.setBounds(0,0,50,50);
        panel1.setLocation(0,0);
        panel2.setLocation(0, 301);
        anuluj.setLocation(0, 301);
        zatwierdz.setLocation(100, 301);
        frame.setResizable(false);


//        System.out.println(panel2.getLocation());
//        System.out.println(anuluj.getLocation());
//        System.out.println();
        //table.setLocation(100, 300);
//        panel2.setLocation(0, 0);


        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //zle wyswietlanie
    }


    public static void main(String[] args) {
       new SalaKinowa();
    }
}
