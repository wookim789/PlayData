package filestream;
import java.io.*;
public class FileDump {

	public static void main(String[] args) {
		if(args.length <1) {
			System.out.println("Usage: java filedump < filename>");
			return;
		}
		
		FileInputStream in =null;
		
		try {
			in = new FileInputStream(args[0]);
			byte arr [] = new byte[16];
			while(true) {
				int num = in.read(arr);
				if(num<0) {
					break;
				}
				for(int cnt = 0; cnt <num; cnt++) {
					System.out.printf("%02X ",arr[cnt]);
					
				}
				System.out.println();
			}
		}catch(Exception e) {
			System.out.println("에러 : 에러 발생");
		}
		finally 
		{
			try 
				{
					in.close();
				}
			catch(Exception e)
				{
					System.out.println("에러 : 파일 닫기 시 에러 발생");
				}
		}

	}

}
