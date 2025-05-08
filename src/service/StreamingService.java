// service/StreamingService.java
package service;

import model.*;

import java.util.*;

public class StreamingService {
    private Map<Integer, Utilizator> utilizatori;
    private Map<Integer, Film> filme;
    private List<Recenzie> recenzii;
    private List<Vizionare> vizionari;

    private int idUtilizatorCurent = 0;
    private int idFilmCurent = 0;

    public StreamingService() {
        utilizatori = new HashMap<>();
        filme = new HashMap<>();
        recenzii = new ArrayList<>();
        vizionari = new ArrayList<>();
    }

    public void adaugaUtilizator(String username, boolean premium) {
        Utilizator u = new Utilizator(username, premium);
        utilizatori.put(++idUtilizatorCurent, u);
        System.out.println("Utilizator standard adaugat cu ID: " + idUtilizatorCurent);
    }

    public void adaugaUtilizatorPremium(String username, String card, String dataExpirare) {
        UtilizatorPremium up = new UtilizatorPremium(username, card, dataExpirare);
        utilizatori.put(++idUtilizatorCurent, up);
        System.out.println("Utilizator premium adaugat cu ID: " + idUtilizatorCurent);
    }

    public void adaugaFilm(String titlu, String descriere, int an, boolean estePremium) {
        Film f = new Film(titlu, descriere, an, new ArrayList<>(), new ArrayList<>(), estePremium);
        filme.put(++idFilmCurent, f);
        System.out.println("Film adaugat cu ID: " + idFilmCurent);
    }

    public void afiseazaUtilizatori() {
        for (Map.Entry<Integer, Utilizator> e : utilizatori.entrySet()) {
            System.out.println("ID " + e.getKey() + ": " + e.getValue());
        }
    }

    public void afiseazaFilme() {
        for (Map.Entry<Integer, Film> e : filme.entrySet()) {
            System.out.println("ID " + e.getKey() + ": " + e.getValue());
        }
    }

    public void afiseazaToateRecenziile() {
        for (Recenzie r : recenzii) {
            System.out.println(r);
        }
    }

    public void afiseazaRecenziiFilm(int idFilm) {
        Film film = filme.get(idFilm);
        if (film == null) {
            System.out.println("Filmul nu exista.");
            return;
        }
        for (Recenzie r : film.getRecenzii()) {
            System.out.println(r);
        }
    }

    public void adaugaRecenzie(int idUtilizator, int idFilm, String comentariu, int stele) {
        Utilizator u = utilizatori.get(idUtilizator);
        Film f = filme.get(idFilm);
        if (u == null || f == null) {
            System.out.println("ID utilizator sau film invalid.");
            return;
        }
        Recenzie recenzie = new Recenzie(u.getUsername(), comentariu, stele);
        recenzii.add(recenzie);
        f.adaugaRecenzie(recenzie);
        System.out.println("Recenzia a fost adaugata si ratingul a fost actualizat.");
    }

    public void afiseazaFilmeSortate() {
        List<Map.Entry<Integer, Film>> lista = new ArrayList<>(filme.entrySet());

        lista.sort(Comparator.comparingDouble(e -> -e.getValue().getRating()));
        System.out.println("\n-- Filme sortate dupa rating --");
        for (var e : lista) {
            System.out.println("ID " + e.getKey() + ": " + e.getValue());
        }

        lista.sort(Comparator.comparingInt(e -> -e.getValue().getNumarVizionari()));
        System.out.println("\n-- Filme sortate dupa numar de vizionari --");
        for (var e : lista) {
            System.out.println("ID " + e.getKey() + ": " + e.getValue());
        }

        lista.sort(Comparator.comparingInt(e -> -e.getValue().getAnLansare()));
        System.out.println("\n-- Filme sortate dupa an lansare --");
        for (var e : lista) {
            System.out.println("ID " + e.getKey() + ": " + e.getValue());
        }
    }

    public void vizioneazaFilm(int idUtilizator, int idFilm) {
        Utilizator user = utilizatori.get(idUtilizator);
        Film film = filme.get(idFilm);

        if (user == null || film == null) {
            System.out.println("ID utilizator sau film invalid.");
            return;
        }

        if (film.isEstePremium() && !user.isPremium()) {
            System.out.println("Filmul este premium si nu poate fi vizionat de utilizatori standard.");
            return;
        }

        film.vizioneaza();
        vizionari.add(new Vizionare(user.getUsername(), film.getTitlu()));
        System.out.println(user.getUsername() + " a vizionat \"" + film.getTitlu() + "\"");
    }

    public void afiseazaToateVizionarile() {
        if (vizionari.isEmpty()) {
            System.out.println("Nu exista vizionari inregistrate.");
            return;
        }
        for (Vizionare v : vizionari) {
            System.out.println(v);
        }
    }
}
