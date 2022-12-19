package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import ownUtil.Observable;
import ownUtil.Observer;
import writers.ConcreteCsvWriterCreator;
import writers.ConcreteCsvWriterProduct;
import writers.ConcreteTxtWriterCreator;
import writers.WriterCreator;
import writers.WriterProduct;

public class FreizeitbaederModel  implements Observable{

	private ArrayList<Freizeitbad> freizeitbaeder = new ArrayList<>();
	private static FreizeitbaederModel freizeitbadModel;
	Vector<Observer> observer = new Vector<Observer>();
	
	private FreizeitbaederModel(){		
	}
	
	public static FreizeitbaederModel getInstance() {
		if(freizeitbadModel == null) {
			freizeitbadModel = new FreizeitbaederModel();
		}
		
		return freizeitbadModel;
	}

	public ArrayList<Freizeitbad> getFreizeitbaeder() {
		return freizeitbaeder;
	}

	public void addFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbaeder.add(freizeitbad);
		notifyObserver();
	}
	
	public void schreibeFreizeitbaederInCsvDatei() throws IOException{
		WriterCreator creator = new ConcreteCsvWriterCreator();
		WriterProduct writer = creator.factoryMethod();
		writer.fuegeInDateiHinzu(this.freizeitbaeder);
		writer.schliesseDatei();
	}
	
	public void schreibeFreizeitbaederInTxtDatei() throws IOException{
		WriterCreator creator = new ConcreteTxtWriterCreator();
		WriterProduct writer = creator.factoryMethod();
		writer.fuegeInDateiHinzu(this.freizeitbaeder);
		writer.schliesseDatei();
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
}
