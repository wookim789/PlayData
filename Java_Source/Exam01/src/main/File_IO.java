package main;

import java.io.*;

public class File_IO {
	// 파일 입출력 및 키보드 입력 담당 클래스

	static public String keyRead() throws IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		// 키보드 입력 System.in 정보를 이용해 InputStreamReader 객체를 생성
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		// InputStreamReader 객체는 바이트 단위의 정보를 처리하므로 BufferedReader 객체를 이용해 문단 단위의 정보를 처리할 수 있게 적용
		return bufferedReader.readLine();
		// 키보드로 입력한 한 줄 단위의 데이터를 스트링으로 출력
	}

	static public Object read(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(fileName);
		// FileInputStream 객체를 생성하여 파일 이름을 지정하여 연결 (파일 -> 프로그램)
		BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
		// 직렬화를 위해 BufferedInputStream 객체를 생성
		ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
		// 파일의 내용을 미리 알 수 없으므로 Object 형으로 받아오기 위해 ObjectInputStream 객체 사용
		Object object = objectInputStream.readObject();
		// 파일의 비정규 데이터를 Object형 객체로 옮겨온다. 이후 형변환이 요구됨
		objectInputStream.close();
		// InputStream을 닫아준다
		return object;
	}
	
	static public void save(String fileName, Object object) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream(fileName);
		// FileInputStream 객체를 생성하여 파일 이름을 지정하여 연결 (프로그램 -> 파일)
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		// 직렬화를 위해 BufferedOutputStream 객체를 생성
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
		// 저장되는 내용을 지정할 필요가 없도록 ObjectOutputStream 객체 사용
		objectOutputStream.writeObject(object);
		// 매개변수인 클래스를 비정규 데이터로 입력한다.
		objectOutputStream.close();
		// OutputStream을 닫아준다
	}
	
}
