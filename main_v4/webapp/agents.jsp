<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Our Agents</title>
<link rel="stylesheet" href="css/commonstyles.css">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
	<header>
		<h1>Real Estate Property Portal Agents</h1>
	</header>
	<nav>
		<a href="home.jsp">Home</a>
		<!-- <a href="agents.jsp">Properties</a> -->
		<a href="agents.jsp">Agents</a>
		<a href="register.jsp">Register</a> 
		<a href="login.jsp">Login</a>
	</nav>
	<div class='body'>
		<div class="container">
			<h2>Our friendly agents at your service!!</h2>
			<p>This is your one-stop destination for all your property needs,
				whether buying, selling, or renting.</p>

			<form id="search-form" action="<%=request.getContextPath()%>/showagents" method="post">
				<div class="input-box">
				<p>Browse here to find Our Agents!!!</p>
					<input type="text" id="agent-name" name="keyword"> 
					<!-- <i class="bx bx-search-alt-2 search-icon" id="search-submit"></i> -->
					<input type="submit" value="Browse" name="search">
				</div>
			</form>

		</div>
	</div>
	
	<footer class="footer">
		<i class='bx bxs-copyright'></i><br>
		<p>2024 Real Estate Portal</p>	
	</footer>
</body>
</html>
