package edu.java.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
	
	// 접속할 서버의 IP
	final static String TCPSERVER_IP = "172.30.1.30";
	
	// 접속할 서버의 포트
	final static int TCPSERVER_PORT = 8873;
	
	// 클라이언트가 보낼 문자열
	final static String MESSAGE_FROM_CLIENT = "Hi sever!";
	
	//서버는 서버 소켓, 소켓이 있지만, 클라이언트는 소켓만 있으면 됨
	public static void main(String[] args) {
		
		// 클라이언트 소켓
		Socket socket = null;
		
		// 클라이언트가 서버에 보낼 바이트 스트림
		OutputStream os =null;
		// 서버에 받을 바이트 스트림
		InputStream is =null;
		
		try {
			// 클라이언트 소켓 생성
			socket = new Socket(TCPSERVER_IP, TCPSERVER_PORT);
			
			os = socket.getOutputStream();
			is = socket.getInputStream();
			
			// 서버에 메세지를 전송
			os.write(MESSAGE_FROM_CLIENT.getBytes());
			os.flush();
			
			// 서버가 보낸 바이트 스트림을 저장할 버퍼의 역할을 함
			byte[] data = new byte[16];
			int n = is.read(data);
			final String messageFromServer = new String(data, 0, n);
			System.out.println(messageFromServer);
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
		
	} //main
	
} // class
