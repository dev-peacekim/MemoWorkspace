package edu.java.net;

public class Quiz {
	
	private int seq;
	private String content;
	private String answer;
	
	public Quiz(int seq, String content, String answer) {
		super();
		this.seq = seq;
		this.content = content;
		this.answer = answer;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
