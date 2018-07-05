package net.basket.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.basket.action.Action;
import net.basket.action.ActionForward;
import net.basket.db.BasketDAO;

public class BasketListAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response)
	throws Exception{
		BasketDAO basketdao=new BasketDAO();
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		
		if(id==null){
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		
		Vector vector = basketdao.getBasketList(id);
		List basketlist=(ArrayList)vector.get(0);
		List goodslist=(ArrayList)vector.get(1);
		
		request.setAttribute("basketlist", basketlist);
		request.setAttribute("goodslist", goodslist);
		
		ActionForward forward=new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./goods_order/goods_basket.jsp");
		
		return forward;
	}
}
