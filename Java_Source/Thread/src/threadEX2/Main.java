package threadEX2;

public class Main {

	public static void main(String[] args) {
		Thread thread1 = new Thread1();
		Thread thread3 = new Thread2();
		thread1.start();
		thread3.start();
	}
}