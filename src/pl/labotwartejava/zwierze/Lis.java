package pl.labotwartejava.zwierze;

import pl.labotwartejava.Organizm;
import pl.labotwartejava.Swiat;

import java.util.concurrent.ThreadLocalRandom;

public class Lis extends Zwierze {
    public Lis(int sila, int inicjatywa, int x, int y, Swiat swiat) {
        super(sila, inicjatywa, x, y, swiat);
    }

    @Override
    public void akcja() {
        int newx, newy, szanse = 50;
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

            szanse--;
            if (szanse <= 0 && !swiat.wychodziZaPlansze(newx, newy)) break;
        } while (swiat.wychodziZaPlansze(newx, newy) || swiat.organizmy[newx][newy] != null);

        this.x = newx;
        this.y = newy;
        swiat.dodajOrganizmNaPlansze(this);
    }

    @Override
    public void kolizja(Organizm organizm, boolean czyatakuje) {
        super.kolizja(organizm, czyatakuje);
    }

    @Override
    public char rysowanie() {
        return 'L';
    }
}
