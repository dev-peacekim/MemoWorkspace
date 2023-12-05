package edu.java.collection1113;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.text.html.HTMLEditorKit.Parser;

public class LottoDupTest {
	
	public static void main(String[] args) {
		
		System.out.println(noDup());
		
	}
	
	static Object noDup() {
		
		// Collection 관련 사용한 코드
		Set<Integer> set = new HashSet<Integer>();
		
		while(set.size()<7) {
			Integer num = (int)(Math.random()*45)+1;
			set.add(num);
		}
		
		return set;
	}
	
}
