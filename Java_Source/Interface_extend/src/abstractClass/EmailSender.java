package abstractClass;
import static java.lang.System.out;

public class EmailSender extends AbstactClass{
	String sender, Recipient, contents;
	EmailSender (String Name, String title, String sdr, String Rct){
		 super(Name, title);
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
		out.print("내용 : " + this.contents);
	}

	
}
