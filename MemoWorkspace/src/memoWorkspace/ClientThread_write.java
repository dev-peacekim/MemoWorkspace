package memoWorkspace;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientThread_write extends Thread {

	Socket socket;
	BufferedWriter bw;
	ServerThread severThread;

	public ClientThread_write(Socket socket) {
		this.socket = socket;
	}
	
	
	@Override
	public void run() {
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			boolean isread = true;
			while(isread) {
				String outData = "";
				outData = scanner.nextLine();
				bw.write(outData+"\n");
				bw.flush();
				
				if(outData.equals("Q")) {
					// 닫기 기능
						System.out.println("메모패드가 종료되었습니다");
						isread = false;
						break;
				}
				
			}
				
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			scanner.close();
			try {
				bw.close();
				socket.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	} // run
	
} // class
