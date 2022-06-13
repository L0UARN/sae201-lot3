package fr.iutlan20212022sae201lot3.sae201.donnees;

public class Emplacement {
    private int numero;
    private NomCategorie categorie;

    public Emplacement(int numero, NomCategorie categorie) {
        this.numero = numero;
        this.categorie = categorie;
    }

    public int getNumero() {
        return numero;
    }

    public void setCategorie(NomCategorie categorie) {
        this.categorie = categorie;
    }
}
