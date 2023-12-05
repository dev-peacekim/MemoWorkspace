package adapter;

public class printAdapter2 implements Print {

	StringPrinter stringPrinter;
	
	@Override
	public void print() {
		stringPrinter = new StringPrinter();
		System.out.println("[홍길동의 정보]");
		stringPrinter.printInfo();
	}
	
	
}
