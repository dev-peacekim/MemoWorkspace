package memoWorkspace;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class ServerLogic {

	BufferedReader br = null;
	BufferedWriter bw = null;
	File userDBdir = new File("C:/db/");
	File userDB = new File("C:/db/userDB.txt");
	FileReader userDBreader = null;
	BufferedReader userDBBr = null;
	FileWriter dbFw = null;
	
	public ServerLogic(BufferedReader br, BufferedWriter bw) {
		
		this.br = br;
		this.bw = bw;
		
	}
	
	
	// 유저 DB 경로 및 파일 생성 (초기 세팅용)
	void setUserDB() {
		
		// DB 경로 생성
		if(!userDBdir.exists()) {
			try {
				userDBdir.mkdir();
			} catch(SecurityException se) {
				se.printStackTrace();
			}
		}
		
		// DB 파일 생성
		if (!userDB.exists()) {
			try {
				userDB.createNewFile();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	} // 유저 DB 경로 및 파일 생성 (초기 세팅용) 끝
	
	
	// 유저 리스트에 유저 객체 저장 기능 (로그인 시 활용)
	UserList storeUserList() {
		
		setUserDB();
		
		UserList userList=null;
		try {
			userDBreader = new FileReader(userDB);
			userDBBr = new BufferedReader(userDBreader);
			userList = new UserList();
			String user;
			while((user = userDBBr.readLine()) != null) {
				// 유저 이름 저장
				int startIndex = user.indexOf("name : ") + 7;
				int endIndex = user.indexOf(",", startIndex);
				String userName = user.substring(startIndex, endIndex);
				
				// 유저 ID 저장
				startIndex = user.indexOf("ID : ") + 5;
				endIndex = user.indexOf(",", startIndex);
				String userID = user.substring(startIndex, endIndex);
				
				// 유저 pw 저장
				startIndex = user.indexOf("PW : ") + 5;
				endIndex = user.indexOf(",", startIndex);
				String userPW = user.substring(startIndex, endIndex);
				
				// 유저 부서 저장
				startIndex = user.indexOf("department : ") + 13;
				endIndex = user.indexOf(",", startIndex);
				String userDepartment = user.substring(startIndex, endIndex);
				userList.getUserList().add(new User(userName, userID, userPW, userDepartment));
			}
		} catch (FileNotFoundException ffe) {
			ffe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		return userList;
			
	}
	
	// 유저 리스트에 유저 객체 저장 기능 (로그인 시 활용) 끝
	
	
	// 부서 리스트 세팅 (has memoList)
		DepartmentList storeDepartmentList() {
			
			DepartmentList departmentList = new DepartmentList();
			
			// 부서 추가하고 싶으면 여기다 추가, 파일로 빼도 되긴함
			String[] dirs = new String[] {"마케팅팀", "영업팀", "생산팀", "IT팀", "재정팀", "인사팀"};
			for(String departmentName : dirs) {
				File directory = new File("C:/memopad/"+departmentName+"/");
				if(!directory.exists()) directory.mkdirs();
				departmentList.getDepartmentList().add(new Department(departmentName, storeMemoList(departmentName)));
			}
			
			return departmentList;
			
		} // 부서 리스트 세팅 끝
		
		
		// 메모 리스트 세팅
		MemoList storeMemoList(String department) {
			
			MemoList memoList = new MemoList();
			
			File filesPath = new File("C:/memopad/"+department);
			File[] files = filesPath.listFiles();
			BufferedReader filebr = null;
			
			for(File file : files) {
				try {
					filebr = new BufferedReader(new FileReader(file));
					String readText;
					String text = "";
					while((readText = filebr.readLine())!=null) {
						text += readText+"\n";
					}
					memoList.getMemoList().add(new Memo(file.getName(),text, file));
				} catch (FileNotFoundException ffe) {
					ffe.printStackTrace();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				} finally {
					try {
						filebr.close();
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
				}
			}
			return memoList;
			
		} // 메모 리스트 세팅 끝	
	
	
	// 초기 화면 문구 전달
	void welcomMessage() {
		try {
			bw.write("=====================================\n"
					+ "==========[Memo Workspace]===========\n"
					+ "=====================================\n\n"
					+ "원하시는 작업을 선택해주세요 : Sign in/Sign up\n\n");
			bw.flush();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	} // 초기 화면 문구 끝
	
	
	// 회원 가입 기능
	void signIn(DepartmentList departmentList) {
		
		try {
			// ID 입력 문구 출력 및 저장
			bw.write("ID를 입력하세요 : \n");
			bw.flush();
			String id = br.readLine();
			System.out.println(id);
			
			// 유저 DB 확인 및 중복 확인
			userDBreader = new FileReader(userDB);
			userDBBr = new BufferedReader(userDBreader);
			
			String user;
			while((user = userDBBr.readLine()) != null) {
				int startIndex = user.indexOf("ID : ") + 5;
				int endIndex = user.indexOf(",", startIndex);
				String userID = user.substring(startIndex, endIndex);
				if(userID.contains(id)) {
					bw.write("중복된 ID가 존재합니다. 다시 입력하세요\n");
					bw.flush();
					userDBreader.close();
					userDBBr.close();
					userDBreader = new FileReader(userDB); // 처음 부터 다시 읽어 들이는 용도
					userDBBr = new BufferedReader(userDBreader); // 처음 부터 다시 읽어 들이는 용도
					id=br.readLine();
					continue;
				}
			}
			
			// 여기서 닫아 주어야 filewriter로 쓸 수 있음
			try {
				userDBBr.close();
				userDBreader.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			
			// PW 입력 문구 출력 및 저장
			bw.write("PW를 입력하세요 : \n");
			bw.flush();
			String pw = br.readLine();
			System.out.println(pw);
			
			// 이름 입력 문구 출력 및 저장
			bw.write("이름을 입력하세요 : \n");
			bw.flush();
			String name = br.readLine();
			System.out.println(name);
			
			// 부서 입력 문구 출력 및 저장
			Iterator<Department> it = departmentList.getDepartmentList().iterator();
			String departments = "";
			while(it.hasNext()) {
				departments += it.next().getDepartmentName() + ", " ;
			}
			
			boolean isSuccess = true;
			while(isSuccess) {
				bw.write("부서를 입력하세요 : (가능한 부서 명 = " + departments + ")\n");
				bw.flush();
				String department = br.readLine();
				System.out.println(department);
				
				if(departments.contains(department)) {
					dbFw = new FileWriter("C:/db/userDB.txt", true); // true로 설정해야 뒤에 붙음
					dbFw.write("name : " + name + ", " + "ID : " + id + ", " + "PW : "+pw + ", " + "department : "+department + ", " + "\n");
					bw.write("회원 가입이 완료되었습니다\n\n");
					bw.flush();
					break;
				} else {
					bw.write("부서명이 적절하지 않습니다.\n\n");
					bw.flush();
					continue;
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				dbFw.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	} // 회원 가입 기능 끝
	
	
	// 로그인 기능
	String signUp() {
		
		String id=null;
		User user=null;
		boolean isSuccess = true;
		while(isSuccess) {
			try {
				UserList userList = storeUserList();
				Iterator<User> userIt = userList.getUserList().iterator();
				// ID 입력 문구 출력 및 저장
				bw.write("ID를 입력하세요 : \n");
				bw.flush();
				id = br.readLine();
				System.out.println(id);
				
				// PW 입력 문구 출력
				bw.write("PW를 입력하세요 : \n");
				bw.flush();
				String pw = br.readLine();
				System.out.println(pw);
				
				while(userIt.hasNext()) {
					
					user = userIt.next();
					System.out.println(user.getId());
					if(user.getId().equals(id)&user.getPassword().equals(pw)) {
						bw.write("로그인에 성공하였습니다.\n\n");
						bw.flush();
						bw.write("메모패드 기능을 선택해주세요 (L/R/W/D/Q) : \n");
						bw.flush();
						isSuccess = false;
						break;
					} else {
						continue;
					}
				}
				if(isSuccess==false) {
					break;
				} else {
					bw.write("아이디와 비밀 번호가 일치하는 계정이 없습니다. 다시 확인 해주세요.\n로그인을 원하시면 Sign up을 입력해주세요.\n");
					bw.flush();
					continue;
				}
			
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		return user.getDepartment();
		
	} // 로그인 기능 끝
	
	
	// 파일 리스트 기능 (L)
	void readList(String department) {
		
		MemoList memoList = storeMemoList(department);
		
		int i =1;
		try {
			for(Memo memo : memoList.getMemoList()) {
				bw.write(i+") "+memo.getTitle()+"\n");
				bw.flush();
				i++;
			}
			bw.write("\n");
			bw.flush();
			bw.write("메모패드 기능을 선택해주세요 (L/R/W/D/Q) : \n");
			bw.flush();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} 
		
	} // 파일 리스트 기능 (L) 끝
	
	
	// 파일 읽기 기능 (R)
	void readMemo(String department) {
		
		MemoList memoList = storeMemoList(department);
		
		try {
			bw.write("원하는 문서의 번호를 입력하세요 (예 : 1)\n\n");
			bw.flush();
			
			int i =1;
			for(Memo memo : memoList.getMemoList()) {
				bw.write(i+") "+memo.getTitle()+"\n");
				bw.flush();
				i++;
			}
			bw.write("\n");
			bw.flush();
			
			int num = Integer.parseInt(br.readLine())-1;
			
			bw.write(memoList.getMemoList().get(num).getText()+"\n");
			bw.flush();
			
			bw.write("\n");
			bw.flush();
			bw.write("메모패드 기능을 선택해주세요 (L/R/W/D/Q) : \n");
			bw.flush();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	} // 파일 읽기 기능 (R) 끝
	
	
	// 파일 쓰기 기능 (W)
	void writeMemo(String department) {
		
		FileWriter fw = null;
		
		try {
			bw.write("제목을 입력하세요 : \n");
			bw.flush();
			String title = br.readLine();
			
			bw.write("내용을 입력하세요 : \n");
			bw.flush();
			String text = br.readLine();
			
			synchronized (new File("C:/memopad/"+department+"/"+title+".txt")) {
				Memo memo = new Memo(title, text, new File("C:/memopad/"+department+"/"+title+".txt"));
				
				// 파일 생성
				if (!memo.getFile().exists()) {
					try {
						memo.getFile().createNewFile();
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
				}
				
				fw = new FileWriter(memo.getFile());
				fw.write("제목 : "+title+"\n"+"내용 : "+text);
			}
			
			bw.write("작성이 완료되었습니다.\n\n");
			bw.flush();
			
			bw.write("메모패드 기능을 선택해주세요 (L/R/W/D/Q) : \n");
			bw.flush();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	} // 파일 쓰기 기능 (W) 끝
	
	
	// 파일 지우기 기능 (D)
	void deleteMemo(String department) {
		
		MemoList memoList = storeMemoList(department);
		
		try {
			bw.write("삭제를 원하는 문서의 번호를 입력하세요 (예 : 1)\n\n");
			bw.flush();
			
			int i =1;
			for(Memo memo : memoList.getMemoList()) {
				bw.write(i+") "+memo.getTitle()+"\n");
				bw.flush();
				i++;
			}
			bw.write("\n");
			bw.flush();
			
			int num = Integer.parseInt(br.readLine())-1;
			
			synchronized (memoList.getMemoList().get(num).getFile()) {
				memoList.getMemoList().get(num).getFile().delete();
			}
			
			bw.write("삭제가 완료되었습니다 \n\n");
			bw.flush();
			bw.write("메모패드 기능을 선택해주세요 (L/R/W/D/Q) : \n");
			bw.flush();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
	
} // class
