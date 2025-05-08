package model;

public class Documentar extends Continut {
    private String autor;
    private int durataMinute;
    private String subiect;

    public Documentar(String titlu, String autor, int durataMinute, String subiect, boolean estePremium) {
        super(titlu, estePremium);
        this.autor = autor;
        this.durataMinute = durataMinute;
        this.subiect = subiect;
    }

    public String getAutor() {
        return autor;
    }

    public int getDurataMinute() {
        return durataMinute;
    }

    public String getSubiect() {
        return subiect;
    }

    @Override
    public String toString() {
        return "Documentar: " + super.toString() + " | Autor: " + autor + " | Durata: " + durataMinute + " min";
    }
}
