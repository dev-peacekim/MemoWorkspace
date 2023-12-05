package edu.java;

public class TypeCastingMain {
	
	public static void main(String[] args) {
		
		Parent parent1 = new Parent();
		Child child1 = new Child();
		
		// Parent 타입의 parent1, 가지고 있는 참조는 Parent 참조
		System.out.println(parent1.getName());
		
		// Child 타입의 child1, 가지고 있는 참조는 Child 참조
		System.out.println(child1.getName());
		
		// upCasting(상위형변환, 묵시적형변환, 하위타입>상위타입)
		// parent2는 Parent타입, 가지고 있는 참조는 Child 참조
		Parent parent2 = new Child();
		System.out.println(parent2.getName());
		
		// downcasting (하위형변환, 명시적형변환, 상위타입>하위타입)
		// Child2는 Child 타입, 가지고 있는 참조는 Child
		// 하위형변환을 위해서는 하위타입의 참조값을 가지고 있어야 한다.
		Child child2 = (Child)parent2;
		System.out.println(child2.getName());
		
		Parent parent3 = child2;
		
	}
	
}
