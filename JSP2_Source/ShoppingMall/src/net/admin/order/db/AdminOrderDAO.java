package net.admin.order.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.order.db.OrderBean;

public class AdminOrderDAO {
	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public AdminOrderDAO(){
		try{
			Context initCtx=new InitialContext();
			   Context envCtx=(Context)initCtx.lookup("java:comp/env");
			   ds=(DataSource)envCtx.lookup("jdbc/OracleDB");
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	
	public int getOrderCount(){
		String order_count_sql="select count(*) from GOODS_ORDER";		
		try{
			conn = ds.getConnection();
			pstmt=conn.prepareStatement(order_count_sql);
			rs=pstmt.executeQuery();
			rs.next();
			
			return rs.getInt(1);
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception ex) {}
		}
		return 0;
	}
	
	public List getOrderList(int page,int limit){
		String order_list_sql=
			"select * from (select rownum rnum,ORDER_NUM,"+
			"ORDER_TRADE_NUM,ORDER_TRANS_NUM,ORDER_GOODS_NUM,"+
			"ORDER_GOODS_AMOUNT,ORDER_MEMBER_ID,"+
			"ORDER_RECEIVE_NAME,ORDER_RECEIVE_ADDR1,"+
			"ORDER_RECEIVE_ADDR2,ORDER_RECEIVE_PHONE,"+
			"ORDER_RECEIVE_MOBILE,ORDER_MEMO,"+
			"ORDER_SUM_MONEY,ORDER_TRADE_TYPE,"+
			"ORDER_TRADE_DATE,ORDER_TRADE_PAYER,"+
			"ORDER_DATE,ORDER_STATUS from "+
			"(select * from GOODS_ORDER order by "+
			"ORDER_DATE desc)) where rnum>=? and rnum<=?";
		List orderlist=new ArrayList();
		
		int startrow=(page-1)*10+1;
		int endrow=startrow+limit-1;
		try {
			conn = ds.getConnection();
			pstmt=conn.prepareStatement(order_list_sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs=pstmt.executeQuery();
			while(rs.next()){
				OrderBean order=new OrderBean();
				order.setORDER_NUM(rs.getInt("ORDER_NUM"));
				order.setORDER_TRADE_NUM(
						rs.getString("ORDER_TRADE_NUM"));
				order.setORDER_TRANS_NUM(
						rs.getString("ORDER_TRANS_NUM"));
				order.setORDER_GOODS_NUM(
						rs.getInt("ORDER_GOODS_NUM"));
				order.setORDER_GOODS_AMOUNT(
						rs.getInt("ORDER_GOODS_AMOUNT"));
				order.setORDER_MEMBER_ID(
						rs.getString("ORDER_MEMBER_ID"));
				order.setORDER_RECEIVE_NAME(
						rs.getString("ORDER_RECEIVE_NAME"));
				order.setORDER_RECEIVE_ADDR1(
						rs.getString("ORDER_RECEIVE_ADDR1"));
				order.setORDER_RECEIVE_ADDR2(
						rs.getString("ORDER_RECEIVE_ADDR2"));
				order.setORDER_RECEIVE_PHONE(
						rs.getString("ORDER_RECEIVE_PHONE"));
				order.setORDER_RECEIVE_MOBILE(
						rs.getString("ORDER_RECEIVE_MOBILE"));
				order.setORDER_MEMO(rs.getString("ORDER_MEMO"));
				order.setORDER_SUM_MONEY(
						rs.getInt("ORDER_SUM_MONEY"));
				order.setORDER_TRADE_TYPE(
						rs.getString("ORDER_TRADE_TYPE"));
				order.setORDER_TRADE_DATE(
						rs.getDate("ORDER_TRADE_DATE"));
				order.setORDER_TRADE_PAYER(
						rs.getString("ORDER_TRADE_PAYER"));
				order.setORDER_DATE(rs.getDate("ORDER_DATE"));
				order.setORDER_STATUS(rs.getInt("ORDER_STATUS"));
				orderlist.add(order);
			}
			
			return orderlist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception ex) {}
		}
		return null;
	}
	
	public OrderBean getOrderDetail(int ordernum){
		String order_detail_sql="select * from GOODS_ORDER where ORDER_NUM=?";
		
		try {
			conn = ds.getConnection();
			pstmt=conn.prepareStatement(order_detail_sql);
			pstmt.setInt(1, ordernum);
			rs=pstmt.executeQuery();
			rs.next();
			
			OrderBean order=new OrderBean();
			order.setORDER_NUM(rs.getInt("ORDER_NUM"));
			order.setORDER_TRADE_NUM(rs.getString("ORDER_TRADE_NUM"));
			order.setORDER_TRANS_NUM(rs.getString("ORDER_TRANS_NUM"));
			order.setORDER_GOODS_NUM(rs.getInt("ORDER_GOODS_NUM"));
			order.setORDER_GOODS_NAME(rs.getString("ORDER_GOODS_NAME"));
			order.setORDER_GOODS_AMOUNT(
					rs.getInt("ORDER_GOODS_AMOUNT"));
			order.setORDER_GOODS_SIZE(rs.getString("ORDER_GOODS_SIZE"));
			order.setORDER_GOODS_COLOR(
					rs.getString("ORDER_GOODS_COLOR"));
			order.setORDER_MEMBER_ID(rs.getString("ORDER_MEMBER_ID"));
			order.setORDER_RECEIVE_NAME(
					rs.getString("ORDER_RECEIVE_NAME"));
			order.setORDER_RECEIVE_ADDR1(
					rs.getString("ORDER_RECEIVE_ADDR1"));
			order.setORDER_RECEIVE_ADDR2(
					rs.getString("ORDER_RECEIVE_ADDR2"));
			order.setORDER_RECEIVE_PHONE(
					rs.getString("ORDER_RECEIVE_PHONE"));
			order.setORDER_RECEIVE_MOBILE(
					rs.getString("ORDER_RECEIVE_MOBILE"));
			order.setORDER_MEMO(rs.getString("ORDER_MEMO"));
			order.setORDER_SUM_MONEY(rs.getInt("ORDER_SUM_MONEY"));
			order.setORDER_TRADE_TYPE(rs.getString("ORDER_TRADE_TYPE"));
			order.setORDER_TRADE_DATE(rs.getDate("ORDER_TRADE_DATE"));
			order.setORDER_TRADE_PAYER(
					rs.getString("ORDER_TRADE_PAYER"));
			order.setORDER_DATE(rs.getDate("ORDER_DATE"));
			order.setORDER_STATUS(rs.getInt("ORDER_STATUS"));
			
			return order;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception ex) {}
		}
		return null;
	}
	
	public boolean modifyOrder(OrderBean order){
		String order_modify_sql=
			"update GOODS_ORDER set ORDER_TRANS_NUM=?,"+
			"ORDER_MEMO=?,ORDER_STATUS=? where ORDER_NUM=?";
		int result=0;
		
		try{
			conn = ds.getConnection();
			pstmt=conn.prepareStatement(order_modify_sql);
			pstmt.setString(1, order.getORDER_TRANS_NUM());
			pstmt.setString(2, order.getORDER_MEMO());
			pstmt.setInt(3, order.getORDER_STATUS());
			pstmt.setInt(4, order.getORDER_NUM());
			result=pstmt.executeUpdate();
			
			if(result==1){
				return true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception ex) {}
		}
		return false;
	}
	
	public boolean deleteOrder(int ordernum){
		String order_delete_sql="delete from GOODS_ORDER where ORDER_NUM=?";
		int result=0;
		
		try{
			conn = ds.getConnection();
			pstmt=conn.prepareStatement(order_delete_sql);
			pstmt.setInt(1, ordernum);
			result=pstmt.executeUpdate();
			
			if(result==1){
				return true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception ex) {}
		}
		return false;
	}
}