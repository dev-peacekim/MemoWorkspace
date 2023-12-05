package command;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CommandMain {

	public static void main(String[] args) {
		
		Command command = null;
		
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		
		String op1="", op2="", opr="";
		
		StringTokenizer st = new StringTokenizer(str, " "); 
		if(st.hasMoreElements()) op1 = st.nextToken();
		if(st.hasMoreElements()) op2 = st.nextToken();	
		if(st.hasMoreElements()) opr = st.nextToken();
		
		// properties는 키, 값이 모두 String인 맵
		Properties prop = new Properties();
		try {
			prop.load(new FileReader("D:\\eclipse_workspace\\DesignPattern\\src\\command\\command.properties"));
			Class cl = Class.forName(prop.getProperty(opr));
			Command obj = (Command)cl.newInstance();
			float result = obj.calc(Integer.parseInt(op1), Integer.parseInt(op2));
			System.out.println("결과 : " + result);
			
		} catch (IllegalAccessException ae) {
			ae.printStackTrace();
		} catch (InstantiationException ie) {
			ie.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
