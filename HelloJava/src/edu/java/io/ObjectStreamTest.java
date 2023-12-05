package edu.java.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest {

	public static void main(String[] args) {
		
		Person person1 = new Person("111111-1111111", "홍길동", 30);
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			oos = new ObjectOutputStream(
						new FileOutputStream("C:/data/person1.obj")
			);
			oos.writeObject(person1);
			oos.flush();
			
			ois = new ObjectInputStream(new FileInputStream("C:/data/person1.obj"));
			Person person2 = (Person)ois.readObject();
			
			oos = new ObjectOutputStream(
					new FileOutputStream("C:/data/person2.obj")
			);
			oos.writeObject(person2);
			oos.flush();
			
			System.out.println(person2);
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
	}  // main
	
}  // class
