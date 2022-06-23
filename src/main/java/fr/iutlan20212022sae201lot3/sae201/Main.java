package fr.iutlan20212022sae201lot3.sae201;

import fr.iutlan20212022sae201lot3.sae201.donnees.Camping;
import fr.iutlan20212022sae201lot3.sae201.fenetres.ConsulterListeEmplacement;
import fr.iutlan20212022sae201lot3.sae201.fenetres.CreerEmplacement;
import fr.iutlan20212022sae201lot3.sae201.fenetres.SupprimerEmplacement;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static ConsulterListeEmplacement consulter;
    private static CreerEmplacement creer;
    private static SupprimerEmplacement supprimer;

    @Override
    public void start(Stage stage) {
        Camping.init();

        consulter = new ConsulterListeEmplacement();
        creer = new CreerEmplacement();
        supprimer = new SupprimerEmplacement();

        consulter.init();
        consulter.show();
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