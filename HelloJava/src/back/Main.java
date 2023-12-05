package back;

import java.util.Scanner;

import javax.swing.text.html.HTMLEditorKit.Parser;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String num = scanner.nextLine();
		int n=Integer.parseInt(num);
		
		if(n>=1&&n<=9) {		
			for(int i=1; i<=9; i++) {
				System.out.println( n+ " * " + i +" = "+  n*i);
			} 
		}
	}
	
}
