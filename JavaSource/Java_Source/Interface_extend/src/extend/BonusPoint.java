package extend;

public class BonusPoint extends Account {
	
	int bonuspoint;
	
	BonusPoint(String accountNo, String ownerName, int balance, int bonuspoint){
		super(accountNo, ownerName, balance);
		this.bonuspoint = bonuspoint;
	}
	
	void deposit(int amount) {
		super.deposit(amount);
		bonuspoint +=(int) (amount *0.01);
	}
	

}
