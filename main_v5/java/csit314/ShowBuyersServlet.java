package csit314;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Servlet implementation class showUsersServlet
 */
@WebServlet("/showbuyers") 

public class ShowBuyersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final static String query = "select userid, fullname,username, email, role from users where role='buyer'";
	
    

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
		pw.println("<link rel='stylesheet' href='../css/bootstrap.css'></link>");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/real_estate_system", "root", "csit314@123");
				
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				
				ResultSet rs = preparedStatement.executeQuery();
				pw.println("<div style='margin:auto;width:1000px;margin-top:100px;;'>"); 
				pw.println("<table class='table table-hover table-striped'>");
				pw.println("<tr>");
				pw.println("<th class='text-light bg-dark'>User ID</th>");
				pw.println("<th class='text-light bg-dark'>Full Name</th>");
				pw.println("<th class='text-light bg-dark'>Username</th>");
				pw.println("<th class='text-light bg-dark'>Email</th>");
				pw.println("<th class='text-light bg-dark'>Role</th>");
				pw.println("<th class='text-light bg-dark'>Edit</th>");
				pw.println("<th class='text-light bg-dark'>Delete</th>");
				pw.println("</tr>");
				
				while(rs.next()) {
					pw.println("<tr>");
					pw.println("<td class='text-light bg-dark'>"+rs.getString(1)+"</td>");
					pw.println("<td class='text-light bg-dark'>"+rs.getString(2)+"</td>");
					pw.println("<td class='text-light bg-dark'>"+rs.getString(3)+"</td>");
					pw.println("<td class='text-light bg-dark'>"+rs.getString(4)+"</td>");
					pw.println("<td class='text-light bg-dark'>"+rs.getString(5)+"</td>");
					pw.println("<td class='text-light bg-dark'><a href='../editurl?userid="+rs.getInt(1)+"'>Edit</a></td>");
					pw.println("<td class='text-light bg-dark'><a href='../deleteurl?userid="+rs.getInt(1)+"'>Delete</a></td>");
					
				}
				pw.println("</table>");
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pw.println("<a href='#'><button class=\"btn btn-primary btn-lg\">Top</button></a>");
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
