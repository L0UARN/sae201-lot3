package fr.iutlan20212022sae201lot3.sae201.donnees;

import java.util.ArrayList;

public class Camping {
    private static ArrayList<Categorie> categories = new ArrayList<>();
    private static ArrayList<Client> clients = new ArrayList<>();
    private static ArrayList<Contrat> contrats = new ArrayList<>();
    private static ArrayList<Emplacement> emplacements = new ArrayList<>();
    private static ArrayList<Prestation> prestations = new ArrayList<>();
    private static ArrayList<Reservation> reservations = new ArrayList<>();

    public static void init() {
        emplacements.add(new Emplacement(1, NomCategorie.EMPLACEMENT_SIMPLE));
        emplacements.add(new Emplacement(2, NomCategorie.MOBILHOME_STANDARD));
        emplacements.add(new Emplacement(3, NomCategorie.EMPLACEMENT_SIMPLE));
        emplacements.add(new Emplacement(4, NomCategorie.MOBILHOME_GRAND_LUXE));
        emplacements.add(new Emplacement(5, NomCategorie.MOBILHOME_GRAND_LUXE));
        emplacements.add(new Emplacement(6, NomCategorie.MOBILHOME_STANDARD));
        emplacements.add(new Emplacement(7, NomCategorie.EMPLACEMENT_SIMPLE));
    }

    public static void ajouterCategorie(Categorie categorie) {
        categories.add(categorie);
    }

    public static void ajouterClient(Client client) {
        clients.add(client);
    }

    public static void ajouterContrat(Contrat contrat) {
        contrats.add(contrat);
    }

    public static void ajouterEmplacement(Emplacement emplacement) {
        emplacements.add(emplacement);
    }

    public static void ajouterPrestation(Prestation prestation) {
        prestations.add(prestation);
    }

    public static void ajouterReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public static void supprimerCategorie(Categorie categorie) {
        categories.remove(categorie);
    }

    public static void supprimerClient(Client client) {
        clients.remove(client);
    }

    public static void supprimerContrat(Contrat contrat) {
        contrats.remove(contrat);
    }

    public static void supprimerEmplacement(Emplacement emplacement) {
        emplacements.remove(emplacement);
    }

    public static void supprimerPrestation(Prestation prestation) {
        prestations.remove(prestation);
    }

    public static void supprimerReservation(Reservation reservation) {
        reservations.remove(reservation);
    }

    public static ArrayList<Emplacement> getEmplacements() {
        return emplacements;
    }
}
