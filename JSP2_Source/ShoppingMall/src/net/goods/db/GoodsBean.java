package net.goods.db;

import java.sql.Timestamp;

public class GoodsBean {
	private int GOODS_NUM;
	private String GOODS_CATEGORY;
	private String GOODS_NAME;
	private String GOODS_CONTENT;
	private String GOODS_SIZE;
	private String GOODS_COLOR;
	private int GOODS_AMOUNT;
	private int GOODS_PRICE;
	private String GOODS_IMAGE;
	private int GOODS_BEST;
	private Timestamp GOODS_DATE;
	
	public int getGOODS_NUM() {
		return GOODS_NUM;
	}
	public void setGOODS_NUM(int goods_num) {
		GOODS_NUM = goods_num;
	}
	public String getGOODS_CATEGORY() {
		return GOODS_CATEGORY;
	}
	public void setGOODS_CATEGORY(String goods_category) {
		GOODS_CATEGORY = goods_category;
	}
	public String getGOODS_NAME() {
		return GOODS_NAME;
	}
	public void setGOODS_NAME(String goods_name) {
		GOODS_NAME = goods_name;
	}
	public String getGOODS_CONTENT() {
		return GOODS_CONTENT;
	}
	public void setGOODS_CONTENT(String goods_content) {
		GOODS_CONTENT = goods_content;
	}
	public String getGOODS_SIZE() {
		return GOODS_SIZE;
	}
	public void setGOODS_SIZE(String goods_size) {
		GOODS_SIZE = goods_size;
	}
	public String getGOODS_COLOR() {
		return GOODS_COLOR;
	}
	public void setGOODS_COLOR(String goods_color) {
		GOODS_COLOR = goods_color;
	}
	public int getGOODS_AMOUNT() {
		return GOODS_AMOUNT;
	}
	public void setGOODS_AMOUNT(int goods_amount) {
		GOODS_AMOUNT = goods_amount;
	}
	public int getGOODS_PRICE() {
		return GOODS_PRICE;
	}
	public void setGOODS_PRICE(int goods_price) {
		GOODS_PRICE = goods_price;
	}
	public String getGOODS_IMAGE() {
		return GOODS_IMAGE;
	}
	public void setGOODS_IMAGE(String goods_image) {
		GOODS_IMAGE = goods_image;
	}
	public int getGOODS_BEST() {
		return GOODS_BEST;
	}
	public void setGOODS_BEST(int goods_best) {
		GOODS_BEST = goods_best;
	}
	public Timestamp getGOODS_DATE() {
		return GOODS_DATE;
	}
	public void setGOODS_DATE(Timestamp goods_date) {
		GOODS_DATE = goods_date;
	}
}