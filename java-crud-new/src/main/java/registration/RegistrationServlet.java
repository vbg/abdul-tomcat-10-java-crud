package registration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")//form action must be here
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//method of the form is post so we have to use doPost method
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		test for the connection
//		PrintWriter out = response.getWriter();
//		out.print("Working");
	
		//catching user inputs
		String uname = request.getParameter("name");
		String uemail = request.getParameter("email");
		String upwd = request.getParameter("pass");
		String umobile = request.getParameter("contact");
		
		boolean isTrue;
		
		//for redirect after adding the data to the table
		jakarta.servlet.RequestDispatcher dispatcher = null;
		
		UsersDBUtil o = new UsersDBUtil();
		isTrue = o.insertuser(uname, uemail, upwd, umobile);
		
		if (isTrue == true) {
			request.setAttribute("status", "success");
			dispatcher = request.getRequestDispatcher("registration.jsp");
		}else {
			request.setAttribute("status", "failed");
		}
		dispatcher.forward(request, response);
		
	}

}
