package edu.java.message;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class AddServer {

	public static void main(String[] args) {
		
		ServerSocket ss =null;
		Socket socket = null;
		OutputStreamWriter osw = null;
		
		try {
			ss = new ServerSocket(8879);
			if(ss!=null) System.out.println("AddServer 준비 완료!!!");
			
			while(true) {
				socket = ss.accept();
				System.out.println(socket.getInetAddress()+"님 접속!!!");
				new AdderThread(socket).start();
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				ss.close();
				socket.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	}
	
}
