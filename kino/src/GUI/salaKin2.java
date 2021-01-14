package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class salaKin2 {
    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private JPanel panelTab;
    private JTable table1;

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
        File test = new File("/home/anita/kino_git/kino/kino/src/dane/test_siedzen.csv");
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
    public salaKin2(){
        final JFrame frame = new JFrame();
        frame.add(panel1);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        DefaultTableModel model = modelTabeli(); //tabela
        table1 = new JTable(model);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int test = ileZaznaczonych(model);
                stanMiejsc(model);
                System.out.println(test);
                RezerwujGUI nowy = new RezerwujGUI();
                nowy.setIleBiletow(test);

            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
            }
        });
    }

    public static void main(String[] args) {
        new salaKin2();
    }
}
