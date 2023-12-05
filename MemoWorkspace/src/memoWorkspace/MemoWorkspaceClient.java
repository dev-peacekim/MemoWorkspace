package memoWorkspace;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class MemoWorkspaceClient {

	final static String SERVER_IP = "172.30.1.74"; // 강의실
//	final static String SERVER_IP = "211.179.4.119"; //집
	final static int SERVER_PORT = 8873;
	
	ClientThread_read read;
	ClientThread_write write;
	
	public static void main(String[] args) {
		
		Socket socket = null;
		
		try {
			
			socket = new Socket(SERVER_IP, SERVER_PORT);
			new ClientThread_read(socket).start();
			new ClientThread_write(socket).start();
			
		} catch(UnknownHostException uhe) {
			uhe.printStackTrace();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} 
		
	} // main
	
} // class
