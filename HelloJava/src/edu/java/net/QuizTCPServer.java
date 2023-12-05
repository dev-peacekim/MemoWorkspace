package edu.java.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class QuizTCPServer {

	final static int SERVER_PORT = 8873;
	
	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(SERVER_PORT);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		try {
			
			while(true) {

				Socket socket = serverSocket.accept();
				new QuizThread(socket, new QuizSharedObject()).start();
				
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} 
		
	} // main
	
} // Class
