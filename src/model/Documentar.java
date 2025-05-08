package model;

import java.util.ArrayList;
import java.util.List;

public class Documentar implements Reviewable, Viewable {
    private String titlu;
    private String autor;
    private int durataMinute;
    private String subiect;
    private boolean estePremium;

    private double rating;
    private int numarRecenzii;
    private int numarVizionari;
    private List<Recenzie> recenzii;

    public Documentar(String titlu, String autor, int durataMinute, String subiect, boolean estePremium) {
        this.titlu = titlu;
        this.autor = autor;
        this.durataMinute = durataMinute;
        this.subiect = subiect;
        this.estePremium = estePremium;
        this.rating = 0.0;
        this.numarRecenzii = 0;
        this.numarVizionari = 0;
        this.recenzii = new ArrayList<>();
    }

    @Override
    public void adaugaRecenzie(Recenzie recenzie) {
        recenzii.add(recenzie);
        double total = rating * numarRecenzii;
        numarRecenzii++;
        rating = (total + recenzie.getStele()) / numarRecenzii;
    }

    @Override
    public void vizioneaza() {
        numarVizionari++;
    }

    @Override
    public int getNumarVizionari() {
        return numarVizionari;
    }

    @Override
    public String getTitlu() {
        return titlu;
    }

    @Override
    public boolean isEstePremium() {
        return estePremium;
    }

    @Override
    public double getRating() {
        return rating;
    }

    @Override
    public int getNumarRecenzii() {
        return numarRecenzii;
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

    public List<Recenzie> getRecenzii() {
        return recenzii;
    }

    @Override
    public String toString() {
        return titlu + " | Autor: " + autor + " | Durata: " + durataMinute + " min | Subiect: " + subiect +
                " | Rating: " + String.format("%.2f", rating) +
                " | Vizionari: " + numarVizionari + " | Premium: " + estePremium;
    }
}
