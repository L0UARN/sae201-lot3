package fr.iutlan20212022sae201lot3.sae201.fenetres;

import fr.iutlan20212022sae201lot3.sae201.Main;
import fr.iutlan20212022sae201lot3.sae201.donnees.Emplacement;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SupprimerEmplacement extends Stage {
    private Label texte;
    private Button valider;
    private Button annuler;
    private Emplacement cible;

    public SupprimerEmplacement() {
        this.setTitle("Supprimer un emplacement");
        this.setWidth(512);
        this.setHeight(160);
        this.setMinWidth(256);
        this.setMinHeight(128);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);

        texte = new Label("Voulez-vous vraiment supprimer cet emplacement ? Cette action est definitive.");
        texte.setAlignment(Pos.CENTER);
        texte.setTextAlignment(TextAlignment.CENTER);
        texte.maxWidthProperty().bind(this.widthProperty());
        texte.setWrapText(true);

        valider = new Button("Oui, supprimer");
        annuler = new Button("Non, ne pas supprimer");

        annuler.setOnAction(e -> this.close());
        valider.setOnAction(e -> {
            Main.supprimerEmplacement(cible);
            Main.rafraichirConsulter();
            this.close();
        });

        remplir();
    }

    public void init(Emplacement e) {
        this.cible = e;
    }

    private void remplir() {
        BorderPane racine = new BorderPane();
        racine.setPadding(new Insets(16));

        HBox boutons = new HBox();
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(16, 16, 0, 16));
        boutons.setSpacing(16);

        boutons.getChildren().add(valider);
        boutons.getChildren().add(annuler);

        racine.setCenter(texte);
        racine.setBottom(boutons);

        Scene scene = new Scene(racine);
        this.setScene(scene);
    }
}
