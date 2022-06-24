package fr.iutlan20212022sae201lot3.sae201.fenetres;

import java.util.*;

import fr.iutlan20212022sae201lot3.sae201.Main;
import fr.iutlan20212022sae201lot3.sae201.donnees.Camping;
import fr.iutlan20212022sae201lot3.sae201.donnees.Emplacement;
import fr.iutlan20212022sae201lot3.sae201.donnees.NomCategorie;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.*;

public class ConsulterListeEmplacement extends Stage{


    private AnchorPane racine = new AnchorPane();
    //Label
    private Label labelRechercheEmplacement = new Label("Rechercher un emplacement :");
    private Label labelFiltrerEmplacement = new Label("Trier les emplacements :");
    //Saisie de texte qui permettra la recherche
    private TextField TFsaisieRecherche = new TextField();
    //Bouton pour valider le texte saisie dans la recherche
    private Button BTNvalideRecherche = new Button("Valider la saisie");
    //Bouton pour annuler la saisie
    private Button BTNannuleRecherche = new Button("Annuler la recherche");

    private Label debutLabel = new Label("Date de debut de periode :");
    private DatePicker debut = new DatePicker();
    private Label finLabel = new Label("Date de fin de periode :");
    private DatePicker fin = new DatePicker();
    private Button BTNvalidePeriode = new Button("Valider la periode");
    private Button BTNannulePeriode = new Button("Annuler la periode");

    //Bouton pour creer un emplacement
    private Button BTNcreerEmplacement = new Button("Créer un emplacement");

    //Bouton pour supprimer un emplacement
    private Button BTNsupprimerEmplacement = new Button("Supprimer un emplacement");

    //Bouton pour fermer la page
    private Button BTNfermer = new Button("Fermer");


    //Bouton pour les filtres

    private VBox boutonFiltre = new VBox();
    private RadioButton RBTNfiltreCroi= new RadioButton("Tri croissant");
    private RadioButton RBTNfiltreCat= new RadioButton("Tri par catégorie");
    private RadioButton RBTNfiltreDecroi= new RadioButton("Tri décroissant");
    //Permet d'avoir seulement un bouton de sélectionné
    private ToggleGroup groupeRB = new ToggleGroup();


    //Notre liste observable qui permet les interactions
    private ObservableList<Emplacement> listeEmplacementObservable = FXCollections.observableArrayList();
    private ObservableList<Emplacement> listeCorrespondance = FXCollections.observableArrayList();


    private TableView<Emplacement>tableEmplacement= new TableView<Emplacement>();

    private String emplacementChoisi=null;


    public ConsulterListeEmplacement(){
        //Fenetre de base
        this.setTitle("Consulter les emplacements");
        this.setWidth(1250);
        this.setHeight(750);
        this.setMinWidth(1250);
        this.setMinHeight(750);
        this.initModality(Modality.APPLICATION_MODAL);

        this.setResizable(true);
        this.setScene(new Scene(creerContenu()));
    }

    public void init() {
        listeEmplacementObservable.clear();
        listeEmplacementObservable.addAll(Main.getEmplacements());
        tableEmplacement.setItems(listeEmplacementObservable);
    }

    public Parent creerContenu() {
        // LISTE DES CHOSES À FAIRE:

        /*
         * CREER UN BOUTON MODIFIER ET AJOUTER
         */

        tableEmplacement.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        //Création des colonnes des tables

        TableColumn<Emplacement,Integer> colonne1 = new TableColumn<Emplacement,Integer>("Numéro");
        colonne1.setCellValueFactory(new PropertyValueFactory<Emplacement,Integer>("numero"));
        tableEmplacement.getColumns().add(colonne1);
        TableColumn<Emplacement, NomCategorie> colonne2 = new TableColumn<Emplacement,NomCategorie>("Catégorie");
        colonne2.setCellValueFactory(new PropertyValueFactory<Emplacement, NomCategorie>("categorie"));
        tableEmplacement.getColumns().add(colonne2);

        boutonFiltre.getChildren().addAll(RBTNfiltreCroi,RBTNfiltreCat,RBTNfiltreDecroi);
        groupeRB.getToggles().addAll(RBTNfiltreCroi,RBTNfiltreCat,RBTNfiltreDecroi);

        labelRechercheEmplacement.setFont(new Font("Arial", 19));
        labelFiltrerEmplacement.setFont(new Font("Arial", 19));
        debutLabel.setFont(new Font("Arial", 19));
        finLabel.setFont(new Font("Arial", 19));

        //Taille des éléments
        BTNvalideRecherche.setPrefSize(250.0, 25.0);
        BTNannuleRecherche.setPrefSize(250.0, 25.0);
        debut.setPrefSize(250.0, 25.0);
        fin.setPrefSize(250.0, 25.0);
        BTNvalidePeriode.setPrefSize(250.0, 25.0);
        BTNannulePeriode.setPrefSize(250.0, 25.0);
        BTNsupprimerEmplacement.setPrefSize(250.0, 40.0);
        BTNcreerEmplacement.setPrefSize(250.0, 40.0);
        BTNfermer.setPrefSize(250.0, 25.0);
        TFsaisieRecherche.setPrefSize(250.0, 10.0);
        tableEmplacement.setPrefSize(50.0,50.0);
        boutonFiltre.setPrefSize(250.0, 250.0);


        //Positionnement des éléments:
        //POS Label txt
        AnchorPane.setTopAnchor(labelRechercheEmplacement, 10.0);
        AnchorPane.setRightAnchor(labelRechercheEmplacement, 25.0);

        //POS zone txt
        AnchorPane.setTopAnchor(TFsaisieRecherche, 50.0);
        AnchorPane.setRightAnchor(TFsaisieRecherche, 25.0);
        //POS valider
        AnchorPane.setTopAnchor(BTNvalideRecherche, 90.0);
        AnchorPane.setRightAnchor(BTNvalideRecherche, 25.0);

        //POS valider
        AnchorPane.setTopAnchor(BTNannuleRecherche, 120.0);
        AnchorPane.setRightAnchor(BTNannuleRecherche, 25.0);

        //POS
        AnchorPane.setTopAnchor(labelFiltrerEmplacement, 200.0);
        AnchorPane.setRightAnchor(labelFiltrerEmplacement, 60.0);


        //ZONE FILTRE
        AnchorPane.setTopAnchor(boutonFiltre, 230.0);
        AnchorPane.setRightAnchor(boutonFiltre, 25.0);

        AnchorPane.setTopAnchor(debutLabel, 320.0);
        AnchorPane.setRightAnchor(debutLabel, 40.0);
        AnchorPane.setTopAnchor(debut, 350.0);
        AnchorPane.setRightAnchor(debut, 25.0);

        AnchorPane.setTopAnchor(finLabel, 390.0);
        AnchorPane.setRightAnchor(finLabel, 65.0);
        AnchorPane.setTopAnchor(fin, 425.0);
        AnchorPane.setRightAnchor(fin, 25.0);

        AnchorPane.setTopAnchor(BTNvalidePeriode, 460.0);
        AnchorPane.setRightAnchor(BTNvalidePeriode, 25.0);
        AnchorPane.setTopAnchor(BTNannulePeriode, 490.0);
        AnchorPane.setRightAnchor(BTNannulePeriode, 25.0);

        //BTNEmplacement
        AnchorPane.setTopAnchor(BTNcreerEmplacement, 600.0);
        AnchorPane.setRightAnchor(BTNcreerEmplacement, 25.0);

        AnchorPane.setTopAnchor(BTNsupprimerEmplacement, 650.0);
        AnchorPane.setRightAnchor(BTNsupprimerEmplacement, 25.0);

        AnchorPane.setBottomAnchor(BTNfermer, 10.0);
        AnchorPane.setRightAnchor(BTNfermer, 25.0);


        //Positionnement de la liste d'emplacement:
        AnchorPane.setTopAnchor(tableEmplacement, 10.0);
        AnchorPane.setLeftAnchor(tableEmplacement, 10.0);
        AnchorPane.setRightAnchor(tableEmplacement, 300.0);
        AnchorPane.setBottomAnchor(tableEmplacement, 10.0);



        //Action
        BTNvalideRecherche.setOnAction(e->{

            listeCorrespondance.clear();
            tableEmplacement.setItems(listeEmplacementObservable);

            emplacementChoisi = TFsaisieRecherche.getText();

            //ON recupere la saisie de l'utilisateur et on compare avec les valeurs du tableau
            for  (int i=0;i<listeEmplacementObservable.size();i++) {
                if (String.valueOf(tableEmplacement.getItems().get(i).getNumero()).contains(emplacementChoisi)||tableEmplacement.getItems().get(i).getCategorie().toString().toLowerCase().contains(emplacementChoisi.toLowerCase())) {
                    listeCorrespondance.add(tableEmplacement.getItems().get(i));
                }
            }
            tableEmplacement.setItems(listeCorrespondance);
        });

        BTNvalideRecherche.disableProperty().bind(TFsaisieRecherche.textProperty().isEmpty());

        BTNannuleRecherche.setOnAction(e ->{
            Main.rafraichirConsulter();
        });

        BTNfermer.setOnAction(e->{
            System.exit(0);
        });


        //Action lors des clics sur les RADIO BUTTON
        RBTNfiltreCroi.setOnAction(e->{
            listeEmplacementObservable.sort(Comparator.comparing(Emplacement::getNumero));
            tableEmplacement.setItems(listeEmplacementObservable);
        });
        RBTNfiltreCat.setOnAction(e->{
            listeEmplacementObservable.sort(Comparator.comparing(Emplacement::getCategorie));
            tableEmplacement.setItems(listeEmplacementObservable);
        });
        RBTNfiltreDecroi.setOnAction(e->{
            listeEmplacementObservable.sort(Comparator.comparing(Emplacement::getNumero).reversed());
            tableEmplacement.setItems(listeEmplacementObservable);
        });

        BTNvalidePeriode.setOnAction(e -> {
            listeCorrespondance.clear();
            for (Emplacement emp : listeEmplacementObservable) {
                if (emp.estLibreSurPeriode(debut.getValue(), fin.getValue())) {
                    listeCorrespondance.add(emp);
                }
            }

            tableEmplacement.setItems(listeCorrespondance);
        });

        BTNannulePeriode.setOnAction(e ->{
            Main.rafraichirConsulter();
        });

        BooleanBinding emplacementNonSelectionne = tableEmplacement.getSelectionModel().selectedIndexProperty().isEqualTo(-1);
        BTNsupprimerEmplacement.disableProperty().bind(emplacementNonSelectionne);

        BTNsupprimerEmplacement.setOnAction(e -> Main.ouvrirSupprimer(tableEmplacement.getSelectionModel().getSelectedItem()));
        BTNcreerEmplacement.setOnAction(e -> Main.ouvrirCreer());

        racine.getChildren().addAll(tableEmplacement,labelRechercheEmplacement,
                TFsaisieRecherche,BTNvalideRecherche,
                BTNannuleRecherche,boutonFiltre,labelFiltrerEmplacement,
                debutLabel, debut, finLabel, fin, BTNvalidePeriode, BTNannulePeriode,
                BTNcreerEmplacement,BTNsupprimerEmplacement,BTNfermer);

        return racine;
    }
}