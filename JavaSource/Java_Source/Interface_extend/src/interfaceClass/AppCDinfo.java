package interfaceClass;
import static java.lang.System.out;

public class AppCDinfo extends ParentClass  implements IntefaceClass{
	String nameOfpeople, dates, state;
	
	AppCDinfo(String manNum, String title, String nameOfpeople, String dates){
		super(manNum,title);
		this.nameOfpeople= nameOfpeople;
		this.dates = dates;
		this.state= "데이터 없음";
	}
	public void borrow() {
		out.println("관리번호 :" + super.manNum);
		out.println("제목 : " + super.title);
		out.println(this.nameOfpeople +"님 안녕하십니까.");
		out.println(this.dates + "일 부터 5일이 반납 기한 입니다.");
		this.state= "대출";
		out.println(this.nameOfpeople +"님은 현재 "+this.state + "중 이십니다.");
	}
	public void returnThings() {
		out.println("관리번호 :" + super.manNum);
		out.println("cd 제목 : " + super.title);
		out.println(this.nameOfpeople +"님 안녕하십니까.");
		out.println(this.dates + "일에"+ super.title +"을 반납하셨습니다.");
		this.state= "데이터 없음";
	}
}
