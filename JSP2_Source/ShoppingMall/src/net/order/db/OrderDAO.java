package net.order.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.basket.db.BasketBean;
import net.goods.db.GoodsBean;

public class OrderDAO {
	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs, rs1;
	
	public OrderDAO(){
		try{
			Context initCtx=new InitialContext();
			Context envCtx=(Context)initCtx.lookup("java:comp/env");
			ds=(DataSource)envCtx.lookup("jdbc/OracleDB");
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	
	public int getOrderCount(String id) throws SQLException {
		String sql="select count(*) from goods_order where ORDER_MEMBER_ID=?";
		
		try{
			conn = ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			rs.next();			
			return rs.getInt(1);
		}catch(Exception ex){
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
	
	public int getOrderSumMoney(String id) throws SQLException{
		String sql="select sum(ORDER_SUM_MONEY) from goods_order "+
				   "where ORDER_MEMBER_ID=?";
		
		try{
			conn = ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			rs.next();
			
			return rs.getInt(1);
		}catch(Exception ex){
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
	
	public List getOrderList(int page,int limit,String id) throws SQLException {
		String sql="select * from (select rownum rnum,ORDER_GOODS_NUM,"+
				"ORDER_GOODS_NAME,ORDER_GOODS_AMOUNT,ORDER_GOODS_SIZE,"+
				"ORDER_GOODS_COLOR,ORDER_SUM_MONEY,ORDER_DATE,"+
				"ORDER_STATUS from (select * from GOODS_ORDER " +
				"where ORDER_MEMBER_ID=? order by ORDER_DATE desc)) "+
				"where rnum>=? and rnum<=?";
		List goods_order_list=new ArrayList();
		
		int startrow=(page-1)*10+1;
		int endrow=startrow+limit-1;
		
		try{
			conn = ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setInt(2,startrow);
			pstmt.setInt(3,endrow);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				OrderBean order=new OrderBean();
				order.setORDER_GOODS_NUM(rs.getInt("ORDER_GOODS_NUM"));
				order.setORDER_GOODS_NAME(rs.getString("ORDER_GOODS_NAME"));
				order.setORDER_GOODS_AMOUNT(rs.getInt("ORDER_GOODS_AMOUNT"));
				order.setORDER_GOODS_SIZE(rs.getString("ORDER_GOODS_SIZE"));
				order.setORDER_GOODS_COLOR(rs.getString("ORDER_GOODS_COLOR"));
				order.setORDER_SUM_MONEY(rs.getInt("ORDER_SUM_MONEY"));
				order.setORDER_STATUS(rs.getInt("ORDER_STATUS"));
				order.setORDER_DATE(rs.getDate("ORDER_DATE"));
				
				goods_order_list.add(order);
			}
			
			return goods_order_list;
		}catch(Exception ex){
			ex.printStackTrace();
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
	
	public int addOrder(OrderBean order, Vector goodsvector){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		
		int ordernum=0;
		String sql="select max(ORDER_NUM) from goods_order";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			rs.next();
			ordernum=rs.getInt(1);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		List basketlist=(ArrayList)goodsvector.get(0);
		List goodslist=(ArrayList)goodsvector.get(1);
		
		for (int i = 0; i < basketlist.size(); i++) {
			BasketBean basket=(BasketBean)basketlist.get(i);
			GoodsBean goods=(GoodsBean)goodslist.get(i);
			
			try {
				conn = ds.getConnection();
				++ordernum;
				
				sql = "insert into goods_order values(?,?,?,?,?,"+
					"?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,0)";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, ordernum);
				pstmt.setString(2,sdf.format(cal.getTime()).toString()+ "-" + ordernum);
				pstmt.setString(3, " ");
				pstmt.setInt(4, goods.getGOODS_NUM());
				pstmt.setString(5, goods.getGOODS_NAME());
				pstmt.setInt(6, basket.getBASKET_GOODS_AMOUNT());
				pstmt.setString(7, basket.getBASKET_GOODS_SIZE());
				pstmt.setString(8, basket.getBASKET_GOODS_COLOR());
				pstmt.setString(9, order.getORDER_MEMBER_ID());
				pstmt.setString(10, order.getORDER_RECEIVE_NAME());
				pstmt.setString(11, order.getORDER_RECEIVE_ADDR1());
				pstmt.setString(12, order.getORDER_RECEIVE_ADDR2());
				pstmt.setString(13, order.getORDER_RECEIVE_PHONE());
				pstmt.setString(14, order.getORDER_RECEIVE_MOBILE());
				pstmt.setString(15, order.getORDER_MEMO());
				pstmt.setInt(16, (goods.getGOODS_PRICE()*basket.getBASKET_GOODS_AMOUNT()));
				pstmt.setString(17, order.getORDER_TRADE_TYPE());
				pstmt.setString(18, order.getORDER_TRADE_PAYER());
      			
      			pstmt.executeUpdate();
      			
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
      	}
		
		return ordernum;
	}
}