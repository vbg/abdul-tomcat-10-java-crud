package registration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		boolean isTrue;
		//making a dispatcher object to redirect
		RequestDispatcher dis = null;
		
		UsersDBUtil o = new UsersDBUtil();
		isTrue = o.updateUser(id, name, password, email, mobile);
		
		if (isTrue == true) {
			request.setAttribute("status", "updatedone");
			dis = request.getRequestDispatcher("login.jsp");
		}else {
			request.setAttribute("status", "updatefailed");
			dis = request.getRequestDispatcher("updateuser.jsp");
		}
		dis.forward(request, response);
	}

}
