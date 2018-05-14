package scoreVer2;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Scanner;

public class CoreClass {

	String userOrder="";
	MethodClass pclass = new  MethodClass();
	 
	void mainMenu(ArrayList<MethodClass> obj) {

		while(!this.userOrder.equals("3")) {
			
			Scanner sc = new Scanner(System.in);		
			
			out.println("성적 입력 : 1");
			out.println("성적 출력 : 2");
			out.println("종료 하기 : 3");
			out.println("학번 조회 : 4");
			out.println("성적 수정 : 5");
			out.println("성적 삭제 : 6");
			
			this.userOrder = sc.next();
			
			switch (this.userOrder) {
				case "1": //제품 데이터 입력
					pclass.input(sc,obj);
					break;
				case "2": // 제품 데이터 모두 출력
					pclass.output(obj);
					break;
				case "3": //프로그램 종료
					out.println("***종료***\n");
					break;
				case "4"://하나의 데이터 조회
					pclass.select(sc,obj);
					break;
				case "5"://하나의 데이터 수정
					pclass.modify(sc,obj);
					break;
				case "6"://하나의 데이터 삭제
					pclass.delete(sc,obj);
					break;
			}
		}
	}
}
