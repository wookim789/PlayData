package net.order.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.order.db.OrderDAO;

public class OrderListAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response){
		ActionForward forward=new ActionForward();
		
		HttpSession session = request.getSession();
		String id =(String)session.getAttribute("id");
		
		if(id==null){			
			forward.setRedirect(true);
			forward.setPath("./MemberLogin.me");
			return forward;
		}
		
		int page=1;
		int limit=10;
		OrderDAO orderdao=new OrderDAO();
		List goods_order_list=new ArrayList();
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		try{
			int ordercount=orderdao.getOrderCount(id);
			int totalmoney=orderdao.getOrderSumMoney(id);
			goods_order_list = orderdao.getOrderList(page,limit,id);
			
			int maxpage=(int)((double)ordercount/limit+0.95);
			int startpage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
			int endpage = maxpage;
			if (endpage>startpage+10-1) endpage=startpage+10-1;
			
			request.setAttribute("page", page);
			request.setAttribute("maxpage", maxpage);
			request.setAttribute("startpage", startpage);
			request.setAttribute("endpage", endpage);
			request.setAttribute("ordercount", ordercount);
			request.setAttribute("totalmoney", totalmoney);
			request.setAttribute("goods_order_list", goods_order_list);
			
			forward.setRedirect(false);
			forward.setPath("./goods_order/goods_my_order.jsp");
			return forward;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	 } 
}