package enumEx;

public class Main {

	public static void main(String[] args) {
		ClothClass obj = new ClothClass("123123","코트","털",ClothClass.Season.SPRINH);
		System.out.println("코드 : " + obj.code);
		System.out.println("이름 : " + obj.name);
		System.out.println("재료 : " + obj.material);
		System.out.println("계절 : " + obj.season);
		
	}

}
