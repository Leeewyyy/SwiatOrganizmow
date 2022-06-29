package pl.labotwartejava;

public abstract class Organizm {

    protected int sila, inicjatywa, x, y, blokada = 0;
    protected Swiat swiat;

    protected Organizm(int sila, int inicjatywa, int x, int y, Swiat swiat) {
        this.inicjatywa = inicjatywa;
        this.sila = sila;
        this.x = x;
        this.y = y;
        this.swiat = swiat;
    }

    public abstract void akcja();

    public abstract void kolizja(Organizm organizm, boolean czyatakuje);

    public abstract char rysowanie();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getInicjatywa() {
        return inicjatywa;
    }

    public void setSila(int sila) { this.sila=sila; }

    public int getSila() {
        return sila;
    }

    public void setBlokada(int blokada) {
        this.blokada = blokada;
    }

    public int getBlokada(){
        return blokada;
    }
}
