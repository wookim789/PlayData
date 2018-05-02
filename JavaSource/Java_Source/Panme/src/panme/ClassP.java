package panme;
import java.util.Scanner;
import static java.lang.System.out;

public class ClassP {
	
	public static String strData[][] = new String [100][5];
	
	public String answer;
	public int num, cost, tot; 
	int i,j;

	public void input(Scanner sc) {
	
		out.println("제품 코드 입력 :");
		strData[i][0]= sc.next();	
		out.println("제품 이름 입력 :");
		strData[i][1] = sc.next();		
		out.println("제품 수량 입력 :");
		num = sc.nextInt();		
		out.println("제품 가격 입력 :");	
		cost = sc.nextInt();

		tot = num * cost;
		
		strData[i][2] = String.valueOf(num);
		strData[i][3] = String.valueOf(cost);
		strData[i][4] = String.valueOf(tot);
		
		i++;
}
	public void output() {
		out.println("\n\t***판매현황***");
		out.println("===================================");
		out.println("제품코드   제품이름       수량     단가          금액  ");
		
		for(j = 0; j < i; j++) {
			out.printf("%4s   %4s   %4s   %4s   %4s   \n" ,
					   strData[j][0], strData[j][1], strData[j][2], strData[j][3], strData[j][4]);
		}
		process();
	}
	
	private void process() {
		for(j =0; j < i; j++) {  
			tot += Integer.parseInt(strData[j][4]);   
		}     
		out.println("===================================");
		out.printf("                    총 판매 금액 : %d\n", tot);	
	}    
}    
  
