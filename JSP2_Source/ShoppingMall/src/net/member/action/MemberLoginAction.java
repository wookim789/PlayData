package net.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.member.db.MemberDAO;
public class MemberLoginAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
	throws Exception{
		HttpSession session=request.getSession();
		ActionForward forward=new ActionForward();
		MemberDAO memberdao=new MemberDAO();		
		String id=request.getParameter("MEMBER_ID");
		String pass=request.getParameter("MEMBER_PW");		
		int check=memberdao.userCheck(id, pass);
		if(check == 1){
			session.setAttribute("id", id);
  			if(memberdao.isAdmin(id)){
				forward.setRedirect(true);
				forward.setPath("./GoodsList.ag"); 
				return forward;
			}else{
				forward.setRedirect(true);
				forward.setPath("./GoodsList.go?item=new_item"); 
				return forward;
			}
		}else if(check == 0){
			response.setContentType("text/html; charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}else{
			response.setContentType("text/html; charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디가 존재하지 않습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		return null;
	}
}