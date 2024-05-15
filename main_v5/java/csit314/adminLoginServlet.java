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
@WebServlet("/adminlogin")
public class adminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private adminLoginDao adminloginDao;

	public void init() {
		adminloginDao = new adminLoginDao();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session= request.getSession();
		adminLogin login = new adminLogin();
		login.setUsername(username);
		login.setPassword(password);
		

		try {

			if (adminloginDao.validate(login)) {
				session.setAttribute("username", username);
				response.sendRedirect("admin/adminprofile.jsp");
			} else {
				response.sendRedirect("admin/adminusernotfound.jsp");
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

}
