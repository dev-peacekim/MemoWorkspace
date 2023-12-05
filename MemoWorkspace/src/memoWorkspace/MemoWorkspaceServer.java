package memoWorkspace;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MemoWorkspaceServer {

	final static int SERVER_PORT = 8873;
	
	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			
			serverSocket = new ServerSocket(SERVER_PORT);
			
			while(true) {
				socket = serverSocket.accept();
				ServerThread serverThread = new ServerThread(socket);
				serverThread.start();
			}
			
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				serverSocket.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
		
	}
	
}
