// main/Main.java
package main;

import model.*;
import service.StreamingService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StreamingService service = new StreamingService();
        demo(service);
        rulareMeniu(service);
    }

    private static void demo(StreamingService service) {
        service.adaugaUtilizatorPremium("ana", "1234-5678-9012-3456", "12/26");
        service.adaugaUtilizator("bogdan", false);

        service.adaugaFilm("Interstellar", "Calatorie in spatiu", 2014, true);
        service.adaugaFilm("Shrek", "Comedie animata", 2001, false);

        service.adaugaRecenzie(1, 1, "Fenomenal", 5);
        service.adaugaRecenzie(2, 2, "Super amuzant", 4);

        service.vizioneazaFilm(1, 1);
        service.vizioneazaFilm(2, 2);
        service.vizioneazaFilm(2, 2);

        System.out.println("\n--- DEMO ---");
        System.out.println("\nUtilizatori:");
        service.afiseazaUtilizatori();

        System.out.println("\nFilme:");
        service.afiseazaFilme();

        System.out.println("\nRecenzii film 1:");
        service.afiseazaRecenziiFilm(1);

        System.out.println("\nFilme sortate:");
        service.afiseazaFilmeSortate();

        System.out.println("\nVizionari:");
        service.afiseazaToateVizionarile();

        System.out.println("--- END DEMO ---\n");
    }

    private static void rulareMeniu(StreamingService service) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENIU ---");
            System.out.println("1. Adauga utilizator");
            System.out.println("2. Adauga film");
            System.out.println("3. Afiseaza toti utilizatorii");
            System.out.println("4. Afiseaza toate filmele");
            System.out.println("5. Afiseaza toate recenziile");
            System.out.println("6. Afiseaza recenzii pentru un film");
            System.out.println("7. Adauga recenzie film (de la utilizator)");
            System.out.println("8. Afiseaza filme sortate dupa rating/vizionari/an lansare");
            System.out.println("9. Vizualizeaza film (de la utilizator)");
            System.out.println("10. Afiseaza toate vizionarile");
            System.out.println("0. Iesire");
            System.out.print("Alege optiunea: ");

            int opt = Integer.parseInt(scanner.nextLine());
            switch (opt) {
                case 1 -> {
                    System.out.print("Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Este premium? (true/false): ");
                    boolean premium = Boolean.parseBoolean(scanner.nextLine());
                    if (premium) {
                        System.out.print("Card bancar: ");
                        String card = scanner.nextLine();
                        System.out.print("Data expirare (MM/YY): ");
                        String data = scanner.nextLine();
                        service.adaugaUtilizatorPremium(username, card, data);
                    } else {
                        service.adaugaUtilizator(username, false);
                    }
                }
                case 2 -> {
                    System.out.print("Titlu: ");
                    String titlu = scanner.nextLine();
                    System.out.print("Descriere: ");
                    String descriere = scanner.nextLine();
                    System.out.print("An lansare: ");
                    int an = Integer.parseInt(scanner.nextLine());
                    System.out.print("Este premium? (true/false): ");
                    boolean premium = Boolean.parseBoolean(scanner.nextLine());
                    service.adaugaFilm(titlu, descriere, an, premium);
                }
                case 3 -> service.afiseazaUtilizatori();
                case 4 -> service.afiseazaFilme();
                case 5 -> service.afiseazaToateRecenziile();
                case 6 -> {
                    System.out.print("ID film: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    service.afiseazaRecenziiFilm(id);
                }
                case 7 -> {
                    System.out.print("ID utilizator: ");
                    int idUser = Integer.parseInt(scanner.nextLine());
                    System.out.print("ID film: ");
                    int idFilm = Integer.parseInt(scanner.nextLine());
                    System.out.print("Comentariu: ");
                    String comentariu = scanner.nextLine();
                    System.out.print("Stele (1-5): ");
                    int stele = Integer.parseInt(scanner.nextLine());
                    service.adaugaRecenzie(idUser, idFilm, comentariu, stele);
                }
                case 8 -> service.afiseazaFilmeSortate();
                case 9 -> {
                    System.out.print("ID utilizator: ");
                    int idUser = Integer.parseInt(scanner.nextLine());
                    System.out.print("ID film: ");
                    int idFilm = Integer.parseInt(scanner.nextLine());
                    service.vizioneazaFilm(idUser, idFilm);
                }
                case 10 -> service.afiseazaToateVizionarile();
                case 0 -> {
                    System.out.println("La revedere!");
                    return;
                }
                default -> System.out.println("Optiune invalida.");
            }
        }
    }
}
