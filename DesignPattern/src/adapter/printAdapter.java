package adapter;

public class printAdapter extends StringPrinter implements Print {

	
	@Override
	public void print() {
		System.out.println("[홍길동의 정보]");
		printInfo();
	}
	
	
}
