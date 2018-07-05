package net.basket.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.basket.db.BasketDAO;

public class BasketAddAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	throws Exception{
		BasketDAO basketdao=new BasketDAO();
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id");
		
		if(id==null){
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		
		int num=Integer.parseInt(request.getParameter("goodsnum"));
		int amount=Integer.parseInt(request.getParameter("amount"));
		String size=request.getParameter("size");
		String color=request.getParameter("color");
		
		String item=request.getParameter("item");
		String gr_goods_num=request.getParameter("gr_goods_num");
		String isitem=request.getParameter("isitem");
		
		basketdao.basketAdd(id,num,amount,size,color);
		
		ActionForward forward=new ActionForward();
		forward.setRedirect(true);
		forward.setPath("./BasketList.ba?item="+item+
				"&gr_goods_num="+gr_goods_num+"&isitem="+isitem);
		return forward;
	}
}