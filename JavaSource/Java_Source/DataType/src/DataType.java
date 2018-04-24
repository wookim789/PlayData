import static java.lang.System.out;

public class DataType {

	public static void main(String[] args) {
		
		float a = 5.1f, b = 2.4f;
		double c = 7.5;
		double d = a + b;
		double e = 5.1 +2.4;
		
		out.printf("a: %f ",a);
		out.printf("b: %f ",b);
		out.printf("c: %f ",c);
		out.printf("d: %f ",d);
		out.printf("e: %f \n",e);

		
		if(c==(a+b)) {
			out.print("c==(a+b) is same  ");
			out.print(a+" ");
			out.print(b+" ");
			out.println(c);
		}else {
			out.println("c==(a+b) is not same ");
			out.print(a+" ");
			out.print(b+" ");
			out.println(c);
		}
	
		if(c==d) {
			out.print("c==d is same ");
			out.print(c+" ");
			out.println(d+" ");
		}else {
			out.print("c==d is not same ");
			out.print(c+" ");
			out.println(d+" ");
		}
		
		if(c==e) {
			out.print("same ");
			out.print(c+" ");
			out.println(e+" ");
		}else {
			out.print("not same");
			out.print(c);
			out.println(e);
		}
		

		
	    
	} 
}