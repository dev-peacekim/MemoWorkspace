package edu.java.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCreator {
	
	public static void main(String[] args) {
		
		OutputStream os = null;
		InputStream is = null;
		
		try {
			is = new FileInputStream("C:/data/bigfile.dat");
			os = new FileOutputStream("C:/data/bigfile_copy.dat");
			
			byte[] buffer = new byte[1024];
			
			long startTime = System.currentTimeMillis();
			while (true) {
				int readByteNum = is.read(buffer);
				if (readByteNum==-1) break;
				os.write(buffer);
			} 
			
			long endTime = System.currentTimeMillis();
			
			System.out.println(endTime - startTime);
						
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
