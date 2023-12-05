package factoryMethod.idcard;

import factoryMethod.framework.Product;

public class IDCard extends Product {

	private String owner;
	
	public IDCard(String owner) {
		this.owner = owner;
	}
	
	@Override
	public void use() {
		System.out.println(owner + "의 카드를 사용합니다.");
	}
	
}
