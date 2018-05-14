package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import data.*;

public class AccountManage {
	// 계좌 관리 클래스
	
	private ArrayList<Credit> account;
	// 계좌 정보 리스트
	private int num;
	// 입력 데이터 저장 버퍼
	
	@SuppressWarnings("unchecked")
	public AccountManage() {

		this.num = 0;
		
		try {
			this.account = (ArrayList<Credit>) File_IO.read(Message.file);
			// 계좌 리스트를 지정된 파일에서 읽어옴
		} catch (ClassNotFoundException | IOException e) {
			this.account = new ArrayList<Credit>();
			// 파일이 없거나 읽기 실패한 경우 새로운 객체를 생성
		}
	}

	public void deposit() {
		// 입금 메서드
		
		Credit credit = this.check();
		
		if (credit != null) {
			// 계좌 정보를 성공적으로 받아왔을 경우에만 입금
			try {
				System.out.print(Message.deposit);
				// 입금 금액 입력 메세지 출력
				num = Integer.parseInt(File_IO.keyRead());
				// 키보드 입력 함수를 사용하여 num에 금액을 대입
				credit.setBalance(credit.getBalance() + num);
				// 입금 완료 후 잔액을 보여준다.
				System.out.println(credit.getName() + Message.complete + credit.getBalance());
				// 갱신된 정보를 저장한다.
				File_IO.save(Message.file, this.account);
			} catch (IOException e) {
				// IOException 발생시 에러메세지 출력 후 처음으로 돌아간다.
				System.out.println(Message.error);
			}
		}
	}
	
	
	public void withdraw() {
		// 출금 메서드

		Credit credit = this.check();
		
		if (credit != null) {
			// 계좌 정보를 성공적으로 받아왔을 경우에만 출금
			try {
				System.out.print(Message.withdraw);
				// 출금 금액 입력 메세지 출력
				num = Integer.parseInt(File_IO.keyRead());
				// 키보드 입력 함수를 사용하여 num에 금액을 대입
				if (credit.getBalance() < num) {
					// 출금하려는 금액이 계좌의 잔액보다 적을 경우 출금 불가능
					System.out.println(Message.balance_fault);
					return;
				}
				credit.setBalance(credit.getBalance() - num);
				// 출금 완료 후 잔액을 보여준다.
				System.out.println(credit.getName() + Message.complete + credit.getBalance());
				// 갱신된 정보를 저장한다.
				File_IO.save(Message.file, this.account);
			} catch (IOException e) {
				// IOException 발생시 에러메세지 출력 후 처음으로 돌아간다.
				System.out.println(Message.error);
			}
		}
	}


	public void transfer() {
		// 이체, 송금 메서드

		Credit credit = this.check();
		
		if (credit != null) {
			// 계좌 정보를 성공적으로 받아왔을 경우에만 이체
			try {
				System.out.print(Message.transfer_account);
				// 계좌번호 입력 메세지 출력
				num = Integer.parseInt(File_IO.keyRead());
				// 키보드 입력 함수를 사용하여 num에 계좌번호를 대입
				for (Credit destination: this.account) {
					// 리스트에서 일치하는 계좌번호를 탐색
					if (destination.getAccount() == num) {
						// 동일한 계좌번호를 가진 정보가 리스트에 있을 경우
						System.out.print(Message.transfer_balance);
						// 이체 금액 입력 메세지 출력
						num = Integer.parseInt(File_IO.keyRead());
						// 키보드 입력 함수를 사용하여 num에 금액을 대입
						if (credit.getBalance() < num) {
							// 이체하려는 금액이 계좌의 잔액보다 적을 경우 출금 불가능
							System.out.println(Message.balance_fault);
							return;
						}
						credit.setBalance(credit.getBalance() - num);
						destination.setBalance(destination.getBalance() + num);
						// 이체 완료 후 잔액을 보여준다.
						System.out.println(credit.getName() + Message.complete + credit.getBalance());
						// 갱신된 정보를 저장한다.
						File_IO.save(Message.file, this.account);
						return;
					}
				}
				// 계좌번호가 없으면 인증 실패 메세지 출력
				System.out.println(Message.account_fault);
			} catch (IOException e) {
				// IOException 발생시 에러메세지 출력 후 처음으로 돌아간다.
				System.out.println(Message.error);
			}
		}
	}
	
	
	public void lookup() {
		// 계좌 조회 메서드
		
		Credit credit = this.check();
		
		if (credit != null) {
			// 계좌 정보를 성공적으로 받아왔을 경우에만 조회
			System.out.println(credit.getName() + Message.complete + credit.getBalance());
		}
	}
	
	
	public void insert() {
		// 계좌 등록 메서드
		Credit credit;
		StringTokenizer token;
		
		try {
			System.out.println(Message.insert);
			// 계좌 등록 메세지 출력
			token = new StringTokenizer(File_IO.keyRead());
			// StringTokenizer 객체를 이용, 입력받은 문자열을 공백 기준으로 분리
			if (token.countTokens() != 3) {
				// 입력한 정보가 3개의 문자열로 나눠지지 않는 경우 작업을 취소한다.
				System.out.println(Message.error);
				return;
			}
			credit = new Credit(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()), token.nextToken());
			// 계좌 객체 생성
			for (Credit compare: this.account) {
				// 리스트에서 중복된 계좌번호를 탐색
				if (credit.getAccount() == compare.getAccount()) {
					// 동일한 계좌번호를 가진 정보가 리스트에 있을 경우
					System.out.print(Message.overlap);
					// 중복 계좌 존재 메세지 출력 후 종료
					return;
				}
			}
			this.account.add(credit);
			// 갱신된 정보를 저장한다.
			File_IO.save(Message.file, this.account);
		} catch (IOException e) {
			// IOException 발생시 에러메세지 출력 후 처음으로 돌아간다.
			System.out.println(Message.error);
		}
	}

	
	public void delete() {
		// 계좌 삭제 메서드

		try {
			System.out.print(Message.accountcheck);
			// 계좌번호 입력 메세지 출력
			num = Integer.parseInt(File_IO.keyRead());
			// 키보드 입력 함수를 사용하여 num에 계좌번호를 대입
			for (Credit credit: this.account) {
				// 리스트에서 일치하는 계좌번호를 탐색
				if (credit.getAccount() == num) {
					// 동일한 계좌번호를 가진 정보가 리스트에 있을 경우 해당 계좌 삭제
					this.account.remove(credit);
					// 갱신된 정보를 저장한다.
					File_IO.save(Message.file, this.account);
					// 반복문의 매개변수로 account를 사용하고 있으므로 값이 변동될 때 반드시 반복문을 빠져나가게 해주어야 한다.
					return;
				}
			}
			// 계좌번호가 없을 경우 인증 실패 메세지 출력
			System.out.println(Message.account_fault);
		} catch (IOException e) {
			// IOException 발생시 에러메세지 출력 후 처음으로 돌아간다.
			System.out.println(Message.error);
		}
	}

	
	public void readAll() {
		// 전체 계좌 조회 메서드
		
		for (Credit credit: this.account) {
			System.out.println(credit.getAccount()
					+ " │ " + credit.getPassword()
					+ " │ " + credit.getName()
					+ " │ " + credit.getBalance());
		}
		System.out.println();
	}
	

	public Credit check() {
		// 계좌 인증 메서드

		try {
			System.out.print(Message.accountcheck);
			// 계좌번호 입력 메세지 출력
			num = Integer.parseInt(File_IO.keyRead());
			// 키보드 입력 함수를 사용하여 num에 계좌번호를 대입
			for (Credit credit: this.account) {
				// 리스트에서 일치하는 계좌번호를 탐색
				if (credit.getAccount() == num) {
					// 동일한 계좌번호를 가진 정보가 리스트에 있을 경우
					System.out.print(Message.passcheck);
					// 비밀번호 입력 메세지 출력
					num = Integer.parseInt(File_IO.keyRead());
					// 키보드 입력 함수를 사용하여 num에 비밀번호를 대입
					if (credit.getPassword() == num) {
						// 해당 계좌 정보의 비밀번호 역시 일치할 경우 해당 계좌 정보를 출력
						return credit;	
					}
				}
			}
			// 계좌번호가 없거나 비밀번호를 틀릴 경우 인증 실패 메세지 출력
			System.out.println(Message.account_fault);
		} catch (IOException e) {
			// IOException 발생시 에러메세지 출력 후 처음으로 돌아간다.
			System.out.println(Message.error);
		}
		
		return null;
	}
}
