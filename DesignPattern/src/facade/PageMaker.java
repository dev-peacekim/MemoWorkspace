package facade;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PageMaker {

	public static void makeWelcomePage(String mailaddr, String filename) {
		try {
			Properties mailprop = Database.getProperties("maildata");
			String username = mailprop.getProperty(mailaddr);
			HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
			writer.title(username + "'s web page");
			writer.paragraph("Welcome to" + username + "'s web page!");
			writer.paragraph("Welcome to" + username + "'s web page!");
			writer.paragraph("Welcome to" + username + "'s web page!");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
}
