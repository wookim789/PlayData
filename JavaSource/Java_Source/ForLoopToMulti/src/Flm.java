import static java.lang.System.out;

import java.util.Scanner;
public class Flm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int startNum, finalNum, init;	
		
		{
			int first, second;
			out.println("1번 수 : ");
			first = sc.nextInt();
			out.println("1번 수 : ");
			second = sc.nextInt();
		
			if(first < second) {
				startNum =first;
				finalNum = second;
			
			}else {
				startNum = second;          
				finalNum = first;			
			}
		}	
		
		for(init = startNum; startNum<=finalNum; startNum++) {
			out.printf("  %d단                              ",startNum);
		}
			
		for(int i = 1; i<10; i++) {
			out.println("");
			
			for(startNum = init; startNum <= finalNum; startNum++) {
				out.printf("%3d x %3d = %3d  ", startNum, i, startNum * i);
			}
		}
	
		sc.close();


	}

}
