package csit314;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddPropertiesDao {

	public int addProperties(AddProperties properties) throws ClassNotFoundException {
		String INSERT_properties_SQL = "INSERT INTO properties" + " (blk_no, address, region, agent, seller) VALUES " + "(?, ?, ?, ?, ?);";

		int result = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/real_estate_system", "root", "csit314@123");
				
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_properties_SQL)) {
				
				preparedStatement.setString(1, properties.getBlk_no());
				preparedStatement.setString(2, properties.getAddress());
				preparedStatement.setString(3, properties.getRegion());
				preparedStatement.setString(4, properties.getAgent());
				preparedStatement.setString(5, properties.getSeller());
								
				System.out.println(preparedStatement);
				result = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	

}
