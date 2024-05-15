<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="login.css">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
	<header>
		<h1>
			Welcome to your seller profile,
			<%=session.getAttribute("username")%>!
		</h1>
	</header>
	<nav>
		<a href="home.jsp">Home</a> <a href="agents.jsp">Agents</a><a
			href="home.jsp">Logout</a>
	</nav>
</body>
</html>