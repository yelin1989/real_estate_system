package csit314;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addpropertiesServelet
 */
@WebServlet("/addproperties")
public class AddPropertiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AddPropertiesDao addPropertiesDao = new AddPropertiesDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPropertiesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String blk_no = request.getParameter("blk_no");
		String address = request.getParameter("address");
		String region = request.getParameter("region");
		String agent = request.getParameter("agent");
		String seller = request.getParameter("seller");
		
		AddProperties addproperties = new AddProperties();
		
		addproperties.setBlk_no(blk_no);
		addproperties.setAddress(address);
		addproperties.setRegion(region);
		addproperties.setAgent(agent);
		addproperties.setSeller(seller);
		
		try {
			addPropertiesDao.addProperties(addproperties);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("agentprofile.jsp");
			dispatcher.forward(request, response);
	
	}
	
}
