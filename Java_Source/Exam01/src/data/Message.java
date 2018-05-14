package data;

public class Message {
	// 출력 메세지 문자열 저장 클래스
	public static final String file = "src/account";

	public static final String mainManu = "1. 입금\t\t3. 이체\n2. 출금\t\t4. 조회";
	public static final String adminManu = "1. 계좌 등록\t4. 돌아가기\n2. 계좌 삭제\t5. 프로그램 종료\n3. 전체 계좌 조회";
	
	public static final String accountcheck = "계좌번호를 입력해 주세요. ";
	public static final String account_fault = "계좌 정보가 올바르지 않습니다.";
	public static final String passcheck = "비밀번호를 입력해 주세요. ";
	
	public static final String deposit = "입금하실 금액을 입력해 주세요. ";
	public static final String withdraw = "출금하실 금액을 입력해 주세요. ";
	public static final String transfer_account = "받으시는 분의 계좌를 입력해 주세요. ";
	public static final String transfer_balance = "이체하실 금액을 입력해 주세요. ";
	public static final String balance_fault = "잔액이 부족합니다.";
	public static final String complete = "님의 현재 잔액 : ";
	
	public static final String insert = "등록하실 계좌를 '계좌번호 비밀번호 이릅' 순서로 입력해주세요.";
	public static final String overlap = "이미 존재하는 계좌번호입니다.";
	
	public static final String error = "잘못된 입력입니다.";
	public static final String exit = "프로그램 종료";

	

}
