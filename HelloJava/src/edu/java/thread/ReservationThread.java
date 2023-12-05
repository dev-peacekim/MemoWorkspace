package edu.java.thread;

import java.util.List;

public class ReservationThread extends Thread {

	private Cinema cinema;
	private List<CinemaPerson> cinemaPersonList;
	
	public ReservationThread(Cinema cinema, List<CinemaPerson> cinemaPersonList) {
		super();
		this.cinema = cinema;
		this.cinemaPersonList = cinemaPersonList;
	}

	@Override
	public void run() {
		
		List<Room> roomList =cinema.getRoomList();
		int seatNum = 0;
		for(int i=0; i<roomList.size(); i++) {
			seatNum += roomList.get(i).getSeatList().size()*roomList.size();
		}
		
		for(int j=0; j<roomList.size(); j++) {
			
			for(int i=0; i<seatNum; i++) {
				int randomNum = (int)(Math.random()*cinemaPersonList.size())+1;  //1~200 중 하나의 정수
				Room room = roomList.get(j);
				Seat seat = room.getSeatList().get(i);
				cinemaPersonList.get(randomNum).setReservationSeat(seat);
				seat.setReservation(true);
			}
			
		}
		
		System.out.println("[영화관 예매 현황]\n"+"");
		
	}
	
}
