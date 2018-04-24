import static java.lang.System.out;

public class LosicOper {

	public static void main(String[] args) {
		
		int a=3,b=4,c=3,d=5;
		
		if((a == 2 | a ==c)&!(a>d)&(1==b^c!=d)) {
			out.println("ture");
		}else {
			out.print("false");
		}
		
	}

}
