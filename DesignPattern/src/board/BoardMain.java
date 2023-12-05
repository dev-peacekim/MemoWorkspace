package board; // 클라이언트, Board 서비스를 쓸거니까

import board.dao.BoardDao;
import board.service.BoardService;
import board.templateMethod.AbstractClass;

public class BoardMain extends AbstractClass {

	static BoardService boardService = BoardDao.getInstance(); // 실제 구현체를 저장시켜야
	
	public static void main(String[] args) {
		/*
		boardService.registBoard(new Board(1, "제목1", "내용1"));
		boardService.registBoard(new Board(2, "제목2", "내용2"));
		boardService.registBoard(new Board(3, "제목3", "내용3"));
				
		printList();
		
		boardService.deleteBoard(2);
		
		printList();
		
		Board board4 = new Board(4, "제목4", "내용4"); // 익명 객체 만드는게 제일 효율이 좋을 듯
		boardService.registBoard(board4);
		
		printList();
		
		board4.setTitle("제목이지롱");
		board4.setContent("내용이지롱");
		boardService.updateBoard(board4);
		*/
//		printList();
		AbstractClass main = new BoardMain();
		main.display();
		
	}
	
	/*
	// 리스트 안에 있는 각각의 bl에 대해서 아래 식을 수행한다. 람다식. bl은 치환변수라 아무거나 넣어주면 됨
	public static void printList() {
		boardService.getBoardList().forEach(bl -> { 
			System.out.println("제목 :" + bl.getTitle());
			System.out.println("내용 :" + bl.getContent());
		});
	}
	*/
	
	@Override
	public void printTop() {
		System.out.println("### 리스트 출력 시작 ###");
	}
	
	
	@Override
	public void printMiddle() {
		boardService.getBoardList().forEach(bl -> { 
			System.out.println("제목 :" + bl.getTitle());
			System.out.println("내용 :" + bl.getContent());
		});
	}

	@Override
	public void printBottom() {
		System.out.println("### 리스트 출력 끝 ###");
	}
	
	@Override
	public void display() {
		printTop();
		printMiddle();
		printBottom();
	}
	
		
}
