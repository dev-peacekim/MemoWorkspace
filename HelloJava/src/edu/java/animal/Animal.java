package edu.java.animal;

// 추상 클래스라 오버라이딩 안해도 에러 안남
public abstract class Animal	implements Walkable, Runnable, Flyable, Soundable {
	
	String sort;
	String name;
	
	@Override
	public void walk() {
		
		System.out.println("걷는다");

	}
	
	@Override
	public void run() {
		
		System.out.println("뛴다");

	}
	
	@Override
	public void fly() {
		System.out.println("난다");
	}

	@Override
	public void sound() {
		System.out.println("소리낸다");
	}
	
}
