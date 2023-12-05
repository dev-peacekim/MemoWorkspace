package edu.java.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PhotoCopyer {

	public static void main(String[] args) {
		
		// C:\data\kimchi.jpg
		
		InputStream is = null;
		OutputStream os = null;

		try {
			is = new FileInputStream("C:/data/186514 (1080p).mp4");
			os = new FileOutputStream("C:/data/186514 (1080p)_copy.mp4");
			
			byte[] buffer = new byte[1024];
			
			while (true) {
				int readByteNum = is.read(buffer);
				if (readByteNum==-1) break;
				os.write(buffer); // readbytenum으로 안받는 이유는 buffer가 리턴하는게 읽은 바이트 수이기 때문임 
			}
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
				os.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	} // main
	
}  // class
