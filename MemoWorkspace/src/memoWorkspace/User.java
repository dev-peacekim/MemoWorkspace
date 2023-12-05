package memoWorkspace;

public class User {

	private String name;
	private String id;
	private String password;
	private String department;
	private int securityLevel;
	private boolean isSuperviser;
	
	public User() {
		
	}
	
	public User(String name, String id, String password, String department) {
		super();
		this.name = name;
		this.id = id;
		this.password = password;
		this.department = department;
	}

	public User(String name, String id, String password, String department, int securityLevel, boolean isSuperviser) {
		super();
		this.name = name;
		this.id = id;
		this.password = password;
		this.department = department;
		this.securityLevel = securityLevel;
		this.isSuperviser = isSuperviser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSecurityLevel() {
		return securityLevel;
	}

	public void setSecurityLevel(int securityLevel) {
		this.securityLevel = securityLevel;
	}

	public boolean isSuperviser() {
		return isSuperviser;
	}

	public void setSuperviser(boolean isSuperviser) {
		this.isSuperviser = isSuperviser;
	}
	
	
}
