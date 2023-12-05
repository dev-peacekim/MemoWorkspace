package board.service;  // Facade

import java.util.List;

import board.bean.Board;

// Board 서비스 facade - 서비스에 접근하기 위한 진입로, 이것만 알면 됨
public interface BoardService {

	// 목록 불러오기
	public abstract List<Board> getBoardList();
	
	// 게시물 등록
	public abstract void registBoard(Board board);
	
	// 게시물 삭제
	public abstract void deleteBoard(int bid);
	
	// 게시물 업데이트
	public abstract void updateBoard(Board board);
	
}
