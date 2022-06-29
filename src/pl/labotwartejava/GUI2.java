package pl.labotwartejava;

import javax.swing.*;
import java.awt.*;

public class GUI2 extends JFrame {
    Swiat swiat;
    JPanel panel;

    public GUI2(Swiat swiat) {
        this.swiat = swiat;
        setSize(800, 600);
        setLocation(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Adam Lewandowski 180355");
//        setLayout(new GridLayout(20,20));
//        setBackground(Color.red);
        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        dodajPlanszeDoOkna(swiat);
        this.add(panel,BorderLayout.NORTH);
        setVisible(true);

    }

    void dodajPlanszeDoOkna(Swiat swiat) {
        JLabel[][] pola = createLabels(swiat);

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                panel.add(pola[i][j]);
            }
        }
    }

    public JLabel[][] createLabels(Swiat swiat) {
        JLabel[][] p = new JLabel[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                p[i][j] = new JLabel(String.valueOf(swiat.getPlansza(i, j)));
//                p[i][j].setBackground(Color.BLUE);
//                p[i][j].setFont(new Font("Arial",Font.BOLD,20));
//                p[i][j].setPreferredSize(new Dimension(20, 20));
            }
        }
        return p;
    }
}
