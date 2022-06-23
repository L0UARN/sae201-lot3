package fr.iutlan20212022sae201lot3.sae201;

import fr.iutlan20212022sae201lot3.sae201.donnees.Camping;
import fr.iutlan20212022sae201lot3.sae201.fenetres.ConsulterListeEmplacement;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
//        Scene scene = new Scene(new Group());
//        stage.setTitle("SAE201");
//        stage.setScene(scene);
        Camping.init();

        stage = new ConsulterListeEmplacement();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}