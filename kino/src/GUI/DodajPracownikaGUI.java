package GUI;

import javax.swing.*;

public class DodajPracownikaGUI {
    public JPanel panel1;
    private JTextField nameTxDKG;
    private JTextField nazwiskoTxGKG;
    private JTextField emailTxDKG;
    private JPasswordField password1;
    private JPasswordField password2;
    private JButton anulujButton;
    private JButton zatwierdźButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("DodajPracownikaGUI");
        frame.setContentPane(new DodajPracownikaGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
