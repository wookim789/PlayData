package main;

import java.io.IOException;
import data.Message;

public class Process {

	private AccountManage account;
	private boolean mode;
	// 관리자 모드 판별 변수
	
	public Process() {
		account = new AccountManage();
		this.mode = false;
	}
	
	public boolean run() {
		
		String menuSelet = null;
		
		if (!mode) { // 일반 사용자 모드
			System.out.println(Message.mainManu);
			// 메인 메뉴 출력
			try {
				menuSelet = File_IO.keyRead();
				// 키보드 입력 함수를 사용하여 menuSelet에 입력 데이터를 대입
			} catch (IOException e) {
				// IOException 발생시 에러메세지 출력 후 처음으로 돌아간다.
				System.out.println(Message.error);
				return true;
			}

			switch (menuSelet.toLowerCase()) { // 대소문자로 인한 예외를 방지하기 위해 toLowerCase 사용
				case "1":
					account.deposit();
					break;
				case "2":
					account.withdraw();
					break;
				case "3":
					account.transfer();
					break;
				case "4":
					account.lookup();
					break;
				case "admin":
					// admin 명령어 입력시 관리자 모드 실행
					admin(true);
					break;
				default:
					System.out.println(Message.error);
					break;
			}
			
		} else { // 관리자 모드
			System.out.println(Message.adminManu);
			// 관리자 메뉴 출력
			try {
				menuSelet = File_IO.keyRead();
				// 키보드 입력 함수를 사용하여 menuSelet에 입력 데이터를 대입
			} catch (IOException e) {
				// IOException 발생시 에러메세지 출력 후 처음으로 돌아간다.
				System.out.println(Message.error);
				return true;
			}

			switch (menuSelet.toLowerCase()) {
				case "1":
					account.insert();
					break;
				case "2":
					account.delete();
					break;
				case "3":
					account.readAll();
					break;
				case "4":
					// 관리자 모드 해제
					admin(false);
					break;
				case "5":
					// 프로그램 종료
					System.out.println(Message.exit);
					return false;
				default:
					System.out.println(Message.error);
					break;
			}
		}
	
		return true;
	}


	private void admin(boolean mode) {
		this.mode = mode;
	}
}
