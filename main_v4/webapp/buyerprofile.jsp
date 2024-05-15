<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="css/login.css">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
<link rel="stylesheet" href="css/profilehome.css">
</head>
<body>
	<header>
		<h1>
			Welcome to your Buyer profile,
			<%=session.getAttribute("username")%>!
		</h1>
	</header>
	<nav>
		<a href="buyerprofile.jsp?username=<%=session.getAttribute("username")%>">My Home</a> 	
		<a href="mortgage.jsp">Calculate Mortgage</a>
		<a href="login.jsp">Logout</a>		
	</nav>
	<div class='body'>
	<div class="button-container">
	    <button><a href="searchpropertybyregion.jsp">Search Properties by Region</a></button>
	    <button><a href="<%=request.getContextPath()%>/browseproperties">Browse All Properties</a></button>
	    <button><a href="<%=request.getContextPath()%>/favoritelist">My Favorite List</a></button>
	</div>
	</div>
	
</body>
</html>