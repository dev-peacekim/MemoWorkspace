package edu.java.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QuizThread extends Thread {

	private Socket socket;
	private QuizSharedObject quizSharedObject;
	
	QuizThread(Socket socket, QuizSharedObject quizSharedObject) {
		this.socket = socket; 
		this.quizSharedObject = quizSharedObject;
	}
	
	@Override
	public void run() {
		// 어레이 리스트에 퀴즈 객체 추가
		List<Quiz> List = new ArrayList<Quiz>();
		List.add(new Quiz(1, "논리적인 사람이 총을 쏘면?", "타당타당"));  
		List.add(new Quiz(2, "소나무가 삐지면?", "칫솔"));  
		List.add(new Quiz(3, "미소의 반대말은?", "당기소"));  
		List.add(new Quiz(4, "딸이 기분이 좋으면?", "딸기모찌"));  
		List.add(new Quiz(5, "바나나가 웃으면?", "바나나킥"));  
		List.add(new Quiz(6, "소변과 대변 중 어느 것이 먼저 나올까?", "급한것"));  
		List.add(new Quiz(7, "도둑이 가장 좋아하는 아이스크림은?", "보석바"));  
		List.add(new Quiz(8, "우유가 웃는다면?", "빙그레"));  
		List.add(new Quiz(9, "도둑이 훔친 돈은?", "슬그머니"));  
		List.add(new Quiz(10, "세상에서 가장 가난한 왕은?", "최저임금"));
		
		// 어레이 리스트 기반의 퀴즈 리스트 객체 생성
		QuizList quizList = new QuizList(List);
		Iterator<Quiz> it = quizList.getQuizList().iterator();
		InputStream is=null;
		OutputStream os=null;
		
		try {
			// 소켓 인풋 스트림 아웃풋 스트림 연결
			is= socket.getInputStream();
			os =socket.getOutputStream();
			
			// 프로그램 시작 시 문구 출력
			os.write("서버---퀴즈 프로그램을 시작합니다.\n".getBytes());
			os.flush();
			
			int count =0;
			
			while(it.hasNext()) {
				Quiz quiz = it.next();
				int questionSeq = quiz.getSeq();
				String question = quiz.getContent();
				
				// 문제 번호 및 퀴즈 보냄
				os.write(("서버---퀴즈 " + questionSeq + " : " + question).getBytes());
				os.flush();
				
				// 10초 대기
				Thread.sleep(10000);
				
				// 클라이언트 답변 읽어 들이기
				
				byte[] data = new byte[100];
				int n = is.read(data);
				final String messageFromClient = new String(data, 0, n);
				quizSharedObject.setClientAnswered(true);
				
				// 클라이언트와의 답변 비교후 정답 여부 전달
				if(messageFromClient.equals(quiz.getAnswer())) {
					os.write("서버---정답입니다.".getBytes());
					os.flush();
					count = count+1; // 정답 갯수
				} else {
					os.write("서버---이것도 몰라?".getBytes());
					os.flush();
				}
			}
			
			// 총 정답 갯수 알려주기
            os.write(("10문제중 총 " + count + "문제 정답입니다.").getBytes());
			os.flush();
			
		} catch(InterruptedException ie) {
			ie.printStackTrace();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				is.close();
				os.close();
				socket.close();
			} catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	}
	
}
