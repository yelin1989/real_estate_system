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
@WebServlet("/addtofavoriteurl") 

public class AddToFavoriteScreenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final static String query = "select blk_no,address,region,agent from properties where property_id=?";
	
	
    

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
		
		//get propertyid
		int propertyid = Integer.parseInt(request.getParameter("property_id"));
		
		//link to bootstrap
		pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/real_estate_system", "root", "csit314@123");
				
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				//set value
				preparedStatement.setInt(1, propertyid);
				
				ResultSet rs = preparedStatement.executeQuery();
				rs.next();
				pw.println("<div style='margin:auto;width:500px;margin-top:100px;'>");
				pw.println("<form action='addfavorite' method='post'>"); 
				pw.println("<table class='table table-hover table-striped'>");
				pw.println("<tr>");
				pw.println("<td>Block Number</td>");
				pw.println("<td><input type='text' name='blk_no' value='"+rs.getString(1)+"' readonly></td>");
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<td>Address</td>");
				pw.println("<td><input type='text' name='address' value='"+rs.getString(2)+"' readonly></td>");
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<td>Region</td>");
				pw.println("<td><input type='text' name='region' value='"+rs.getString(3)+"' readonly></td>");
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<td>Agent</td>");
				pw.println("<td><input type='text' name='agent' value='"+rs.getString(4)+"' readonly></td>");
				pw.println("</tr>");
				pw.println("<tr>");
				
				pw.println("<td><button type='submit' class='btn btn-outline-success'>Save</button></td>"); 
				/*
				 * pw.
				 * println("<td><button type='reset' class='btn btn-outline-danger'>Cancel</button></td>"
				 * );
				 */
				pw.println("<td>\r\n"
						+ "    <button type=\"reset\" class=\"btn btn-outline-danger\">\r\n"
						+ "        <a href=\"buyerprofile.jsp?username=<%=session.getAttribute('username')%>\">Cancel</a>\r\n"
						+ "    </button>\r\n"
						+ "</td>");
				 
				pw.println("</tr>");
				
				
				
				
				pw.println("</table>");
				
				pw.println("</form>"); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pw.println("<a href='#'><button class='btn btn-outline-success'>Top</button></a>");
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
