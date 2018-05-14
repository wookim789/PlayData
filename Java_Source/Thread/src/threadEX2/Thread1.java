package threadEX2;

public class Thread1 extends Thread {
	public void run() {
		char array [] = {'ㄱ','ㄴ','ㄷ','ㄹ','ㅁ','ㅂ','ㅅ','ㅇ','ㅈ','ㅊ','ㅋ','ㅌ','ㅍ','ㅎ'};

		for(char a : array) {
			System.out.print(a);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				
			}
		}
	}

}
