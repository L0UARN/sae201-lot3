package fr.iutlan20212022sae201lot3.sae201.donnees;

public class Client {
    private String nom;
    private String prenom;
    private int codePostal;
    private String ville;
    private String pays;
    private String telephone;

    public Client(String nom, String prenom, int codePostal, String ville, String pays, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;
        this.telephone = telephone;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public int getCodePostal() {
        return this.codePostal;
    }

    public String getVille() {
        return this.ville;
    }

    public String getPays() {
        return this.pays;
    }

    public String getTelephone() {
        return this.telephone;
    }
}
