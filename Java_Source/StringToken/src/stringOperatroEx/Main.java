package stringOperatroEx;
import static java.lang.System.out;
import static java.lang.System.in;
import java.util.*;

public class Main {

	static int cnt = 1 ;
	
	public static void main(String[] args) {
		int num2 = 0;
		float tot=0.f;
		StringTokenizer op;
		String oper; //지역 변수 선언

		Scanner sc = new Scanner(in); //스캐너 객체 선언
		
		System.out.println("수식 입력 =>");
		oper = sc.nextLine();        // 수식 입력
		op = new StringTokenizer(oper,"+-/*",true);  // 해당 스트링 객체를 토크나이저 생성자에 값전달. true일 때 "+-*/" 내용 도 토큰으로 만듬
		
		if(check(op)) { // check()메소드 실행 -> op의 수식이 정상적인지 검사.
			//if문 check(op)에서 nextToken()메소드를 사용했기 때문에  ->총알이 떨어짐 
			op = new StringTokenizer(oper,"+-/*",true); // 새로운 객체 생성 이후 op로 해당 객체 주소 저장
			
			for(int i = 1; i < cnt ; i ++) { //cnt는 static 필드로 check() 연산자에서 수식의 길이를 저장함
				if(i == 1) {
					tot = Integer.parseInt(op.nextToken());   // 첫 번째 수식은 숫자로 해당값 tot에 저장
				}else if(i % 2 == 1) {            //첫 번재 수가 저장되고 2번째 연산자가 들어오면 아무것도 안함.
					switch (op.nextToken()) {     //이점에 착안하여 switch문에서 op.nextToken을 써서 연산자 종류에 따라 
					case "+":  					  //case문 실행
						num2 = Integer.parseInt(op.nextToken()); //한번더 nextTiken()사용시 숫자를 읽어옴
						tot  += num2;			  //해당 연산 수행
						break;
					case "-" : 
						num2 = Integer.parseInt(op.nextToken());
						tot -= num2;
						break;
					case "*":  
						num2 = Integer.parseInt(op.nextToken());
						tot *= num2;
						break;
					case "/": 
						num2 = Integer.parseInt(op.nextToken());
						tot  /= (float)num2;				
						break;
				}
			}
		}
			out.println(oper + " = " + tot);
			sc.close();
	}else {
		out.println("연산 불가");
		sc.close();
	}
}
	static boolean check(StringTokenizer op) {
		while(op.hasMoreTokens()) {
			
			String str = op.nextToken();  //스트링 객체에 토큰 객체 저장
										  //			System.out.println( str);
			int checknum = 0;

			if(cnt % 2 == 1) {  //수식의 홀수행 : 숫자, 짝수 행 : 연산자
				try { //숫자일때 해당 문자 객체를 숫자로 변환 해봄.
					//System.out.println("숫자 변환 cnt :" + cnt);  
					checknum = Integer.parseInt(str);
					cnt++; // 성공하면 수식 길이 증가
				}catch(java.lang.NumberFormatException e){
					//System.out.println("숫자 변환 실패  cnt :" + cnt);
					cnt = 1;  //실패시 수식 길이 초기화
					return false; // false 반환으로 	out.println("연산 불가"); 출력
				}
				//System.out.println("숫자 변환 성공  cnt :" + cnt);
			}else { //짝수행일 때
				if((str.equals("+")|| str.equals("-") || str.equals("*") || str.equals("/"))){ //해당 토큰 객체가
					cnt++;							      //연산자 이면 문자 길이 증가
				}else {
					System.out.println("잘못된 연산자" + str); //아닐 시 출력
					cnt = 1;							  //문자 길이 초기화
					return false;
				}
			}
		}
		System.out.println("정삭 적인 수식"); //모든 수식이 정상적일 때 출력.
		return true;
	}

}
