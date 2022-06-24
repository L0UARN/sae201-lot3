package fr.iutlan20212022sae201lot3.sae201.donnees;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;

public class Emplacement {
    private int numero;
    private NomCategorie categorie;
    private HashMap<LocalDate, LocalDate> reservations;

    public Emplacement(int numero, NomCategorie categorie) {
        this.numero = numero;
        this.categorie = categorie;
        this.reservations = new HashMap<>();
    }

    public int getNumero() {
        return numero;
    }

    public void ajouterReservation(LocalDate debut, LocalDate fin) {
        reservations.put(debut, fin);
    }

    public boolean estLibreSurPeriode(LocalDate debut, LocalDate fin) {
        boolean resultat = true;
        for (LocalDate d : this.reservations.keySet()) {
            if (debut.isBefore(d) && fin.isAfter(reservations.get(d))) {
                resultat = false;
            }

            if (debut.isAfter(d) && debut.isBefore(reservations.get(d))) {
                resultat = false;
            }

            if (fin.isAfter(d) && fin.isBefore(reservations.get(d))) {
                resultat = false;
            }
        }

        return resultat;
    }

    public void setCategorie(NomCategorie categorie) {
        this.categorie = categorie;
    }

    public NomCategorie getCategorie() {
        return categorie;
    }
}
