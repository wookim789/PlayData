package net.member.db;
import java.sql.*;
public class MemberBean {
	private String MEMBER_ID;
	private String MEMBER_PW;
	private String MEMBER_NAME;
	private int MEMBER_JUMIN1;
	private int MEMBER_JUMIN2;
	private String MEMBER_EMAIL;
	private String MEMBER_EMAIL_GET;
	private String MEMBER_MOBILE;
	private String MEMBER_PHONE;
	private String MEMBER_ZIPCODE;
	private String MEMBER_ADDR1;
	private String MEMBER_ADDR2;
	private int MEMBER_ADMIN;
	private Timestamp MEMBER_JOIN_DATE;
	
	public String getMEMBER_ID() {
		return MEMBER_ID;
	}
	public void setMEMBER_ID(String member_id) {
		MEMBER_ID = member_id;
	}
	public String getMEMBER_PW() {
		return MEMBER_PW;
	}
	public void setMEMBER_PW(String member_pw) {
		MEMBER_PW = member_pw;
	}
	public String getMEMBER_NAME() {
		return MEMBER_NAME;
	}
	public void setMEMBER_NAME(String member_name) {
		MEMBER_NAME = member_name;
	}
	public int getMEMBER_JUMIN1() {
		return MEMBER_JUMIN1;
	}
	public void setMEMBER_JUMIN1(int member_jumin1) {
		MEMBER_JUMIN1 = member_jumin1;
	}
	public int getMEMBER_JUMIN2() {
		return MEMBER_JUMIN2;
	}
	public void setMEMBER_JUMIN2(int member_jumin2) {
		MEMBER_JUMIN2 = member_jumin2;
	}
	public String getMEMBER_EMAIL() {
		return MEMBER_EMAIL;
	}
	public void setMEMBER_EMAIL(String member_email) {
		MEMBER_EMAIL = member_email;
	}
	public String getMEMBER_EMAIL_GET() {
		return MEMBER_EMAIL_GET;
	}
	public void setMEMBER_EMAIL_GET(String member_email_get) {
		MEMBER_EMAIL_GET = member_email_get;
	}
	public String getMEMBER_MOBILE() {
		return MEMBER_MOBILE;
	}
	public void setMEMBER_MOBILE(String member_mobile) {
		MEMBER_MOBILE = member_mobile;
	}
	public String getMEMBER_PHONE() {
		return MEMBER_PHONE;
	}
	public void setMEMBER_PHONE(String member_phone) {
		MEMBER_PHONE = member_phone;
	}
	public String getMEMBER_ZIPCODE() {
		return MEMBER_ZIPCODE;
	}
	public void setMEMBER_ZIPCODE(String member_zipcode) {
		MEMBER_ZIPCODE = member_zipcode;
	}
	public String getMEMBER_ADDR1() {
		return MEMBER_ADDR1;
	}
	public void setMEMBER_ADDR1(String member_addr1) {
		MEMBER_ADDR1 = member_addr1;
	}
	public String getMEMBER_ADDR2() {
		return MEMBER_ADDR2;
	}
	public void setMEMBER_ADDR2(String member_addr2) {
		MEMBER_ADDR2 = member_addr2;
	}
	public int getMEMBER_ADMIN() {
		return MEMBER_ADMIN;
	}
	public void setMEMBER_ADMIN(int member_admin) {
		MEMBER_ADMIN = member_admin;
	}
	public Timestamp getMEMBER_JOIN_DATE() {
		return MEMBER_JOIN_DATE;
	}
	public void setMEMBER_JOIN_DATE(Timestamp member_join_date) {
		MEMBER_JOIN_DATE = member_join_date;
	}	
}