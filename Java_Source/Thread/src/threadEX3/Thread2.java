package threadEX3;

public class Thread2 extends Thread{
	public DataClass dc;
	public void run() {
		while(dc.controler!=true) {
			continue;
		}
		System.out.println(dc.result);
	}

}
