package board.dao; // AC에서 작성한 것중에 구현하고 싶은 메소드만 구현 (Data Access Object - 데이터에 접근해서 직접 작업을 하는)

import java.util.ArrayList;
import java.util.List;

import board.aggregate.BidAggregate;
import board.bean.Board;
import board.iterator.Iterator;
import board.service.AbstractBoard;

public class BoardDao extends AbstractBoard {

	private List<Board> boardList;
	
	// 싱글톤 - 로직은 하나만 있어도 되니까
	
	private static BoardDao boardDao = new BoardDao();
	
	private BoardDao() {
		boardList = new ArrayList<Board>();
		Iterator it = (Iterator)new BidAggregate().iterator();
		while(it.hasNext()) {
			int itNext = (Integer)it.next();
			registBoard(new Board(itNext, "제목" + itNext, "내용" + itNext));
		}
	}
	
	public static BoardDao getInstance() {
		return boardDao;
	}
	
	@Override
	public List<Board> getBoardList() {
		return boardList;
	}
	
	@Override
	public void registBoard(Board board) {
		boardList.add(board);
	}
	
	@Override
	public void deleteBoard(int bid) {
		for(Board board : boardList) {
			if(board.getBid()==bid) {
				boardList.remove(board);
			}
		}
	}
	
	@Override
	public void updateBoard(Board board) {
		for(Board brd : boardList) {
			if(brd.getBid()==board.getBid()) {
				brd.setTitle(board.getTitle());
				brd.setContent(board.getContent());
			}
		}
	}
	
}
