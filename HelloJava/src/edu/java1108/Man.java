package edu.java1108;

public class Man extends Person {
	
	
	Man(String name, String sex) {
		super(name, sex);
	}
	
	
	@Override
	void sayName() {
		
		System.out.println("저는" + sex + "인" + name + "입니다");
		
	}
	
}
