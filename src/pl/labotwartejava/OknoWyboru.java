package pl.labotwartejava;

import javax.swing.*;
import java.awt.*;

public class OknoWyboru extends JFrame {

    public OknoWyboru(Swiat swiat, GUI apka){
        setSize(new Dimension(200,200));
        setLocation(800,600);
        setTitle("Wybor organizmu");
        setLayout(new GridLayout(4,4));

        JButton wilk = new JButton("Wilk");
        add(wilk);
        JButton owca = new JButton("Owca");
        add(owca);
        JButton lis = new JButton("Lis");
        add(lis);
        JButton jez = new JButton("Jez");
        add(jez);
        JButton kangur = new JButton("Kangur");
        add(kangur);
        JButton trawa = new JButton("Trawa");
        add(trawa);
        JButton mlecz = new JButton("Mlecz");
        add(mlecz);
        JButton guarana = new JButton("Guarana");
        add(guarana);

        wilk.addActionListener(e->new OknoDodania('w', swiat, apka));
        owca.addActionListener(e->new OknoDodania('o', swiat, apka));
        lis.addActionListener(e->new OknoDodania('l', swiat, apka));
        jez.addActionListener(e->new OknoDodania('j', swiat, apka));
        kangur.addActionListener(e->new OknoDodania('k', swiat, apka));
        trawa.addActionListener(e->new OknoDodania('t', swiat, apka));
        mlecz.addActionListener(e->new OknoDodania('m', swiat, apka));
        guarana.addActionListener(e->new OknoDodania('g', swiat, apka));

        setVisible(true);
    }
}
