package net.member.action;
import java.io.PrintWriter;
import javax.servlet.http.*;
import net.member.db.MemberDAO;
public class MemberDeleteAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
	throws Exception{
		ActionForward forward=new ActionForward();
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		
		if(id==null){
			forward.setRedirect(true);
			forward.setPath("./MemberLogin.me");
			return forward;
		}
		MemberDAO memberdao=new MemberDAO();
		String pass=request.getParameter("MEMBER_PW");
		
		try{
			int check=memberdao.deleteMember(id, pass);
			
			if(check == 1){
				
				session.invalidate();
				
				forward.setPath("./member/member_out_ok.jsp"); 
				
			}else{
				response.setContentType("text/html; charset=euc-kr");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('비밀번호가 맞지않습니다.');");
				out.println("history.go(-1);");
				out.println("</script>");
				out.close();
				forward=null;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return forward;
	}
}