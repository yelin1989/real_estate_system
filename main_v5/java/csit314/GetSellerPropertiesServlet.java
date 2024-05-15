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

@WebServlet("/sellerproperties")
public class GetSellerPropertiesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");

        int sellerId = (int) request.getSession().getAttribute("userid");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/real_estate_system", "root", "csit314@123");
                 PreparedStatement preparedStatement = connection.prepareStatement("SELECT property_id, blk_no, address, region, agent, num_views, num_shortlists FROM properties WHERE seller_id = ?")) {

                preparedStatement.setInt(1, sellerId);
                ResultSet rs = preparedStatement.executeQuery();

                pw.println("<table class='table table-hover table-striped'>");
                pw.println("<tr>");
                pw.println("<th>Property ID</th>");
                pw.println("<th>Block Number</th>");
                pw.println("<th>Address</th>");
                pw.println("<th>Region</th>");
                pw.println("<th>Agent</th>");
                pw.println("<th>Views</th>");
                pw.println("<th>Shortlists</th>");
                pw.println("</tr>");

                while (rs.next()) {
                    pw.println("<tr>");
                    pw.println("<td>" + rs.getInt("property_id") + "</td>");
                    pw.println("<td>" + rs.getString("blk_no") + "</td>");
                    pw.println("<td>" + rs.getString("address") + "</td>");
                    pw.println("<td>" + rs.getString("region") + "</td>");
                    pw.println("<td>" + rs.getString("agent") + "</td>");
                    pw.println("<td>" + rs.getInt("num_views") + "</td>");
                    pw.println("<td>" + rs.getInt("num_shortlists") + "</td>");
                    pw.println("</tr>");
                }

                pw.println("</table>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}