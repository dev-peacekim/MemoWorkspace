package edu.java;

public class MacBookMain {
	
	public static void main(String[] args) {
		
		MacBook macBook_pro = new MacBook("pro", "24inch", "쿼티");
		System.out.println(macBook_pro.getMacBookData());
		System.out.println(macBook_pro.company);
		
	}
	
}
