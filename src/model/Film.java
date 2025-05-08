package model;

import java.util.ArrayList;
import java.util.List;

public class Film implements Reviewable, Viewable {
    private String titlu;
    private String descriere;
    private int anLansare;
    private List<String> genuri;
    private List<String> actori;
    private boolean estePremium;

    private double rating;
    private int numarRecenzii;
    private int numarVizionari;
    private List<Recenzie> recenzii;

    public Film(String titlu, String descriere, int anLansare, List<String> genuri, List<String> actori, boolean estePremium) {
        this.titlu = titlu;
        this.descriere = descriere;
        this.anLansare = anLansare;
        this.genuri = genuri;
        this.actori = actori;
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

    public String getDescriere() {
        return descriere;
    }

    public int getAnLansare() {
        return anLansare;
    }

    public List<String> getGenuri() {
        return genuri;
    }

    public List<String> getActori() {
        return actori;
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

    public List<Recenzie> getRecenzii() {
        return recenzii;
    }

    @Override
    public String toString() {
        return titlu + " (" + anLansare + ") | Rating: " + String.format("%.2f", rating) +
                " | Vizionari: " + numarVizionari + " | Premium: " + estePremium;
    }
}
