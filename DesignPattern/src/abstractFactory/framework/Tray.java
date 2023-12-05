package abstractFactory.framework;

public abstract class Tray extends Item {

	Item tray;
	
	public Item getTray() {
		return tray;
	}
	
	public abstract void add();
	
	@Override
	public abstract String makeHTML();

}
