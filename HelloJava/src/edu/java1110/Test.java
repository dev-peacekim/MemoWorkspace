package edu.java1110;

public class Test {
	
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		long before = System.currentTimeMillis();
		int sum = 0;
		for(int i =1; i<100000000; i++) {
			sum= sum+1;
			System.out.println(sum);
		}
		
		long after = System.currentTimeMillis();
		
		System.out.println(after-before);
		
	}
	
}
