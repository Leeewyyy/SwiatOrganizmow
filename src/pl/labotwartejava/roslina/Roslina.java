package pl.labotwartejava.roslina;

import pl.labotwartejava.Organizm;
import pl.labotwartejava.Swiat;

public abstract class Roslina extends Organizm {

    Roslina(int sila, int x, int y, Swiat swiat) {
        super(sila, 0, x, y, swiat);
    }

    @Override
    public void akcja() {

    }

    @Override
    public void kolizja(Organizm organizm, boolean czyatakuje) {

    }

    @Override
    public char rysowanie() {

        return 0;
    }
}
