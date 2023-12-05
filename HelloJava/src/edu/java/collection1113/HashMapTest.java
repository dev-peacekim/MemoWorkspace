package edu.java.collection1113;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;

public class HashMapTest {
	
	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("김평화", 1234);
		map.put("유안나", 3412);
		map.put("김요한", 1010);
		
		System.out.println(map);
		
		map.replace("김요한", 1111);
		
		System.out.println(map);
		
		
		
		Map<String, Integer> map2 = new HashMap<String, Integer>();
		map2.putAll(map);
		
		System.out.println(map);

		System.out.println(map2.get("김평화"));
		
		Set keySet = map.keySet();
		Iterator it = keySet.iterator();
		
		try {
			while(it.hasNext()) {
				String nextItem = (String)it.next();
				System.out.println(nextItem);
			}
		} catch (NoSuchElementException e) {
			System.out.println("엘리먼트 없음");
		}
		
	}
	
}
