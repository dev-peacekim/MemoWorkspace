package factoryMethod.idcard;

import java.util.ArrayList;
import java.util.List;

import factoryMethod.framework.Factory;
import factoryMethod.framework.Product;

public class IDCardFactory extends Factory {

	private List<Product> productList;
	private String owner;
	
	public String getOwner() {
		return this.owner;
	}
	
	public List<Product> getProductList() {
		return this.productList;
	}
	
	public IDCardFactory() {
		this.productList = new ArrayList<Product>();
	}
	
	@Override
	public Product createProduct(String owner) {
		return new IDCard(owner);
	}
	
	@Override
	public void registerProduct(Product product) {
		productList.add(product);
	}
	
}
