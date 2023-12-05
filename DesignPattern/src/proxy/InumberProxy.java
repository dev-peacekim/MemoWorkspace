package proxy;

public class InumberProxy implements Inum {

	private Inumber real;

	@Override
	public void printNum(int num) {
		if(num>=1&num<=5) {
			System.out.println(num);
		} else if(num>=6&num<=10)  {
			realize().printNum(num);
		}
	}
	
	private Inumber realize() {
		if(real==null) {
			real = new Inumber();
		}
		return real;
	}

}
