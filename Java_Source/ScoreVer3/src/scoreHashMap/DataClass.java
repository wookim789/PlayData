package scoreHashMap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import oracle.jdbc.OracleTypes;

public class DataClass {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private Connection con = null;
	private CallableStatement cstmt = null;
	private BufferedReader br =null;
	private ResultSet rs =null;
		
	private String num, name, grade; 
	private int kor, eng, mat, tot;
	private float avg;
	
	public void insert() {
		try {
			br = new BufferedReader(new InputStreamReader (System.in));
			System.out.println("테이블 데이터 삽입");
		
			System.out.println("학번 입력 : ");
			num = br.readLine();
			System.out.println("이름 입력 : ");
			name = br.readLine();
			
			System.out.println("국어 점수 입력 : ");
			kor = Integer.parseInt(br.readLine());
			System.out.println("영어 점수 입력 : ");
			eng = Integer.parseInt(br.readLine());
			System.out.println("수학 점수 입력 : ");
			mat = Integer.parseInt(br.readLine());
			
			
			tot = kor + eng + mat;
			System.out.printf("tot : %d",tot);
			
			avg = (float)tot/3.0f;
			System.out.printf("avg : %f",avg);
			
			gradeM(avg);
			System.out.printf("grade : %s",grade);
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "wookim", "123456");

			cstmt = con.prepareCall("{call call_insert(?,?,?,?,?,?,?,?)}");
			cstmt.setString(1, num);
			cstmt.setString(2, name);
			cstmt.setInt(3, kor);
			cstmt.setInt(4, eng);
			cstmt.setInt(5, mat);
			cstmt.setInt(6, tot);
			cstmt.setFloat(7, avg);
			cstmt.setString(8, this.grade);
	
			cstmt.executeUpdate();
			System.out.println("데이터베이스 연결성공!");
			
			}catch(Exception e) {
				System.out.println("데이터 베이스 연결 실패 = "+ e.getMessage());
			}
		
			finally {
				try{
					if(con != null) con.close();
					if(cstmt != null) cstmt.close();
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		
	}
	public void update( ) {
		try {
			br = new BufferedReader (new InputStreamReader(System.in));
			System.out.println("Memeber 테이블에 값 갱신하기 .....");
			
			System.out.println("갱신할 학번 입력");
			num = br.readLine();
			System.out.println("갱신할 이름 입력 : ");
			name = br.readLine();
			System.out.println("갱신할 국어 점수 입력 : ");
			kor = Integer.parseInt(br.readLine());
			System.out.println("갱신할 영어 점수 입력 : ");
			eng = Integer.parseInt(br.readLine());
			System.out.println("갱신할 수학 점수 입력 : ");
			mat= Integer.parseInt(br.readLine());
			
			tot = kor + eng + mat;
			
			avg = (float)tot/3.0f;
			
			gradeM(avg);
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "wookim", "123456");
			cstmt = con.prepareCall("{call  call_update(?,?,?,?,?,?,?,?)}");
			cstmt.setString(1, num);
			cstmt.setString(2, name);
			cstmt.setInt(3, kor);
			cstmt.setInt(4, eng);
			cstmt.setInt(5, mat);
			cstmt.setInt(6, tot);
			cstmt.setFloat(7, avg);
			cstmt.setString(8, this.grade);
				
			
			cstmt.executeUpdate();

			System.out.println("데이터 베이스 내용 갱신 성공!");
			
		}catch(Exception e) {
			System.out.println("데이터베이스 연결 실패!" + e.getMessage());
		}

		finally {
			try {
				if(cstmt != null) cstmt.close();
				if(con != null) con.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		
	}
	public void delete( ) {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Member 테이블 값 삭제하기.....");
			System.out.println("삭제할 학번 입력 : ");
			this.num = br.readLine();
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "wookim", "123456");
			cstmt = con.prepareCall("{call call_delete(?)}");
			cstmt.setString(1, this.num);
			cstmt.executeUpdate();
			
			
		}catch(Exception e) {
			System.out.println("데이터 베이스 연결 실패 " + e.getMessage());
		}
		finally {
			try {
				if(cstmt != null) cstmt.close();
				if(con != null) con.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	public void select() {
		try {
			br = new BufferedReader (new InputStreamReader(System.in));
			System.out.println("해당 테이블  조회 .....");
			
			System.out.println("코드 입력");
			num = br.readLine();
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "wookim", "123456");
			
			cstmt = con.prepareCall("{call call_select(?,?)}"); //call 다음 call_selectp는 db에 등록되있는 프로시저 식별자다!
			cstmt.setString(1, num);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.executeQuery();
			
			rs = (ResultSet)cstmt.getObject(2);
			
			System.out.println("num/name/kor/eng/mat/tot/avg");
			System.out.println("--------------------------------------");
			//System.out.println(rs.next());
			while(rs.next()) {
				System.out.print(rs.getString("num") + "\t");
				System.out.print(rs.getString("name") + "\t");
				System.out.print(rs.getString("kor") + "\t");
				System.out.print(rs.getString("eng") + "\t");
				System.out.print(rs.getString("mat") + "\t");
				System.out.print(rs.getString("tot") + "\t");
				System.out.print(rs.getString("avg") + "\t");
				System.out.print(rs.getString("grade") + "\n");
			}
		}catch(Exception e) {
			System.out.println("데이터베이스 연결 실패!");
			e.printStackTrace();
		}
		finally {
			try {
				if(con != null) con.close();
				if( cstmt != null) cstmt.close();
				if(rs != null)rs.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	public void selectAll() {
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "wookim", "123456");
			
			cstmt = con.prepareCall("{call call_selectAll(?)}");
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.executeQuery();
			
			rs = (ResultSet)cstmt.getObject(1);
//			System.out.println("rs=" + rs);
			System.out.println("num/name/kor/eng/mat/tot/avg");
			System.out.println("--------------------------------------");

			while(rs.next()) 
			{	System.out.print(rs.getString("num") + "\t");
				System.out.print(rs.getString("name") + "\t");
				System.out.print(Integer.toString(rs.getInt("kor")) + "\t");
				System.out.print(Integer.toString(rs.getInt("eng")) + "\t");
				System.out.print(Integer.toString(rs.getInt("mat")) + "\t");
				System.out.print(Integer.toString(rs.getInt("tot")) + "\t");
				System.out.print(Float.toString(rs.getInt("avg")) + "\t");
				System.out.print(rs.getString("grade") + "\n");
				
			}
		}catch(Exception e) {
			System.out.println("데이터베이스 연결 실패!" + e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				if(con != null) con.close();
				if( cstmt != null) cstmt.close();
				if(rs != null) rs.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	
	public void gradeM(float avg) {
		int a = (int)(avg)/10;
		   
		   switch(a) {
		   		case 10:
		   		case 9:
		   			this.grade = "수";
		   			break;
		   		case 8:
		   			this.grade = "우";
		   			break;
		   		case 7:
		   			this.grade = "미";
		   			break;
		   		case 6:
		   			this.grade = "양";
		   			break;
		   		default :
		   			this.grade = "가";
		   			break;
		   }
	}
}
