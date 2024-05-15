package csit314;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;

	public void init() {
		loginDao = new LoginDao();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		Login login = new Login();
		HttpSession session= request.getSession();
		login.setUsername(username);
		login.setPassword(password);
		login.setRole(role);

		try {
			

			
			
			  if (loginDao.validate(login) && role.equals("Agent")) {
				  response.sendRedirect("agentprofile.jsp");
			   } else if
			  (loginDao.validate(login) && role.equals("Buyer")) {
					/* session.setAttribute("username", username); */
				  response.sendRedirect("buyerprofile.jsp");
			   } else if
			  (loginDao.validate(login) && role.equals("Seller")) {
				   response.sendRedirect("sellerprofile.jsp");	
			   } else {
			  response.sendRedirect("usernotfound.jsp"); }
			  
			  session.setAttribute("username", username);
			 
			
			 
		
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

}
