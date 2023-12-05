package builder;

public class TextBuilder extends Builder{

	StringBuilder builder;
	
	@Override
	public String makeTitle(String title) {
		return title;
	}

	@Override
	public String makeString(String string) {
		return string;
	}

	@Override
	public String makeItems(String items) {
		return items;
	}

	@Override
	public Object getResult() {
		String title = makeTitle(null);
		StringBuilder document = new StringBuilder();
		return document;
	}
	
}
