package business.businessSporthallen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import ownUtil.Observable;
import ownUtil.Observer;
import ownUtil.PlausiException;


public class SporthallenModel implements Observable{
	
	private ArrayList<Sporthalle> sporthallen = new ArrayList<>();
	private static SporthallenModel sporthallenModel;
	Vector<Observer> observer = new Vector<Observer>();
	
	private SporthallenModel(){		
	}
	
	public static SporthallenModel getInstance() {
		if(sporthallenModel == null) {
			sporthallenModel = new SporthallenModel();
		}
		
		return sporthallenModel;
	}

	public ArrayList<Sporthalle> getSporthallen() {
		return sporthallen;
	}

	public void addSporthalle(Sporthalle sporthalle) {
		this.sporthallen.add(sporthalle);
		notifyObserver();
	}
		
	public void addObserver(Observer obs) {
		this.observer.add(obs);
	}
	
	public void removeObserver(Observer obs) {
		this.observer.remove(obs);
	}
	
	public void notifyObserver() {
		for(int i = 0; i < observer.size(); i++) {
			this.observer.elementAt(i).update();
		}
	}
	
	public void leseSporthallenAusCsvDatei()
			throws IOException, PlausiException{
			BufferedReader ein = new BufferedReader(
		 		new FileReader("Sporthallen.csv"));
			ArrayList<Sporthalle> ergebnis = new ArrayList<>(); 
			String zeileStr = ein.readLine();
			while(zeileStr != null) {
				String[] zeile = zeileStr.split(";");
		           ergebnis.add( 
					new Sporthalle(zeile[0], zeile[1], zeile[2]));
		           zeileStr = ein.readLine();
			}    
		 	ein.close();
		 	this.sporthallen = ergebnis;
		}

}

