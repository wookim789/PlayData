package net.basket.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.basket.db.BasketDAO;

public class BasketDeleteAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response)
	throws Exception{
		BasketDAO basketdao=new BasketDAO();
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id");
		
		if(id==null){ //로그인되지 않았을 경우.
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		String num=request.getParameter("num");
		if(num==null){
			return null;
		}
		
		basketdao.basketRemove(Integer.parseInt(num));
		
		ActionForward forward=new ActionForward();
		forward.setRedirect(true);
		forward.setPath("./BasketList.ba");
		return forward;
	}
}