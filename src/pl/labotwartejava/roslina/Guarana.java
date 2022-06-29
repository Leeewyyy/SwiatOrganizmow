package pl.labotwartejava.roslina;

import pl.labotwartejava.Organizm;
import pl.labotwartejava.Swiat;

public class Guarana extends Roslina {
    public Guarana(int sila, int x, int y, Swiat swiat) {
        super(sila, x, y, swiat);
    }

    @Override
    public void akcja() {
        super.akcja();
    }

    @Override
    public void kolizja(Organizm organizm, boolean czyatakuje) {
        organizm.setSila(organizm.getSila()+3);
        super.kolizja(organizm, czyatakuje);
    }

    @Override
    public char rysowanie() {
        super.rysowanie();
        return 'G';
    }
}
