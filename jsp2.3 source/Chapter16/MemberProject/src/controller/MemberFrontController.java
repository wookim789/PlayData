package controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.Action;
import action.MemberDeleteAction;
import action.MemberJoinAction;
import action.MemberListAction;
import action.MemberLoginAction;
import action.MemberViewAction;
import vo.ActionForward;

@WebServlet("*.me")
public class MemberFrontController extends javax.servlet.http.HttpServlet 
{
	static final long serialVersionUID = 1L;
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		ActionForward forward=null;
		Action action=null;

		if(command.equals("/memberLogin.me")){
			forward=new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./loginForm.jsp");
		}else if(command.equals("/memberJoin.me")){
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./joinForm.jsp");
		}else if(command.equals("/memberLoginAction.me")){
			action = new MemberLoginAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/memberJoinAction.me")){
			action = new MemberJoinAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/memberListAction.me")){
			action = new MemberListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/memberViewAction.me")){
			action = new MemberViewAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/memberDeleteAction.me")){
			action = new MemberDeleteAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(forward != null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher=
						request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request,response);
	}  	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doProcess(request,response);
	}   	  	      	    
}