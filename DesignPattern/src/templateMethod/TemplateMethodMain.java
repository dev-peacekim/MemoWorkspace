package templateMethod;

public class TemplateMethodMain {

	public static void main(String[] args) {
		AbstractDisplay charDisplay = new CharDisplay('A');
		AbstractDisplay stringDisplay = new StringDisplay("Hello");
		
		charDisplay.dispaly();
		stringDisplay.dispaly();
	}
	
}
