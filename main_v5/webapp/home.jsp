<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Real Estate Property Website</title>
<link rel="stylesheet" href="css/commonstyles.css">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'
	rel='stylesheet'>
<link href='css/bootstrap.css' rel='styelsheet'>
</head>
<body>
	<header>
		<h1>Real Estate Property Portal Home</h1>
	</header>
	<nav>
		<a href="home.jsp">Home</a> <a
			href="<%=request.getContextPath()%>/showagents">Agents</a> <a
			href="register.jsp">Register</a> <a href="login.jsp">Login</a>
	</nav>
	<div class='body'>
		<div class="container">
			<h2>Welcome to Our Real Estate Portal</h2>
			<p>This is your one-stop destination for all your property needs,
				whether buying, selling, or renting.</p>

			<form id="search-form" action="<%=request.getContextPath()%>/showproperties" method="post">
				<div class="input-box">
					<p>Browse here to find Properties By Region!!!</p>
					<select id="search-input" name="region">
						<option value="central">Central</option>
						<option value="east">East</option>
						<option value="west">West</option>
						<option value="north">North</option>
						<option value="north-east">North-East</option>
					</select> 
					<input type="submit" value="Search" name="search">
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