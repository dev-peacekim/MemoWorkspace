package Lotto;

//로또 기계
public class Lottery {
	
	LottoBall[] lottoBalls;
	
	Lottery() {
		lottoBalls = new LottoBall[45];
	}
	
	Lottery(LottoBall[] lottoBalls) {
		this.lottoBalls = lottoBalls;
	}
	
	// 로또볼을 섞는 메소드
	void shuffle() {
		// 로직구현
		for(int i=0; i<45; i++) {
			lottoBalls[i] = new LottoBall(i);
		}
	}
	
	// 로또볼을 하나씩 추출하는 메소드
	LottoBall getLottoBall() {
		// 로직구현
		
		return null;
	}
	
	// 로또볼의 중복여부 체크 : 중복 true, 미중복 false
	boolean isDuplicate(LottoBall lottoBall) {
		//로직구현
		return false;
	}
	
}
