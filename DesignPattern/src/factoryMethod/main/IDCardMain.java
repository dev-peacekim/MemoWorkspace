package factoryMethod.main;

import java.util.List;

import factoryMethod.framework.Factory;
import factoryMethod.framework.Product;
import factoryMethod.idcard.IDCardFactory;

public class IDCardMain {

	public static void main(String[] args) {
		
		Factory factory = new IDCardFactory();
		Product product1 = factory.create("김평화");		
		Product product2 = factory.create("유안나");		
		Product product3 = factory.create("김요한");		
		
		List<Product> productList = ((IDCardFactory)factory).getProductList();
		
		for(Product product : productList) {
			product.use();
		}
		
	}
	
}
