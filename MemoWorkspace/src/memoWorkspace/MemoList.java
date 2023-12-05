package memoWorkspace;

import java.util.ArrayList;
import java.util.List;

public class MemoList {

	private List<Memo> memoList;
	
	public MemoList() {
		this.memoList = new ArrayList<Memo>();
	}

	public List<Memo> getMemoList() {
		return memoList;
	}

	public void setMemoList(List<Memo> memoList) {
		this.memoList = memoList;
	}
	
}
