package net.order.db;

import java.sql.Date;

public class OrderBean {
	private int ORDER_NUM;
	private String ORDER_TRADE_NUM;
	private String ORDER_TRANS_NUM;
	private int ORDER_GOODS_NUM;
	private String ORDER_GOODS_NAME;
	private int ORDER_GOODS_AMOUNT;
	private String ORDER_GOODS_SIZE;
	private String ORDER_GOODS_COLOR;
	private String ORDER_MEMBER_ID;
	private String ORDER_RECEIVE_NAME;
	private String ORDER_RECEIVE_ADDR1;
	private String ORDER_RECEIVE_ADDR2;
	private String ORDER_RECEIVE_PHONE;
	private String ORDER_RECEIVE_MOBILE;
	private String ORDER_MEMO;
	private int ORDER_SUM_MONEY;
	private String ORDER_TRADE_TYPE;
	private Date ORDER_TRADE_DATE;
	private String ORDER_TRADE_PAYER;
	private Date ORDER_DATE;
	private int ORDER_STATUS;
	
	public String getORDER_GOODS_NAME() {
		return ORDER_GOODS_NAME;
	}
	public void setORDER_GOODS_NAME(String order_goods_name) {
		ORDER_GOODS_NAME = order_goods_name;
	}
	public String getORDER_GOODS_SIZE() {
		return ORDER_GOODS_SIZE;
	}
	public void setORDER_GOODS_SIZE(String order_goods_size) {
		ORDER_GOODS_SIZE = order_goods_size;
	}
	public String getORDER_GOODS_COLOR() {
		return ORDER_GOODS_COLOR;
	}
	public void setORDER_GOODS_COLOR(String order_goods_color) {
		ORDER_GOODS_COLOR = order_goods_color;
	}
	public String getORDER_TRANS_NUM() {
		return ORDER_TRANS_NUM;
	}
	public void setORDER_TRANS_NUM(String order_trans_num) {
		ORDER_TRANS_NUM = order_trans_num;
	}
	public int getORDER_NUM() {
		return ORDER_NUM;
	}
	public void setORDER_NUM(int order_num) {
		ORDER_NUM = order_num;
	}
	public String getORDER_TRADE_NUM() {
		return ORDER_TRADE_NUM;
	}
	public void setORDER_TRADE_NUM(String order_trade_num) {
		ORDER_TRADE_NUM = order_trade_num;
	}
	public int getORDER_GOODS_NUM() {
		return ORDER_GOODS_NUM;
	}
	public void setORDER_GOODS_NUM(int order_goods_num) {
		ORDER_GOODS_NUM = order_goods_num;
	}
	public int getORDER_GOODS_AMOUNT() {
		return ORDER_GOODS_AMOUNT;
	}
	public void setORDER_GOODS_AMOUNT(int order_goods_amount) {
		ORDER_GOODS_AMOUNT = order_goods_amount;
	}
	public String getORDER_MEMBER_ID() {
		return ORDER_MEMBER_ID;
	}
	public void setORDER_MEMBER_ID(String order_member_id) {
		ORDER_MEMBER_ID = order_member_id;
	}
	public String getORDER_RECEIVE_NAME() {
		return ORDER_RECEIVE_NAME;
	}
	public void setORDER_RECEIVE_NAME(String order_receive_name) {
		ORDER_RECEIVE_NAME = order_receive_name;
	}
	public String getORDER_RECEIVE_ADDR1() {
		return ORDER_RECEIVE_ADDR1;
	}
	public void setORDER_RECEIVE_ADDR1(String order_receive_addr1) {
		ORDER_RECEIVE_ADDR1 = order_receive_addr1;
	}
	public String getORDER_RECEIVE_ADDR2() {
		return ORDER_RECEIVE_ADDR2;
	}
	public void setORDER_RECEIVE_ADDR2(String order_receive_addr2) {
		ORDER_RECEIVE_ADDR2 = order_receive_addr2;
	}
	public String getORDER_RECEIVE_PHONE() {
		return ORDER_RECEIVE_PHONE;
	}
	public void setORDER_RECEIVE_PHONE(String order_receive_phone) {
		ORDER_RECEIVE_PHONE = order_receive_phone;
	}
	public String getORDER_RECEIVE_MOBILE() {
		return ORDER_RECEIVE_MOBILE;
	}
	public void setORDER_RECEIVE_MOBILE(String order_receive_mobile) {
		ORDER_RECEIVE_MOBILE = order_receive_mobile;
	}
	public String getORDER_MEMO() {
		return ORDER_MEMO;
	}
	public void setORDER_MEMO(String order_memo) {
		ORDER_MEMO = order_memo;
	}
	public int getORDER_SUM_MONEY() {
		return ORDER_SUM_MONEY;
	}
	public void setORDER_SUM_MONEY(int order_sum_money) {
		ORDER_SUM_MONEY = order_sum_money;
	}
	public String getORDER_TRADE_TYPE() {
		return ORDER_TRADE_TYPE;
	}
	public void setORDER_TRADE_TYPE(String order_trade_type) {
		ORDER_TRADE_TYPE = order_trade_type;
	}
	public Date getORDER_TRADE_DATE() {
		return ORDER_TRADE_DATE;
	}
	public void setORDER_TRADE_DATE(Date order_trade_date) {
		ORDER_TRADE_DATE = order_trade_date;
	}
	public String getORDER_TRADE_PAYER() {
		return ORDER_TRADE_PAYER;
	}
	public void setORDER_TRADE_PAYER(String order_trade_payer) {
		ORDER_TRADE_PAYER = order_trade_payer;
	}
	public Date getORDER_DATE() {
		return ORDER_DATE;
	}
	public void setORDER_DATE(Date order_date) {
		ORDER_DATE = order_date;
	}
	public int getORDER_STATUS() {
		return ORDER_STATUS;
	}
	public void setORDER_STATUS(int order_status) {
		ORDER_STATUS = order_status;
	}
}