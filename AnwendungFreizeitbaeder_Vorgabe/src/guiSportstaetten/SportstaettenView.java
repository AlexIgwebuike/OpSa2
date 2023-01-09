package guiSportstaetten;

import java.io.IOException;

import business.Freizeitbad;
import business.FreizeitbaederModel;
import business.businessSporthallen.Sporthalle;
import business.businessSporthallen.SporthallenModel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;
import ownUtil.PlausiException;

public class SportstaettenView{
	
	private FreizeitbaederModel fzModel;
	private SportstaettenControl spControl;
	private SporthallenModel spModel;
	
	//Komponenten für die Freizeitbaeder anzeige.
	private Pane pane = new Pane();
	private Label lblAnzeigeFreizeitbaeder = new Label("Anzeige Freizeitbaeder");
	private Button btnAnzeigeFreizeitbaeder = new Button("Anzeige");
	private TextArea txtAnzeigeFreizeitbaeder = new TextArea();
	
	//Komponenten für die Sporthallen anzeige.
	private Label lblAnzeigeSporthallen = new Label("Anzeige Sporthallen");
	private Button btnAnzeigeSporthallen = new Button("csv-import und Anzeige");
	private TextArea txtAnzeigeSporthallen = new TextArea();
	
	 private void initKomponentenFreizeitbaeder(){
	       	// Labels
		 	lblAnzeigeFreizeitbaeder.setLayoutX(310);
	    	lblAnzeigeFreizeitbaeder.setLayoutY(40);
	    	Font font = new Font("Arial", 24); 
	      	lblAnzeigeFreizeitbaeder.setFont(font);
	       	lblAnzeigeFreizeitbaeder.setStyle("-fx-font-weight: bold;"); 
	    	lblAnzeigeFreizeitbaeder.setLayoutX(310);
	    	lblAnzeigeFreizeitbaeder.setLayoutY(40);
	      	lblAnzeigeFreizeitbaeder.setFont(font);
	       	lblAnzeigeFreizeitbaeder.setStyle("-fx-font-weight: bold;"); 
	       	pane.getChildren().addAll(lblAnzeigeFreizeitbaeder);
	       	
	     // Textbereich	
	        txtAnzeigeFreizeitbaeder.setEditable(false);
	     	txtAnzeigeFreizeitbaeder.setLayoutX(310);
	    	txtAnzeigeFreizeitbaeder.setLayoutY(90);
	     	txtAnzeigeFreizeitbaeder.setPrefWidth(220);
	    	txtAnzeigeFreizeitbaeder.setPrefHeight(185);
	       	pane.getChildren().add(txtAnzeigeFreizeitbaeder); 
	       	
	       	btnAnzeigeFreizeitbaeder.setLayoutX(310);
	        btnAnzeigeFreizeitbaeder.setLayoutY(290);
	        pane.getChildren().addAll(btnAnzeigeFreizeitbaeder);

	 }
	 
	 private void initKomponentenSporthallen(){
	       	// Labels
		 	lblAnzeigeSporthallen.setLayoutX(30);
	    	lblAnzeigeSporthallen.setLayoutY(40);
	    	Font font = new Font("Arial", 24); 
	      	lblAnzeigeSporthallen.setFont(font);
	       	lblAnzeigeSporthallen.setStyle("-fx-font-weight: bold;"); 
	    	lblAnzeigeSporthallen.setLayoutX(30);
	    	lblAnzeigeSporthallen.setLayoutY(40);
	      	lblAnzeigeSporthallen.setFont(font);
	       	lblAnzeigeSporthallen.setStyle("-fx-font-weight: bold;"); 
	       	pane.getChildren().addAll(lblAnzeigeSporthallen);
	       	
	     // Textbereich	
	        txtAnzeigeSporthallen.setEditable(false);
	     	txtAnzeigeSporthallen.setLayoutX(30);
	    	txtAnzeigeSporthallen.setLayoutY(90);
	     	txtAnzeigeSporthallen.setPrefWidth(220);
	    	txtAnzeigeSporthallen.setPrefHeight(185);
	       	pane.getChildren().add(txtAnzeigeSporthallen); 
	       	
	       	btnAnzeigeSporthallen.setLayoutX(30);
	        btnAnzeigeSporthallen.setLayoutY(290);
	        pane.getChildren().addAll(btnAnzeigeSporthallen);

	 }
	 
	 
	 
	 public SportstaettenView(Stage primaryStage,SportstaettenControl spControl, FreizeitbaederModel fzModel, SporthallenModel spModel){
	    	this.spControl = spControl;
	    	this.spModel = spModel;
	    	this.fzModel = fzModel;
	    	Scene scene = new Scene(this.pane, 560, 340);
	    	primaryStage.setScene(scene);
	    	primaryStage.setTitle("Anzeige von Sportstaetten");
	    	primaryStage.show();
	    	this.initKomponentenFreizeitbaeder();
	    	this.initKomponentenSporthallen();
			this.initListenerFreizeitbaeder();
			this.initListenerSporthallen();
	    }
	 
	 private void initListenerFreizeitbaeder() {
		 btnAnzeigeFreizeitbaeder.setOnAction(e -> zeigFreizeitbaederAn());
	 }
	 
	 private void initListenerSporthallen() {
		 btnAnzeigeSporthallen.setOnAction(e -> {
			try {
				this.spModel.leseSporthallenAusCsvDatei();
				zeigSporthallenAn();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (PlausiException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	 }
	 
	 public void zeigFreizeitbaederAn(){
		 if(fzModel.getFreizeitbaeder().size() > 0){
			 StringBuffer text = new StringBuffer();
		    		
		    for(Freizeitbad freizeitbad : this.fzModel.getFreizeitbaeder()) {
		    	text.append(freizeitbad.gibFreizeitbadZurueck(' ') + "\n");
		    }
		    		
		    this.txtAnzeigeFreizeitbaeder.setText(text.toString());
		 }
		 else{
		    zeigeInformationsfensterAn("Bisher wurde kein Freizeitbad aufgenommen!");
		 }
	  }
	 
	 public void zeigSporthallenAn(){
		 if(spModel.getSporthallen().size() > 0){
			 StringBuffer text = new StringBuffer();
		    		
		    for(Sporthalle sporthalle : this.spModel.getSporthallen()) {
		    	text.append(sporthalle.gibSporthalleZurueck(' ') + "\n");
		    }
		    		
		    this.txtAnzeigeSporthallen.setText(text.toString());
		 }
		 else{
		    zeigeInformationsfensterAn("Bisher wurde kein Freizeitbad aufgenommen!");
		 }
	 }	
		 
	 void zeigeInformationsfensterAn(String meldung){
		 new MeldungsfensterAnzeiger(AlertType.INFORMATION,
		    "Information", meldung).zeigeMeldungsfensterAn();
	 }	
	
}
