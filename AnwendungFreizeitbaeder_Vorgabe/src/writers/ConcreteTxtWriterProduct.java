package writers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Freizeitbad;

public class ConcreteTxtWriterProduct extends WriterProduct {
	
	BufferedWriter aus;
	
	public ConcreteTxtWriterProduct() {
		try {
			aus = new BufferedWriter(new FileWriter("Freizeitbaeder.txt", true));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		
	public void fuegeInDateiHinzu(Freizeitbad freizeitbad) throws IOException{
		this.aus.write(freizeitbad.gibFreizeitbadZurueck(';'));
		this.aus.close();
	}
		
	public void schliesseDatei() throws IOException{
		aus.close();
	}
		
}
