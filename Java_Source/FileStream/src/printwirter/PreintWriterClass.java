package printwirter;
import java.io.*;

public class PreintWriterClass {

	public static void main(String[] args) {
		PrintWriter pw = null;
		
		try {
			pw = new PrintWriter("output.txt");
			pw.println("ww");
			pw.print("금여일");
		}
		catch(IOException ioe){
			System.out.println("에러");
		}
		finally {
			pw.close();
		}

	}

}
