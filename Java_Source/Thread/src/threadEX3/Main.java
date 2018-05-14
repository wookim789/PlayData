package threadEX3;

public class Main {

	public static void main(String[] args) {
		DataClass dc = new DataClass();
		Thread thread1 =  new Thread1();
		Thread thread2 = new Thread2();
		
		thread1.dc = dc;
		
		thread1.start();
		thread2.start();

	}

}
