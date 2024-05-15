<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Seller Profile</title>
<link rel="stylesheet" href="css/login.css">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
<link rel="stylesheet" href="css/profilehome.css">
</head>
<body>
    <header>
        <h1>Welcome to your Seller profile, <%=session.getAttribute("username")%>!</h1>
    </header>
    <nav>
        <a href="sellerprofile.jsp?username=<%=session.getAttribute("username")%>">My Home</a>
        <a href="mortgage.jsp">Calculate Mortgage</a>
        <a href="login.jsp">Logout</a>
    </nav>
    <div class='body'>
        <div class="button-container">
            <button><a href="createproperty.jsp">Create New Property Listing</a></button>
            <button><a href="manageproperties.jsp">Manage Property Listings</a></button>
            <button><a href="sellerproperties.jsp">View My Property Listings</a></button>
        </div>
    </div>
    <footer class="footer">
        <i class='bx bxs-copyright'></i><br>
        <p>2024 Real Estate Portal</p>
    </footer>
</body>
</html>