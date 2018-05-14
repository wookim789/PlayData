package fileclass;
import java.util.*;
import java.io.*;

public class FileClass {

	public static void main(String[] args) {
		File file = new File(".");
		File arr[] = file.listFiles();
		
		for(int i = 0; i < arr.length; i++) 
			System.out.println(arr[i]);

	}

}
