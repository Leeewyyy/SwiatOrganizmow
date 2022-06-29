package pl.labotwartejava;

import pl.labotwartejava.zwierze.*;
import pl.labotwartejava.roslina.*;

import javax.swing.*;
import java.awt.*;

public class OknoDodania extends JFrame {
    private final char org;
    private final Swiat swiat;
    private final GUI apka;
    private final JLabel warning;

    public OknoDodania(char org, Swiat swiat, GUI apka) {
        this.org = org;
        this.swiat = swiat;
        this.apka = apka;
        setSize(new Dimension(600, 200));
        setLocation(800, 600);
        setTitle("Wybor miejsca");
        setLayout(new FlowLayout());

        JLabel x = new JLabel("Podaj x:");
        add(x);
        JTextField tx = new JTextField();
        tx.setPreferredSize(new Dimension(20, 20));
        add(tx);
        JLabel y = new JLabel("Podaj y:");
        add(y);
        JTextField ty = new JTextField();
        ty.setPreferredSize(new Dimension(20, 20));
        add(ty);
        JButton dodaj = new JButton("Dodaj");
        add(dodaj);
        warning = new JLabel();
        add(warning);

        try {
            dodaj.addActionListener(e -> dodajOrganizm(Integer.parseInt(tx.getText()), Integer.parseInt(ty.getText())));
        }
        catch (NumberFormatException n) {
            warning.setText("Na tym polu juz znajduje sie organizm lub dane sa nieprawidlowe!");
        }



        setVisible(true);
    }

    void dodajOrganizm(int x, int y) {
        if (!swiat.wychodziZaPlansze(x,y) && swiat.organizmy[y][x] == null) {
            switch (org) {
                case 'w':
                    swiat.dodajOrganizmDoSwiata(new Wilk(9, 4, x, y, swiat));
                    break;
                case 'o':
                    swiat.dodajOrganizmDoSwiata(new Owca(4, 4, x, y, swiat));
                    break;
                case 'l':
                    swiat.dodajOrganizmDoSwiata(new Lis(3, 7, x, y, swiat));
                    break;
                case 'j':
                    swiat.dodajOrganizmDoSwiata(new Jez(2, 3, x, y, swiat));
                    break;
                case 'k':
                    swiat.dodajOrganizmDoSwiata(new Kangur(7, 6, x, y, swiat));
                    break;
                case 't':
                    swiat.dodajOrganizmDoSwiata(new Trawa(0, x, y, swiat));
                    break;
                case 'm':
                    swiat.dodajOrganizmDoSwiata(new Mlecz(0, x, y, swiat));
                    break;
                case 'g':
                    swiat.dodajOrganizmDoSwiata(new Guarana(0, x, y, swiat));
                    break;
                default:
            }
        }
        else warning.setText("Na tym polu juz znajduje sie organizm lub dane sa nieprawidlowe!");
        swiat.rysujSwiat(apka);
    }
}
