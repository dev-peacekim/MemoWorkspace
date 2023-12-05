package compositeMethod;

public class File extends Entry{

	private String name;
	private int size;
	
	public File(String name, int size) {
		this.name = name;
		this.size = size;
	}
	
	@Override
	public void printList() {
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public long getSize() {
		return this.size;
	}
	
}
