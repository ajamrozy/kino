package GUI;

import all.ListaFilmow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class WyswietlListeFilmowGUI extends ListaFilmow {
    private JPanel panel1;
    JTable listaFilmow1;
    Object[][] data1 = {
            {"Kathy", "Smith",
                    "Snowboarding", 5, Boolean.FALSE},
            {"John", "Doe",
                    "Rowing", 3, Boolean.TRUE},
            {"Sue", "Black",
                    "Knitting", 2, Boolean.FALSE},
            {"Jane", "White",
                    "Speed reading", 20, Boolean.TRUE},
            {"Joe", "Brown",
                    "Pool", 10, Boolean.FALSE}
    };
    String[] columnNames1 = {"First Name",
            "Last Name",
            "Sport",
            "# of Years",
            "Vegetarian"};


    public WyswietlListeFilmowGUI() {
        listaFilmow1.setModel(new DefaultTableModel(
        new String[] {"First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"}, 0));


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("wyswietlListeFilmowGUI");
        frame.setContentPane(new WyswietlListeFilmowGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
