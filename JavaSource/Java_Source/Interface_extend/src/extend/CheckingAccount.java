package extend;

public class CheckingAccount extends Account{
	String carNo;
	int minusLimit;
	CheckingAccount(String accountNo, String ownerName, int balance, String carNo){
		super(accountNo, ownerName, balance);
		this.carNo = carNo;
		this.minusLimit = -2000000;
	}
	//메소드 오버라이딩
	int withdraw (int amount) throws Exception{
		if(minusLimit > balance - amount) {
			throw new Exception("한도 초과");
		}
		balance -= amount;
		return amount;
	}
	
	int pay(String carNo, int amount) throws Exception{
		if(!carNo.equals(this.carNo)||(minusLimit > balance - amount)) {
			throw new Exception("지불 불가");
		}
		return withdraw(amount);
	}

}
