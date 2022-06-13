package fr.iutlan20212022sae201lot3.sae201.donnees;

import java.util.Date;

public class Reservation {
    private Categorie categorie;
    private Client client;
    private Contrat contrat;
    private boolean acceptee;
    private Date dateDebut;
    private Date dateFin;
    private int nombreAdultes;
    private int nombreEnfants;
    private String souhaits;

    public Reservation(Categorie categorie, Client client, Contrat contrat, boolean acceptee, Date dateDebut, Date dateFin, int nombreAdultes, int nombreEnfants, String souhaits) {
        this.categorie = categorie;
        this.client = client;
        this.contrat = contrat;
        this.acceptee = acceptee;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nombreAdultes = nombreAdultes;
        this.nombreEnfants = nombreEnfants;
        this.souhaits = souhaits;
    }
}
