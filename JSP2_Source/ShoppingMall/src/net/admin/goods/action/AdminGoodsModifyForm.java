package net.admin.goods.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.admin.goods.db.*;
public class AdminGoodsModifyForm implements Action {
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) {
		ActionForward forward=new ActionForward();		
		AdminGoodsDAO agoodsdao=new AdminGoodsDAO();
		GoodsBean agb=new GoodsBean();		
		String num=request.getParameter("goods_num");		
		agb=agoodsdao.getGoods(Integer.parseInt(num));		
		request.setAttribute("agb", agb);		
		forward.setPath("./admingoods/admin_goods_modify.jsp");
		return forward;
	}
}