package csit314;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class showUsersServlet
 */
@WebServlet("/deletepropertyurl") 

public class DeletePropertyServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final static String query = "delete from properties where property_id = ?";


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
		
		int propertyid = Integer.parseInt(request.getParameter("property_id"));
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/real_estate_system", "root", "csit314@123");
				
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				
				//set the values
				preparedStatement.setInt(1, propertyid);
				//execute the query
				int count = preparedStatement.executeUpdate();
				pw.println("<div class='card' style='margin:auto;width:300px;margin-top:100px'>");
				
				if(count==1) {
					
					pw.println("<h2 class='bg-danger text-light text-center'> Property has been deleted!</h2>");
				} else {
					pw.println("<h2 class='bg-danger text-light text-center'> Property is NOT deleted!</h2>");
				}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		pw.println("<a href='agentprofile.jsp?username=<%=session.getAttribute(\"username\")%'><button class='btn btn-outline-success'>Go Back To Admin Page</button></a>");
		pw.println("</div>"); 
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
