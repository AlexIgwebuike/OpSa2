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
		this.aus.write("Daten des Freizeitbades"
					+ "\nName des Freizeitbads:              " + freizeitbad.getName()
					+ "\nÖffnungszeit des Freizeitbads:       " + freizeitbad.getGeoeffnetVon() + " - " + freizeitbad.getGeoeffnetBis()
					+ "\nBeckenlänge des Freizeitbads:        " + freizeitbad.getBeckenlaenge()
					+ "\nWasasertemperatur des Freizeitbads:  " + freizeitbad.getTemperatur());
		schliesseDatei();
	}
		
	public void schliesseDatei() throws IOException{
		this.aus.close();
	}
		
}
