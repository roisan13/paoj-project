package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Continut implements Viewable, Reviewable {
    protected String titlu;
    protected boolean estePremium;
    protected int numarVizionari;

    protected double rating;
    protected int numarRecenzii;
    protected List<Recenzie> recenzii;

    public Continut(String titlu, boolean estePremium) {
        this.titlu = titlu;
        this.estePremium = estePremium;
        this.numarVizionari = 0;
        this.rating = 0.0;
        this.numarRecenzii = 0;
        this.recenzii = new ArrayList<>();
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
    public void vizioneaza() {
        numarVizionari++;
    }

    @Override
    public int getNumarVizionari() {
        return numarVizionari;
    }

    @Override
    public void adaugaRecenzie(Recenzie recenzie) {
        recenzii.add(recenzie);
        double total = rating * numarRecenzii;
        numarRecenzii++;
        rating = (total + recenzie.getStele()) / numarRecenzii;
    }

    @Override
    public double getRating() {
        return rating;
    }

    @Override
    public int getNumarRecenzii() {
        return numarRecenzii;
    }

    public List<Recenzie> getRecenzii() {
        return recenzii;
    }

    @Override
    public String toString() {
        return titlu + " | Vizionari: " + numarVizionari +
                " | Rating: " + String.format("%.2f", rating) +
                " | Premium: " + estePremium;
    }
}
