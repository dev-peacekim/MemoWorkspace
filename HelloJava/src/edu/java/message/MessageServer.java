package edu.java.message;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class MessageServer {

	final static int SERVER_PORT = 8873;

	public static void main(String[] args) {
		
		// 여러번 쓸 것 같은걸 여기 위치에 만들어 주면 됨
		ObjectInputStream ois=null;
		ObjectOutputStream oos = null;
		Socket socket = null;
		ServerSocket serverSocket = null;
		FileWriter fw = null;
		
		try {
			serverSocket = new ServerSocket(SERVER_PORT);
			socket = serverSocket.accept(); // 클라이언트가 접근할 때 까지 기다림
				
			ois = new ObjectInputStream(socket.getInputStream());
			List messageList = (List) ois.readObject();
			
			File dir = new File("C:/java_logs");
			if(!dir.exists()) dir.mkdir();
			
			File file = new File("C:/java_logs/log_20231121.txt");
			if(!file.exists()) file.createNewFile();
			
			fw = new FileWriter(file);
			
			Iterator<Message> it = messageList.iterator();
			
			while(it.hasNext()) {
				Message message = it.next();
				System.out.println("제목 : " + message. getSubject());
				System.out.println("내용 : " + message.getContent());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh:mm");
				String writeDate = sdf.format(message.getWriteDate());
				System.out.println("작성일시 : " + writeDate);
				
				fw.write(writeDate+ ":"+message. getSubject()+":"+message.getContent()+"\n");
				fw.flush();
			}
			
		} catch(ClassNotFoundException cne) {
			cne.printStackTrace();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				fw.close();
				ois.close();
				socket.close();
				serverSocket.close();
			} catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
		
	}
	
}
