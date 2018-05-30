package panmever2;
import static java.lang.System.out;
import java.util.Scanner;

public class Panme02 {
	
	static int tot = 0, numberOfData = 0;	
	String code;
	String name;

	int su,price,sumcost;
	
	void input(Scanner sc, Panme02 obj[]) { //중복체크
		boolean a = false;
		
		checkloop://제품 코드 중복 비교
		while(a!=true) {
			out.println("제품 코드 입력 :");
			String check= sc.next();
			
			if(Panme02.numberOfData == 0) {//데이터를 처음 입력하면 바로 저장
				obj[Panme02.numberOfData].code = check;
			}else {
				for(int k = 0; k < Panme02.numberOfData; k++) {//제품 코드만 한 하여 
															   //중복 비교 및 루프 재시작
					if(obj[k].name.equals(check)) {
						out.printf("\n중복되는 아이디 : " + obj[k].name+" %d\n",k);
						continue checkloop;
					}else {
						obj[Panme02.numberOfData].code = check;
					}
				}
			}
			
			out.println("제품 이름 입력 :"); //제품 이름 입력
			obj[Panme02.numberOfData].name = sc.next();	
			
			inputErro://루프 라벨
			while(a!=true) {
				try { //수량 , 가격에 숫자만 입력 되도록 예외문 처리
					out.println("제품 수량 입력 :");
					obj[Panme02.numberOfData].su= sc.nextInt();		
					out.println("제품 가격 입력 :");	
					obj[Panme02.numberOfData].price = sc.nextInt();

					obj[Panme02.numberOfData].sumcost = obj[Panme02.numberOfData].su * obj[Panme02.numberOfData].price;
					return;
					
				}catch(java.util.InputMismatchException e) {
					out.println("숫자만 입력 가능합니다.\n");	
					sc.nextLine() ;
					continue inputErro; //수량부터 다시 입력
				}
			}
			return;
		}	
	}
	
	void output(Panme02 obj[]) { //모든 제품 데이터 출력
		
		Panme02.tot=0;
		
		out.println("\n\t***판매현황***");
		out.println("===================================");
		out.println("제품코드     제품이름       수량        단가       금액  ");
		
		for(int i = 0; i < Panme02.numberOfData; i++) {
			out.printf("%4s   %4s   %4s   %4s   %4s   \n" ,
					obj[i].code, obj[i].name,
					obj[i].su, obj[i].price,
					obj[i].sumcost);	
			Panme02.tot += obj[i].sumcost; // 모든 가격의 총합
			}
		out.println("===================================");
		out.printf("                    총 판매 금액 : %d\n", Panme02.tot);	
	}
	
	void select( Scanner sc,Panme02 obj[]) { // 하나의 데이터 조회
		out.print("조회 할 코드 입력 : ");
		String searchCode = sc.next();
		
		for(int i = 0; i < Panme02.numberOfData; i++) { 
			if(obj[i].code.equals(searchCode)){ // 입력한 제품 코드가 데이터에 존자하면 데이터 출력
				out.println("\n\t***판매현황***");
				out.println("===================================");
				out.println("제품코드     제품이름       수량        단가       금액  ");
				Panme02.tot=0;
				out.printf("%4s   %4s   %4s   %4s   %4s   \n" ,
							obj[i].code, obj[i].name,
							obj[i].su, obj[i].price,
							obj[i].sumcost);	
				out.println("===================================");		
				return;
			}
		}
		out.print("해당 코드가 없습니다.\n"); // 제품 코드가 없을 떄 종료
	}
	
	void modify(Scanner sc,Panme02 obj[]) { // 제품 데이터 수정
		out.print("수정 할 코드 입력 : ");
		String modifyCode = sc.next(); // 제품 코드 입력

		for(int i = 0; i < Panme02.numberOfData; i++) {
			if(obj[i].code.equals(modifyCode)){ // 입력한 코드가 데이터에 있으면 
				out.print("수정 할 수량 입력 : ");     //수정할 데이터 재 입력
				obj[i].su = sc.nextInt();
				out.print("수정 할 단가 입력 : ");
				obj[i].price = sc.nextInt();
				obj[i].sumcost = obj[i].su * obj[i].price;
				return;                         //sum_cost에 값 할당 이후 종료
				} 
		}
		out.print("해당 코드가 없습니다.\n"); // 없을 시 종료
	}
	
	void delete(Scanner sc, Panme02 obj[]) { // 데이터 삭제
		out.print("삭제 할 코드 입력 : ");
		String delteCode = sc.next();

		for(int i = 0; i < Panme02.numberOfData; i++) {
			if(obj[i].code.equals(delteCode)){
				while(i< Panme02.numberOfData) {
					obj[i] = obj[i+1];
					obj [Panme02.numberOfData] = null;
					Panme02.numberOfData--;
					i++;
					return;
				}
				if(i == Panme02.numberOfData) {
					obj[i]=null;
					Panme02.numberOfData--;
					return;
				}
			}
		}
		out.print("해당 코드가 없습니다.\n");
	}
}
