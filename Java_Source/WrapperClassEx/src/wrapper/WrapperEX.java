package wrapper;

public class WrapperEX {

	public static void main(String[] args) {
		Integer a = Integer.valueOf(20);
		
		System.out.println(a);                 // a: 객체 변수=> 프린트 메소드 => 해당 객체의 값을 출력
		System.out.println(Integer.valueOf(a));

		a =Integer.valueOf(30);
		
		System.out.println(a);
		System.out.println(Integer.valueOf(a));
	}

}
