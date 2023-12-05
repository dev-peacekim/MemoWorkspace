package edu.java.thread;


// 1~30의 정수 중 짝수만 출력하는 스레드
public class EvenThread extends Thread{

	// 공유객체를 쓰레드가 가지도록 (has a)
	private SharedObject sharedObject;
		
	public SharedObject getSharedObject() {
		return sharedObject;
	}

	
	public void setSharedObject(SharedObject sharedObject) {
		this.sharedObject = sharedObject;
	}


	@Override
	public void run() {
		while(true) {
			// 짝수일 때만 실행
			if(sharedObject.isEvened()) {
				try {
					// 동기화 블럭 : 공유 객체에 대해서 락을 획득(EvenThread가 SharedObject를 독점)
					synchronized (sharedObject) {
						System.out.println("EvenThread : "+sharedObject.getSharedNum());
						sharedObject.setSharedNum(sharedObject.getSharedNum()+1);
						// 홀수 출력할 차례
						sharedObject.setEvened(false);
						// 30이면 종료하기 위해서 InterruptedExeption을 강제 발생시킴
						if(sharedObject.getSharedNum()==30) interrupt();
					}
					Thread.sleep(500);
				} catch (InterruptedException ie) {
					System.out.println("EvenThread 종료!");
					break;
				}
			}
		}
	}
	
}
