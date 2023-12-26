import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class GSONTest {

	public static void main(String[] args) {
		
		Gson gson = new Gson();
		
		Map<String, String> inputMap = new HashMap<String, String>();
		inputMap.put("name", "홍길동");
		inputMap.put("age", "30");
		inputMap.put("address", "서울시 어딘가");
		
		// Map 객체를 json 문자열로 (직렬화)
		String jsonStr = gson.toJson(inputMap);
		System.out.println(jsonStr);
		
		// json 문자열을 map 객체로 변환 (역직렬화)
		Map jsonMap = gson.fromJson(jsonStr, Map.class);
		System.out.println(jsonMap.get("address"));
		
		List<String> strList = new ArrayList<String>();
		strList.add("한국");
		strList.add("일본");
		strList.add("중국");
		
		// List 객체를 json 문자열로
		String str = gson.toJson(strList);
		System.out.println(str);
		
		// json 문자열을 List 객체로 (역직렬화)
		List list = gson.fromJson(str, List.class);
		System.out.println(list.get(1));
		
		
		// Person 객체를 json 문자열로 (직렬화)
		Person person1 = new Person("홍길동", new Integer(30), "서울시 어딘가");
		String strPerson1 = gson.toJson(person1);
		System.out.println(strPerson1);
		
		// json문자열을 Person객체로 (역직렬화)
		Person person2 = gson.fromJson(strPerson1, Person.class);
		System.out.println(person2);
		
		// 실습1 List에 Person을 3명 담고 직렬화
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("홍길동", 30, "성동구 어딘가"));
		personList.add(new Person("강감찬", 20, "광진구 어딘가"));
		personList.add(new Person("김기리", 40, "왕십리 어딘가"));
		
		String personListStr = gson.toJson(personList);
		System.out.println(personListStr);
		
		List<Person> personList2 = gson.fromJson(personListStr, List.class);
		System.out.println(personList2);
		
		// 실습2 map에 Person을 3명 담고 직렬화 / 역직렬화
		Map<String, Object> personMap = new HashMap<String, Object>();
		personMap.put("person1", new Person("홍길동", 30, "성동구 어딘가"));
		personMap.put("person2", new Person("강감찬", 40, "성동구 어딘가"));
		personMap.put("person3", new Person("이순신", 60, "성동구 어딘가"));
		String strPersonMap = gson.toJson(personMap);
		System.out.println(strPersonMap);
		
		Map personMap2 = gson.fromJson(strPersonMap, Map.class);
		System.out.println(personMap2.get("person1"));
		
		// GSON의 JsonObject
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("name", "홍길동");
		jsonObject.addProperty("age", 30);
		jsonObject.addProperty("married", true);
		
		System.out.println(jsonObject);
		System.out.println(jsonObject.get("name").getAsString());
		System.out.println(jsonObject.get("age").getAsInt());
		System.out.println(jsonObject.get("married").getAsBoolean());
		
		// GSON pretty Printing
		Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
		String prettyStr = gson2.toJson(jsonObject);
		System.out.println(prettyStr);
		
	} // main
	
} // class
