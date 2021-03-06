package fr.iutlan20212022sae201lot3.sae201.donnees;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Contrat {
    private Client client;
    private Emplacement emplacement;
    private String souhaits;
    private ArrayList<Prestation> prestations;
    private LocalDate debut;
    private LocalDate fin;
    private boolean etatCaution;
    private boolean etatAcompte;
    private boolean etatSolde;
    private float caution;
    private float acompte;
    private float solde;

    public Contrat(Client client, Emplacement emplacement, String souhaits, LocalDate debut, LocalDate fin, float caution, float acompte, float solde) {
        this.client = client;
        this.emplacement = emplacement;
        this.souhaits = souhaits;
        this.prestations = new ArrayList<>();
        this.debut = debut;
        this.fin = fin;
        this.etatCaution = false;
        this.etatAcompte = false;
        this.etatSolde = false;
        this.caution = caution;
        this.acompte = acompte;
        this.solde = solde;

        emplacement.ajouterReservation(debut, fin);
    }

    public Client getClient() {
        return client;
    }

    public Emplacement getEmplacement() {
        return emplacement;
    }

    public String getSouhaits() {
        return souhaits;
    }

    public ArrayList<Prestation> getPrestations() {
        return prestations;
    }

    public LocalDate getDebut() {
        return debut;
    }

    public LocalDate getFin() {
        return fin;
    }

    public boolean etatCaution() {
        return etatCaution;
    }

    public boolean etatAcompte() {
        return etatAcompte;
    }

    public boolean etatSolde() {
        return etatSolde;
    }

    public float getCaution() {
        return caution;
    }

    public float getAcompte() {
        return acompte;
    }

    public float getSolde() {
        return solde;
    }
}
