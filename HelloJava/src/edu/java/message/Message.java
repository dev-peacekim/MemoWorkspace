package edu.java.message;

import java.io.Serializable;
import java.util.Date;

// DTO 데이터 전송에 쓰이는 데이터 유형의 기본 형식

public class Message implements Serializable {
	
	public static final long serialVersionUID = 3258789564564L; // 다른 곳에 있는 메시지와 충돌을 방지하기 위한 ID
	
	private String subject; 		// 제목
	private String content;		// 내용
	private Date writeDate; 	// 작성 일시
	
	public Message() {
		
	}
	
	public Message(String subject, String content, Date writeDate) {
		super();
		this.subject = subject;
		this.content = content;
		this.writeDate = writeDate;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "Message [subject=" + subject + ", content=" + content + ", writeDate=" + writeDate + "]";
	}
	
}
