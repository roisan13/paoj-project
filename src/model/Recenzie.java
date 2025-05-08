package model;

public class Recenzie {
    private String utilizator;
    private String comentariu;
    private int stele;

    public Recenzie(String utilizator, String comentariu, int stele) {
        this.utilizator = utilizator;
        this.comentariu = comentariu;
        this.stele = stele;
    }

    public String getUtilizator() {
        return utilizator;
    }

    public String getComentariu() {
        return comentariu;
    }

    public int getStele() {
        return stele;
    }

    @Override
    public String toString() {
        return utilizator + " (" + stele + " stele): " + comentariu;
    }
}