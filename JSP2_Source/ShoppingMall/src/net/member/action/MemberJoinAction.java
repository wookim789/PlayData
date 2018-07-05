package net.member.action;
import java.io.PrintWriter;
import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.member.db.MemberBean;
import net.member.db.MemberDAO;
public class MemberJoinAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		request.setCharacterEncoding("utf-8");		
		MemberDAO memberdao=new MemberDAO();
		MemberBean dto=new MemberBean();
		ActionForward forward=null;		
		dto.setMEMBER_ID(request.getParameter("MEMBER_ID"));
		dto.setMEMBER_PW(request.getParameter("MEMBER_PW"));
		dto.setMEMBER_NAME(request.getParameter("MEMBER_NAME"));
		dto.setMEMBER_JUMIN1(Integer.parseInt(request.getParameter("MEMBER_JUMIN1")));
		dto.setMEMBER_JUMIN2(Integer.parseInt(request.getParameter("MEMBER_JUMIN2")));
		dto.setMEMBER_EMAIL(request.getParameter("MEMBER_EMAIL1")+"@"+
				request.getParameter("MEMBER_EMAIL2"));
		dto.setMEMBER_EMAIL_GET(request.getParameter("MEMBER_EMAIL_GET"));
		dto.setMEMBER_MOBILE(request.getParameter("MEMBER_MOBILE"));
		dto.setMEMBER_PHONE(request.getParameter("MEMBER_PHONE"));
		dto.setMEMBER_ZIPCODE(request.getParameter("MEMBER_ZIPCODE1")+ " - " +
				request.getParameter("MEMBER_ZIPCODE2"));
		dto.setMEMBER_ADDR1(request.getParameter("MEMBER_ADDR1"));
		dto.setMEMBER_ADDR2(request.getParameter("MEMBER_ADDR2"));
		dto.setMEMBER_ADMIN(0);
		dto.setMEMBER_JOIN_DATE(new Timestamp(System.currentTimeMillis()));		
		memberdao.insertMember(dto);		
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('회원가입에 성공하였습니다.');");
		out.println("location.href='./MemberLogin.me';");
		out.println("</script>");			
		out.close();	
		return forward;
	}
}