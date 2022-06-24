package fr.iutlan20212022sae201lot3.sae201.fenetres;

import fr.iutlan20212022sae201lot3.sae201.Main;
import fr.iutlan20212022sae201lot3.sae201.donnees.Camping;
import fr.iutlan20212022sae201lot3.sae201.donnees.Categorie;
import fr.iutlan20212022sae201lot3.sae201.donnees.Emplacement;
import fr.iutlan20212022sae201lot3.sae201.donnees.NomCategorie;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.IntegerBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;

public class CreerEmplacement extends Stage {
    private Label lbNumero = new Label("Numero");
    private Label lbCategorie = new Label("Catégorie");
    private Label lbErreur = new Label("Erreur: Le numéro d'emplacement doit être compris en 1 et 180.");
    private TextField tfNumero = new TextField();
    private ChoiceBox<NomCategorie> cbCategorie = new ChoiceBox<NomCategorie>();
    private Button bnCreer = new Button("Créer");
    private Button bnAnnuler = new Button("Annuler");

    public CreerEmplacement() {
        this.setTitle("Créer un emplacement");
        setWidth(700);
        setHeight(700);
        setMinWidth(500);
        setMinHeight(200);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);

        Scene scene = new Scene(contenu());
        this.setScene(scene);
        this.sizeToScene();
    }

    Parent contenu() {
        // Condition pour griser le bouton Creer
        IntegerBinding valeurConvvertie = Bindings.createIntegerBinding(() -> Integer.parseInt(tfNumero.getText()), tfNumero.textProperty());

        BooleanBinding manque = Bindings.or(
          Bindings.equal(tfNumero.textProperty(), ""),
          Bindings.or(
                  Bindings.or(
                          Bindings.greaterThan(valeurConvvertie, 180),
                          Bindings.lessThan(valeurConvvertie, 1)
                  ),
            cbCategorie.valueProperty().isNull()
          )
        );

        cbCategorie.setMinWidth(160);
        lbErreur.setTextFill(Color.RED);

        BooleanBinding erreurAffichee = Bindings.createBooleanBinding(() -> {
            int valeur = Integer.parseInt(tfNumero.getText());
            return !(valeur > 0 && valeur <= 180);
        }, tfNumero.textProperty());
        lbErreur.visibleProperty().bind(erreurAffichee);

        cbCategorie.setItems(FXCollections.observableList(NomCategorie.toutes()));

        BorderPane primary = new BorderPane();

        // Structure formulaire
        HBox hbNumero = new HBox(lbNumero, tfNumero);
        HBox hbCategorie = new HBox(lbCategorie, cbCategorie);

        // Positionnement hbNumero
        hbNumero.setAlignment(Pos.CENTER);
        hbNumero.setSpacing(10);

        // Positionnement hbCategorie
        hbCategorie.setAlignment(Pos.CENTER);
        hbCategorie.setSpacing(10);

        // Parametrage GridPane
        GridPane grdForm = new GridPane();
        grdForm.add(lbNumero, 2, 0);
        grdForm.add(tfNumero, 3, 0);
        grdForm.add(lbCategorie, 2, 1);
        grdForm.add(cbCategorie, 3, 1);

        // Positionnement grdForm
        grdForm.setAlignment(Pos.CENTER);
        grdForm.setHgap(10.0);
        grdForm.setVgap(10.0);


        // Structure center
        VBox vbCenter = new VBox(grdForm, lbErreur);
        // Positionnement vbCenter
        vbCenter.setAlignment(Pos.CENTER);
        vbCenter.setSpacing(15);
        vbCenter.setPadding(new Insets(50));

        // Structure Bouton
        HBox hbButton = new HBox(bnAnnuler, bnCreer);
        // Positionnement hbButton
        hbButton.setAlignment(Pos.CENTER);
        hbButton.setSpacing(50);

        // Ajout des composants dans les zones du BorderPane
        primary.setCenter(vbCenter);
        primary.setBottom(hbButton);

        // Placement de chaque composants dans sa zone
        BorderPane.setAlignment(vbCenter, Pos.CENTER);
        BorderPane.setAlignment(hbButton, Pos.BOTTOM_CENTER);

        primary.setPadding(new Insets(20));


        bnCreer.disableProperty().bind(Bindings.when(manque).then(true).otherwise(false));


        // Pose des ecouteurs
        bnAnnuler.setOnAction(e -> this.close());

        bnCreer.setOnAction(e -> creerEmplacement(e));

        return primary;
    }

    public void creerEmplacement(ActionEvent e) {
        int valeur = Integer.parseInt(tfNumero.getText());
        NomCategorie categorie = cbCategorie.getValue();

        Main.ajouterEmplacement(new Emplacement(valeur, categorie));
        Main.rafraichirConsulter();
        this.close();
    }

}
