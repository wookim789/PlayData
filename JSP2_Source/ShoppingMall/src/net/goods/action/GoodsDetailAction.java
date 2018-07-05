package net.goods.action;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.goods.db.*;

public class GoodsDetailAction implements Action {
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		GoodsDAO goodsdao = new GoodsDAO();
		
		List imgList = new ArrayList();
		int gr_goods_num = 0;
		GoodsBean isnextpage = null;
		GoodsBean isprevpage = null;
		GoodsBean itemArray = null;
		GoodsBean next_Bean = null;
		GoodsBean prev_Bean = null;
		String item = null;
		String price = "no";

		gr_goods_num = Integer.parseInt(request.getParameter("gr_goods_num"));
		item = request.getParameter("item");
		
		int nextpage = 0;
		int prevpage = 0;
		
		if (request.getParameter("price") != null &&
			!request.getParameter("price").equals("")){
			price = request.getParameter("price");
		}
		if (request.getParameter("search")!= null){
			if (request.getParameter("search").equals("next")) {
				next_Bean = goodsdao.findDetail(gr_goods_num, item, price,"next");
				nextpage = next_Bean.getGOODS_NUM();
				itemArray = goodsdao.findDetailList(nextpage, item);
				isnextpage = goodsdao.findDetail(nextpage, item, price,"next");
				isprevpage = goodsdao.findDetail(nextpage, item, price,"prev");
			}else if (request.getParameter("search").equals("prev")){
				prev_Bean = goodsdao.findDetail(gr_goods_num, item,price,"prev");
				prevpage = prev_Bean.getGOODS_NUM();
				itemArray = goodsdao.findDetailList(prevpage, item);
				isnextpage = goodsdao.findDetail(prevpage, item, price,"next");
				isprevpage = goodsdao.findDetail(prevpage, item, price,"prev");
			}
		}else {
			itemArray = goodsdao.findDetailList(gr_goods_num, item);
			
			if (request.getParameter("isitem").equals("new")) {
				item = "new_item";
			}else if (request.getParameter("isitem").equals("hit")) {
				item = "hit_item";
			}
			
			isnextpage = goodsdao.findDetail(gr_goods_num, item, price,"next");
			isprevpage = goodsdao.findDetail(gr_goods_num, item, price,"prev");
		}
		
		String images = itemArray.getGOODS_IMAGE();
		StringTokenizer st = new StringTokenizer(images, ",");
		while (st.hasMoreTokens()) {
			imgList.add(st.nextToken());
		}
		
		String mainImage = (String) imgList.get(1);
		List contentImage = new ArrayList();
		for (int i = 2; i < imgList.size(); i++) {
			contentImage.add(imgList.get(i));
		}
		
		request.setAttribute("itemArray", itemArray);
		request.setAttribute("item", item);
		request.setAttribute("mainImage", mainImage);
		request.setAttribute("contentImage", contentImage);
		request.setAttribute("prevpage", isprevpage);
		request.setAttribute("nextpage", isnextpage);
		request.setAttribute("price", price);
		
		forward.setRedirect(false);
		forward.setPath("./goods/goods_detail.jsp");
		return forward;
	}
}