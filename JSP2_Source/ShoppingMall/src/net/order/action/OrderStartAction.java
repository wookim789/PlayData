package net.order.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.basket.db.BasketDAO;
import net.member.db.MemberDAO;
import net.member.db.MemberBean;

public class OrderStartAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	throws Exception{
		ActionForward forward=new ActionForward();
		
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		if(id==null){
			forward.setRedirect(true);
			forward.setPath("./MemberLogin.me");
			return forward;
		}
		
		request.setCharacterEncoding("utf-8");
		
		List orderinfo=new ArrayList();
		String order=request.getParameter("order");
		
		if(order.equals("goods")){
			orderinfo.add(Integer.parseInt(request.getParameter("goodsnum")));
			orderinfo.add(request.getParameter("goodsname"));
			orderinfo.add(Integer.parseInt(request.getParameter("amount")));
			orderinfo.add(request.getParameter("size"));
			orderinfo.add(request.getParameter("color"));
			orderinfo.add(Integer.parseInt(request.getParameter("price")));
			orderinfo.add(request.getParameter("goodsimage"));
			
			request.setAttribute("ordertype", "goods");
			request.setAttribute("orderinfo", orderinfo);
		}else{
			BasketDAO basketdao=new BasketDAO();
			Vector vector=basketdao.getBasketList(id);
			List basketlist=(ArrayList)vector.get(0);
			List goodslist=(ArrayList)vector.get(1);
			
			request.setAttribute("ordertype", "basket");
			request.setAttribute("basketlist", basketlist);
			request.setAttribute("goodslist", goodslist);
		}
		
		MemberDAO memberdao=new MemberDAO();
		MemberBean member=(MemberBean)memberdao.getMember(id);
		request.setAttribute("member", member);
		
		forward.setRedirect(false);
		forward.setPath("./goods_order/goods_buy.jsp");
		return forward;
	}
}