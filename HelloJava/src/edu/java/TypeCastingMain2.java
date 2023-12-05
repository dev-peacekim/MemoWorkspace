package edu.java;

import java.util.ArrayList;

public class TypeCastingMain2 {
	
	public static void main(String[] args) {
		
		ArrayList<Object> al = new ArrayList<Object>(); // 객체들의 리스트를 만드는
		al.add(new Parent());
		al.add(new Child());
		
		Parent parent = (Parent)al.get(0);
		Child child = (Child)al.get(1);
		
		Object parent = al.get(0);
		Object child = al.get(1);
		
		
		
	}
	
}
