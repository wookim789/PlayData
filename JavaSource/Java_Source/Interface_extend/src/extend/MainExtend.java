package extend;

public class MainExtend {

	public static void main(String[] args) {
		//CheckingAccount obj = new CheckingAccount("111-22-33333","홍길동",1000000,"11-11-11");
		BonusPoint pot = new BonusPoint("11","홍길",0,0);
		pot.deposit(100000);
		System.out.println("잔액 : " + pot.balance);
		System.out.println("누적 포인트 : " + pot.bonuspoint);
//		try {
//			int paidAmount = obj.pay("11-11-11",3000000);
//			System.out.println("지불액 : " + paidAmount);
//			System.out.println("잔액 :" + obj.balance);
//		}catch ( Exception e) {
//			String msg = e.getMessage();
//			System.out.println(msg);
//		}
 
	}

}
