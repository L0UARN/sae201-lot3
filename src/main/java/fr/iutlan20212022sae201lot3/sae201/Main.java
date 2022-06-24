package fr.iutlan20212022sae201lot3.sae201;

import fr.iutlan20212022sae201lot3.sae201.donnees.*;
import fr.iutlan20212022sae201lot3.sae201.fenetres.ConsulterListeEmplacement;
import fr.iutlan20212022sae201lot3.sae201.fenetres.CreerEmplacement;
import fr.iutlan20212022sae201lot3.sae201.fenetres.SupprimerEmplacement;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Main extends Application {
    private static ConsulterListeEmplacement consulter;
    private static CreerEmplacement creer;
    private static SupprimerEmplacement supprimer;
    private static Camping camping;

    @Override
    public void start(Stage stage) {
        camping = new Camping();
        camping.ajouterEmplacement(new Emplacement(1, NomCategorie.EMPLACEMENT_SIMPLE));
        camping.ajouterEmplacement(new Emplacement(2, NomCategorie.MOBILHOME_GRAND_LUXE));
        camping.ajouterEmplacement(new Emplacement(3, NomCategorie.MOBILHOME_STANDARD));
        camping.ajouterEmplacement(new Emplacement(4, NomCategorie.EMPLACEMENT_SIMPLE));

        camping.ajouterClient(new Client("NEYMAR", "Jean", 22300, "Lannion", "France", "0123456789"));
        camping.ajouterClient(new Client("PEUPLU", "Jean", 35520, "Melesse", "France", "1728396450"));
        camping.ajouterClient(new Client("VIDCREVER", "Jean", 56400, "Auray", "France", "0987654321"));

        camping.ajouterContrat(new Contrat(camping.getClients().get(0), camping.getEmplacements().get(0), "Toilettes proches", LocalDate.of(2022, 7, 3), LocalDate.of(2022, 7, 10), 200.0f, 50.0f, 450.0f));
        camping.ajouterContrat(new Contrat(camping.getClients().get(2), camping.getEmplacements().get(3), "Piscine proche", LocalDate.of(2022, 7, 10), LocalDate.of(2022, 7, 17), 150.0f, 70.0f, 300.0f));

        consulter = new ConsulterListeEmplacement();
        creer = new CreerEmplacement();
        supprimer = new SupprimerEmplacement();

        consulter.init();
        consulter.show();
    }

    public static ArrayList<Emplacement> getEmplacements() {
        return camping.getEmplacements();
    }

    public static void ouvrirCreer() {
        creer.show();
    }

    public static void ouvrirSupprimer(Emplacement e) {
        supprimer.init(e);
        supprimer.show();
    }

    public static void ajouterEmplacement(Emplacement e) {
        camping.ajouterEmplacement(e);
    }

    public static void supprimerEmplacement(Emplacement e) {
        camping.supprimerEmplacement(e);
    }

    public static void rafraichirConsulter() {
        consulter.init();
    }

    public static void main(String[] args) {
        launch();
    }
}