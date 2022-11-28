package guiSportstaetten;

import java.io.IOException;

import business.FreizeitbaederModel;
import guiFreizeitbaeder.FreizeitbaederView;
import javafx.stage.Stage;

public class SportstaettenControl {

	private SportstaettenView spView;
	private FreizeitbaederModel fzModel;

	public SportstaettenControl(Stage primaryStage){
		this.fzModel = fzModel.getInstance();
		this.spView = new SportstaettenView(primaryStage, this, fzModel);
	}
}
