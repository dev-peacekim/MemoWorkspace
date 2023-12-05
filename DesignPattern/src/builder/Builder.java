package builder;

public abstract class Builder {

	public abstract String makeTitle(String title);
	public abstract String makeString(String string);
	public abstract String makeItems(String items);
	public abstract Object getResult();
	
}
