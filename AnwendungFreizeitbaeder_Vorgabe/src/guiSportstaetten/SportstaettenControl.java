package guiSportstaetten;

import business.FreizeitbaederModel;
import business.businessSporthallen.SporthallenModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class SportstaettenControl implements Observer{

	private SportstaettenView spView;
	private FreizeitbaederModel fzModel;
	private SporthallenModel spModel;

	public SportstaettenControl(Stage primaryStage){
		this.fzModel = FreizeitbaederModel.getInstance();
		this.spModel = SporthallenModel.getInstance();
		this.spView = new SportstaettenView(primaryStage, this, fzModel, spModel);
		this.fzModel.addObserver(this);
		//this.spModel.addObserver(this);
	}
	
	public void update() {
		this.spView.zeigFreizeitbaederAn();
	}
}
