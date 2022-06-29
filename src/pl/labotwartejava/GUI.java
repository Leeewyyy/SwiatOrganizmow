package pl.labotwartejava;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private final JLabel zdarzenie = new JLabel();

    public GUI() {
        this.setSize(1920, 1080);
        this.setTitle("Adam Lewandowski");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    void dodajPlanszeDoOkna(Swiat swiat) {
        JButton button, button2, button3, button4;
        JPanel panel = new JPanel();
        button = new JButton("Nowa tura");
        button2 = new JButton("Zapisz gre");
        button3 = new JButton("Wczytaj gre");
        button4 = new JButton("Dodaj organizm do gry");
        button.setBounds(0, 0, 200, 50);
        button2.setBounds(0, 0, 200, 50);
        button3.setBounds(0, 0, 200, 50);
        button4.setBounds(0, 0, 200, 50);
        button.addActionListener(e -> swiat.wykonajTure(this));
        button.addActionListener(e -> zdarzenie.setText(""));
        button2.addActionListener(e -> swiat.zapiszGre());
        button3.addActionListener(e -> swiat.wczytajGre());
        button4.addActionListener(e -> new OknoWyboru(swiat,this));

        JLabel[][] pola = createLabels(swiat);
        JPanel[] panels = createPanels();

        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBackground(Color.red);

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                panels[i].add(pola[i][j]);
                panels[i].setBackground(Color.BLUE);
            }
            panel.add(panels[i]);
        }

        panel.add(button);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(zdarzenie);
        this.add(panel);
        this.setVisible(true);
    }

    public void wypiszZdarzenie(Organizm organizm) {
        zdarzenie.setText(organizm.rysowanie() + " zostal zabity!");
    }

    public void wypiszNiewlasciwyPlik(){
        zdarzenie.setText("Nie mozna wczytac pliku! Jest niewlasciwy!");
    }

    public JPanel[] createPanels() {
        JPanel[] p = new JPanel[20];
        for (int i = 0; i < 20; i++) {
            p[i] = new JPanel();
            p[i].setMaximumSize(new Dimension(500, 25));
        }
        return p;
    }

    public JLabel[][] createLabels(Swiat swiat) {
        JLabel[][] p = new JLabel[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                p[i][j] = new JLabel(String.valueOf(swiat.getPlansza(i, j)));
                p[i][j].setFont(new Font("Arial", Font.BOLD, 20));
                p[i][j].setPreferredSize(new Dimension(20, 20));
            }
        }
        return p;
    }
}
