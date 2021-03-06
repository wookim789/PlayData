import java.util.Scanner;

public class SimpleAdder {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String name, grade;		
		int math, kor, eng, tot, number;
		float ave;
		
		System.out.println("이름 입력 :");
		name = sc.nextLine();
		System.out.println("학번 입력 :");
		number = sc.nextInt();
		System.out.println("수학 점수 :");
		math = sc.nextInt();
		System.out.println("영어 점수 :");
		eng = sc.nextInt();
		System.out.println("국어 점수 :");
		kor = sc.nextInt();
		
		tot = math + kor + eng;
		ave = tot / 3.0f;
		
		
		int reAvg = (int)(ave/10);
		
		switch (reAvg) 
		{
		case 10 :
		case 9 :
			grade = "수";
			break;
		case 8:
			grade ="우";
			break;
		case 7:
			grade ="미";
			break;
		case 6:
			grade ="양";
			break;
		default:
			grade = "가";
			break;
		}

		System.out.println("\n\t\t ***성적표***");
		System.out.println("========================================");
		System.out.println("학번      이름      국어      영어      수학      총점      평균      등급");
		System.out.println("========================================");
		System.out.printf("%3d  %3s  %3d  %3d  %3d  %3d  %6.2f  %3s \n", 
				           number, name, kor, eng, math, tot, ave, grade);
		System.out.println("========================================");
		
		switch (grade) 
		{
		case "수" :
			System.out.println("\t\t축하합니다.");
			break;
		case "우" :
			System.out.println("\t\t수를 향해 달려가세요.");
			break;
		case "미" :
			System.out.println("\t\t조금만 더 노력하세요.");
			break;
		case "양" :
			System.out.println("\t\t유급 위기입니다.");
			break;
		default :
			System.out.println("\t\t유급입니다.");
			break;
		}

		sc.close();
	}
}
