package subscriberinfo;
import Utility.*;
public class Constuctor {

	public static void main(String[] args) {
		
		SubscriberInfo si1, si2;
		si1 = new SubscriberInfo("연흥부","poorman","zebi");
		si2 = new SubscriberInfo("연놀부","richman","money","02-000-0000","타워팰리스");
		
		pintSubscriberInfo(si1);
		pintSubscriberInfo(si2);
	}
	static void pintSubscriberInfo(SubscriberInfo obj) {
		Utility.println("이름 : " + obj.name);
		Utility.println("아이디 : " + obj.id);
		Utility.println("패스워드 : " + obj.password);
		Utility.println("전화번호 : " + obj.phoneNo);
		Utility.println("주소: " + obj.address);		
	}

}
