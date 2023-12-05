package edu.java;

public class JavaVariable2 {
	
	//non-static variable
	int realnsi=1;
	
	// non-static block
	{
		// local variable
		int nsi = 1;
		realnsi = 1;
		realsi =1;
		Person2 a = new Person2(); // 얘도 지역변수
	}
	
	// static block
	static { // static 변수의 초기화 블록 이라고도 함, static 변수의 초기화를 위해 사용) 
		// local variable
		int si = 2;	
		realnsi =2;  // static 블록 안에 nsi를 집어 넣을 수 없는건 static이 먼저 실행되기 때문
		realsi = 2;
		Person2 a = new Person2(); // 얘도 지역변수
	}
	
	// static member variable
	static int realsi = 1;
	
	public static void main(String[] args) {
		System.out.println(realnsi);
		System.out.println(realsi);
		// 위에서 블록 안에 선언되었기 때문에 블록 밖을 벗어날 수 없음 (지역변수)
	}
	
}
