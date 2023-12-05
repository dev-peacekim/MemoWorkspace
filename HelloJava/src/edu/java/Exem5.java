package edu.java;

public class Exem5 {

	public static void main(String[] args) {

		for (int i = 1; i <= 5; i++) {
			

			for (int j = 5; j-i >= 1; j--) {

				System.out.print(" ");

			}
			
			for (int k = 1; k <= i*2-1; k++) {

				System.out.print("*");

			}
			
			System.out.println();

		}

	}

}