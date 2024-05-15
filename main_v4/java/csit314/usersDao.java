package csit314;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class usersDao {

	public int registerUsers(users users) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO users" + " (fullname, username, password, email, role) VALUES " + "(?, ?, ?, ?, ?);";

		int result = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/real_estate_system", "root", "csit314@123");
				
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
				
				preparedStatement.setString(1, users.getFullname());
				preparedStatement.setString(2, users.getUsername());
				preparedStatement.setString(3, users.getPassword());
				preparedStatement.setString(4, users.getEmail());
				preparedStatement.setString(5, users.getRole());
								
				System.out.println(preparedStatement);
				result = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	

}
