package writers;

public class ConcreteCsvWriterCreator extends WriterCreator {
	
	public WriterProduct factoryMethod() {
		return new ConcreteCsvWriterProduct();
	}

}
