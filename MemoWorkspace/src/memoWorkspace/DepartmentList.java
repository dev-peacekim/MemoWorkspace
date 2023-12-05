package memoWorkspace;

import java.util.ArrayList;
import java.util.List;

public class DepartmentList {

	List<Department> departmentList;
	
	public DepartmentList() {
		this.departmentList = new ArrayList<Department>();
	}

	public List<Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}
	
}
