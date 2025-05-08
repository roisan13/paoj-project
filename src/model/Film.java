package model;

import java.util.List;

public class Film extends Continut {
    private String descriere;
    private int anLansare;
    private List<String> genuri;
    private List<String> actori;

    public Film(String titlu, String descriere, int anLansare, List<String> genuri, List<String> actori, boolean estePremium) {
        super(titlu, estePremium);
        this.descriere = descriere;
        this.anLansare = anLansare;
        this.genuri = genuri;
        this.actori = actori;
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
    public String toString() {
        return "Film: " + super.toString() + " | An: " + anLansare;
    }
}
