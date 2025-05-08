package model;

import java.util.ArrayList;
import java.util.List;

public class Serial implements Reviewable {
    private String titlu;
    private int numarSezoane;
    private List<String> genuri;
    private boolean estePremium;

    private double rating;
    private int numarRecenzii;
    private List<Recenzie> recenzii;

    public Serial(String titlu, int numarSezoane, List<String> genuri, boolean estePremium) {
        this.titlu = titlu;
        this.numarSezoane = numarSezoane;
        this.genuri = genuri;
        this.estePremium = estePremium;
        this.rating = 0.0;
        this.numarRecenzii = 0;
        this.recenzii = new ArrayList<>();
    }

    @Override
    public void adaugaRecenzie(Recenzie recenzie) {
        recenzii.add(recenzie);
        double total = rating * numarRecenzii;
        numarRecenzii++;
        rating = (total + recenzie.getStele()) / numarRecenzii;
    }

    public String getTitlu() {
        return titlu;
    }

    public int getNumarSezoane() {
        return numarSezoane;
    }

    public List<String> getGenuri() {
        return genuri;
    }

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

    public List<Recenzie> getRecenzii() {
        return recenzii;
    }

    @Override
    public String toString() {
        return titlu + " | Sezoane: " + numarSezoane + " | Rating: " +
                String.format("%.2f", rating) + " | Premium: " + estePremium;
    }
}
