package GUI;

import javax.swing.*;

public class AdminMenuGUI {
    public JPanel panel1;
    private JTextField textField1;
    private JButton dodajFilmButton;
    private JButton usuńFilmButton;
    private JButton wyświetlListęRezerwacjiButton;
    private JButton wylogujButton;
    private JButton zarządzajButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("AdminMenuGUI");
        frame.setContentPane(new AdminMenuGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
