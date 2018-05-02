package idPassword;
import java.util.*;


public class IdPassword {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("주민 번호 : ");
		String id = sc.nextLine();
		
		while(!(check_input(id))){
			System.out.println("다시 입력");
			id = sc.nextLine();
		}
		sc.close();
		
		String a;
		int num, tot = 0, mul = 2, output = 0;

		for(int index = 0; index < 13; index ++) {
			
			if(index == 6) {
				index++;
			}
			a  = Character.toString(id.charAt(index));
			num = Integer.parseInt(a);
			tot += (num * mul);		
			
			mul++;
			
			if(mul ==10 ) 
				mul = 2;
		}
		output = 11 - (tot % 11);
		if(output == 11){
			if(1==Integer.parseInt(Character.toString(id.charAt(13)))) {
				System.out.println(id + "(o)");
				System.out.print("output : "+ output);
			}else {
				System.out.println(id + "(x)");
				System.out.print("output : "+ output);
			}
		}else if(10 == output) {
			if(0==Integer.parseInt(Character.toString(id.charAt(13)))) {
				System.out.println(id + "(o)");
				System.out.print("output : "+ output);
			}else {
				System.out.println(id + "(x)");
				System.out.print("output : "+ output);
			}
		}else {
			if(output == Integer.parseInt(Character.toString(id.charAt(13)))){
				System.out.println(id + "(o)");
				System.out.print("output : "+ output);
			}else {
				System.out.println(id + "(x)");
				System.out.print("output : "+ output);
			}
		}
	}
	static boolean check_input(String id) {
		int i=0;
		if(id.length() != 14) {
			System.out.print("1");
			return false;
		}
		if(id.charAt(6)!='-') {
			System.out.print("2");
			return false;
		}
		if(id.charAt(7) != '1' && id.charAt(7) != '2'&& id.charAt(7) !='3' && id.charAt(7) !='4' ) {
			return false;
		}
		while(true) {
			if(i != 6) {
				if( (int)id.charAt(i)<'0' || (int)id.charAt(i)>'9' ) {
					System.out.print((int)id.charAt(i));			
					
					return false;
				}else {
					i++;
					if(i == 13) {
						return true;
					}
					continue;
				}
			}else {
				i++;
			}
			
		}
	}
}
