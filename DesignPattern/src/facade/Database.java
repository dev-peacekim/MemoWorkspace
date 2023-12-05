package facade;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Database {

	private Database() {
		
	}
	
	public static Properties getProperties(String dbname) {
		String filename = dbname + ".txt";
		Properties prop = new Properties();
		try {
			prop.load(new FileReader(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
	
}
