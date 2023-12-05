package prototype.framework;

public class PrototypeMain {

	public static void main(String[] args) {
		
		Product product = new MessageBox("======");
		Manager manager = new Manager(product);
		try {
			Product cloneProduct = (Product)manager.create();
			cloneProduct.use();
		} catch (CloneNotSupportedException cse) {
			cse.printStackTrace();
		}
		
	}
	
}
