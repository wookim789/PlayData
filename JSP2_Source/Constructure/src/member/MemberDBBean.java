package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MemberDBBean {
   private static MemberDBBean instance = new MemberDBBean();
   
   //DBBean 에서 MemberDataBean의 로우 데이터들을 저장 할 수 있는 Method 만들 것.
   // 여기서 rs 객체를 사용 안함. 위 Method 안에서 사용한다.
   // member_list data 를 arrayList 에 추가
   // ArrayList가 memberDataBean 주소를 가지고 있음 즉 이 ArrayList가 MemberDataBean 유형을 가지고 있음.
   // DBBean은 DataBean의 내용을 가지고 와서 내용 처리, 출력, 수정 등을 위해 사용. MemberDAO(Data Access Object) //MemberDataBean - >Vo(Value object)
   // DB를 처리하는 JavaBean 을 의미한다. 
   public static MemberDBBean getInstance()
   {
      return instance;
   }
   
   private MemberDBBean() {}
   
   private Connection getConnection() throws Exception
   {
	   Context initCtx = new InitialContext();
	   Context envCtx = (Context) initCtx.lookup("java:comp/env");
	   DataSource ds = (DataSource)envCtx.lookup("jdbc/OracleDB");   //데이터 소스 객체
	   return ds.getConnection();
   }
   
   public int insertMember(MemberDataBean memberdata) throws Exception
   {
      Connection conn = null;
      PreparedStatement pstmt = null;
      int result = 0;
      
      try
      {
         conn = getConnection();
         
         pstmt = conn.prepareStatement("insert into member values(?,?,?,?,?,?)");
         pstmt.setString(1,  memberdata.getId());
         pstmt.setString(2,  memberdata.getPassword());
         pstmt.setString(3,  memberdata.getName());
         pstmt.setInt(4,  memberdata.getAge());
         pstmt.setString(5,  memberdata.getGender());
         pstmt.setString(6,  memberdata.getEmail());
         result = pstmt.executeUpdate();
      }
      catch (Exception ex) {
         System.out.println("가입오류" + ex.getMessage());
         ex.printStackTrace();
      } finally {
         if(pstmt != null) try {pstmt.close();}catch(SQLException ex) {}
         if(conn != null) try {pstmt.close();}catch(SQLException ex) {}
      }
      
      return result;
   }
   
   
   public ArrayList<MemberDataBean> getDBListdata(){
	   ArrayList<MemberDataBean> arr=null;
	   MemberDataBean mdb =null;
	   Connection conn=null;
	   PreparedStatement pstmt=null;
	   ResultSet rs=null;
	  
		try {
				arr = new ArrayList<MemberDataBean>();
				conn = getConnection();
				
				pstmt=conn.prepareStatement("SELECT * FROM member");

				rs = pstmt.executeQuery();
				while(rs.next()) {
		
					mdb = new MemberDataBean();
					mdb.setId(rs.getString("id"));
					mdb.setPassword(rs.getString("password"));
					mdb.setName(rs.getString("name"));
					mdb.setAge(rs.getInt("age"));
					mdb.setGender(rs.getString("gender"));
					mdb.setEmail(rs.getString("email"));
					arr.add(mdb);
				}
				
		}catch (Exception ex) 
	      {
	         ex.printStackTrace();
	      } 
	      
		return arr;
   }
}