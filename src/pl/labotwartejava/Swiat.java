package pl.labotwartejava;

import pl.labotwartejava.zwierze.*;
import pl.labotwartejava.roslina.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Swiat {

    private GUI apka;
    private final char[][] plansza = new char[20][20];
    private final HashMap<Organizm, Integer> inicjatywy = new HashMap<Organizm, Integer>();
    private final List<Organizm> doZabicia = new ArrayList<>();
    public Organizm[][] organizmy = new Organizm[20][20];

    void rysujSwiat(GUI apka) {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (organizmy[i][j] != null) plansza[i][j] = organizmy[i][j].rysowanie();
                else plansza[i][j] = ' ';
            }
        }
        apka.dodajPlanszeDoOkna(this);
    }

    void wykonajTure(GUI apka) {
        this.apka = apka;
        doZabicia.clear();
        List<Integer> listainicjatyw = new ArrayList<>(inicjatywy.values());
        listainicjatyw.sort(Collections.reverseOrder());

        int poprz = 0;
        for (Integer i : listainicjatyw) {
            if (i == poprz) continue;
            else poprz = i;
            for (Organizm o : inicjatywy.keySet()) {
                if (o.getInicjatywa() == i) {
                    if (!doZabicia.contains(o)) {
                        if (o.getBlokada() > 0) o.setBlokada(o.getBlokada() - 1);
                        else o.akcja();
                    }
                }
            }
        }
        for (Organizm o : doZabicia) usunOrganizmZeSwiata(o);
        rysujSwiat(apka);
    }

    public void dodajOrganizmDoSwiata(Organizm organizm) {
        dodajOrganizmNaPlansze(organizm);
        inicjatywy.put(organizm, organizm.getInicjatywa());
    }

    public void usunOrganizmZeSwiata(Organizm organizm) {
        inicjatywy.remove(organizm);
    }

    public void dodajOrganizmNaPlansze(Organizm organizm) {
        int x = organizm.getX();
        int y = organizm.getY();
        if (organizmy[y][x] != null) organizm.kolizja(organizmy[y][x], true);
        else organizmy[y][x] = organizm;
    }

    public void usunOrganizmZPlanszy(Organizm organizm) {
        int x = organizm.getX();
        int y = organizm.getY();

        organizmy[y][x] = null;
    }

    public char getPlansza(int x, int y) {
        return plansza[x][y];
    }

    public Boolean wychodziZaPlansze(int x, int y) {
        return x < 0 || x >= 20 || y < 0 || y >= 20;
    }

    public void zarejestrujZabojstwo(Organizm organizm, boolean czyusuwac) {
        if (czyusuwac) usunOrganizmZPlanszy(organizm);
        doZabicia.add(organizm);
        apka.wypiszZdarzenie(organizm);
    }

    public void wczytajGre() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("gra.txt"));
            String line;
            int sila, inicjatywa, x, y, blokada;
            boolean niewlasciwyPlik=false;

            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    if (organizmy[j][i] != null) {
                        usunOrganizmZeSwiata(organizmy[j][i]);
                        organizmy[j][i] = null;
                    }
                }
            }

            while ((line = reader.readLine()) != null){
                switch (line) {
                    case "W" -> {
                        sila = Integer.parseInt(reader.readLine());
                        inicjatywa = Integer.parseInt(reader.readLine());
                        x = Integer.parseInt(reader.readLine());
                        y = Integer.parseInt(reader.readLine());
                        blokada = Integer.parseInt(reader.readLine());
                        this.dodajOrganizmDoSwiata(new Wilk(sila, inicjatywa, x, y, this));
                        organizmy[y][x].setBlokada(blokada);
                    }
                    case "O" -> {
                        sila = Integer.parseInt(reader.readLine());
                        inicjatywa = Integer.parseInt(reader.readLine());
                        x = Integer.parseInt(reader.readLine());
                        y = Integer.parseInt(reader.readLine());
                        blokada = Integer.parseInt(reader.readLine());
                        this.dodajOrganizmDoSwiata(new Owca(sila, inicjatywa, x, y, this));
                        organizmy[y][x].setBlokada(blokada);
                    }
                    case "L" -> {
                        sila = Integer.parseInt(reader.readLine());
                        inicjatywa = Integer.parseInt(reader.readLine());
                        x = Integer.parseInt(reader.readLine());
                        y = Integer.parseInt(reader.readLine());
                        blokada = Integer.parseInt(reader.readLine());
                        this.dodajOrganizmDoSwiata(new Lis(sila, inicjatywa, x, y, this));
                        organizmy[y][x].setBlokada(blokada);
                    }
                    case "J" -> {
                        sila = Integer.parseInt(reader.readLine());
                        inicjatywa = Integer.parseInt(reader.readLine());
                        x = Integer.parseInt(reader.readLine());
                        y = Integer.parseInt(reader.readLine());
                        blokada = Integer.parseInt(reader.readLine());
                        this.dodajOrganizmDoSwiata(new Jez(sila, inicjatywa, x, y, this));
                        organizmy[y][x].setBlokada(blokada);
                    }
                    case "K" -> {
                        sila = Integer.parseInt(reader.readLine());
                        inicjatywa = Integer.parseInt(reader.readLine());
                        x = Integer.parseInt(reader.readLine());
                        y = Integer.parseInt(reader.readLine());
                        blokada = Integer.parseInt(reader.readLine());
                        this.dodajOrganizmDoSwiata(new Kangur(sila, inicjatywa, x, y, this));
                        organizmy[y][x].setBlokada(blokada);
                    }
                    case "T" -> {
                        sila = Integer.parseInt(reader.readLine());
                        inicjatywa = Integer.parseInt(reader.readLine());
                        x = Integer.parseInt(reader.readLine());
                        y = Integer.parseInt(reader.readLine());
                        blokada = Integer.parseInt(reader.readLine());
                        this.dodajOrganizmDoSwiata(new Trawa(sila, x, y, this));
                        organizmy[y][x].setBlokada(blokada);
                    }
                    case "M" -> {
                        sila = Integer.parseInt(reader.readLine());
                        inicjatywa = Integer.parseInt(reader.readLine());
                        x = Integer.parseInt(reader.readLine());
                        y = Integer.parseInt(reader.readLine());
                        blokada = Integer.parseInt(reader.readLine());
                        this.dodajOrganizmDoSwiata(new Mlecz(sila, x, y, this));
                        organizmy[y][x].setBlokada(blokada);
                    }
                    case "G" -> {
                        sila = Integer.parseInt(reader.readLine());
                        inicjatywa = Integer.parseInt(reader.readLine());
                        x = Integer.parseInt(reader.readLine());
                        y = Integer.parseInt(reader.readLine());
                        blokada = Integer.parseInt(reader.readLine());
                        this.dodajOrganizmDoSwiata(new Guarana(sila, x, y, this));
                        organizmy[y][x].setBlokada(blokada);
                    }
                    case "" -> {

                    }
                    default -> {
                        apka.wypiszNiewlasciwyPlik();
                        niewlasciwyPlik=true;
                    }
                }
                if(niewlasciwyPlik) break;
            }

                reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        rysujSwiat(apka);
    }

    public void zapiszGre() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("gra.txt"));

            for (Organizm o : inicjatywy.keySet()) {
                writer.write(o.rysowanie() + "\n");
                writer.write(String.valueOf(o.getSila()) + "\n");
                writer.write(String.valueOf(o.getInicjatywa()) + "\n");
                writer.write(String.valueOf(o.getX()) + "\n");
                writer.write(String.valueOf(o.getY()) + "\n");
                writer.write(String.valueOf(o.getBlokada()) + "\n");
                writer.write("\n");
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
