package csit314;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/trackshortlists")
public class TrackShortlistsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int propertyId = Integer.parseInt(request.getParameter("property_id"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/real_estate_system", "root", "csit314@123");
                 PreparedStatement preparedStatement = connection.prepareStatement("UPDATE properties SET num_shortlists = num_shortlists + 1 WHERE property_id = ?")) {

                preparedStatement.setInt(1, propertyId);
                preparedStatement.executeUpdate();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Redirect back to property details page or other relevant page
        response.sendRedirect("property-details.jsp?id=" + propertyId);
    }
}