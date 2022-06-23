package fr.iutlan20212022sae201lot3.sae201.donnees;

import java.util.ArrayList;

public class Camping {
    private ArrayList<Categorie> categories = new ArrayList<>();
    private ArrayList<Client> clients = new ArrayList<>();
    private ArrayList<Contrat> contrats = new ArrayList<>();
    private ArrayList<Emplacement> emplacements = new ArrayList<>();
    private ArrayList<Prestation> prestations = new ArrayList<>();
    private ArrayList<Reservation> reservations = new ArrayList<>();

    public void ajouterCategorie(Categorie categorie) {
        categories.add(categorie);
    }

    public void ajouterClient(Client client) {
        clients.add(client);
    }

    public void ajouterContrat(Contrat contrat) {
        contrats.add(contrat);
    }

    public void ajouterEmplacement(Emplacement emplacement) {
        emplacements.add(emplacement);
    }

    public void ajouterPrestation(Prestation prestation) {
        prestations.add(prestation);
    }

    public void ajouterReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void supprimerCategorie(Categorie categorie) {
        categories.remove(categorie);
    }

    public void supprimerClient(Client client) {
        clients.remove(client);
    }

    public void supprimerContrat(Contrat contrat) {
        contrats.remove(contrat);
    }

    public void supprimerEmplacement(Emplacement emplacement) {
        emplacements.remove(emplacement);
    }

    public void supprimerPrestation(Prestation prestation) {
        prestations.remove(prestation);
    }

    public void supprimerReservation(Reservation reservation) {
        reservations.remove(reservation);
    }

    public ArrayList<Emplacement> getEmplacements() {
        return emplacements;
    }
}
