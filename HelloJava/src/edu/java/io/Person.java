package edu.java.io;

import java.io.Serializable;

public class Person implements Serializable {
	
	public static final long serialVersionUID = 354646546546545644L;  // 네트워크 상의 ID

	private String ssn;				// 주민등록 번호
	private String name;			// 이름
	private int age;					// 나이
	

	Person() {
		
	}
	
	public Person(String ssn, String name, int age) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [ssn=" + ssn + ", name=" + name + ", age=" + age + "]";
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
