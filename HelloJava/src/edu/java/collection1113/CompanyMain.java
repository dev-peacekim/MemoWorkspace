package edu.java.collection1113;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CompanyMain {

	public static void main(String[] args) {
		
		// 실습2. 회사 2개를 생성하고 회사 2개의 2022년 수익합계와 2023년 수익 합계를 아래와 같이 출력하시오.
		// 			ABC회사와 DEF회사의 2022년 총 수익은 ___입니다.
		// 			ABC회사와 DEF회사의 2023년 총 수익은 ___입니다.
		
		
		Company abc = new Company("12345", "ABC", 100, 200);
		Company def = new Company("45678", "DEF", 300, 400);
		
		Map<String, Company> map = new HashMap<String, Company>();
		
		map.put(abc.getSsn(), abc);
		map.put(def.getSsn(), def);
		
		
		List<Integer> al = new ArrayList<Integer>();
		al.add(0);  // 1번째에 0
		al.add(0); // 2번째에 0
		Iterator it= map.entrySet().iterator();
		
		while(it.hasNext()) {
			Map.Entry<String, Company> entry =  (Map.Entry<String, Company>)it.next();
			Company company = (Company)entry.getValue();
			
			al.set(0, al.get(0)+company.getIncome2022());
			al.set(1, al.get(1)+company.getIncome2023());
			
		}
		
		for (Integer in : al) {
			System.out.println(in / map.size());
		}
		
		
	}  //main
	
}  //class