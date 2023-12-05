package templateMethod;

public class StringDisplay extends AbstractDisplay {

	String str;
	
	public StringDisplay(String str) {
		this.str = str;
	}
	
	@Override
	void open() {
		System.out.println("+=============+");
	}

	@Override
	void print() {
		
		System.out.println(str);

	}

	@Override
	void close() {
		System.out.println("+=============+");
	}

}
