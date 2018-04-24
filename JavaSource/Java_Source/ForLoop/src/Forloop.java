import static java.lang.System.out;
public class Forloop {

	public static void main(String[] args) {
		
		int sum=0;
		int arr[ ] = {10, 20, 30, 40, 50};
		
		for(int num :arr) {
			sum += num;
			out.println(sum);
		}
	}
}
