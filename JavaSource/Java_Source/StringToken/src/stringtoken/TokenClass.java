package stringtoken;
import java.util.*;

public abstract class TokenClass {

	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("a=10 b=10,c=10|d=10",",=| ");
		
		while(st.hasMoreElements()) {
			String token = st.nextToken();             
			System.out.print(token);
		}

	}

}
