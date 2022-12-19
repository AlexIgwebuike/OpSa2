package writers;

import java.io.IOException;
import java.util.ArrayList;

import business.Freizeitbad;

public abstract class WriterProduct {
	
	public abstract void fuegeInDateiHinzu(ArrayList<Freizeitbad> freizeitbaeder) throws IOException;
	
	public abstract void schliesseDatei() throws IOException;

}
