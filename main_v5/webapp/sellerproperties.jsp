<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Property Listings</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/commonstyles.css">
</head>
<body>
    <header>
        <h1>My Property Listings</h1>
    </header>
    <nav>
        <a href="sellerprofile.jsp?username=<%=session.getAttribute("username")%>">My Home</a>
        <a href="mortgage.jsp">Calculate Mortgage</a>
        <a href="login.jsp">Logout</a>
    </nav>
    <div class="body">
        <div class="property-table">
            <h2>Properties under your name</h2>
            <table class="table table-hover table-striped">
                <tr>
                    <th>Property ID</th>
                    <th>Block Number</th>
                    <th>Address</th>
                    <th>Region</th>
                    <th>Agent</th>
                    <th>View</th>
                    <th>Favourite</th>
                </tr>
                <%
                    String jdbcURL = "jdbc:mysql://localhost:3306/real_estate_system";
                    String jdbcUsername = "root";
                    String jdbcPassword = "csit314@123";

                    int sellerId = (int) session.getAttribute("userid");

                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

                        String sql = "SELECT property_id, blk_no, address, region, agent, num_views, num_shortlists FROM properties WHERE seller_id = ?";
                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setInt(1, sellerId);

                        ResultSet resultSet = statement.executeQuery();

                        while (resultSet.next()) {
                            int propertyId = resultSet.getInt("property_id");
                            String blkNo = resultSet.getString("blk_no");
                            String address = resultSet.getString("address");
                            String region = resultSet.getString("region");
                            String agent = resultSet.getString("agent");
                            int numViews = resultSet.getInt("num_views");
                            int numShortlists = resultSet.getInt("num_shortlists");

                            out.println("<tr>");
                            out.println("<td>" + propertyId + "</td>");
                            out.println("<td>" + blkNo + "</td>");
                            out.println("<td>" + address + "</td>");
                            out.println("<td>" + region + "</td>");
                            out.println("<td>" + agent + "</td>");
                            out.println("<td>" + numViews + "</td>");
                            out.println("<td>" + numShortlists + "</td>");
                            out.println("</tr>");
                        }

                        connection.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                %>
            </table>
        </div>
    </div>
    <footer class="footer">
        <i class='bx bxs-copyright'></i><br>
        <p>2024 Real Estate Portal</p>
    </footer>
</body>
</html>