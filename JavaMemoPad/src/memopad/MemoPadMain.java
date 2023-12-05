package memopad;

import java.io.IOException;

public class MemoPadMain {
	
	public static void main(String[] args) {
		
		boolean boo = true;
		MemoPadLogic memoPadLogic = new MemoPadLogic();
		while(boo) {
			
			String function = memoPadLogic.sysoutFunctionList();
			char function2 = function.charAt(0);
			switch(function2) {
			
				case 'L' :
					memoPadLogic.readList();
					break;
					
				case 'R' :
					String nums = function.substring(2);
					memoPadLogic.readNote(nums);
					break;
			
				case 'W' :
					memoPadLogic.writeNote();
					break;
				
				case 'D' :
					String nums2 = function.substring(2);
					memoPadLogic.deleteNote(nums2);
					break;
					
				case 'Q' :
					System.out.println("메모패드가 종료되었습니다");
					boo = false;
					break;
			}
			
		}
		
	}
	
}
