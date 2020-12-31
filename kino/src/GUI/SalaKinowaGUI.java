package GUI;

import javax.swing.*;
import java.awt.event.*;

public class SalaKinowaGUI {

    private JPanel panel1;
    private JCheckBox miejsce11;
    private JCheckBox miejsce12;
    private JCheckBox miejsce13;
    private JCheckBox miejsce14;
    private JCheckBox miejsce15;
    private JCheckBox miejsce21;
    private JCheckBox miejsce22;
    private JCheckBox miejsce23;
    private JCheckBox miejsce24;
    private JCheckBox miejsce25;
    private JButton anulujButton;
    private JButton potwierdźButton;
    private JCheckBox miejsce16;
    private JCheckBox miejsce26;
    private JCheckBox miejsce36;
    private JCheckBox miejsce35;
    private JCheckBox miejsce34;
    private JCheckBox miejsce33;
    private JCheckBox miejsce32;
    private JCheckBox miejsce31;
    private JCheckBox miejsce17;
    private JCheckBox miejsce27;
    private JCheckBox miejsce37;
    private JCheckBox miejsce57;
    private JCheckBox miejsce56;
    private JCheckBox miejsce54;
    private JCheckBox miejsce43;
    private JCheckBox miejsce44;
    private JCheckBox miejsce45;
    private JCheckBox miejsce46;
    private JCheckBox miejsce47;
    private JCheckBox miejsce53;
    private JCheckBox miejsce42;
    private JCheckBox miejsce41;
    private JCheckBox miejsce51;
    private JCheckBox miejsce52;
    private JCheckBox miejsce55;


    public int ileSelected(){
        int licznikBiletow = 0;
        if (miejsce11.isSelected())
            licznikBiletow++;
        if (miejsce12.isSelected())
            licznikBiletow++;
        if (miejsce13.isSelected())
            licznikBiletow++;
        if (miejsce14.isSelected())
            licznikBiletow++;
        if (miejsce15.isSelected())
            licznikBiletow++;
        if (miejsce16.isSelected())
            licznikBiletow++;
        if (miejsce17.isSelected())
            licznikBiletow++;
        if (miejsce21.isSelected())
            licznikBiletow++;
        if (miejsce22.isSelected())
            licznikBiletow++;
        if (miejsce23.isSelected())
            licznikBiletow++;
        if (miejsce24.isSelected())
            licznikBiletow++;
        if (miejsce25.isSelected())
            licznikBiletow++;
        if (miejsce26.isSelected())
            licznikBiletow++;
        if (miejsce27.isSelected())
            licznikBiletow++;
        if (miejsce31.isSelected())
            licznikBiletow++;
        if (miejsce32.isSelected())
            licznikBiletow++;
        if (miejsce33.isSelected())
            licznikBiletow++;
        if (miejsce34.isSelected())
            licznikBiletow++;
        if (miejsce35.isSelected())
            licznikBiletow++;
        if (miejsce36.isSelected())
            licznikBiletow++;
        if (miejsce37.isSelected())
            licznikBiletow++;
        if (miejsce41.isSelected())
            licznikBiletow++;
        if (miejsce42.isSelected())
            licznikBiletow++;
        if (miejsce43.isSelected())
            licznikBiletow++;
        if (miejsce44.isSelected())
            licznikBiletow++;
        if (miejsce45.isSelected())
            licznikBiletow++;
        if (miejsce46.isSelected())
            licznikBiletow++;
        if (miejsce47.isSelected())
            licznikBiletow++;
        if (miejsce51.isSelected())
            licznikBiletow++;
        if (miejsce52.isSelected())
            licznikBiletow++;
        if (miejsce53.isSelected())
            licznikBiletow++;
        if (miejsce54.isSelected())
            licznikBiletow++;
        if (miejsce55.isSelected())
            licznikBiletow++;
        if (miejsce56.isSelected())
            licznikBiletow++;
        if (miejsce57.isSelected())
            licznikBiletow++;
        return licznikBiletow;
    }

    public SalaKinowaGUI() {
        potwierdźButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                //frame.dispose();
                int licznikBiletow = ileSelected();
                System.out.println(licznikBiletow);
               // rezerwujGui.setIleBiletow(licznikBiletow);
                JFrame nowa = new JFrame();
                RezerwujGUI rezerwujGui = new RezerwujGUI(licznikBiletow);
                nowa.setContentPane(new RezerwujGUI(licznikBiletow).panel1);
                nowa.setVisible(true);
                nowa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //nowa.setLocationRelativeTo(null);
                nowa.pack();

            }
        });
        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //frame.dispose(); //frame dispose????

                //System.exit(0);
            }
        });
//        frame.setSize(100,100);
//        frame.pack();
//        frame.setVisible(true);



    }

    public static void main(String[] args) {

 //      new SalaKinowaGUI();
        JFrame frame = new JFrame("SalaKinowaGUI");

        frame.setContentPane(new SalaKinowaGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }



}
