package net.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	DataSource ds;
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	public MemberDAO() {
		try{
			Context initCtx=new InitialContext();
			Context envCtx=(Context)initCtx.lookup("java:comp/env");
			ds=(DataSource)envCtx.lookup("jdbc/OracleDB");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public boolean insertMember(MemberBean mb) throws SQLException{
		String sql=null;
		boolean result = false;
		try{
			con = ds.getConnection();
			sql="insert into member values "+
				"(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mb.getMEMBER_ID());
			pstmt.setString(2, mb.getMEMBER_PW());
			pstmt.setString(3, mb.getMEMBER_NAME());
			pstmt.setInt(4, mb.getMEMBER_JUMIN1());
			pstmt.setInt(5, mb.getMEMBER_JUMIN2());
			pstmt.setString(6, mb.getMEMBER_EMAIL());
			pstmt.setString(7, mb.getMEMBER_EMAIL_GET());
			pstmt.setString(8, mb.getMEMBER_MOBILE());
			pstmt.setString(9, mb.getMEMBER_PHONE());
			pstmt.setString(10, mb.getMEMBER_ZIPCODE());
			pstmt.setString(11, mb.getMEMBER_ADDR1());
			pstmt.setString(12, mb.getMEMBER_ADDR2());
			pstmt.setInt(13, mb.getMEMBER_ADMIN());
			pstmt.setTimestamp(14, mb.getMEMBER_JOIN_DATE());
			pstmt.executeUpdate();
			
			result = true;
		}catch(Exception e){
			e.printStackTrace();
		}	finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		
		return result;
	}
	
	public int userCheck(String id, String pw) throws SQLException{
		String sql=null;
		int x=-1;
		
		try{
			con = ds.getConnection();
			sql="select MEMBER_PW from member where MEMBER_ID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				String memberpw=rs.getString("MEMBER_PW");
				
				if(memberpw.equals(pw)){
					x=1;
				}else{
					x=0;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}	finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		
		return x;
	}
	
	public int confirmId(String id) throws SQLException{
		String sql=null;
		int x=-1;
		
		try{
			con = ds.getConnection();
			sql="select MEMBER_ID from member where MEMBER_ID=? ";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				x=1;
			}
		}catch(Exception e){
			e.printStackTrace();
		}	finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		
		return x;
	}
	
	public MemberBean getMember(String id) throws SQLException{
		MemberBean member=null;
		String sql=null;
		
		try{
			con = ds.getConnection();
			sql="select * from member where MEMBER_ID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				member=new MemberBean();
				
				member.setMEMBER_ID(rs.getString("MEMBER_ID"));
				member.setMEMBER_NAME(rs.getString("MEMBER_NAME"));
				member.setMEMBER_JUMIN1(rs.getInt("MEMBER_JUMIN1"));
				member.setMEMBER_JUMIN2(rs.getInt("MEMBER_JUMIN2"));
				member.setMEMBER_EMAIL(rs.getString("MEMBER_EMAIL"));
				member.setMEMBER_EMAIL_GET(
						rs.getString("MEMBER_EMAIL_GET"));
				member.setMEMBER_MOBILE(
						rs.getString("MEMBER_MOBILE"));
				member.setMEMBER_PHONE(
						rs.getString("MEMBER_PHONE"));
				member.setMEMBER_ZIPCODE(
						rs.getString("MEMBER_ZIPCODE"));
				member.setMEMBER_ADDR1(rs.getString("MEMBER_ADDR1"));
				member.setMEMBER_ADDR2(rs.getString("MEMBER_ADDR2"));
				
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}	finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		
		return member;
	}
	
	public void updateMember(MemberBean mb) throws SQLException{
		String sql=null;
		
		try{
			con = ds.getConnection();
			sql="update member set MEMBER_PW=?,MEMBER_NAME=?,"+
			"MEMBER_EMAIL=?,MEMBER_EMAIL_GET=?,MEMBER_MOBILE=?,"+
			"MEMBER_PHONE=?,MEMBER_ZIPCODE=?,MEMBER_ADDR1=?,"+
			"MEMBER_ADDR2=? where MEMBER_ID=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mb.getMEMBER_PW());
			pstmt.setString(2, mb.getMEMBER_NAME());
			pstmt.setString(3, mb.getMEMBER_EMAIL());
			pstmt.setString(4, mb.getMEMBER_EMAIL_GET());
			pstmt.setString(5, mb.getMEMBER_MOBILE());
			pstmt.setString(6, mb.getMEMBER_PHONE());
			pstmt.setString(7, mb.getMEMBER_ZIPCODE());
			pstmt.setString(8, mb.getMEMBER_ADDR1());
			pstmt.setString(9, mb.getMEMBER_ADDR2());
			pstmt.setString(10, mb.getMEMBER_ID());			
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}	finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
	}
	
	public int deleteMember(String id, String pw) throws SQLException{
		String sql=null;
		int x=-1;
		
		try{
			con = ds.getConnection();
			sql="select MEMBER_PW from member where MEMBER_ID=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				String memberpw=rs.getString("MEMBER_PW");
				if(memberpw.equals(pw)){
					sql="delete from member where MEMBER_ID=?";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					x=1;
				}else{
					x=0;
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}	finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		
		return x;
	}	
	
	public MemberBean findId(String name, String jumin1, String jumin2)
	throws SQLException{
		String sql=null;
		MemberBean member=null;
		
		try{
			con = ds.getConnection();
			sql="select MEMBER_ID, MEMBER_PW, MEMBER_JUMIN1,"+
				"MEMBER_JUMIN2 from member where MEMBER_NAME=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				
				String memberjumin1=rs.getString("MEMBER_JUMIN1");
				String memberjumin2=rs.getString("MEMBER_JUMIN2");
				
				if(memberjumin1.equals(jumin1) && 
						memberjumin2.equals(jumin2)){
					member = new MemberBean();
					member.setMEMBER_ID(
							rs.getString("MEMBER_ID"));
					member.setMEMBER_PW(
							rs.getString("MEMBER_PW"));
					
				}
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}	finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		
		return member;
	}
	
	public boolean isAdmin(String id){
		String sql="select MEMBER_ADMIN from MEMBER where MEMBER_ID=?";
		int member_admin=0;
		boolean result = false;
		try {
			con = ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			rs.next();
			
			member_admin=rs.getInt("MEMBER_ADMIN");
			
			if(member_admin==1){
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		return result;
	}
	
	public List searchZipcode(String searchdong){
		String sql="select * from zipcode where dong like ?";
		List zipcodeList=new ArrayList();
		
		try{
			con = ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, "%"+searchdong+"%");
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				String sido=rs.getString("sido");
				String gugun=rs.getString("gugun");
				String dong=rs.getString("dong");  
				String ri=rs.getString("ri"); 
				String bunji=rs.getString("bunji");
				if(ri == null) ri="";
				if(bunji == null) bunji="";
				
				String zipcode=rs.getString("zipcode");
				String addr=sido+ " "+gugun+ " "+dong+ " "+ri+ " "+bunji;
				
				zipcodeList.add(zipcode+","+addr);
			}
			
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		return zipcodeList;
	}
}