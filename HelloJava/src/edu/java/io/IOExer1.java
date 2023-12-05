package edu.java.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class IOExer1 {
	
	// IO실습1)
	// 1. diary.txt파일을 생성하고 오늘 일기를 쓰세요
	// 2. diary.txt파일을 읽어 diary_copy.txt파일로 복사하세요.
	
	public static void main(String[] args) {
		
		Writer writer = null;
		Reader reader = null;
		
		try {
			reader = new FileReader("C:/data/diary.txt");
			writer = new FileWriter("C:/data/diary_copy2.txt");
			while(true) {
				int read=reader.read();
				if(read==-1) break;
				writer.write(read);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.flush();
				writer.close();
				reader.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
}
