package score;

import java.util.Scanner;
import java.util.*;

public class ClassScroe {
	//ArrayList<ArrayList<String>> studentData = new ArrayList<ArrayList<String>>();
	int cnt=0;
	String answer="";
	
	Scanner sc = new Scanner(System.in);
	ArrayList<String> num = new ArrayList<String>();
	ArrayList<String> name= new ArrayList<String>();
	ArrayList<String> kor = new ArrayList<String>();
	ArrayList<String> eng= new ArrayList<String>();
	ArrayList<String> mat= new ArrayList<String>();
	ArrayList <Integer> tot = new ArrayList <Integer>();
	ArrayList<Float> avg= new ArrayList<Float>();
	ArrayList<String> grade= new ArrayList<String>();
	
	public void input() {
		while(!answer.equals("exit")) {
			
			System.out.println("학번 =>");
			String data = sc.nextLine();
			this.num.add(data);
			
			System.out.println("이름 =>");
			data= sc.nextLine();
			this.name.add(data);
			
			System.out.println("국어 =>");
			int kor = sc.nextInt();
			this.kor.add(String.valueOf(kor));
			
			System.out.println("영어 =>");
			int eng = sc.nextInt();
			this.eng.add(String.valueOf(eng));
			
			System.out.println("수학 =>");
			int mat = sc.nextInt();
			this.mat.add(String.valueOf(mat));
			
			process(kor,eng,mat);
			 
			System.out.println("추가 시 아무키, 없을 시 exit\n");
			sc.nextLine();
			this.answer = sc.nextLine();
			//sc.nextLine();
			cnt++;
		}
		output();
	}
	private void process(int kor, int eng, int mat) {
		int tot1= kor + eng + mat;
		this.tot.add(tot1); 
		Float avg1 = (tot1)/3.f;	
		this.avg.add(avg1);
		int grade = (int)(avg1/10);

		switch (grade) {
		case 10:
		case 9:
			this.grade.add("수");
			break;
		case 8:
			this.grade.add("우");
			break;
		case 7:
			this.grade.add("미");
			break;
		case 6:
			this.grade.add("양");
			break;
		default:
			this.grade.add("가");
			break;
		}
	}
	public void output() {
		System.out.println("\n\t\t 성적표");
		System.out.println("===================================");
		System.out.println("학번     이름    국어    영어    수학    총점    평균    등급");
		
		for(int i =0; i < this.name.size(); i++) {
			System.out.printf("%3s %3s %3s %3s %3s %3d %3.2f, %3s ",
					this.num.get(i),this.name.get(i),this.kor.get(i),
					this.eng.get(i),this.mat.get(i),this.tot.get(i),
					this.avg.get(i),this.grade.get(i));
			
			System.out.println("\n");
		}
		System.out.println("===================================");
	}

}
