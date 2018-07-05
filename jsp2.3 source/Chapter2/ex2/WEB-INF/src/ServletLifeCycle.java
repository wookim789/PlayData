import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLifeCycle extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public ServletLifeCycle() {
        super();
        System.out.println("Constructor");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	System.out.println("init");
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("service");
    	super.service(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet");
    }
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("doPost");
    }
	
    @Override
    public void destroy() {
        System.out.println("destroy");
	super.destroy();
    }

}
