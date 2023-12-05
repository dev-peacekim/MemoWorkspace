package memoWorkspace;

import java.util.ArrayList;
import java.util.List;

public class UserList {

	private List<User> userList;
	
	public UserList() {
		 this.userList= new ArrayList<User>();
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
}
