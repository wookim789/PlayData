package score;

import java.util.Scanner;

public class ClassScroe {
	String studentData [][] = new String[100][8];
	int cnt,tot;
	float avg;
	Scanner sc = new Scanner(System.in);
	String answer="";
	
	public void input() {
		while(!answer.equals("exit")) {
			
			System.out.println("학번 =>");
			studentData[cnt][0] = sc.nextLine();
			System.out.println("이름 =>");
			studentData[cnt][1] = sc.nextLine();
			System.out.println("국어 =>");
			int kor = sc.nextInt();
			System.out.println("영어 =>");
			int eng = sc.nextInt();
			System.out.println("수학 =>");
			int mat = sc.nextInt();
		
			process(kor,eng,mat);
		
			this.studentData[cnt][2] = String.valueOf(kor);
			this.studentData[cnt][3] = String.valueOf(eng);
			this.studentData[cnt][4] = String.valueOf(mat);
			this.studentData[cnt][5] = String.valueOf(tot);
			this.studentData[cnt][6] = String.valueOf(avg);
			System.out.println("추가 시 아무키, 없을 시 exit\n");
			sc.nextLine();
			this.answer = sc.nextLine();
			//sc.nextLine();
			cnt++;
		}
		output();
	}
	private void process(int kor, int eng, int mat) {
		
		this.tot = kor + eng + mat; 
		this.avg = (float)tot/3.f;
		
		int grade = (int)(avg/10);
		
		switch (grade) {
		case 10:
		case 9:
			this.studentData [cnt][7] = "수";
			break;
		case 8:
			this.studentData [cnt][7] = "우";
			break;
		case 7:
			this.studentData [cnt][7] = "미";
			break;
		case 6:
			this.studentData [cnt][7] = "양";
			break;
		default:
			this.studentData [cnt][7] = "가";
			break;
		}
	}
	public void output() {
		System.out.println("\n\t\t 성적표");
		System.out.println("===================================");
		System.out.println("학번     이름    국어    영어    수학    총점    평균    등급");
		for(int i =0; i < cnt ; i++) {
			System.out.printf("%s  %3s  %3s %3s %3s  %3s %3s %s", studentData [i][0],studentData [i][1],studentData [i][2],studentData [i][3],
					studentData [i][4],studentData [i][5],studentData [i][6],studentData [i][7]);
			System.out.println("\n");
		}
		System.out.println("===================================");
	}

}
