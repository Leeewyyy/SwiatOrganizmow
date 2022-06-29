package pl.labotwartejava;

import pl.labotwartejava.roslina.*;
import pl.labotwartejava.zwierze.*;

public class Main {

    public static void main(String[] args) {

        Swiat s1 = new Swiat();
        GUI apka = new GUI();
        Wilk w = new Wilk(9, 5, 1, 0, s1);
        Wilk w2 = new Wilk(9, 5, 1, 1, s1);
        Wilk w3 = new Wilk(9, 5, 0, 1, s1);
        Owca o = new Owca(4, 4, 8, 6, s1);
//        Owca o2 = new Owca(4, 4, 1, 0, s1);
//        Owca o3 = new Owca(4, 4, 0, 1, s1);
//        Owca o4 = new Owca(4, 4, 0, 2, s1);
//        Owca o5 = new Owca(4, 4, 1, 2, s1);
//        Owca o6 = new Owca(4, 4, 2, 2, s1);
//        Owca o7 = new Owca(4, 4, 2, 1, s1);
//        Owca o8 = new Owca(4, 4, 2, 0, s1);
        Jez j = new Jez(2,3,10,10,s1);
//        Jez j2 = new Jez(2,3,1,0,s1);
//        Jez j3 = new Jez(2,3,1,1,s1);
//        Jez j4 = new Jez(2,3,0,1,s1);
        Kangur k = new Kangur(7,6,19,19,s1);
        Lis l = new Lis(0,7,0,0,s1);
        Trawa t = new Trawa(0,0,19,s1);
        Mlecz m = new Mlecz(0,19,2,s1);
        Guarana g = new Guarana(0,5,19,s1);
//        Guarana g2 = new Guarana(0,0,1,s1);
//        Guarana g3 = new Guarana(0,1,1,s1);
//        Guarana g4 = new Guarana(0,1,0,s1);

        s1.dodajOrganizmDoSwiata(w);
        s1.dodajOrganizmDoSwiata(w2);
        s1.dodajOrganizmDoSwiata(w3);
        s1.dodajOrganizmDoSwiata(o);
//        s1.dodajOrganizmDoSwiata(o2);
//        s1.dodajOrganizmDoSwiata(o3);
//        s1.dodajOrganizmDoSwiata(o4);
//        s1.dodajOrganizmDoSwiata(o5);
//        s1.dodajOrganizmDoSwiata(o6);
//        s1.dodajOrganizmDoSwiata(o7);
//        s1.dodajOrganizmDoSwiata(o8);
        s1.dodajOrganizmDoSwiata(j);
//        s1.dodajOrganizmDoSwiata(j2);
//        s1.dodajOrganizmDoSwiata(j3);
//        s1.dodajOrganizmDoSwiata(j4);
        s1.dodajOrganizmDoSwiata(k);
        s1.dodajOrganizmDoSwiata(l);
        s1.dodajOrganizmDoSwiata(t);
        s1.dodajOrganizmDoSwiata(m);
        s1.dodajOrganizmDoSwiata(g);
//        s1.dodajOrganizmDoSwiata(g2);
//        s1.dodajOrganizmDoSwiata(g3);
//        s1.dodajOrganizmDoSwiata(g4);

        s1.rysujSwiat(apka);

    }
}
