package csit314;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class showUsersServlet
 */
@WebServlet("/agentshowpropertiesbyregion") 

public class AgentShowPropertiesByRegionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final static String query = "select blk_no, address, region, agent from properties where region= ?";
	
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * response.getWriter().append("Served at: ").append(request.getContextPath());
		 */
		
		//get PrintWriter
		PrintWriter pw = response.getWriter();
		
		//set content type
		response.setContentType("text/html");
		
	
		
		//link to bootstrap
		pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
		pw.println("<link rel='stylesheet' href='css/commonstyles.css'></link>");
		pw.println("<link rel='stylesheet' href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'></link>");
		pw.println("<script src=\"main.js\"></script>\r\n"
				+ "");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String selectedRegion = request.getParameter("region");
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/real_estate_system", "root", "csit314@123");
				
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				
			/* preparedStatement.setString(1, "agent"); */
				preparedStatement.setString(1, selectedRegion); // Set the selected region as a parameter

				ResultSet rs = preparedStatement.executeQuery();
				
				
				pw.println("<body>");
				pw.println("<header> <h1>Properties For You!</h1> </header>");
				
				pw.println("<nav>");
				pw.println("<a href='agentprofile.jsp?username=<%=session.getAttribute(\"username\")%'>My Home</a>"); 
				pw.println(" <a href='login.jsp'>Logout</a>"); 
				pw.println("</nav>");
				 
				 
				
				pw.println("<div class='body' style='height: 400px; overflow: auto;'>"); 
				
				pw.println("<div style='margin:auto;width:1000px;margin-top:100px;'>"); 
				pw.println("<table class='table table-hover table-striped'");
				pw.println("<tr>");
				
				pw.println("<th class='text-light bg-dark'>Block Number</th>");
				pw.println("<th class='text-light bg-dark'>Address</th>");
				pw.println("<th class='text-light bg-dark'>Region</th>");
				pw.println("<th class='text-light bg-dark'>Agent Name</th>");
				 
				
				
				pw.println("</tr>");
				
				while(rs.next()) {
					pw.println("<tr>");
					pw.println("<td class='text-light bg-dark'>"+rs.getString(1)+"</td>");
					pw.println("<td class='text-light bg-dark'>"+rs.getString(2)+"</td>");
					pw.println("<td class='text-light bg-dark'>"+rs.getString(3)+"</td>");
					pw.println("<td class='text-light bg-dark'>"+rs.getString(4)+"</td>");
					
				}
				pw.println("</table>");
				
				
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*
		 * pw.
		 * println("<a href='home.jsp'><button class='btn btn-success'>Home!</button></a>"
		 * );
		 */
		pw.println("</div>");
		pw.println("</div>");
		pw.println("<footer class='footer'>");
		pw.println("<i class='bx bxs-copyright'></i><br>");
		pw.println("<p>2024 Real Estate Portal</p>");	
		pw.println("</footer>");
		pw.println("</body>");
		//close stream
		pw.close();
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
