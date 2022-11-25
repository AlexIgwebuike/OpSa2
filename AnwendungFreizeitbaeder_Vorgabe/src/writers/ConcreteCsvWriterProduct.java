package writers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Freizeitbad;

public class ConcreteCsvWriterProduct extends WriterProduct {
	
	BufferedWriter aus;
	
	public ConcreteCsvWriterProduct() {
		try {
			aus = new BufferedWriter(new FileWriter("Freizeitbaeder.csv", true));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void fuegeInDateiHinzu(Freizeitbad freizeitbad) throws IOException{
		this.aus.write(freizeitbad.gibFreizeitbadZurueck(';'));
		schliesseDatei();
	}
	
	public void schliesseDatei() throws IOException{
		this.aus.close();
	}
}
