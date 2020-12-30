package GUI;

import all.SalaKinowa;
import podstawowe.Bilet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RezerwujGUI extends Thread {
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

    public RezerwujGUI(int ileBiletow) {
        rodzaj1Tx.setText(biletUlg.getRodzaj());
        rodzaj2Tx.setText(biletNorm.getRodzaj());
        test();
        start();
        System.out.println(ileBiletow);

        zakonczIPotwierdzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            }
        });
        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

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
        if (ileBiletow == comb1 + comb2)
            zakonczIPotwierdzButton.setEnabled(true);
        zakonczIPotwierdzButton.setEnabled(false);

    }
    public void sprawdz(){

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
        JFrame frame = new JFrame("RezerwujGUI");
        SalaKinowaGUI sala = new SalaKinowaGUI();
        frame.setContentPane(new RezerwujGUI(sala.ileSelected()).panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
