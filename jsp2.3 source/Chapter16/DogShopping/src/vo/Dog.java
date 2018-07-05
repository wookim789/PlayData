package vo;

import java.net.URLEncoder;

public class Dog {
	
	private int id;
	private String kind;
	private int price;
	private String image;
	private String country;
	private int height;
	private int weight;
	private String content;
	private int readcount;

	
	public Dog(int id, String kind, int price, String image, String country,
			int height, int weight, String content, int readcount) {
		super();
		this.id = id;
		this.kind = kind;
		this.price = price;
		this.image = image;
		this.country = country;
		this.height = height;
		this.weight = weight;
		this.content = content;
		this.readcount = readcount;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
    public String getKind(){
    	return kind;
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
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getReadcount() {
		return readcount;
	}
	
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
		
}
