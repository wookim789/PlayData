package main;

public class AutomatedTeller {

	public static void main(String[] args) {
		// 메인 메서드
		
		Process process = new Process();
		// ATM 메뉴와 계좌관리를 담당하는  Process 객체 생성
		
		while (process.run());
		// Process객체 내부에서 false를 반환할 때까지 반복시킨다.
		
	}
}
