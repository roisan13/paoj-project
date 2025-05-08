package main;

import model.*;
import service.StreamingService;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StreamingService service = new StreamingService();
        rulareTest(service);
        rulareMeniu(service);
    }

    private static void rulareTest(StreamingService service) {
        // Filme
        Film f1 = new Film("Inception", "Thriller SF", 2010,
                Arrays.asList("SF", "Thriller"), Arrays.asList("DiCaprio"), false);
        Film f2 = new Film("The Matrix", "Actiune cibernetica", 1999,
                Arrays.asList("Actiune", "SF"), Arrays.asList("Keanu Reeves"), true);

        service.adaugaFilm(f1);
        service.adaugaFilm(f2);

        // Utilizatori
        Utilizator u1 = new Utilizator("andrei", false);
        Utilizator u2 = new Utilizator("maria", true);

        service.inregistreazaUtilizator(u1);
        service.inregistreazaUtilizator(u2);

        // Recenzii
        service.adaugaRecenzie("andrei", "Inception", "Foarte tare", 5);
        service.adaugaRecenzie("maria", "The Matrix", "Excelent", 4);

        // Statistici
        System.out.println("Toate filmele:");
        service.afiseazaToateFilmele();

        System.out.println("\nUtilizatori premium:");
        service.afiseazaUtilizatoriPremium();

        System.out.println("\nRecenzii pentru Inception:");
        service.afiseazaRecenziiPentruFilm("Inception");
    }

    private static void rulareMeniu(StreamingService service) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- MENIU ---");
            System.out.println("1. Adauga utilizator");
            System.out.println("2. Adauga film");
            System.out.println("3. Adauga recenzie la film");
            System.out.println("4. Afiseaza toate filmele");
            System.out.println("5. Afiseaza utilizatori");
            System.out.println("6. Afiseaza recenzii pentru un film");
            System.out.println("0. Iesire");
            System.out.print("Alege optiunea: ");

            int opt = Integer.parseInt(scanner.nextLine());
            switch (opt) {
                case 1:
                    System.out.print("Introdu username: ");
                    String user = scanner.nextLine();
                    System.out.print("Este premium? (true/false): ");
                    boolean premium = Boolean.parseBoolean(scanner.nextLine());
                    service.inregistreazaUtilizator(new Utilizator(user, premium));
                    break;
                case 2:
                    System.out.print("Titlu film: ");
                    String titlu = scanner.nextLine();
                    System.out.print("Descriere: ");
                    String descriere = scanner.nextLine();
                    System.out.print("An lansare: ");
                    int an = Integer.parseInt(scanner.nextLine());
                    System.out.print("Genuri separate prin virgula: ");
                    String[] genuri = scanner.nextLine().split(",");
                    System.out.print("Actori separati prin virgula: ");
                    String[] actori = scanner.nextLine().split(",");
                    System.out.print("Este premium? (true/false): ");
                    boolean isPrem = Boolean.parseBoolean(scanner.nextLine());
                    service.adaugaFilm(new Film(titlu, descriere, an, Arrays.asList(genuri), Arrays.asList(actori), isPrem));
                    break;
                case 3:
                    System.out.print("Username: ");
                    String u = scanner.nextLine();
                    System.out.print("Titlu film: ");
                    String tf = scanner.nextLine();
                    System.out.print("Comentariu: ");
                    String com = scanner.nextLine();
                    System.out.print("Stele (1-5): ");
                    int stele = Integer.parseInt(scanner.nextLine());
                    service.adaugaRecenzie(u, tf, com, stele);
                    break;
                case 4:
                    service.afiseazaToateFilmele();
                    break;
                case 5:
                    service.afiseazaUtilizatori();
                    break;
                case 6:
                    System.out.print("Titlu film: ");
                    String tf2 = scanner.nextLine();
                    service.afiseazaRecenziiPentruFilm(tf2);
                    break;
                case 0:
                    System.out.println("La revedere!");
                    return;
                default:
                    System.out.println("Optiune invalida.");
            }
        }
    }
}
