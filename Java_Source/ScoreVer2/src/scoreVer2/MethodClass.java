package scoreVer2;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Scanner;

public class MethodClass {
	static float totavg = 0.f;
	
	MethodClass mc;
	String code;
	String name;
	String grade;
	int kor, eng, mat, tot;
	float avg;
	
	public boolean equals(Object mc) {
		if(!(mc instanceof MethodClass)) {
			return false;
		}else {
			MethodClass mc2 = (MethodClass) mc;
			if(this.code.equals(mc2.code)) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	public void input(Scanner sc, ArrayList<MethodClass> obj) {
		
		out.print("학번 : \n");
		String check = sc.next();
		out.println(obj.size());
		for(int i = 0; i < obj.size() ; i ++) {
			if(check.equals(obj.get(i).code)) {
				out.print("학번 중복\n");
				return;
			}
		}
		obj.add(obj.size() ,new MethodClass());

		obj.get(obj.size()-1).code = check;
		out.print("이름 : \n");
		obj.get(obj.size()-1).name = sc.next();
		
		try {
			out.print("국어 : \n");
			obj.get(obj.size()-1).kor = Integer.parseInt(sc.next());
			out.print("영어 : \n");
			obj.get(obj.size()-1).eng = Integer.parseInt(sc.next());
			out.print("수학 : \n");
			obj.get(obj.size()-1).mat = Integer.parseInt(sc.next());
			obj.get(obj.size()-1).tot = obj.get(obj.size()-1).kor + obj.get(obj.size()-1).eng + obj.get(obj.size()-1).mat;
			obj.get(obj.size()-1).avg = obj.get(obj.size()-1).tot / 3.f;
			gradeMethod(obj.size()-1, obj);
			//MethodClass.nod++;
			return;
			
		}catch(java.lang.NumberFormatException e){
			out.print("점수는 숫자만 입력 가능합니다 => 초기 화면으로\n");
			return;
		}
	}
	
	public void output(ArrayList<MethodClass> obj) {
		
		out.println("\n\t***성적표***");
		out.println("===================================");
		out.println("학번     이름       국어        영어       수학      총합       평균       등급  ");
		
		for(int i = 0; i < obj.size(); i++) {
			printScore(i,obj);
			}
		out.println("===================================");
		out.printf("                    총 평균 : %s\n", process(obj));	
		
	}
	public String process(ArrayList<MethodClass> obj) {
		float tot = 0;
		MethodClass.totavg =0;
		
		for(int i = 0; i < obj.size() ; i++) {
			tot += obj.get(i).avg;
		}
		
		if(obj.size()!=0) {
			MethodClass.totavg = tot/ obj.size();
		}else {
			MethodClass.totavg = 0.f;
		}
		return String.valueOf(MethodClass.totavg);
	}
	
	public void gradeMethod(int i, ArrayList<MethodClass> obj) {
		int gradeScore = (int)(obj.get(i).avg/10);
		
		switch(gradeScore) {
		case 10:
			obj.get(i).grade = "A+";
			break;
		case 9 :
			obj.get(i).grade = "A+";
			break;
		case 8:
			obj.get(i).grade = "A" ;
			break;
		case 7:
			obj.get(i).grade = "B+";
			break;
		case 6:
			obj.get(i).grade = "B";
			break;
		case 5:
			obj.get(i).grade = "C+";
			break;
		case 4: 
			obj.get(i).grade = "C";
			break;
		case 3:
			obj.get(i).grade = "D";
			break;
		default:
			obj.get(i).grade = "F";
		}
	}
	public void exit() {
		out.println("종료");
		return;
	}
	
	public void printScore(int i, ArrayList<MethodClass> obj) {
		out.printf("%4s   %4s   %4s   %4s   %4s   %4s   %4s   %4s\n" ,
				obj.get(i).code, obj.get(i).name,
				obj.get(i).kor, obj.get(i).eng,
				obj.get(i).mat, obj.get(i).tot,
				obj.get(i).avg, obj.get(i).grade);	
	}
	
	public void select(Scanner sc, ArrayList<MethodClass> obj) {
		out.println("조회할 학생의 학번 입력: ");
	
		String number = sc.next();
		for(int i = 0; i < obj.size(); i++) {
			if(number.equals(obj.get(i).code)) {
				out.println("\n\t***성적표***");
				out.println("==============================================");
				out.println("학번     이름       국어        영어       수학      총합       평균       등급  ");			
				printScore(i, obj);
				out.println("==============================================");
				out.printf("                    총 평균 : %s\n", process(obj));	
				return;
				}
			}
		out.print("해당 학번의 학생이 없습니다.\n");
		return;
	}
	public void modify(Scanner sc, ArrayList<MethodClass> obj) {
		out.println("수정할 학생의 학번 입력: \n");
		String number = sc.next();
		
		for(int i = 0; i < obj.size(); i++) {
			if(number.equals(obj.get(i).code)) {
				
				out.println("국어 점수 입력: \n");
				obj.get(i).kor = Integer.parseInt(sc.next());
				out.println("영어 점수 입력: \n");
				obj.get(i).eng = Integer.parseInt(sc.next());
				out.println("수학 점수 입력: \n");
				obj.get(i).mat = Integer.parseInt(sc.next());
				
				obj.get(i).tot = obj.get(i).kor + obj.get(i).eng + obj.get(i).mat;
				obj.get(i).avg = obj.get(i).tot / 3.f;
				gradeMethod(i,obj);
				return;
				}

			}
		out.print("해당 학번의 학생이 없습니다.\n");
		return;
		
	}
	public void delete(Scanner sc, ArrayList<MethodClass> obj) {
		out.println("삭제할 학생의 학번 입력: \n");
		String number = sc.next();
		
		for(int i = 0; i <obj.size(); i++) {
			if(number.equals(obj.get(i).code)) {
//				for(int j = i; j < MethodClass.nod  ; j++) {
//					obj[j] = obj[j+1];
//				}
				obj.remove(i); 
				//MethodClass.nod--;
				return;
				}
			}
		 out.print("해당 학번의 학생이 없습니다.\n");
		 return;
	}
}
