package net.admin.goods.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.admin.goods.db.*;
public class AdminGoodsDeleteAction implements Action {
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) {	
		ActionForward forward=new ActionForward();
		AdminGoodsDAO agoodsdao=new AdminGoodsDAO();
		GoodsBean agb= new GoodsBean();		
		agb.setGOODS_NUM(
				Integer.parseInt(request.getParameter("goods_num")));		
		int check=agoodsdao.deleteGoods(agb);
		if(check>0){
			forward.setRedirect(true);
			forward.setPath("GoodsList.ag");
		}		
		return forward;
	}
}