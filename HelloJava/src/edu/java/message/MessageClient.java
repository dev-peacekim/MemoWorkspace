package edu.java.message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageClient {

	final static String TCPSERVER_IP = "172.30.1.74";
	final static int TCPSERVER_PORT = 8873;
	
	public static void main(String[] args) {
		
		ObjectOutputStream oos = null;
		Socket socket = null;
		
		try {
			socket = new Socket(TCPSERVER_IP, TCPSERVER_PORT);
			oos = new ObjectOutputStream(socket.getOutputStream());
			List<Message> messageList = new ArrayList<Message>(); 
			messageList.add(new Message("안녕하세요", "김평화입니다.", new Date()));
			messageList.add(new Message("안녕하세요", "유안나입니다.", new Date()));
			messageList.add(new Message("안녕하세요", "김요한입니다.", new Date()));
			
			oos.writeObject(messageList);
			
		} catch(UnknownHostException uhe) {
			uhe.printStackTrace();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				oos.close();
				socket.close();
			} catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	}
	
}
