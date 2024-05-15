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

@WebServlet("/propertydetails")
public class PropertyDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int propertyId = Integer.parseInt(request.getParameter("id"));

        String jdbcURL = "jdbc:mysql://localhost:3306/real_estate_system";
        String jdbcUsername = "root";
        String jdbcPassword = "csit314@123";

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        Connection connection = null;
        PreparedStatement updateViewsStmt = null;
        PreparedStatement propertyDetailsStmt = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

            // Increment the view count
            String updateViewsSql = "UPDATE properties SET num_views = num_views + 1 WHERE property_id = ?";
            updateViewsStmt = connection.prepareStatement(updateViewsSql);
            updateViewsStmt.setInt(1, propertyId);
            updateViewsStmt.executeUpdate();

            // Retrieve property details
            String propertyDetailsSql = "SELECT * FROM properties WHERE property_id = ?";
            propertyDetailsStmt = connection.prepareStatement(propertyDetailsSql);
            propertyDetailsStmt.setInt(1, propertyId);
            resultSet = propertyDetailsStmt.executeQuery();

            out.println("<html><head><title>Property Details</title></head><body>");
            out.println("<h1>Property Details</h1>");

            if (resultSet.next()) {
                String blkNo = resultSet.getString("blk_no");
                String address = resultSet.getString("address");
                String region = resultSet.getString("region");
                String agent = resultSet.getString("agent");
                String seller = resultSet.getString("seller");
                double price = resultSet.getDouble("price");
                int sqft = resultSet.getInt("sqft");
                int numBedrooms = resultSet.getInt("num_bedrooms");
                int numBathrooms = resultSet.getInt("num_bathrooms");
                String propertyType = resultSet.getString("property_type");

                out.println("<p>Block Number: " + blkNo + "</p>");
                out.println("<p>Address: " + address + "</p>");
                out.println("<p>Region: " + region + "</p>");
                out.println("<p>Agent: " + agent + "</p>");
                out.println("<p>Seller: " + seller + "</p>");
                out.println("<p>Price: $" + price + "</p>");
                out.println("<p>Square Feet: " + sqft + " sqft</p>");
                out.println("<p>Bedrooms: " + numBedrooms + "</p>");
                out.println("<p>Bathrooms: " + numBathrooms + "</p>");
                out.println("<p>Property Type: " + propertyType + "</p>");
            } else {
                out.println("<p>Property not found.</p>");
            }

            out.println("</body></html>");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("<html><body><h1>Error retrieving property details.</h1></body></html>");
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (propertyDetailsStmt != null) propertyDetailsStmt.close();
                if (updateViewsStmt != null) updateViewsStmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}