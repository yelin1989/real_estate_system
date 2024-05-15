package csit314;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/real_estate_system";
    private String jdbcUsername = "root";
    private String jdbcPassword = "csit314@123";

    private static final String SELECT_USER_BY_USERNAME = "SELECT * FROM users WHERE username = ?";
    private static final String SELECT_USER_BY_USERNAME_AND_PASSWORD = "SELECT * FROM users WHERE username = ? AND password = ?";
    private static final String SELECT_USER_BY_USERNAME_PASSWORD_AND_ROLE = "SELECT * FROM users WHERE username = ? AND password = ? AND role = ?";

    public boolean doesUsernameExist(String username) throws ClassNotFoundException {
        boolean exists = false;
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME)) {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            exists = rs.next();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return exists;
    }

    public boolean isPasswordCorrect(String username, String password) throws ClassNotFoundException {
        boolean isCorrect = false;
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME_AND_PASSWORD)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            isCorrect = rs.next();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return isCorrect;
    }

    public boolean isRoleCorrect(String username, String password, String role) throws ClassNotFoundException {
        boolean isCorrect = false;
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME_PASSWORD_AND_ROLE)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, role);
            ResultSet rs = preparedStatement.executeQuery();
            isCorrect = rs.next();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return isCorrect;
    }

    public boolean validate(Login login) throws ClassNotFoundException {
        return isRoleCorrect(login.getUsername(), login.getPassword(), login.getRole());
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}