package net.basket.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.goods.db.GoodsBean;

public class BasketDAO {
	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs, rs1;
	
	public BasketDAO(){
		try{
			Context initCtx=new InitialContext();
			Context envCtx=(Context)initCtx.lookup("java:comp/env");
			ds=(DataSource)envCtx.lookup("jdbc/OracleDB");
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	
	public Vector getBasketList(String id) {
		Vector vector=new Vector();
		List basketlist = new ArrayList();
		List goodslist = new ArrayList();
		
		String sql = "select * from basket where BASKET_MEMBER_ID=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BasketBean dto = new BasketBean();
				GoodsBean goods = new GoodsBean();
				
				dto.setBASKET_NUM(rs.getInt("BASKET_NUM"));
				dto.setBASKET_MEMBER_ID(
						rs.getString("BASKET_MEMBER_ID"));
				dto.setBASKET_GOODS_NUM(
						rs.getInt("BASKET_GOODS_NUM"));
				dto.setBASKET_GOODS_AMOUNT(
						rs.getInt("BASKET_GOODS_AMOUNT"));
				dto.setBASKET_GOODS_SIZE(
						rs.getString("BASKET_GOODS_SIZE"));
				dto.setBASKET_GOODS_COLOR(
						rs.getString("BASKET_GOODS_COLOR"));
				dto.setBASKET_DATE(
						rs.getDate("BASKET_DATE"));
				
				sql = "select * from goods where goods_num=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, dto.getBASKET_GOODS_NUM());
				rs1 = pstmt.executeQuery();
				
				if(rs1.next()){
					goods.setGOODS_NAME(rs1.getString("goods_name"));
					goods.setGOODS_PRICE(rs1.getInt("goods_price"));
					goods.setGOODS_IMAGE(rs1.getString("GOODS_IMAGE"));				}else{
					return null;
				}
				
				basketlist.add(dto);
				goodslist.add(goods);
			}
			
			vector.add(basketlist);
			vector.add(goodslist);
			
			return vector;
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
	
	public void basketAdd(String id,int goodsnum, int amount,String size,String color){
		String sql="select max(basket_num) from basket";
		int num=0;
		
		try{
			conn = ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			rs.next();
			num=rs.getInt(1)+1;
			
			sql="insert into basket values (?,?,?,?,?,?,sysdate)";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, id);
			pstmt.setInt(3, goodsnum);
			pstmt.setInt(4, amount);
			pstmt.setString(5,size);
			pstmt.setString(6, color);
			
			pstmt.executeUpdate();
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
	}
	
	public boolean basketRemove(int num) {
		String sql = "delete from BASKET where BASKET_NUM=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			if(pstmt.executeUpdate()!=0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception ex) {}
		}
		return false;
	}
}