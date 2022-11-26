package registration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServletNew extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//getting the user inputs
		String uemail = request.getParameter("username");
		String upwd = request.getParameter("password");
		
		//creating a session
		HttpSession session = request.getSession();
		
		//making a dispatcher object to redirect
		RequestDispatcher dispatcher = null;
		
		
		//validations
		if (uemail == null || uemail.equals("")) {
			request.setAttribute("status", "invalidemail");
			dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		if (upwd == null || upwd.equals("")) {
			request.setAttribute("status", "invalidupwd");
			dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		
		//to catch the boolean value that returns from the util class
		boolean isTrue;
		
		//creating a object from util class to access the method
		UsersDBUtil o = new UsersDBUtil();
		
		//passing the return value of the method
        isTrue = o.validateuser(uemail, upwd);
        
        //storing user data
      	List<User> userDetails = o.getUserDetails(uemail, upwd);
      	
		if (UsersDBUtil.userCheck == true) {
			
			//creating the session
			session.setAttribute("name", uemail);
			request.setAttribute("userDetails", userDetails);
			request.setAttribute("status", "pass");
			//redirect to another page
			dispatcher = request.getRequestDispatcher("admin.jsp");
		
		}else if (isTrue == true) {
			
			//creating the session
			session.setAttribute("name", uemail);
			request.setAttribute("userDetails", userDetails);
			request.setAttribute("status", "pass");
			//redirect to another page
			dispatcher = request.getRequestDispatcher("myacc.jsp");
		
		}else {
			request.setAttribute("status", "failed");
			dispatcher = request.getRequestDispatcher("login.jsp");
		}
		//finalizing the dispatcher
		dispatcher.forward(request, response);
		
	}

}
