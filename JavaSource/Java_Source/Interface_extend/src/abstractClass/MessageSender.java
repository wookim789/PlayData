package abstractClass;
import static java.lang.System.out;

public class MessageSender extends AbstactClass {
	String sender, Recipient, contents, phoneNum;
	MessageSender (String Name, String title, String sdr, String Rct,String phoneNum){
		 super(Name, title);
		 this.phoneNum = phoneNum;
		 this.sender =sdr;
		 this.Recipient = Rct;
		 this.contents ="";
	 }
	
	void sendMassage(String contents) {
		this.contents=contents;
		out.print("-------------------------");
		out.print("제목 : " + this.Title);
		out.print("보내는 사람 : " + this.sender);
		out.print("받는 사람 : " + this.Recipient);
		out.print("회신 전화번호 : " + this.phoneNum);
		out.print("내용 : " + this.contents);
	}


}
