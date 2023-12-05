package edu.java.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


// TCP 서버
public class TCPServer{
	
	// 서버의 포트번호 (0~1023제외, ~65534까지 중에서 하나)
	final static int SERVER_PORT = 8873;
	// 서버에서 클라이언트에게 보낼 메세지
	final static String MESSAGE_FROM_SERVER = "Hello Client!";
	
	public static void main(String[] args) {
		
		// 서버는 서버 소켓이 필요함
		// 서버 소켓은 클라이언트에게 할당할 소켓들을 관리하는 역할
		ServerSocket serverSocket = null;
		
		try {
			// 설정한 포트를 사용하는 서버 소켓을 생성, 포트가 있어야 함
			serverSocket = new ServerSocket(SERVER_PORT);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		//클라이언트 > 서버 바이트 스트림
		InputStream is= null;
		
		//서버 > 클라이언트 바이트스트림
		OutputStream os =null;
		
		try {
			// 클라이언트에게 요청을 계속 받아야 되니까 무한 반복 시켜줌, 서버는 계속 살아있게
			while(true) {

				// 서버 소켓의 accept 메소드는 blocking 메소드라 부르며
				// accept 메소드가 호출되면 클라이언트의 연결을 대기, 연결 될때까지 밑의 코드 실행을 안함

				// accept는 소켓(서버쪽에 있는 클라이언트와 통신하는 서버 소켓)을 반환함
				Socket socket = serverSocket.accept(); // accept는 blocking 메소드라 대기 시킴
				
				// 클라이언트와 연결되면 클라이언트에 할당한 소켓의 입출력 스트림을 얻을 수 있다.
				is = socket.getInputStream();  // 클라이언트>서버 바이트 스트림
				os = socket.getOutputStream();  // 서버>클라이언트 바이트 스트림
				
				
				// 16바이트 버퍼
				byte[] data = new byte[16];
				
				// 읽어들인 바이트 수 반환
				int n = is.read(data);
				
				// 클라이언트에서 받은 바이트스트림을 문자열로 변환
				final String messageFromClient = new String(data, 0, n);
				
				// 서버에서 클라이언트에게 바이트 배열을 보냄
				os.write(MESSAGE_FROM_SERVER.getBytes());
				
				// 그냥 아웃풋 스트림이기 때문에 flush 해주어야 클라이언트에게 전송됨, bufferedoutputstream의 경우 자동으로 flush()
				os.flush();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				is.close();
				os.close();
			} catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	} // main
	
} // class
