package model;

import java.util.List;

public class Serial extends Continut {
    private int numarSezoane;
    private List<String> genuri;

    public Serial(String titlu, int numarSezoane, List<String> genuri, boolean estePremium) {
        super(titlu, estePremium);
        this.numarSezoane = numarSezoane;
        this.genuri = genuri;
    }

    public int getNumarSezoane() {
        return numarSezoane;
    }

    public List<String> getGenuri() {
        return genuri;
    }

    @Override
    public String toString() {
        return "Serial: " + super.toString() + " | Sezoane: " + numarSezoane;
    }
}
