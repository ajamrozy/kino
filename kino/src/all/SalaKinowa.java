package all;

import GUI.RezerwujGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;


import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class SalaKinowa {
    private String filename;

    public SalaKinowa(String fileName){ //konstruktor
        this.filename = fileName;  //dane nazwy pliku, w ktorym przechowywane sa stany miejsc

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
                ArrayList<ArrayList<String>> zaznaczone = stanMiejscZm(model);
                //wpiszDoPlikuStanMiejsc(zaznaczone);
                if (zaznaczone.size() - wczytajIleZaznaczonych() != 0) {
                    RezerwujGUI nowy = new RezerwujGUI();
                    nowy.setIleBiletow(zaznaczone.size() - wczytajIleZaznaczonych());

                    try {
                        wpiszDoPlikuStanMiejsc(zaznaczone);
                        Thread.sleep(500);
                        frame.dispose();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                else
                    JOptionPane.showMessageDialog(null, "musisz wybrać miejsce, aby móc przejść do rezerwacji", "Sala Kinowa", JOptionPane.PLAIN_MESSAGE);
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



    public DefaultTableModel modelTabeli(){
        ArrayList<Boolean> listaMiejscDoModelu = wczytajPlikStanMiejsc(); //pobranie listy miejsc z funkcji wczytajPlikStanMiejsc
        DefaultTableModel model = new DefaultTableModel(new Object[]{"kolumna 1", "kolumna2", "kolumna3",  "kolumna4", "kolumna5", "kolumna6", "kolumna7", "kolumna8"}, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return Boolean.class;
            }
            public boolean isCellEditable(int row, int column) {
                return Boolean.FALSE == listaMiejscDoModelu.get(row + column);
            }
        };
        System.out.println(listaMiejscDoModelu);
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
        File test = new File(filename);
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
    public int wczytajIleZaznaczonych(){
        File test = new File(filename);
        int wczytanoIleZazn = 0;
        try {
            Scanner input = new Scanner(test);
            input.nextLine();
            while (input.hasNext()){
                String line = input.nextLine();
                String[] line2 = line.split(",");
                if (line2[2].equals("TRUE"))
                    wczytanoIleZazn++;
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return wczytanoIleZazn;
    }



    public void wpiszDoPlikuStanMiejsc(ArrayList<ArrayList<String>> stanMiejscZmienione) {
        try {
            File file = new File(filename);
            Scanner input = new Scanner(file);
            ArrayList<String[]> listaStanuMiejscStr = new ArrayList<>();
            String line;

            while (input.hasNext()) {
                line = input.nextLine();
                String[] line2 = line.split(",");
                listaStanuMiejscStr.add(line2);
            }
            input.close();

            for (ArrayList<String> testZmienna : stanMiejscZmienione) {
                String tymczasowyX = testZmienna.get(0);
                String tymczasowyY = testZmienna.get(1);
                for (int i = 0; i < listaStanuMiejscStr.size(); i++) {
                    String[] tymczas = listaStanuMiejscStr.get(i);
                    if (tymczas[0].equals(tymczasowyX) && tymczas[1].equals(tymczasowyY))
                        tymczas[2] = "TRUE";
                }
            }

            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();

            FileWriter writer2 = new FileWriter(file);
            for (int i = 0; i < listaStanuMiejscStr.size(); i++) {
                String tymczasCol = listaStanuMiejscStr.get(i)[1];
                String tymczasRow = listaStanuMiejscStr.get(i)[0];
                String tymczasStan = listaStanuMiejscStr.get(i)[2];
                writer2.write(tymczasRow);
                writer2.write(",");
                writer2.write(tymczasCol);
                writer2.write(",");
                writer2.write(tymczasStan);
                writer2.write("\n");
            }
            writer2.close();

        } catch (Exception e) {
            System.out.println("Problem reading file.");
        }
    }

    public ArrayList<ArrayList<String>> stanMiejscZm(DefaultTableModel modelTable) {
        ArrayList<ArrayList<String>> miejscaZajete = new ArrayList<>();
        for (int i = 0; i < modelTable.getColumnCount(); i++) {
            for (int j = 0; j < modelTable.getRowCount(); j++) {
                if (modelTable.getValueAt(j, i).equals(Boolean.TRUE)) {
                    ArrayList<String> wspolrzednePunktu = new ArrayList<>(2);
                    wspolrzednePunktu.add(Integer.toString(j));
                    wspolrzednePunktu.add(Integer.toString(i));
                    miejscaZajete.add(wspolrzednePunktu);
                }

            }
        }
        return miejscaZajete;
    }


    public static void main(String[] args) {
       new SalaKinowa("test_siedzen.txt");
    }
}
