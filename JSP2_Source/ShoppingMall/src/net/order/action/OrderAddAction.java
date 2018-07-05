package net.order.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.basket.db.BasketBean;
import net.basket.db.BasketDAO;

import net.goods.db.GoodsBean;

import net.order.db.OrderBean;
import net.order.db.OrderDAO;

public class OrderAddAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	throws Exception{
		request.setCharacterEncoding("utf-8");
		
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		
		if(id==null){
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		
		Vector goodsvector=new Vector();
		
		OrderDAO orderdao=new OrderDAO();
		OrderBean order=new OrderBean();
		
		List basketlist=new ArrayList();
		List goodslist=new ArrayList();
		GoodsBean goods=new GoodsBean();
		BasketDAO basketdao=new BasketDAO();
		BasketBean basket=new BasketBean();
		
		order.setORDER_MEMBER_ID(request.getParameter("memberid"));
		order.setORDER_RECEIVE_NAME(request.getParameter("ORDER_RECEIVE_NAME"));
		order.setORDER_RECEIVE_PHONE(request.getParameter("ORDER_RECEIVE_PHONE"));
		order.setORDER_RECEIVE_MOBILE(request.getParameter("ORDER_RECEIVE_MOBILE"));
		order.setORDER_RECEIVE_ADDR1(request.getParameter("ORDER_RECEIVE_ZIPCODE")+
				" "+request.getParameter("ORDER_RECEIVE_ADDR1"));
		order.setORDER_RECEIVE_ADDR2(request.getParameter("ORDER_RECEIVE_ADDR2"));
		order.setORDER_MEMO(request.getParameter("ORDER_MEMO"));
		order.setORDER_TRADE_TYPE("온라인입금");
		order.setORDER_TRADE_PAYER(request.getParameter("ORDER_TRADE_PAYER"));
		
		String ordertype=request.getParameter("ordertype");
		if(ordertype.equals("goods")){
			basket.setBASKET_GOODS_NUM(	Integer.parseInt(request.getParameter("goodsnum")));
			basket.setBASKET_GOODS_AMOUNT(Integer.parseInt(request.getParameter("goodsamount")));
			basket.setBASKET_GOODS_SIZE(request.getParameter("goodssize"));
			basket.setBASKET_GOODS_COLOR(request.getParameter("goodscolor"));
			
			goods.setGOODS_NAME(request.getParameter("goodsname"));
			goods.setGOODS_PRICE(Integer.parseInt(request.getParameter("goodsprice")));
			
			basketlist.add(basket);
			goodslist.add(goods);
			
			goodsvector.add(basketlist);
			goodsvector.add(goodslist);
		}else{
			goodsvector=basketdao.getBasketList(id);
		}
		
		orderdao.addOrder(order, goodsvector);
		
		ActionForward forward=new ActionForward();
		forward.setRedirect(true);
		forward.setPath("./OrderOk.or");
		return forward;
	}
}