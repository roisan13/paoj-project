// service/StreamingService.java
package service;

import model.*;

import java.util.*;

public class StreamingService {
    private Map<Integer, Utilizator> utilizatori;
    private Map<Integer, Continut> continut;
    private List<Recenzie> recenzii;
    private List<Vizionare> vizionari;

    private int idUtilizatorCurent = 0;
    private int idContinutCurent = 0;

    public StreamingService() {
        utilizatori = new HashMap<>();
        continut = new HashMap<>();
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

    public void adaugaFilm(Film f) {
        continut.put(++idContinutCurent, f);
        System.out.println("Film adaugat cu ID: " + idContinutCurent);
    }

    public void adaugaSerial(Serial s) {
        continut.put(++idContinutCurent, s);
        System.out.println("Serial adaugat cu ID: " + idContinutCurent);
    }

    public void adaugaDocumentar(Documentar d) {
        continut.put(++idContinutCurent, d);
        System.out.println("Documentar adaugat cu ID: " + idContinutCurent);
    }

    public void afiseazaUtilizatori() {
        for (Map.Entry<Integer, Utilizator> e : utilizatori.entrySet()) {
            System.out.println("ID " + e.getKey() + ": " + e.getValue());
        }
    }

    public void afiseazaContinut() {
        for (Map.Entry<Integer, Continut> e : continut.entrySet()) {
            System.out.println("ID " + e.getKey() + ": " + e.getValue());
        }
    }

    public void afiseazaToateRecenziile() {
        for (Recenzie r : recenzii) {
            System.out.println(r);
        }
    }

    public void afiseazaRecenziiContinut(int idContinut) {
        Continut c = continut.get(idContinut);
        if (c == null) {
            System.out.println("Continutul nu exista.");
            return;
        }
        for (Recenzie r : c.getRecenzii()) {
            System.out.println(r);
        }
    }

    public void adaugaRecenzie(int idUtilizator, int idContinut, String comentariu, int stele) {
        Utilizator u = utilizatori.get(idUtilizator);
        Continut c = continut.get(idContinut);
        if (u == null || c == null) {
            System.out.println("ID utilizator sau continut invalid.");
            return;
        }
        Recenzie recenzie = new Recenzie(u.getUsername(), comentariu, stele);
        recenzii.add(recenzie);
        c.adaugaRecenzie(recenzie);
        System.out.println("Recenzia a fost adaugata si ratingul a fost actualizat.");
    }

    public void afiseazaContinutSortat() {
        List<Map.Entry<Integer, Continut>> lista = new ArrayList<>(continut.entrySet());

        lista.sort(Comparator.comparingDouble(e -> -e.getValue().getRating()));
        System.out.println("\n-- Continut sortat dupa rating --");
        for (var e : lista) {
            System.out.println("ID " + e.getKey() + ": " + e.getValue());
        }

        lista.sort(Comparator.comparingInt(e -> -e.getValue().getNumarVizionari()));
        System.out.println("\n-- Continut sortat dupa numar de vizionari --");
        for (var e : lista) {
            System.out.println("ID " + e.getKey() + ": " + e.getValue());
        }
    }

    public void vizioneazaContinut(int idUtilizator, int idContinut) {
        Utilizator user = utilizatori.get(idUtilizator);
        Continut c = continut.get(idContinut);

        if (user == null || c == null) {
            System.out.println("ID utilizator sau continut invalid.");
            return;
        }

        if (c.isEstePremium() && !user.isPremium()) {
            System.out.println("Continutul este premium si nu poate fi vizionat de utilizatori standard.");
            return;
        }

        c.vizioneaza();
        vizionari.add(new Vizionare(user.getUsername(), c.getTitlu()));
        System.out.println(user.getUsername() + " a vizionat \"" + c.getTitlu() + "\"");
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
