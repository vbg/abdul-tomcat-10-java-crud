package registration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class deleteuserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//getting the user inputs
		String deletedataid = request.getParameter("deletedataid");
		System.out.println(deletedataid);
		
		//making a dispatcher object to redirect
		RequestDispatcher dispatcher = null;
		
		//to catch the boolean value that returns from the util class
		boolean isTrue;
		
		//creating a object from util class to access the method
		UsersDBUtil o = new UsersDBUtil();
		//passing the return value of the method
		isTrue = o.deleteUser(deletedataid);
		
		if (isTrue == true) {
		
		request.setAttribute("status", "deleted");
		dispatcher = request.getRequestDispatcher("registration.jsp");
		
		}else {
			
		request.setAttribute("status", "notdeleted");
		dispatcher = request.getRequestDispatcher("myacc.jsp");
		
		}
		//finalizing the dispatcher
		dispatcher.forward(request, response);
	}

}
