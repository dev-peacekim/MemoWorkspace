package memoWorkspace;

import java.io.File;

public class Memo {
	
	private String title;
	private String text;
	private String securityLevel;
	private File file;
	
	public Memo() {
		
	}

	public Memo(String title, String text, File file) {
		this.title = title;
		this.text = text;
		this.file = file;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSecurityLevel() {
		return securityLevel;
	}

	public void setSecurityLevel(String securityLevel) {
		this.securityLevel = securityLevel;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	
	
}
