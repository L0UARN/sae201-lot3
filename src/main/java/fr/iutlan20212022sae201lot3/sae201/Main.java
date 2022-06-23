package fr.iutlan20212022sae201lot3.sae201;

import fr.iutlan20212022sae201lot3.sae201.donnees.Camping;
import fr.iutlan20212022sae201lot3.sae201.donnees.Emplacement;
import fr.iutlan20212022sae201lot3.sae201.donnees.NomCategorie;
import fr.iutlan20212022sae201lot3.sae201.fenetres.ConsulterListeEmplacement;
import fr.iutlan20212022sae201lot3.sae201.fenetres.CreerEmplacement;
import fr.iutlan20212022sae201lot3.sae201.fenetres.SupprimerEmplacement;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

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

    public static void ouvrirSupprimer() {
        supprimer.show();
    }

    public static void main(String[] args) {
        launch();
    }
}