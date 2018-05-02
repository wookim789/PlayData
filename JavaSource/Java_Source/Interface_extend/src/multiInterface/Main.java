package multiInterface;

public class Main {

	public static void main(String[] args) {
		Label obj = new Label("hello","굴림체" ,"green" ,"red" ,100 ,30 );
		printLabel(obj);
	}
	
	static void printLabel(Label obj){
		System.out.printf(
							"%s %d x %d 배경색 (%s) 전경색 (%s) 폰트(%s) \n",
							obj.text,obj.width,obj.height,obj.background,obj.foreground,obj.font
					     );
	}

}
