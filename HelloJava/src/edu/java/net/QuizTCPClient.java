package edu.java.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class QuizTCPClient {

	final static String TCPSERVER_IP = "172.30.1.74"; // 강의실
//	final static String TCPSERVER_IP = "211.212.147.10"; //집
	final static int TCPSERVER_PORT = 8873;
	QuizSharedObject quizSharedObject;
	
	
	public QuizTCPClient(QuizSharedObject quizSharedObject) {
		this.quizSharedObject = quizSharedObject;
	}

	public static void main(String[] args) {
		
		Socket socket = null;
		OutputStream os =null;
		InputStream is =null;
		
		try {
			// 클라이언트 소켓 생성
			socket = new Socket(TCPSERVER_IP, TCPSERVER_PORT);
			
			os = socket.getOutputStream();
			is = socket.getInputStream();
			
			byte[] data = new byte[100];
			int n = is.read(data);
			final String messageFromServer = new String(data, 0, n);
			System.out.println(messageFromServer);
			
			
			while(true) { 
				data = new byte[100];
				n = is.read(data);
				final String messageFromServer2 = new String(data, 0, n);
				System.out.println(messageFromServer2);
				Scanner scanner = new Scanner(System.in);
				String clientTyped = scanner.nextLine();
				os.write(clientTyped.getBytes());
				os.flush();
			}
			
			
		} catch (UnknownHostException uhe) {
			uhe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				is.close();
				os.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	}
	
}
