package model;

import java.util.ArrayList;
import java.util.List;

public class Utilizator {
    private String username;
    private boolean premium;
    private List<Film> playlist;

    public Utilizator(String username, boolean premium) {
        this.username = username;
        this.premium = premium;
        this.playlist = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public boolean isPremium() {
        return premium;
    }

    public void adaugaLaPlaylist(Film film) {
        playlist.add(film);
    }

    public List<Film> getPlaylist() {
        return playlist;
    }

    @Override
    public String toString() {
        return username + (premium ? " (Premium)" : " (Standard)");
    }
}