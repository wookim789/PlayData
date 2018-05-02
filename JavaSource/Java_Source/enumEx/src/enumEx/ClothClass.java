package enumEx;

public class ClothClass {
	
	enum Season{
		SPRINH,SUMMER,FALL,WINTER
	}
	
	String code, name, material;
	
	Season season;
	
	ClothClass(String code,String name,String material, Season season){
		this.code = code;
		this.name = name;
		this.material = material;
		this.season = season; 
	}
}
