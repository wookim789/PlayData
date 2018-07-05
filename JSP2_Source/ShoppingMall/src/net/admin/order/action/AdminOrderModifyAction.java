package net.admin.order.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.admin.order.db.AdminOrderDAO;
import net.order.db.OrderBean;

public class AdminOrderModifyAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	throws Exception{
		AdminOrderDAO orderdao=new AdminOrderDAO();
		OrderBean order=new OrderBean();
		
		boolean result=false;
		request.setCharacterEncoding("utf-8");
		order.setORDER_NUM(Integer.parseInt(request.getParameter("num")));
		order.setORDER_TRANS_NUM(request.getParameter("transportnum"));
		order.setORDER_MEMO(request.getParameter("memo"));
		order.setORDER_STATUS(Integer.parseInt(request.getParameter("status")));
		
		result=orderdao.modifyOrder(order);
		if(result==false){
			System.out.println("상품 수정 실패");
			return null;
		}
		
		ActionForward forward=new ActionForward();
		forward.setRedirect(true);
		forward.setPath("./AdminOrderList.ao");
		return forward;
	 } 
}