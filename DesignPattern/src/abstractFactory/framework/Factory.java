package abstractFactory.framework;

public abstract class Factory {

	private static Factory factory;
	
	private Factory() {
		// TODO Auto-generated constructor stub
	}
	
	public static Factory getFactory() {
		return factory;
	}
	
	public abstract String createLink();
	public abstract Tray createTray();
	public abstract String createPage();
	
}
