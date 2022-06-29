package pl.labotwartejava.roslina;

import pl.labotwartejava.Organizm;
import pl.labotwartejava.Swiat;

public class Mlecz extends Roslina {
    public Mlecz(int sila, int x, int y, Swiat swiat) {
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
        return 'M';
    }
}
