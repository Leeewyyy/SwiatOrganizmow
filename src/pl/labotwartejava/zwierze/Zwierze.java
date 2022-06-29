package pl.labotwartejava.zwierze;

import pl.labotwartejava.Organizm;
import pl.labotwartejava.Swiat;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Zwierze extends Organizm {

    Zwierze(int sila, int inicjatywa, int x, int y, Swiat swiat) {
        super(sila, inicjatywa, x, y, swiat);
    }

    @Override
    public void akcja() {
        int newx, newy;
        swiat.usunOrganizmZPlanszy(this);
        do {
            newx = this.x;
            newy = this.y;
            int gdziex = ThreadLocalRandom.current().nextInt(0, 3);
            int gdziey = ThreadLocalRandom.current().nextInt(0, 3);

            if (gdziex == 0) newx -= 1;
            else if (gdziex == 2) newx += 1;
            if (gdziey == 0) newy -= 1;
            else if (gdziey == 2) newy += 1;
        } while (swiat.wychodziZaPlansze(newx, newy));

        this.x = newx;
        this.y = newy;
        swiat.dodajOrganizmNaPlansze(this);
    }

    @Override
    public void kolizja(Organizm organizm, boolean czyatakuje) {
        if (czyatakuje) {
            if (organizm.getSila() > this.sila) {
                swiat.zarejestrujZabojstwo(this, false);
            } else {
                swiat.zarejestrujZabojstwo(organizm, true);
                swiat.dodajOrganizmNaPlansze(this);
            }
            organizm.kolizja(this, false);
        }
    }

    @Override
    public char rysowanie() {

        return 0;
    }
}
