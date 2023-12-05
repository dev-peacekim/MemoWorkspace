package edu.java.thread;

public class ThreadExer1 {

	public static void main(String[] args) {
		
		/*
		Thread oddPrinter1 = new Thread(new OddPrinter1());
		oddPrinter1.start();
		*/
		
		/*
		new OddPrinter2().start();
		*/
		
		Thread thread = new Thread() {
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
		};
		
		thread.start();
		thread.setName("호출스레드");
		System.out.println(thread.getName());
		
		for(int i=2; i<102; i=i+2) {
			System.out.println("main thread : " + i);
			try {
			Thread.sleep(200);
			} catch(InterruptedException ie) {
				ie.printStackTrace();
			}
			
		}
		
	} // main
	
} // class
