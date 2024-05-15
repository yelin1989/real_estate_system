<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="adminstyle.css">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'
	rel='stylesheet'>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- Link to main.js -->
    <script src="../main.js"></script>
</head>
<body>
	<header>
		<h1>
			Welcome back,
			<%=session.getAttribute("username")%>!
		</h1>
	</header>
	<nav>
		<a href="adminprofile.jsp?username=<%=session.getAttribute("username")%>">My Home</a>
		<!-- <a href="../showusers">Show Users</a> -->
		<a href="#" id="showUsersLink">Show Agents</a>
		<a href="#" id="showSellersLink">Show Sellers</a>
		<a href="#" id="showBuyersLink">Show Buyers</a>	
		<a href="adminhome.jsp">Logout</a>
	</nav>
	<div class='body'>
	<!-- Div to display user data -->
    <div id="userTable" style='margin:auto;width:800px;margin-top:100px;'></div>
    
    
    </div>
    
    
	
</body>
</html>