package board.bean; // 게시물의 데이터를 정의하는 패키지

public class Board {

	private int bid;			// 번호
	private String title;  	// 제목
	private String content; // 내용
	
	public Board() {
		
	}

	public Board(int bid, String title, String content) {
		this.bid = bid;
		this.title = title;
		this.content = content;
	}
	
	public int getBid() {
		return bid;
	}
	
	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Board [bid=" + bid + ", title=" + title + ", content=" + content + "]";
	}
	
}
