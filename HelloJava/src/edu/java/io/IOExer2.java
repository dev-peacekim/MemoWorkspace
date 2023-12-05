package edu.java.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class IOExer2 {
	
	// IO실습2
	// 아래 내용을 포함하는 텍스트 파일을 생성하고 읽어서 화면에 출력하세요
	// 단) Buffering을 사용하세요
	
	
	public static void main(String[] args) {
		
		BufferedWriter bw = null;
		BufferedReader br = null;
		
		try {
		String filepath = "C:/data/poem.txt";
		bw = new BufferedWriter(new FileWriter(filepath));
		bw.write("죽는 날까지 하늘을 우르러");
		bw.newLine();
		bw.write("한 점 부끄럼 없기를");
		bw.newLine();
		bw.write("그 다음 몰라...");
		bw.flush();
		
		br = new BufferedReader(new FileReader(filepath));
		String lineData = null;
		while ((lineData=br.readLine())!=null) {
			
			System.out.println(lineData);
			
		}
		
		} catch(IOException e) {
			e.printStackTrace();
			
		} finally {
			try {
				bw.close();
				br.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
