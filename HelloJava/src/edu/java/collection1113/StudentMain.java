package edu.java.collection1113;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StudentMain {

	public static void main(String[] args) {
		
		Student hong = new Student("std001", "홍길동", 100, 90, 80);
		Student gang = new Student("std002", "강감찬", 50, 30, 20);
		
		hong.setKor(95);
		hong.getKor(); // 해당 메소드 마저 빼버리면 국어 점수엔 아예 접근 불가
		
		// 1. 두 학생의 데이터를 Collection으로 만들어서 
		//     국어점수평균, 영어점수평균, 수학점수평균을 출력
		
		Map<String, Student> map = new HashMap<String, Student>();
		
		map.put(hong.getSno(), hong);
		map.put(gang.getSno(), gang);
		
		List<Integer> al = new ArrayList<Integer>();
		
		al.add(0);
		al.add(0);
		al.add(0);
		
		Iterator it = map.entrySet().iterator();
		
		while(it.hasNext()) {
			Map.Entry<String, Student> entry =  (Map.Entry<String, Student>)it.next();
			Student student = (Student)entry.getValue();
			al.set(0, al.get(0)+student.getKor());
			al.set(1, al.get(1)+student.getEng());
			al.set(2, al.get(2)+student.getMath());
		}
		for (Integer in : al) {
			System.out.println(in / map.size());
		}
	}
	
}
