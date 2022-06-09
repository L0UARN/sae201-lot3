package fr.iutlan20212022sae201lot3.sae201.donnees;

import java.util.ArrayList;

public class Camping {
    private ArrayList<Categorie> categories;
    private ArrayList<Client> clients;
    private ArrayList<Contrat> contrats;
    private ArrayList<Emplacement> emplacements;
    private ArrayList<Prestation> prestations;
    private ArrayList<Reservation> reservations;

    public Camping() {
        this.categories = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.contrats = new ArrayList<>();
        this.emplacements = new ArrayList<>();
        this.prestations = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    public void ajouterCategorie(Categorie categorie) {
        this.categories.add(categorie);
    }

    public void ajouterClient(Client client) {
        this.clients.add(client);
    }

    public void ajouterContrat(Contrat contrat) {
        this.contrats.add(contrat);
    }

    public void ajouterEmplacement(Emplacement emplacement) {
        this.emplacements.add(emplacement);
    }

    public void ajouterPrestation(Prestation prestation) {
        this.prestations.add(prestation);
    }

    public void ajouterReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }

    public void supprimerCategorie(Categorie categorie) {
        this.categories.remove(categorie);
    }

    public void supprimerClient(Client client) {
        this.clients.remove(client);
    }

    public void supprimerContrat(Contrat contrat) {
        this.contrats.remove(contrat);
    }

    public void supprimerEmplacement(Emplacement emplacement) {
        this.emplacements.remove(emplacement);
    }

    public void supprimerPrestation(Prestation prestation) {
        this.prestations.remove(prestation);
    }

    public void supprimerReservation(Reservation reservation) {
        this.reservations.remove(reservation);
    }
}
