<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="css/login.css">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'
	rel='stylesheet'>
<link rel="stylesheet" href="css/profilehome.css">
</head>
<body>
	<header>
		<h1>
			Welcome to your agent profile,
			<%=session.getAttribute("username")%>!
		</h1>
	</header>
	<nav>
		<a
			href="agentprofile.jsp?username=<%=session.getAttribute("username")%>">My
			Home</a> <a href="login.jsp">Logout</a>
	</nav>
	<div class='body'>
		<div class="button-container">
			<a href="addproperties.jsp"><button>Add Properties </button></a>
			<a href="<%=request.getContextPath()%>/myproperties"><button>My Properties</button></a>
			<a href="agentsearchpropertybyregion.jsp"><button>Search Properties by Region</button></a>
		</div>
	</div>
</body>
</html>