package memopad;

import java.io.File;
import java.util.Date;

class Memo {

	String title;
	Date date;
	String text;
	File file;
	
	Memo(String title, String text) {
		this.title = title;
		this.text = text;
		this.date = new Date();
	}
	
}
