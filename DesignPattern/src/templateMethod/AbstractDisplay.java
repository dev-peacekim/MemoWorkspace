package templateMethod;

public abstract class AbstractDisplay implements Display {

	abstract void open();
	abstract void print();
	abstract void close();
	
	
	@Override
	public void dispaly() {
		open();
		print();
		close();
	}
	
}
