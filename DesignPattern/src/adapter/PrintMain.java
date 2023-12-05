package adapter;

public class PrintMain {

	public static void main(String[] args) {
		
		Print print = new printAdapter();
		Print print2 = new printAdapter2();
		print.print();
		print2.print();
		
	}
	
}
