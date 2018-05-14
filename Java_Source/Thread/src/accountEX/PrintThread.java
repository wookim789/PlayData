package accountEX;

public class PrintThread extends Thread{
	DataClass dc;
	
	PrintThread(DataClass dc){
		this.dc = dc;
	}
	public void run() {
		for(int i = 0; i < 12 ; i ++) {
		synchronized(dc) {
		
				System.out.print("이몽룡 계좌 잔약 : ");
				System.out.print(dc.ac1.stock+"\n");
				System.out.print("성춘향 계좌 잔약 : ");
				System.out.print(dc.ac2.stock + "\n");
				System.out.print("전체 계좌 잔액 조회 : ");
				int ac1 = Integer.parseInt(dc.ac1.stock);
				int ac2 = Integer.parseInt(dc.ac2.stock);
				int sum = ac1 + ac2;
				System.out.print(sum+"\n");
			}
		
		}
	}

}
