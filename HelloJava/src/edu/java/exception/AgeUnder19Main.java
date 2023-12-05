package edu.java.exception;

public class AgeUnder19Main {
	
	public static void main(String[] args) {
		
		int age = 15;
		int age2 = 55;
		if (age<19) {
			try {
			throw new AgeUnder19Exeption();
			} catch (AgeUnder19Exeption e) {
				System.out.println(e);
			}
		} 
		if(age2>50) {
			try {
				throw new AgeOver50Exception();
			} catch (AgeOver50Exception ex) {
				System.out.println(ex);
			}
		}
		
	}
	
}