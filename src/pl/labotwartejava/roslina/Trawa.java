package pl.labotwartejava.roslina;

import pl.labotwartejava.Organizm;
import pl.labotwartejava.Swiat;

public class Trawa extends Roslina{
    public Trawa(int sila, int x, int y, Swiat swiat) {
        super(sila, x, y, swiat);
    }

    @Override
    public void akcja() {
    }

    @Override
    public void kolizja(Organizm organizm, boolean czyatakuje) {
    }

    @Override
    public char rysowanie() {
        return 'T';
    }
}
