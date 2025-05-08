package service;

import model.*;

import java.util.*;
import java.util.stream.Collectors;

public class StreamingService {
    private List<Film> filme;
    private Map<String, Utilizator> utilizatori;

    public StreamingService() {
        this.filme = new ArrayList<>();
        this.utilizatori = new HashMap<>();
    }

    public void adaugaFilm(Film film) {
        filme.add(film);
    }

    public void inregistreazaUtilizator(Utilizator utilizator) {
        utilizatori.put(utilizator.getUsername(), utilizator);
    }

    public Utilizator getUtilizator(String username) {
        return utilizatori.get(username);
    }

    public void adaugaRecenzie(String username, String titluFilm, String comentariu, int stele) {
        Film film = filme.stream().filter(f -> f.getTitlu().equalsIgnoreCase(titluFilm)).findFirst().orElse(null);
        if (film != null) {
            Recenzie r = new Recenzie(username, comentariu, stele);
            film.adaugaRecenzie(r);
        }
    }

    public List<Film> getToateFilmele() {
        return filme;
    }

    public List<Film> getFilmePremium() {
        return filme.stream().filter(Film::isEstePremium).collect(Collectors.toList());
    }

    public List<Film> getFilmeDupaGen(String gen) {
        return filme.stream()
                .filter(f -> f.getGenuri().stream().anyMatch(g -> g.equalsIgnoreCase(gen)))
                .collect(Collectors.toList());
    }

    public void afiseazaRecenziiPentruFilm(String titlu) {
        filme.stream()
                .filter(f -> f.getTitlu().equalsIgnoreCase(titlu))
                .flatMap(f -> f.getRecenzii().stream())
                .forEach(System.out::println);
    }

    public void afiseazaUtilizatori() {
        utilizatori.values().forEach(System.out::println);
    }

    public void afiseazaUtilizatoriPremium() {
        utilizatori.values().stream().filter(Utilizator::isPremium).forEach(System.out::println);
    }

    public void afiseazaToateFilmele() {
        filme.forEach(System.out::println);
    }
}
 