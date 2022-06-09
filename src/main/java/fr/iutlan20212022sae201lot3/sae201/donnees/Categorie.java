package fr.iutlan20212022sae201lot3.sae201.donnees;

public class Categorie {
    private NomCategorie categorie;
    private int surface;
    private float tarif;
    private int capacite;

    public Categorie(NomCategorie categorie, int surface, float tarif, int capacite) {
        this.categorie = categorie;
        this.surface = surface;
        this.tarif = tarif;
        this.capacite = capacite;
    }

    public NomCategorie getCategorie() {
        return categorie;
    }

    public int getSurface() {
        return surface;
    }

    public float getTarif() {
        return tarif;
    }

    public int getCapacite() {
        return capacite;
    }
}
