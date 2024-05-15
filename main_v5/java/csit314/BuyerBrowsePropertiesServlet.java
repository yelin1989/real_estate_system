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
 * Servlet implementation class BuyerBrowsePropertiesServlet
 */
@WebServlet("/browseproperties")
public class BuyerBrowsePropertiesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private final static String query = "SELECT property_id, blk_no, address, region, agent FROM properties";
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");
        
        pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
        pw.println("<link rel='stylesheet' href='css/commonstyles.css'></link>");
        pw.println("<link rel='stylesheet' href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'></link>");
        pw.println("<script src=\"main.js\"></script>");
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/real_estate_system", "root", "csit314@123");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            ResultSet rs = preparedStatement.executeQuery();
            
            pw.println("<body>");
            pw.println("<header> <h1>Properties For You!</h1> </header>");
            pw.println("<nav>");
            pw.println("<a href='buyerprofile.jsp?username=" + request.getSession().getAttribute("username") + "'>My Home</a>");
            pw.println("<a href=\"mortgage.jsp\">Calculate Mortgage</a>");
            pw.println("<a href=\"login.jsp\">Logout</a>");
            pw.println("</nav>");
            
            pw.println("<div class='body' style='height: 400px; overflow: auto;'>");
            pw.println("<div style='margin:auto;width:1000px;margin-top:100px;'>");
            pw.println("<table class='table table-hover table-striped'>");
            pw.println("<tr>");
            pw.println("<th class='text-light bg-dark'>Property ID</th>");
            pw.println("<th class='text-light bg-dark'>Block Number</th>");
            pw.println("<th class='text-light bg-dark'>Address</th>");
            pw.println("<th class='text-light bg-dark'>Region</th>");
            pw.println("<th class='text-light bg-dark'>Agent Name</th>");
            pw.println("<th class='text-light bg-dark'>Add to favorite</th>");
            pw.println("</tr>");
            
            while(rs.next()) {
                pw.println("<tr>");
                pw.println("<td class='text-light bg-dark'><a href='property-details.jsp?id=" + rs.getInt(1) + "'>" + rs.getString(1) + "</a></td>");
                pw.println("<td class='text-light bg-dark'>" + rs.getString(2) + "</td>");
                pw.println("<td class='text-light bg-dark'>" + rs.getString(3) + "</td>");
                pw.println("<td class='text-light bg-dark'>" + rs.getString(4) + "</td>");
                pw.println("<td class='text-light bg-dark'>" + rs.getString(5) + "</td>");
                pw.println("<td class='text-light bg-dark'><a href='addtofavoriteurl?property_id=" + rs.getInt(1) + "'>Favorite</a></td>");
                pw.println("</tr>");
            }
            pw.println("</table>");
            pw.println("</div>");
            pw.println("</div>");
            pw.println("<footer class='footer'>");
            pw.println("<i class='bx bxs-copyright'></i><br>");
            pw.println("<p>2024 Real Estate Portal</p>");
            pw.println("</footer>");
            pw.println("</body>");
            pw.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}