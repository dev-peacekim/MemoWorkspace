package memoWorkspace;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerThread extends Thread{

	private Socket socket;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			ServerLogic serverLogic = new ServerLogic(br, bw);
			DepartmentList departmentList=serverLogic.storeDepartmentList();
			String department=null;
			
			// 유저 DB 경로 및 파일 생성(없을 경우)
			serverLogic.setUserDB();
			
			// 초기 화면 문구 출력
			serverLogic.welcomMessage();
			
			// 루프 탈출용 boolean 생성
			boolean isread = true;
			
			// 읽어 들인 값에 따라 다른 기능 실행
			while(isread) {
				
				switch(br.readLine()) {
					
					// 회원 가입 기능
					case "Sign in" :
						serverLogic.signIn(departmentList);
						serverLogic.welcomMessage();
						break;
						
						
					// 로그인 기능
					case 	"Sign up" :
						department = serverLogic.signUp(); // 아래 모든 기능에서 사용
						break;
					
						
					// 파일 리스트 기능 (L)
					case "L" :
						serverLogic.readList(department);
					break;	
					
					
					// 파일 리스트 기능 (W)
					case "W" :
						serverLogic.writeMemo(department);
					break;	
					
					
					// 파일 리스트 기능 (R)
					case "R" :
						serverLogic.readMemo(department);
					break;	
					
					
					// 파일 삭제 기능 (D)
					case "D" :
						serverLogic.deleteMemo(department);
					break;
					
					
					// 종료 기능
					case "Q" : 
						bw.write("시스템이 종료됩니다.\n");
						bw.flush();
						break;
						
				} // switch
				
			} // while
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				br.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
	} // run
	
} // close
