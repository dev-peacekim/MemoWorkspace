package edu.java1108;

public class Car {

	String name = "포르쉐";
	int tireCount = 4;
	
	@Override
	public String toString() {
		
		return this.name + "차량이며 바퀴가" +
				this.tireCount + "개입니다.";
		
	}
}
