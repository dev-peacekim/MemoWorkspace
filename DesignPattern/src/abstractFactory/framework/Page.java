package abstractFactory.framework;

public abstract class Page {

	private Item item;
	
	public Item getItem() {
		return item;
	}
	
	String title;
	String author;
	String content;
	
	void add() {
		
	}
	
	void output() {
		
	}
	
	public abstract String makeHTML();
	
}
