package edu.java.collection1113;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ArrayListTest {
	
	public static void main(String[] args) {
		
		List<String> al = new ArrayList<String>();
		
		al.add("사과");
		al.add("딸기");
		al.add("바나나");
		
		Iterator<String> it = al.iterator();
		
		int j = al.size();
		for(int i=0; i<j; i++) {
			String str = it.next();
			System.out.println(str);
		}
		
		
		al.remove("딸기");
		
		
		Iterator<String> it2 = al.iterator();
		
		for(int i=0; i<j-1; i++) {
			String str2 = it2.next();
			System.out.println(str2);
		}
		
		al.addAll(포도,);
		
	}
	
}
