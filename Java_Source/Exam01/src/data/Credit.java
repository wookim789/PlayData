package data;

import java.io.Serializable;

public class Credit implements Serializable {
	// 계좌 정보 클래스
	private static final long serialVersionUID = 1L;
	
	private int account;
	private int password;
	private String name;
	private int balance;
	
	public Credit(int account, int password, String name) {
		this.account = account;
		this.password = password;
		this.name = name;
		this.balance = 0;
	}
	
	public int getAccount() {return account;}
	public int getPassword() {return password;}
	public String getName() {return name;}
	public int getBalance() {return balance;}
	
	public void setAccount(int account) {this.account = account;}
	public void setPassword(int password) {this.password = password;}
	public void setName(String name) {this.name = name;}
	public void setBalance(int balance) {this.balance = balance;}
	
}
