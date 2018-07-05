package net.admin.goods.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
public class AdminGoodsDAO {
	DataSource ds;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public AdminGoodsDAO(){
		try{
			Context initCtx=new InitialContext();
			   Context envCtx=(Context)initCtx.lookup("java:comp/env");
			   ds=(DataSource)envCtx.lookup("jdbc/OracleDB");
			  
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	public List getGoodsList() {
		List goodslist = new ArrayList();
		try {
			con = ds.getConnection();
			String sql="select * from goods order by goods_num";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				GoodsBean agb = new GoodsBean();
				agb.setGOODS_NUM(rs.getInt("goods_num"));
				agb.setGOODS_CATEGORY(rs.getString("goods_category"));
				agb.setGOODS_NAME(rs.getString("goods_name"));
				agb.setGOODS_CONTENT(rs.getString("goods_content"));
				agb.setGOODS_SIZE(rs.getString("goods_size"));
				agb.setGOODS_COLOR(rs.getString("goods_color"));
				agb.setGOODS_AMOUNT(rs.getInt("goods_amount"));
				agb.setGOODS_PRICE(rs.getInt("goods_price"));
				agb.setGOODS_IMAGE(rs.getString("goods_image"));
				agb.setGOODS_BEST(rs.getInt("goods_best"));
				agb.setGOODS_DATE(rs.getString("goods_date"));
				goodslist.add(agb);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		return goodslist;
	}
	public GoodsBean getGoods(int num) {
		GoodsBean agb = null;
		try {
			con = ds.getConnection();
			String sql="select * from goods where goods_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,num);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
			agb=new GoodsBean();
			agb.setGOODS_NUM(rs.getInt("goods_num"));
			agb.setGOODS_CATEGORY(rs.getString("goods_category"));
			agb.setGOODS_NAME(rs.getString("goods_name"));
			agb.setGOODS_CONTENT(rs.getString("goods_content"));
			agb.setGOODS_SIZE(rs.getString("goods_size"));
			agb.setGOODS_COLOR(rs.getString("goods_color"));
			agb.setGOODS_AMOUNT(rs.getInt("goods_amount"));
			agb.setGOODS_PRICE(rs.getInt("goods_price"));
			agb.setGOODS_IMAGE(rs.getString("goods_image"));
			agb.setGOODS_BEST(rs.getInt("goods_best"));
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

		return agb;
	}
	public int insertGoods(GoodsBean agb) {
		int result = 0;
		int num=0;
		String sql="select max(goods_num) from goods";
		try {
			con = ds.getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			rs.next();
			num=rs.getInt(1)+1;
			sql="insert into goods values "+
			"(?,?,?,?,?,?,?,?,?,?,sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, agb.getGOODS_CATEGORY());
			pstmt.setString(3, agb.getGOODS_NAME());
			pstmt.setString(4, agb.getGOODS_CONTENT());
			pstmt.setString(5, agb.getGOODS_SIZE());
			pstmt.setString(6, agb.getGOODS_COLOR());
			pstmt.setInt(7, agb.getGOODS_AMOUNT());
			pstmt.setInt(8, agb.getGOODS_PRICE());
			pstmt.setString(9, agb.getGOODS_IMAGE());
			pstmt.setInt(10, agb.getGOODS_BEST());
			result = pstmt.executeUpdate();
			} catch (Exception e) {
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
	public int deleteGoods(GoodsBean agb){
		int result = 0;
		try {
			con = ds.getConnection();
			String sql="delete from goods where goods_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, agb.getGOODS_NUM());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.getStackTrace();
		}
		finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		return result;
	}
	public int modifyGoods(GoodsBean agb) {
		int result = 0;
		try {
			con = ds.getConnection();
			String sql="update goods set "+
			"goods_category=?, goods_name=?, goods_price=? ,"+
			"goods_color=? ,goods_amount=? ,goods_size=? ,"+
			"goods_content=?,goods_best=? where goods_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, agb.getGOODS_CATEGORY());
			pstmt.setString(2, agb.getGOODS_NAME());
			pstmt.setInt(3, agb.getGOODS_PRICE());
			pstmt.setString(4, agb.getGOODS_COLOR());
			pstmt.setInt(5, agb.getGOODS_AMOUNT());
			pstmt.setString(6, agb.getGOODS_SIZE());
			pstmt.setString(7, agb.getGOODS_CONTENT());
			pstmt.setInt(8, agb.getGOODS_BEST());
			pstmt.setInt(9, agb.getGOODS_NUM());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		return result;
	}
}