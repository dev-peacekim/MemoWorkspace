package edu.java.thread;

public class Seat {
	
	private String seatNum;
	private boolean isReservation;
	
	public Seat() {
		
	}

	public Seat(String seatNum, boolean isReservation) {
		super();
		this.seatNum = seatNum;
		this.isReservation = isReservation;
	}

	public String getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}

	public boolean isReservation() {
		return isReservation;
	}

	public void setReservation(boolean isReservation) {
		this.isReservation = isReservation;
	}

	@Override
	public String toString() {
		return "Seat [seatNum=" + seatNum + ", isReservation=" + isReservation + "]";
	}
	
	
	
}
