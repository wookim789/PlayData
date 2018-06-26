

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChoiseDogServlet
 */
@WebServlet("/source/ChoiseDogServlet")
public class ChoiseDogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChoiseDogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String[] dog = request.getParameterValues("dog");
		

		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body bgcolo = 'black'>");
		out.println("<table align = 'center' bgcolor='yellow'>");
		out.println("<tr>");
		
		for(int i = 0; i < dog.length ; i++) {
			out.println("<td>");
			out.println("<img src ='" +dog[i]+ "' />");
			out.println("</td>");
		}
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

}
