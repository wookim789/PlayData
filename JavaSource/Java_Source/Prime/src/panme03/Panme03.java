package panme03;
import java.util.Scanner;
import Utility.*;
public class Panme03 {

public static void main(String[] args) {
	
	int [] num =inputPrimeNumber();
		
	primeNumber(num);
		 
	}
	static int[] inputPrimeNumber() {
		Scanner in = new Scanner(System.in);
		int [] num = new int[2];
		
		System.out.print("첫 번째 수 입력 => ");
		num[0] = in.nextInt();
		System.out.print("두 번째 수 입력 => ");
		num[1] = in.nextInt();
		System.out.println();
		
		if (num[0]<= num[1]) {
		}
		else
		{
			int bignum = num[1];
			num[1] = num[0];
			num[0] = bignum;
		}
		in.close();
		return num;		
	}
	static void primeNumber(int [] num) {
		int cnt=0, i,j;
		for (i = num[0]; i<=num[1]; i++) 
		{
			for (j =2; j<i; j++) 
			{
				if (i%j == 0) 
					break;  
			}
			if (i == j) 
			{
				System.out.printf("%5d", i); 
				cnt++; 
				if (cnt % 10 == 0) 
					System.out.println();
			}		
		}
		if (cnt % 10 != 0)
			System.out.println();
		Utility.print("총 개수 = " + cnt);
	}
}
