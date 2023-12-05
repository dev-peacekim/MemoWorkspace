package edu.java;

// 로또 로직
public class LottoLogic {
	
	LottoBall[] comNums; //7개
	LottoBall[] userNums; //6개
	
	LottoLogic() {
		
	}
	
	LottoLogic(LottoBall[] comNums, LottoBall[] userNums) {
		
		this.comNums = comNums;
		this.userNums = userNums;
		
	}
	
	// 순위를 연산해서 return 해주는 메소드
	int getRank() {
		//순위를 연산
		return 0;
	}
	
}
