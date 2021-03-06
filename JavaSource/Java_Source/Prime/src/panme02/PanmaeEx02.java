package panme02;
import java.util.Scanner;

public class PanmaeEx02 {
	
	final static int MAX = 100;
	
	public static void main(String[] args) {
		
		String code[] = new String[MAX];
		String irum[] = new String[MAX];
		int su[] = new int[MAX];
		int danga[] = new int[MAX];
		int price[] = new int[MAX];
		
		int totCnt[] = inputData(code, irum, su, danga, price);	
		printOuput(code,irum ,su,danga,price,totCnt);
	}
	
	public static int [] inputData(String code[],String irum [], int su[], int danga[],int price[]) {
		
		int totCnt[] = new int [2];
		int i, total = 0, cnt = 0;
		
		Scanner in = new Scanner(System.in);
		
		for (i=0; i<MAX; i++)
		{
			System.out.print("��ǰ�ڵ� �Է� => ");
			code[i] = in.next();
			if (code[i].equals("exit"))
				break;
			
			System.out.print("��ǰ�� �Է� => ");
			irum[i] = in.next();
			System.out.print("���� �Է� => ");
			su[i] = in.nextInt();
			System.out.print("�ܰ� �Է� => ");
			danga[i] = in.nextInt();
			
			price[i] = su[i] * danga[i];
			total += price[i];
			cnt++;
			System.out.println();
		}
		totCnt[0] = total;
		totCnt[1] = cnt;
		in.close();
		return totCnt;
	}
	public static void printOuput(String code[],String irum [], int su[], int danga[],int price[],int totCnt[]) {

		System.out.println("\n\t       *** �Ǹ� ��Ȳ ***");
		System.out.println("============================================");
		System.out.println("��ǰ�ڵ�        ��ǰ��          ����           �ܰ�             �ݾ�");
		System.out.println("============================================");
		for (int i=0; i<totCnt[1]; i++)
		{
			System.out.printf("%4s      %3s        %4d    %6d   %9d\n",
				code[i], irum[i], su[i], danga[i], price[i]);
		}
		System.out.println("============================================");
		System.out.printf("\t\t\t  ���Ǹž�  : %d\n", totCnt[0]);
	}
}