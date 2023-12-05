package proxy;

import java.util.Scanner;

public class ProxyMain {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		Inum inum = new InumberProxy();
		
		inum.printNum(num);
		
	}
	
}
