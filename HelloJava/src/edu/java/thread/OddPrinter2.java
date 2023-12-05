package edu.java.thread;

public class OddPrinter2 extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i =1; i<100; i=i+2) {
			System.out.println("OddPrinter2 thread : "+ i);
			
			try {
				Thread.sleep(800);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			
		}
		
		
	}
	
}
