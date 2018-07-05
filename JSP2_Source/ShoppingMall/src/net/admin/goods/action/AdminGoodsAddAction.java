package net.admin.goods.action;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import net.admin.goods.db.*;
public class AdminGoodsAddAction implements Action {
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		AdminGoodsDAO agoodsdao= new AdminGoodsDAO();
		GoodsBean agb = new GoodsBean();
		String realPath = "";
		String savePath = "/upload";
		int maxSize = 5 * 1024 * 1024;
		realPath = request.getRealPath(savePath);
		//서버 상의 물리적인 업로드 경로를 얻어 옴
		List savefiles=new ArrayList();
		try {
			MultipartRequest multi = null;
			multi = new MultipartRequest(request, realPath, maxSize, "utf-8",
					new DefaultFileRenamePolicy());
			//
			Enumeration files=multi.getFileNames();
			while(files.hasMoreElements()){
				String name=(String)files.nextElement();
				//file input box 의 이름들을 하나씩 가져옴
				if(files.hasMoreElements()){
					//지금 가져온 이름 다음 이름이 더 있으면
					//즉, 지금 enumeration에서 가져온 이름이 마지막 요소가 아니면
					savefiles.add(multi.getFilesystemName(name)+",");
				}else{
					savefiles.add(multi.getFilesystemName(name));
				}
				//마지막 파일이 아니면 파일명 뒤에 , 를 붙여서 추가하고
				//마지막 파일이면 , 를 붙이지 않고 추가
			}
			StringBuffer fl=new StringBuffer();
			for(int i=0;i<savefiles.size();i++){
				fl.append(savefiles.get(i));	
			}
			//main.jpg,image1-1.jpg,image1-2.jpg,image1-3.jpg
			agb.setGOODS_CATEGORY(multi.getParameter("goods_category"));
			agb.setGOODS_NAME(multi.getParameter("goods_name"));
			agb.setGOODS_CONTENT(multi.getParameter("goods_content"));
			agb.setGOODS_SIZE(multi.getParameter("goods_size"));
			agb.setGOODS_COLOR(multi.getParameter("goods_color"));
			agb.setGOODS_AMOUNT(
					Integer.parseInt(multi.getParameter("goods_amount")));
			agb.setGOODS_PRICE(
					Integer.parseInt(multi.getParameter("goods_price")));
			agb.setGOODS_IMAGE(fl.toString());
			agb.setGOODS_BEST(
					Integer.parseInt(multi.getParameter("goods_best")));
			
			int result = agoodsdao.insertGoods(agb);
			//MultiPartRequest 객체 생성할 때 이미 업로드 처리 되었고
			//업로드 된 파일에 관련된 정보 속성들을 TO 객체에 담아서 파라미터로 전송하면서
			//DB에 입력 작업을 함
			if (result <= 0){
				response.setContentType("text/html;charset=euc-kr");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('등록실패')");
				out.println("history.back()");
				out.println("</script>");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		forward.setRedirect(true);
		forward.setPath("GoodsList.ag");
		return forward;
	}
}