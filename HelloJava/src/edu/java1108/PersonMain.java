package edu.java1108;

public class PersonMain {
	
	public static void main(String[] args) {
		
		Person person = new Man("김평화", "남자");
		Person person2 = new Women("유안나", "여자");
		person.sayName();
		person2.sayName();
		
	}
	
}
