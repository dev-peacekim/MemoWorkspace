package edu.java.thread;

public class OddPrinter1 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i =1; i<100; i=i+2) {
			System.out.println("OddPrinter1 thread : "+ i);
			
			try {
				Thread.sleep(800);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			
		}
		
		
	}

}
