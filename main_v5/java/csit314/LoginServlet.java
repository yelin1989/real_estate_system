package csit314;

import java.io.IOException;
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
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        String jdbcURL = "jdbc:mysql://localhost:3306/real_estate_system";
        String jdbcUsername = "root";
        String jdbcPassword = "csit314@123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

            String sql = "SELECT userid, fullname, username, password, role FROM users WHERE username = ? AND password = ? AND role = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, role);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int userId = resultSet.getInt("userid");
                String fullName = resultSet.getString("fullname");

                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("userid", userId);
                session.setAttribute("fullname", fullName);

                if ("Seller".equals(role)) {
                    response.sendRedirect("sellerprofile.jsp");
                } else if ("Buyer".equals(role)) {
                    response.sendRedirect("buyerprofile.jsp");
                } else if ("Agent".equals(role)) {
                    response.sendRedirect("agentprofile.jsp");
                }
            } else {
                request.setAttribute("errorMessage", "Invalid username, password, or role.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred. Please try again.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}