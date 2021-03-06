package score;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

public class ScoreModel {
	private String id;
	private String name;
	private String kor;
	private String eng;
	private String mat;
	private String tot;
	private String evg;
	private String grade;
	
	public void process() {
		int totf = Integer.parseInt(this.kor) + Integer.parseInt(this.eng) + Integer.parseInt(this.mat);
		this.tot =  Integer.toString(totf);
		/*setTot( Integer.toString(totf));*/
		float evgf = (float)totf/3.0f;	
		this.evg = Float.toString(evgf);
		int a = (int)evgf/10;
		
		switch(a) {
		case 10:
		case 9:
			setGrade( "A");
			break;
		case 8:
			setGrade(  "B");
			break;
		case 7:
			setGrade( "C");
			break;
		case 6:
			setGrade( "D");
			break;
		case 5:
			setGrade( "E");
			break;
		default:
			setGrade(  "F");
			break;
		}
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKor() {
		return kor;
	}
	public void setKor(String kor) {
		this.kor = kor;
	}
	public String getEng() {
		return eng;
	}
	public void setEng(String eng) {
		this.eng = eng;
	}
	public String getMat() {
		return mat;
	}
	public void setMat(String mat) {
		this.mat = mat;
	}



	public String getTot() {
		return tot;
	}



	public void setTot(String tot) {
		this.tot = tot;
	}



	public String getEvg() {
		return evg;
	}



	public void setEvg(String evg) {
		this.evg = evg;
	}



	public String getGrade() {
		return grade;
	}



	public void setGrade(String grade) {
		this.grade = grade;
	}
}
