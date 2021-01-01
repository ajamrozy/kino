package all;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class SalaKinowa extends Thread{
    private void budowaSali(){

        final JFrame frame = new JFrame();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        frame.add(panel1);
        frame.add(panel2);
        ImageIcon imageIcon = new ImageIcon("ekran.png");
        JLabel ekran = new JLabel(imageIcon);
        panel1.add(ekran);
        ekran.setLocation(250, 10);
        JButton zatwierdz = new JButton("Zatwierdz");
        JButton anuluj = new JButton("Anuluj");
        panel2.add(zatwierdz);
        panel2.add(anuluj);
        zatwierdz.setLocation(0, 250);
        anuluj.setLocation(100, 250);

        DefaultTableModel model = modelTabeli();
        JTable table = new JTable(model);



        zatwierdz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int test = ileZaznaczonych(model);
                System.out.println(test);
            }
        });

        anuluj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
            }
        });


        table.setBounds(300, 400, 500, 200);
        table.setLocation(100, 300);
        frame.setSize(500, 250);
        panel1.setSize(500, 200);
        panel2.setSize(500, 50);
        panel2.setLocation(0, 0);
        JScrollPane sp = new JScrollPane(table);
        panel1.add(sp);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //zle wyswietlanie

    }
    public DefaultTableModel modelTabeli(){
        DefaultTableModel model = new DefaultTableModel(new Object[]{"kolumna 1", "kolumna2", "kolumna3",  "kolumna4", "kolumna5", "kolumna6", "kolumna7", "kolumna8"}, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return Boolean.class;
            }
        };
        for (int index = 0; index < 10; index++) {
            model.addRow(new Object[]{Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,Boolean.FALSE});
        }
        return model;
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


    public SalaKinowa(){
        budowaSali();

    }

    public void run(){
        while (true){
            budowaSali();
            try {
                Thread.sleep(200);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SalaKinowa sala = new SalaKinowa();
        //sala.tabelka();
    }
}
