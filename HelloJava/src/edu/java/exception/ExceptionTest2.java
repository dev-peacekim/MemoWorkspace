package edu.java.exception;

public class ExceptionTest2 {
	
	public static void main(String[] args) {
		// 실습1 outofmemory에러를 내보세요.
		// 실습2 stackoverflow에러를 내보셔
		/*
		int count=0;
		while(true) {
			
			new ExceptionTest2();
			System.out.println(++count);
			
		} */
		a();
		
	}
	
	public static void a() {
		b();
	}
	
	
	public static void b() {
		a();
	}
	
	
	
}
