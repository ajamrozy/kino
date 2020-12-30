package GUI;

import podstawowe.Klient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KlientMenuGlGUI{
    private JPanel panel1;
    private JTextField nazwaKlientMenuGlGui;
    private JButton kupBiletButton;
    private JButton wyświetlMojeRezerwacjeButton;
    private JButton wylogujButton;

    Klient klient = new Klient("a", "b", "c", "aaaaaa");

    public KlientMenuGlGUI() {
        refresh();
        kupBiletButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                refresh();
            }
        });
        wyświetlMojeRezerwacjeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                refresh();
            }
        });
        wylogujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                refresh();
            }
        });
    }
    public void refresh(){
        nazwaKlientMenuGlGui.setText(klient.getImie());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("KlientMenuGlGUI");
        frame.setContentPane(new KlientMenuGlGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
