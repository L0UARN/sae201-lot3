package fr.iutlan20212022sae201lot3.sae201.donnees;

public class Client {
    // variables d'instances
    private Camping camping;

    private String nom;
    private String prenom;
    private int codePostal;
    private String ville;
    private String pays;
    private String telephone;

    // constructeur
    public Client(Camping camping, String nom, String prenom, int codePostal, String ville, String pays, String telephone) {
        this.camping = camping;

        this.nom = nom;
        this.prenom = prenom;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;
        this.telephone = telephone;
    }

    // getters
    public Camping getCamping() {
        return camping;
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
