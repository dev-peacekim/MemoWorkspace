package edu.java.net;

import java.util.Scanner;

public class QuizThread2 extends Thread{

	@Override
	public void run() {
		
		Scanner scanner = new Scanner(System.in);
		String clientTyped = scanner.nextLine();
		os.write(clientTyped.getBytes());
		os.flush();
		
	}
	
}
