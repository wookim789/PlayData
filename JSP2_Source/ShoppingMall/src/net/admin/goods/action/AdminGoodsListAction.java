package net.admin.goods.action;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.admin.goods.db.*;
public class AdminGoodsListAction implements Action {
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) {
		AdminGoodsDAO agoodsdao=new AdminGoodsDAO();
		GoodsBean agb=new GoodsBean();
		
		ActionForward forward=new ActionForward();
		
		ArrayList list=(ArrayList)agoodsdao.getGoodsList();
		
		request.setAttribute("list",list);
		
		forward.setPath("./admingoods/admin_goods_list.jsp");
		return forward;
	}
}