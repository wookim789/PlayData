package net.member.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.member.db.MemberDAO;
public class MemberIDCheckAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
	throws Exception{
		ActionForward forward=new ActionForward();
		String id=request.getParameter("MEMBER_ID");
		MemberDAO memberdao=new MemberDAO();
		int check=memberdao.confirmId(id);	
		request.setAttribute("id", id);
		request.setAttribute("check", check);
		forward.setPath("./member/member_idchk.jsp"); 			
		return forward;
	}
}