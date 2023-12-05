package edu.java;

public class MacBook {

	static String company="apple";
	String model;
	String monitorSize;
	String keyboardType;
	
	public MacBook() {
		
	}
	
	MacBook(String model, String monitorSize, String keyboardType) {
		
		this.model = model;
		this.monitorSize = monitorSize;
		this.keyboardType = keyboardType;
		
	}
	
	String getMacBookData() {
		
		 String resultStr 
		 	= "이 노트북의 모델은" + this.model + ", "
		 	+"모니터 사이즈는" + this.monitorSize + ", "
		 	+"키보드 타입은" + this.keyboardType;
		 
		 return resultStr;
		
	}
	
}
