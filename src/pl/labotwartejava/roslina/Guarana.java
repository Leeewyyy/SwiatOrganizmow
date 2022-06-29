package pl.labotwartejava.roslina;

import pl.labotwartejava.Organizm;
import pl.labotwartejava.Swiat;

public class Guarana extends Roslina {
    public Guarana(int sila, int x, int y, Swiat swiat) {
        super(sila, x, y, swiat);
    }

    @Override
    public void akcja() {
    }

    @Override
    public void kolizja(Organizm organizm, boolean czyatakuje) {
        organizm.setSila(organizm.getSila()+3);
    }

    @Override
    public char rysowanie() {
        return 'G';
    }
}
