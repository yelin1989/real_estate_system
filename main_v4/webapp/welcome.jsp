<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="css/commonstyles.css">
<style>
  body {
    justify-content: center;
    align-items: center;
    /* height: 100vh; */
    margin: 0;
    
    top: 20px;
    background-size: cover;
  }

  h1 {
    text-align: center;
    margin-bottom: 20px;
    
  }

  h2 {
    display: block;
    text-align: center;
  }
</style>
</head>
<body>
<header>
		<h1>Dear New Member, Welcome To Real Estate Portal!</h1>
	</header>
    <nav>
        <a href="home.jsp">Home</a>   
        <a href="agents.jsp">Agents</a>
        <a href="register.jsp">Register</a>
        <a href="login.jsp">Login</a>
    </nav>

<h1>Your registration is successful.</h1>
<h2>Please <a href="login.jsp">click here</a>to login to your account!</h2>

</body>
</html>