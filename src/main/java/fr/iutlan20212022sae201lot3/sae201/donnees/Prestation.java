package fr.iutlan20212022sae201lot3.sae201.donnees;

public class Prestation {
    private String libelle;
    private int tarif;

    public Prestation(String libelle, int tarif) {
        this.libelle = libelle;
        this.tarif = tarif;
    }

    public String getLibelle() {
        return libelle;
    }

    public int getTarif() {
        return tarif;
    }
}
