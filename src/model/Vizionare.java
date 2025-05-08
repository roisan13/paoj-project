package model;

import java.time.LocalDateTime;

public class Vizionare {
    private String utilizator;
    private String titluFilm;
    private LocalDateTime dataVizionarii;

    public Vizionare(String utilizator, String titluFilm) {
        this.utilizator = utilizator;
        this.titluFilm = titluFilm;
        this.dataVizionarii = LocalDateTime.now();
    }

    public String getUtilizator() {
        return utilizator;
    }

    public String getTitluFilm() {
        return titluFilm;
    }

    public LocalDateTime getDataVizionarii() {
        return dataVizionarii;
    }

    @Override
    public String toString() {
        return utilizator + " a vizionat \"" + titluFilm + "\" la " + dataVizionarii;
    }
}
