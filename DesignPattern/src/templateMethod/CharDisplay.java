package templateMethod;

public class CharDisplay extends AbstractDisplay {

	char ch;
	
	public CharDisplay(char ch) {
		this.ch = ch;
	}
	
	@Override
	void open() {
		System.out.println("<<");
	}
	
	@Override
	void print() {
		
		System.out.println(ch);
		
	}
	
	@Override
	void close() {
		
		System.out.println(">>");
		
	}
	
}
