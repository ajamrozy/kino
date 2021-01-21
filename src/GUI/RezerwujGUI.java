package GUI;

import all.SalaKinowa;
import podstawowe.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Boolean.TRUE;

public class RezerwujGUI extends Thread {
    public JFrame frame;
    public JPanel panel1;
    private JButton zakonczIPotwierdzButton;
    private JTextField kwotaTx;
    private JButton anulujButton;
    private JTextField rodzaj1Tx;
    private JTextField rodzaj2Tx;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private double suma;
    public int ileBiletow;
    private int comb1;
    private int comb2;
    ArrayList<ArrayList<String>> zaznaczone1;
    String filename;

    public void setIleBiletow(int ileBiletow) {
        this.ileBiletow = ileBiletow;
    }


    Bilet biletUlg = new Bilet(10, "ulgowy");
    Bilet biletNorm = new Bilet(15, "normalny");

    public void test(){
        for (int i = 0; i < 10; i++) {
            comboBox1.addItem(i);
            comboBox2.addItem(i);
        }
    }

    public void refresh(){
        suma = (comboBox1.getSelectedIndex() * biletUlg.getCena()) + (comboBox1.getSelectedIndex() * biletNorm.getCena());
        kwotaTx.setText(String.valueOf(suma));
    }

    public RezerwujGUI(ArrayList<ArrayList<String>> zaznaczone, String fileName) {
        this.zaznaczone1 = zaznaczone;
        this.filename = fileName;
        frame = new JFrame();
        frame.add(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        rodzaj1Tx.setText(biletUlg.getRodzaj());
        rodzaj2Tx.setText(biletNorm.getRodzaj());
        test();
        start();
        //System.out.println(ileBiletow);

        zakonczIPotwierdzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    wpiszDoPlikuStanMiejsc(zaznaczone);
                    Thread.sleep(500);
                    frame.dispose();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                comb1 = comboBox1.getSelectedIndex();
                sprawdz();
            }
        });
        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                comb2 = comboBox2.getSelectedIndex();
                sprawdz();
            }
        });
    }
    public void sprawdz(){
        if ((comb2 + comb1) == ileBiletow){
            zakonczIPotwierdzButton.setEnabled(true);
        }
        else
            zakonczIPotwierdzButton.setEnabled(false);


    }
    public void wpiszDoPlikuStanMiejsc(ArrayList<ArrayList<String>> stanMiejscZmienione) {
        try {
            // input the file content to the StringBuffer "input"
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
            // display the original file for debugging

            // logic to replace lines in the string (could use regex here to be generic)
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
    public void run(){
        while (true){
            refresh();
            sprawdz();
            try {
                Thread.sleep(200);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        String test = "test_siedzen.txt";
        ArrayList<ArrayList<String>> test1 = new ArrayList<>();
        new RezerwujGUI(test1, test);

    }
}
