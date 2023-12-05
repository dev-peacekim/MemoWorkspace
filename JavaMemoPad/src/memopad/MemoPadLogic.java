package memopad;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.text.SimpleDateFormat;

class MemoPadLogic {
	
	// 기능 선택 문구 출력 및 선택한 기능의 문자 반환 
	String sysoutFunctionList() {
		
		System.out.print("메모패드 기능을 선택해주세요 (L/R/W/D/Q) : ");
		Scanner scanner = new Scanner(System.in);
		String function = scanner.nextLine();
		return function;
		
	} // 기능 선택 문구 출력 및 선택한 기능의 문자 반환 끝
	
	
	// 파일 리스트 기능 (L)
	void readList() {
		
		File filesPath = new File("C:/memopad/");
		String[] files = filesPath.list();
		int j = files.length;
		for(int i=0; i<j; i++) {
			System.out.println((i+1)+") "+files[i]);
		}
		
	} // 파일 리스트 기능 끝
	
		
	// 파일 읽기 기능 (R)
	void readNote(String nums) {
		
		// 기능 선택 시 return 받은 숫자 문자열을 int로 변환
		int num = Integer.parseInt(nums);
		num = num-1;
		
		// 파일 배열 생성
		File filesPath = new File("C:/memopad/");
		File[] files = filesPath.listFiles();
		
		// 파일 리더 인스턴스 생성 및 내용 읽기 + 예외 처리
		FileReader reader = null;
		try {
			reader = new FileReader(files[num]);
			int end;  
			while((end = reader.read()) != -1) { // 스트림이라 계속해서 읽어 나가는 거임
				System.out.print((char)end); //int라서 char 타입으로 바꿔줘야 읽을 수 있음
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		System.out.println();
		
	} // 파일 읽기 기능 끝
	
	
	// 파일 쓰기 기능 (W)
	void writeNote() {
		
		// 메모 제목 입력 후 저장
		System.out.print("제목 : ");
		Scanner scanner = new Scanner(System.in);
		String title = scanner.nextLine();
		
		// 메모 내용 입력 후 저장
		System.out.print("내용 : ");
		String text = scanner.nextLine();
		
		// 메모 제목을 기반으로 메모 객체 생성 및 파일 객체 생성
		Memo memo = new Memo(title, text);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddhhmm");
		String strNow = sdf.format(memo.date);
		memo.file = new File("C:/memopad/"+title+"_"+strNow+".txt");
		
		// 파일 생성
		if (!memo.file.exists()) {
			try {
				memo.file.createNewFile();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
		// 파일 내용 쓰기
		FileWriter fw = null;
		try {
			fw = new FileWriter(memo.file);
			fw.write("제목 : "+title+"\n"+"내용 : "+text);
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	} // 파일 쓰기 기능 끝
	
	
	// 파일 지우기 기능 (D)
	void deleteNote(String nums) {
		
		int num = Integer.parseInt(nums);
		num = num-1;
		// 파일 배열 생성
		File filesPath = new File("C:/memopad/");
		File[] files = filesPath.listFiles();
		
		files[num].delete();
		
	} // 파일 지우기 기능 끝
	
} // class
