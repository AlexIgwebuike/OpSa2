package guiSportstaetten;

import business.FreizeitbaederModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class SportstaettenControl implements Observer{

	private SportstaettenView spView;
	private FreizeitbaederModel fzModel;

	public SportstaettenControl(Stage primaryStage){
		this.fzModel = FreizeitbaederModel.getInstance();
		this.spView = new SportstaettenView(primaryStage, this, fzModel);
		this.fzModel.addObserver(this);
	}
	
	public void update() {
		this.spView.zeigFreizeitbaederAn();
	}
}
