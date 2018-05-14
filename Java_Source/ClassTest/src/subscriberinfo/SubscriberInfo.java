package subscriberinfo;

public class SubscriberInfo {
	String name, id, password, phoneNo, address;
	
	SubscriberInfo(String name, String id, String password){
		this.name = name;
		this.id = id;
		this.password = password;
	}
	SubscriberInfo(String name, String id, String password, String phoneNo, String address){
		this.name = name;
		this.id = id;
		this.password = password;
		this.phoneNo = phoneNo;
		this.address = address;
	}
	void changePassword(String password) {
		this.password = password;
	}
	void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	void setAddress(String address) {
		this.address = address;
	}
}
