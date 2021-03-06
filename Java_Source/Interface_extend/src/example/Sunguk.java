package example;

import static java.lang.System.out;
import java.util.*;

public class Sunguk extends Person implements Personable{
	 Scanner sc;
	 int kor, eng, mat, tot;
	 public static int cnt =0;
	 float avg;
	 String grade;
	 Sunguk obj [];
	
	Sunguk(String hakburn, String irum){
		super(hakburn, irum);
		this.kor = 0;                         
		this.eng = 0;
		this.mat = 0;
		this.avg = 0.f;
		this.tot = 0;
	}
	
	@Override
	public void input() {
		this.sc = new Scanner(System.in);
		
		out.println("국어점수 입력");
		this.kor = Integer.valueOf(sc.nextLine()); 
		out.println("영어점수 입력");
		this.eng = Integer.valueOf(sc.nextLine()); 
		out.println("수학점수 입력");
		this.mat = Integer.valueOf(sc.nextLine());  
		
		process();
		cnt++;
		return;
	}
	
	private void process() {
		this.tot = this.kor + this.eng + this.mat;
		this.avg = (this.tot / 3.f);
		
		int gradeNo = (int)(avg/10);
		
		switch (gradeNo) {
		case 10 :
		case 9 :
			this.grade = "수";
			break;
		case 8:
			this.grade = "우";
			break;
		case 7:
			this.grade = "미";
			break;
		case 6:
			this.grade = "양";
			break;
		default :
			this.grade = "가";
			break;
		}
		return;
	}
	
	@Override
	public void output() {
		
			out.printf("%4s %3s %3d %3d %3d %3d %3f %s \n",
					super.hakbun, super.irum, this.kor, this.eng, this.mat, this.tot, this.avg, this.grade);
			return;
		}
		
}
