package Lotto;


public class LottoMain {

	public static void main(String[] args) {
		
		// 1. 중복되지 않은 7개의 로또볼을 추출
		// 2. 사용자에게 중복되지 않은 6개의 1~45 번호 입력 받아야 함 (main 구현)
		// 3. 연산 결과를 출력 (main 구현)
		
		Lottery a = new Lottery();
		a.shuffle();
		System.out.println(a.lottoBalls[1]);
		System.out.println(a.lottoBalls[30]);
		System.out.println(a.lottoBalls[31]);
		System.out.println(a.lottoBalls[33]);
		System.out.println(a.lottoBalls[34]);
		System.out.println(a.lottoBalls[4].ballNumber);
	}
	
}
