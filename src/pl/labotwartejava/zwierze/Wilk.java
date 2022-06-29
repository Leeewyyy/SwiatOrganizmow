package pl.labotwartejava.zwierze;

import pl.labotwartejava.Organizm;
import pl.labotwartejava.Swiat;

public class Wilk extends Zwierze{
    public Wilk(int sila, int inicjatywa, int x, int y, Swiat swiat) {
        super(sila, inicjatywa, x, y, swiat);
    }

    @Override
    public void akcja() {
        super.akcja();
    }

    @Override
    public void kolizja(Organizm organizm, boolean czyatakuje) {
        super.kolizja(organizm, czyatakuje);
    }

    @Override
    public char rysowanie() {
        return 'W';
    }
}
