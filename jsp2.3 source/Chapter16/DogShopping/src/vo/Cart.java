package vo;

import java.net.URLEncoder;

public class Cart {
	
	private String image;
	private String kind;
	private int price;
	private int qty;
	private String encodingKind;
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getKind() {
		return kind;
	}
	
	public String getEncodingKind() {
		try{
		encodingKind = URLEncoder.encode(kind, "UTF-8");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return encodingKind;
	}
	
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getQty() {
		return qty;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
	}
	
}