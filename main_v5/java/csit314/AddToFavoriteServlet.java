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
import jakarta.servlet.http.HttpSession;

@WebServlet("/addfavorite")
public class AddToFavoriteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private String insertQuery = "INSERT INTO favorite (blk_no, address, region, agent, buyer) VALUES (?, ?, ?, ?, ?)";
    private String updateQuery = "UPDATE properties SET num_shortlists = num_shortlists + 1 WHERE property_id = ?";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get PrintWriter
        PrintWriter pw = response.getWriter();

        // Set content type
        response.setContentType("text/html");

        // Link to bootstrap
        pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");

        HttpSession newSession = request.getSession();
        String username = (String) newSession.getAttribute("username");

        String block_no = request.getParameter("blk_no");
        String address = request.getParameter("address");
        String region = request.getParameter("region");
        String agent = request.getParameter("agent");
        int propertyId = Integer.parseInt(request.getParameter("property_id"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/real_estate_system", "root", "csit314@123");
             PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
             PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {

            // Set the values for insert query
            insertStatement.setString(1, block_no);
            insertStatement.setString(2, address);
            insertStatement.setString(3, region);
            insertStatement.setString(4, agent);
            insertStatement.setString(5, username);

            // Execute the insert query
            int insertCount = insertStatement.executeUpdate();

            // Set the value for update query
            updateStatement.setInt(1, propertyId);

            // Execute the update query
            int updateCount = updateStatement.executeUpdate();

            pw.println("<div class='card' style='margin:auto;width:300px;margin-top:100px'>");

            if (insertCount == 1 && updateCount == 1) {
                pw.println("<h2 class='bg-success text-light text-center'> You have added the property into the favorite list.</h2>");
            } else {
                pw.println("<h2 class='bg-danger text-light text-center'> Changes have not been saved!</h2>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        pw.println("<a href='buyerprofile.jsp?username=" + username + "'><button class='btn btn-outline-success'>Go Back To Your Profile Page.</button></a>");
        pw.println("</div>");
        // Close stream
        pw.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}