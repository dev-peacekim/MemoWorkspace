package edu.java;

public class Exem6 {

	public static void main(String[] args) {
		
		for(int i=0; i<5; i++) {
			
			for(int j=0; j<5; j++) {
				
				if((i>=1&&i<=3)&&(j>=1&&j<=3)) {
					
					System.out.print(" ");
					
				}
				
				if((i>=1&&i<=3)&&(j==0||j==4)) {
					
					System.out.print("*");
					
				}
				
				if(i==0||i==4) {
					
					System.out.print("*");
					
				}
				
			}
			
			System.out.println();
			
		}
			
	} // main
	
} // class
