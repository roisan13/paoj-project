// main/Main.java
package main;

import model.*;
import service.StreamingService;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StreamingService service = new StreamingService();
        demo(service);
        rulareMeniu(service);
    }

    private static void demo(StreamingService service) {
        // Utilizatori
        service.adaugaUtilizatorPremium("ana", "1234-5678-9012-3456", "12/26");
        service.adaugaUtilizator("bogdan", false);

        // Continut
        service.adaugaFilm(new Film("Interstellar", "Calatorie in spatiu", 2014,
                Arrays.asList("SF", "Drama"), Arrays.asList("McConaughey", "Hathaway"), true));

        service.adaugaSerial(new Serial("Breaking Bad", 5,
                Arrays.asList("Drama", "Crima"), true));

        service.adaugaDocumentar(new Documentar("Cosmos", "Carl Sagan", 60,
                "Universul", false));

        // Recenzii
        service.adaugaRecenzie(1, 1, "Epic si emotionant", 5);
        service.adaugaRecenzie(2, 2, "Foarte intens si bine jucat", 5);
        service.adaugaRecenzie(2, 3, "Informativ si placut", 4);

        // Vizionari
        service.vizioneazaContinut(1, 1);
        service.vizioneazaContinut(1, 2);
        service.vizioneazaContinut(2, 3);
        service.vizioneazaContinut(2, 3);

        // Afisari
        System.out.println("\n--- DEMO ---");
        System.out.println("\nUtilizatori:");
        service.afiseazaUtilizatori();

        System.out.println("\nContinut:");
        service.afiseazaContinut();

        System.out.println("\nRecenzii pentru fiecare continut:");
        service.afiseazaRecenziiContinut(1);
        service.afiseazaRecenziiContinut(2);
        service.afiseazaRecenziiContinut(3);

        System.out.println("\nContinut sortat:");
        service.afiseazaContinutSortat();

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
            System.out.println("3. Adauga serial");
            System.out.println("4. Adauga documentar");
            System.out.println("5. Afiseaza toti utilizatorii");
            System.out.println("6. Afiseaza tot continutul");
            System.out.println("7. Afiseaza toate recenziile");
            System.out.println("8. Afiseaza recenzii pentru un continut");
            System.out.println("9. Adauga recenzie la continut");
            System.out.println("10. Afiseaza continut sortat dupa rating/vizionari");
            System.out.println("11. Vizualizeaza continut");
            System.out.println("12. Afiseaza toate vizionarile");
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
                }
                case 3 -> {
                    System.out.print("Titlu serial: ");
                    String titlu = scanner.nextLine();
                    System.out.print("Numar sezoane: ");
                    int sezoane = Integer.parseInt(scanner.nextLine());
                    System.out.print("Genuri separate prin virgula: ");
                    String[] genuri = scanner.nextLine().split(",");
                    System.out.print("Este premium? (true/false): ");
                    boolean isPrem = Boolean.parseBoolean(scanner.nextLine());
                    service.adaugaSerial(new Serial(titlu, sezoane, Arrays.asList(genuri), isPrem));
                }
                case 4 -> {
                    System.out.print("Titlu documentar: ");
                    String titlu = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Durata (minute): ");
                    int durata = Integer.parseInt(scanner.nextLine());
                    System.out.print("Subiect: ");
                    String subiect = scanner.nextLine();
                    System.out.print("Este premium? (true/false): ");
                    boolean isPrem = Boolean.parseBoolean(scanner.nextLine());
                    service.adaugaDocumentar(new Documentar(titlu, autor, durata, subiect, isPrem));
                }
                case 5 -> service.afiseazaUtilizatori();
                case 6 -> service.afiseazaContinut();
                case 7 -> service.afiseazaToateRecenziile();
                case 8 -> {
                    System.out.print("ID continut: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    service.afiseazaRecenziiContinut(id);
                }
                case 9 -> {
                    System.out.print("ID utilizator: ");
                    int idUser = Integer.parseInt(scanner.nextLine());
                    System.out.print("ID continut: ");
                    int idContinut = Integer.parseInt(scanner.nextLine());
                    System.out.print("Comentariu: ");
                    String comentariu = scanner.nextLine();
                    System.out.print("Stele (1-5): ");
                    int stele = Integer.parseInt(scanner.nextLine());
                    service.adaugaRecenzie(idUser, idContinut, comentariu, stele);
                }
                case 10 -> service.afiseazaContinutSortat();
                case 11 -> {
                    System.out.print("ID utilizator: ");
                    int idUser = Integer.parseInt(scanner.nextLine());
                    System.out.print("ID continut: ");
                    int idContinut = Integer.parseInt(scanner.nextLine());
                    service.vizioneazaContinut(idUser, idContinut);
                }
                case 12 -> service.afiseazaToateVizionarile();
                case 0 -> {
                    System.out.println("La revedere!");
                    return;
                }
                default -> System.out.println("Optiune invalida.");
            }
        }
    }
}
