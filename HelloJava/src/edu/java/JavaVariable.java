package edu.java;

public class JavaVariable {
	
	// static member variable
	static int si = 1;
	
	// non static member variable
	// 자동 초기화가 됨 non-static 멤버는
	int nsi = 2;
	
	// static member method
	static int add(int i, int j) {
		// int i, int j : add 메소드의 local variable, stack에 들어감
		return i+j;
	}
	
	// non static member method
	int mul(int i, int j) {
		return i*j;  
	}
	
}
