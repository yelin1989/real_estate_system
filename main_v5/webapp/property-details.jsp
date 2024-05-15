<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Property Details</title>
    <link rel="stylesheet" href="css/login.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="css/profilehome.css">
</head>
<body>
    <header>
        <h1>Property Details</h1>
    </header>
    <nav>
        <a href="home.jsp">Home</a>
        <a href="mortgage.jsp">Calculate Mortgage</a>
        <a href="login.jsp">Logout</a>
    </nav>
    <div class='body'>
        <div class="property-details">
            <%
                String propertyId = request.getParameter("id");
                String jdbcURL = "jdbc:mysql://localhost:3306/real_estate_system";
                String jdbcUsername = "root";
                String jdbcPassword = "csit314@123";

                try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
                     PreparedStatement statement = connection.prepareStatement("SELECT * FROM properties WHERE property_id = ?")) {

                    statement.setInt(1, Integer.parseInt(propertyId));
                    ResultSet resultSet = statement.executeQuery();

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

                } catch (SQLException e) {
                    e.printStackTrace();
                    out.println("<p>Error retrieving property details.</p>");
                }
            %>
        </div>
        <a href="browseproperties" class="btn btn-outline-success">Back to Properties</a>
    </div>
    <footer class="footer">
        <i class='bx bxs-copyright'></i><br>
        <p>2024 Real Estate Portal</p>
    </footer>
</body>
</html>