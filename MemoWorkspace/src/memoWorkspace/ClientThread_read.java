package memoWorkspace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread_read extends Thread {

	Socket socket;
	BufferedReader br = null;

	public ClientThread_read(Socket socet) {
		this.socket = socet;
	}
	
	@Override
	public void run() {
		
		try {
			while(true) {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				String readData;
				String message = "";
			
				while((readData=br.readLine()) != null) {
					message = readData;
					System.out.println(message);
				}
				
				if(message.equals("시스템이 종료됩니다.")) {
					break;
				} 
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				br.close();
				socket.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	} // run
	
} // class
