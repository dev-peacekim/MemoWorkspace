package memoWorkspace;

public class Department {

	private String departmentName;
	private MemoList memoList;
	
	public Department() {
		
	}

	public Department(String departmentName, MemoList memoList) {
		
		this.departmentName = departmentName;
		this.memoList = memoList;
		
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public MemoList getMemoList() {
		return memoList;
	}

	public void setMemoList(MemoList memoList) {
		this.memoList = memoList;
	}

	
}
