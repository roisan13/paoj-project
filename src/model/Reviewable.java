package model;

public interface Reviewable {
    void adaugaRecenzie(Recenzie recenzie);
    double getRating();
    int getNumarRecenzii();
}