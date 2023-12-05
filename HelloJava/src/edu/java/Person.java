package edu.java;

public class Person {

	static int si = 100; //초기화 안하면 런타임 전에 실행되버림
	int nsi; // 여기선 초기화 안해도 됨, non-static 멤버 변수라
	String name;
	
	String getName() {
		
		return this.name;
		
	}
	
	void setName(String name) {
		
		this.name = name;
		
	}
	
	int getNsi() {
		
		return this.nsi;
		
	}
	
	void setNsi(int nsi) {
		
		this.nsi = nsi;
		
	}
	
//	public static void main(String[] args) {
//		
//		int li =2; // 여기선 초기화 해야함, 지역변수라
//		
//	}
	
}
