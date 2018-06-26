package dbEx2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import oracle.jdbc.OracleTypes;

public class SelectExam_call {
	public static void main(String args[]) {
//
//create or replace procedure call_select(
//    v_member_cursor out sys_refcursor
//)
//is
//begin
//        open v_member_cursor
//    for
//    select * from member
//    order by hakbun;
//end;
///
//
//select * from member;
//
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.0.194:1521:orcl";
		Connection con = null;
		CallableStatement cstmt =null;
		ResultSet rs =null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "SCOTT", "123456");
			
			cstmt = con.prepareCall("{call call_select(?)}");
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.executeQuery();	
			
			rs = (ResultSet)cstmt.getObject(1);
			
			System.out.println("hakbun\tname\taddr\tphone");
			System.out.println("--------------------------------------");
			while(rs.next()) {
				System.out.println(rs.getString("hakbun") + "\t");
				System.out.println(rs.getString("name") + "\t");
				System.out.println(rs.getString("addr") + "\t");
				System.out.println(rs.getString("phone") + "\n");
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

}
