package edu.java.thread;

import java.util.ArrayList;
import java.util.List;

public class ReservationMain {

	public static final int ROOM_COUNT = 5;
	public static final int SEAT_COUNT_PER_ROOM = 25;
	public static final int CINEMAPERSON_COUNT = 200;
	
	public static void main(String[] args) {
		
		// 1. 시트 생성
		List<Seat> seatList = new ArrayList<Seat>();
		for(int i =0; i<=ROOM_COUNT*SEAT_COUNT_PER_ROOM; i++) {
			seatList.add(new Seat(String.valueOf(i+1), false));
		}
		
		
		// 2. 룸 생성
		List<Room> roomList = new ArrayList<Room>();
		for(int i=0; i<ROOM_COUNT; i++) {
			roomList.add(new Room((i+1)+"관",seatList.subList(i*SEAT_COUNT_PER_ROOM, (i+1)*(SEAT_COUNT_PER_ROOM))));
		}

 		
		// 3. 영화관 생성
		Cinema cinema = new Cinema(roomList);
		
		
		// 4. 사람 생성
				List<CinemaPerson> cinemaPersonList = new ArrayList<CinemaPerson>();
				
				for(int i = 0; i<CINEMAPERSON_COUNT; i++) {
					cinemaPersonList.add(new CinemaPerson("CP"+(i+1), null));
				}
		
		// 5. 예메 로직
		Thread reservationThread = new ReservationThread(cinema, cinemaPersonList);
		reservationThread.start();
		
		
		// 6. 출력
		
		
	}
	
}
