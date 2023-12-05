package singleton;

public class SingletonMain {

	public static void main(String[] args) {
		
		Singleton singleton = Singleton.getInstance();
		Singleton singleton1= Singleton.getInstance();
		
		System.out.println(singleton);
		System.out.println(singleton1);
		
		System.out.println(singleton==singleton1 ? "같은 객체" : "다른 객체");
		
	}
	
}
