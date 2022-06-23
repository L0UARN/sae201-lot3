package fr.iutlan20212022sae201lot3.sae201.fenetres;

import java.util.*;

import fr.iutlan20212022sae201lot3.sae201.donnees.Emplacement;
import fr.iutlan20212022sae201lot3.sae201.donnees.NomCategorie;
import javafx.collections.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
	
	//Bouton pour creer un emplacement
	private Button BTNcreerEmplacement = new Button("Cr�er un emplacement");
	
	//Bouton pour supprimer un emplacement
	private Button BTNsupprimerEmplacement = new Button("Supprimer un emplacement");
	
	//Bouton pour fermer la page
	private Button BTNfermer = new Button("Fermer");
		
	
	//Bouton pour les filtres
	
	private VBox boutonFiltre = new VBox();
	private RadioButton RBTNfiltreCroi= new RadioButton("Tri croissant"); 
	private RadioButton RBTNfiltreCat= new RadioButton("Tri par cat�gorie"); 
	private RadioButton RBTNfiltreDecroi= new RadioButton("Tri d�croissant");
	//Permet d'avoir seulement un bouton de s�lectionn�
	private ToggleGroup groupeRB = new ToggleGroup();
	
	
	//Notre liste observable qui permet les interactions 
	private ObservableList<Emplacement> listeEmplacementObservable = FXCollections.observableArrayList();
	private ObservableList<Emplacement> listeCorrespondance = FXCollections.observableArrayList();
	
	
	private TableView<Emplacement>tableEmplacement= new TableView<Emplacement>();
	
	private String emplacementChoisi=null;
	
	
	
	//Test en ajoutant un emplacement
	Emplacement unEmplacement1=new Emplacement(41, NomCategorie.EMPLACEMENT_SIMPLE);
	Emplacement unEmplacement2=new Emplacement(83, NomCategorie.MOBILHOME_GRAND_LUXE);
	Emplacement unEmplacement3=new Emplacement(31, NomCategorie.EMPLACEMENT_SIMPLE);
	Emplacement unEmplacement4=new Emplacement(61, NomCategorie.MOBILHOME_STANDARD);
	
	
	public ConsulterListeEmplacement(){
		//Fenetre de base
		this.setTitle("Consulter les emplacements");
		this.setWidth(1250);
		this.setHeight(750);
		this.setMinWidth(1250);
		this.setMinHeight(750);
		
		this.setResizable(true);
		this.setScene(new Scene(creerContenu()));	
	}

	private String categorieToString(NomCategorie nomCategorie) {
		String resultat;

		switch (nomCategorie) {
			case EMPLACEMENT_SIMPLE:
				resultat = "Emplacement Simple";
				break;

			case MOBILHOME_GRAND_LUXE:
				resultat = "Mobil-home Grand Luxe";
				break;

			case MOBILHOME_STANDARD:
				resultat = "Mobil-home Standard";
				break;

			default:
				resultat = "Inconnu";
				break;
		}

		return resultat;
	}
	
	public Parent creerContenu() {
		// LISTE DES CHOSES � FAIRE:
		
		/*
		 * CREER UN BOUTON MODIFIER ET AJOUTER
		*/
		
		tableEmplacement.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		//Cr�ation des colonnes des tables
		
		
		TableColumn<Emplacement,String> colonne1 = new TableColumn<Emplacement,String>("Num�ro");
		colonne1.setCellValueFactory(new PropertyValueFactory<Emplacement,String>("numero"));
		tableEmplacement.getColumns().add(colonne1);		
		TableColumn<Emplacement, String> colonne2 = new TableColumn<Emplacement,String>("Cat�gorie");
		colonne2.setCellValueFactory(new PropertyValueFactory<Emplacement, String>("categorie"));
		tableEmplacement.getColumns().add(colonne2);
		
		
		listeEmplacementObservable.add(unEmplacement1);
		listeEmplacementObservable.add(unEmplacement2);
		listeEmplacementObservable.add(unEmplacement3);
		listeEmplacementObservable.add(unEmplacement4);
		
		boutonFiltre.getChildren().addAll(RBTNfiltreCroi,RBTNfiltreCat,RBTNfiltreDecroi);
		groupeRB.getToggles().addAll(RBTNfiltreCroi,RBTNfiltreCat,RBTNfiltreDecroi);
		
		
		tableEmplacement.setItems(listeEmplacementObservable);
		
		labelRechercheEmplacement.setFont(new Font("Arial", 19));
		labelFiltrerEmplacement.setFont(new Font("Arial", 19));
		
		//Taille des �l�ments
		BTNvalideRecherche.setPrefSize(250.0, 25.0);
		BTNannuleRecherche.setPrefSize(250.0, 25.0);
		BTNsupprimerEmplacement.setPrefSize(250.0, 40.0);
		BTNcreerEmplacement.setPrefSize(250.0, 40.0);
		BTNfermer.setPrefSize(250.0, 25.0);
		TFsaisieRecherche.setPrefSize(250.0, 10.0);
		tableEmplacement.setPrefSize(50.0,50.0);
		boutonFiltre.setPrefSize(250.0, 250.0);
		
		
		//Positionnement des �l�ments:
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
		
		//BTNEmplacement
		AnchorPane.setTopAnchor(BTNcreerEmplacement, 400.0);
		AnchorPane.setRightAnchor(BTNcreerEmplacement, 25.0);
		
		AnchorPane.setTopAnchor(BTNsupprimerEmplacement, 450.0);
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
				if (String.valueOf(tableEmplacement.getItems().get(i).getNumero()).contains(emplacementChoisi)||categorieToString(tableEmplacement.getItems().get(i).getCategorie()).contains(emplacementChoisi)) {
					listeCorrespondance.add(tableEmplacement.getItems().get(i));
				}
			}
			tableEmplacement.setItems(listeCorrespondance);
		});
		
		BTNvalideRecherche.disableProperty().bind(TFsaisieRecherche.textProperty().isEmpty());
		
		BTNannuleRecherche.setOnAction(e ->{
			tableEmplacement.setItems(listeEmplacementObservable);
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
		
		
		racine.getChildren().addAll(tableEmplacement,labelRechercheEmplacement,
				TFsaisieRecherche,BTNvalideRecherche,
				BTNannuleRecherche,boutonFiltre,labelFiltrerEmplacement,
				BTNcreerEmplacement,BTNsupprimerEmplacement,BTNfermer);
	
		return racine;
	}
}