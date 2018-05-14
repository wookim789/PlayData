package filestream;
import java.lang.*;
import java.io.*;

public class FileReadClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int readchar;
		FileReader reader = null;
		
		try 
		{
			reader = new FileReader("porem.txt");
			while(true) 
				{
					readchar = reader.read();
					if(readchar < 0) 
						{
							break;
						}
				else 
					{
						System.out.print((char)readchar);
					}
			}
		}
		catch(FileNotFoundException fnfe) 
			{
				System.out.println("에러 : 파일을 찾을 수 없음");
			}
		catch(IOException ioe) 
			{
				System.out.println("에러 : 파일을 읽을 수 없음");
			}
		finally 
			{
				try 
					{
					reader.close();
					}
				catch(Exception e)
					{
					System.out.println("에러 : 파일 닫기 시 에러 발생");
					}
		}
	}
}
