package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import writers.ConcreteCsvWriterCreator;
import writers.ConcreteCsvWriterProduct;
import writers.ConcreteTxtWriterCreator;
import writers.WriterCreator;
import writers.WriterProduct;

public class FreizeitbaederModel {

	private Freizeitbad freizeitbad;

	public Freizeitbad getFreizeitbad() {
		return freizeitbad;
	}

	public void setFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad = freizeitbad;
	}
	
	public void schreibeFreizeitbaederInCsvDatei() throws IOException{
		WriterCreator creator = new ConcreteCsvWriterCreator();
		WriterProduct writer = creator.factoryMethod();
		writer.fuegeInDateiHinzu(this.freizeitbad);
		writer.schliesseDatei();
	}
	
	public void schreibeFreizeitbaederInTxtDatei() throws IOException{
		WriterCreator creator = new ConcreteTxtWriterCreator();
		WriterProduct writer = creator.factoryMethod();
		writer.fuegeInDateiHinzu(this.freizeitbad);
		writer.schliesseDatei();
	}
}
