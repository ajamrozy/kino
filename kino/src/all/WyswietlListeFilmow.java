package all;

import javax.swing.*;

public class WyswietlListeFilmow extends JFrame {
    JFrame frame;
    JTable tableFilm;
    WyswietlListeFilmow(){
        frame = new JFrame();
        frame.setTitle("WyswietlListeFilmow");
        String[][] data = {
                { "Kundan Kumar Jha", "4031", "CSE" },
                { "Anand Jha", "6014", "IT" }
        };
        String[] columnNames = { "Name", "Roll Number", "Department" };
        JFileChooser test = new JFileChooser("filmy.txt");
        tableFilm = new JTable(data, columnNames);
        tableFilm.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(tableFilm);
        frame.add(sp);
        frame.setSize(500, 200);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new WyswietlListeFilmow();
    }
}
