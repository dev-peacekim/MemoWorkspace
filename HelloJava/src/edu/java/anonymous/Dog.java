package edu.java.anonymous;

public class Dog implements Soundable {

	String name;
	String sound;
	
	Dog() {
	}
	
	Dog(String name, String sound) {
		this.name = name;
		this.sound = sound; 
	}
	
	@Override
	public String sound() {
		// TODO Auto-generated method stub
		return this.sound;
	}
	
	public String name() {
		
		return this.name;
	}

}
