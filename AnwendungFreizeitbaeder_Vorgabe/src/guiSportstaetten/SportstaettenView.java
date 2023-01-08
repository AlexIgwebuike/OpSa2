package guiSportstaetten;

import business.Freizeitbad;
import business.FreizeitbaederModel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class SportstaettenView{
	
	private FreizeitbaederModel spModel;
	private SportstaettenControl spControl;
	
	private Pane pane = new Pane();
	private Label lblAnzeige = new Label("Anzeige Freizeitbaeder");
	private Button btnAnzeige = new Button("Anzeige");
	private TextArea txtAnzeige = new TextArea();
	
	 private void initKomponenten(){
	       	// Labels
		 	lblAnzeige.setLayoutX(310);
	    	lblAnzeige.setLayoutY(40);
	    	Font font = new Font("Arial", 24); 
	      	lblAnzeige.setFont(font);
	       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
	    	lblAnzeige.setLayoutX(310);
	    	lblAnzeige.setLayoutY(40);
	      	lblAnzeige.setFont(font);
	       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
	       	pane.getChildren().addAll(lblAnzeige);
	       	
	     // Textbereich	
	        txtAnzeige.setEditable(false);
	     	txtAnzeige.setLayoutX(310);
	    	txtAnzeige.setLayoutY(90);
	     	txtAnzeige.setPrefWidth(220);
	    	txtAnzeige.setPrefHeight(185);
	       	pane.getChildren().add(txtAnzeige); 
	       	
	       	btnAnzeige.setLayoutX(310);
	        btnAnzeige.setLayoutY(290);
	        pane.getChildren().addAll(btnAnzeige);

	 }
	 
	 public SportstaettenView(Stage primaryStage,SportstaettenControl spControl, FreizeitbaederModel fzModel){
	    	this.spControl = spControl;
	    	this.spModel = fzModel;
	    	Scene scene = new Scene(this.pane, 560, 340);
	    	primaryStage.setScene(scene);
	    	primaryStage.setTitle("Anzeige von Sportstaetten");
	    	primaryStage.show();
	    	this.initKomponenten();
			this.initListener();
	    }
	 
	 private void initListener() {
		 btnAnzeige.setOnAction(e -> zeigFreizeitbaederAn());
	 } 
	 
		 public void zeigFreizeitbaederAn(){
			 if(spModel.getFreizeitbaeder().size() > 0){
		    	StringBuffer text = new StringBuffer();
		    		
		    	for(Freizeitbad freizeitbad : this.spModel.getFreizeitbaeder()) {
		    		text.append(freizeitbad.gibFreizeitbadZurueck(' ') + "\n");
		    	}
		    		
		    	this.txtAnzeige.setText(text.toString());
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
