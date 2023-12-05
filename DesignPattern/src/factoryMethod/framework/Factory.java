package factoryMethod.framework;

public abstract class Factory {

	
	public abstract Product createProduct(String owner);
	public abstract void registerProduct(Product product);
	public Product create(String owner) {
		Product product = createProduct(owner);
		registerProduct(product);
		return product;
	}
	
}
