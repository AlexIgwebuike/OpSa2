package guiSportstaetten;

import business.FreizeitbaederModel;
import guiFreizeitbaeder.FreizeitbaederControl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;
import ownUtil.Observer;

public class SportstaettenView implements Observer{
	
	private FreizeitbaederModel spModel;
	private SportstaettenControl spControl;
	
	private Pane pane = new  Pane();
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
	 }
	 
	 public SportstaettenView(Stage primaryStage,SportstaettenControl spControl, FreizeitbaederModel fzModel){
	    	this.spModel = spModel.getInstance();
	    	this.spControl = spControl;
	    	this.spModel.addObserver(this);
	    	Scene scene = new Scene(this.pane, 560, 340);
	    	primaryStage.setScene(scene);
	    	primaryStage.setTitle("Anzeige von Sportstaetten");
	    	primaryStage.show();
	    	this.initKomponenten();
			this.initListener();
	    }
	 
	 private void initListener() {
		    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
		    	@Override
		        public void handle(ActionEvent e) {
		            update();
		        } 
	   	    });  
	    }
	 
		 public void update(){
		    	if(this.spModel.getFreizeitbad()  != null){
		    		txtAnzeige.setText(
		    				this.spModel.getFreizeitbad().gibFreizeitbadZurueck(' '));
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
