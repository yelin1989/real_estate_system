<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" href="css/login.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
    <header>
		<h1>Real Estate Property Portal Registration Page</h1>
	</header>
    <nav>
        <a href="home.jsp">Home</a>
        <a href="<%=request.getContextPath()%>/showagents">Agents</a>
        <a href="register.jsp">Register</a>
        <a href="login.jsp">Login</a>
    </nav>
    <!-- <div class="container"> -->
        <div class='body'>
            <div class='login-wrapper'>
        <form action="<%= request.getContextPath() %>/register" method="post">
          
             
             <h1>Register</h1>
             <div class="input-box">
                        <input type='text' placeholder='Full Name' name="fullname" required />
                        <i class='bx bxs-user' ></i>
                    </div>
             
                    <div class="input-box">
                        <input type='text' placeholder='Username' name="username" required />
                        <i class='bx bxs-user' ></i>
                    </div>
                    <div class="input-box">
                        <input type='password' class="password" placeholder='Password' name="password" required />
                        <i class='bx bxs-lock-alt'></i>
                    </div>
                     <div class="input-box">
                        <input type='email' class="email" placeholder='Email' name="email" required />
                        <i class='bx bxs-envelope'></i>
                    </div>
                   
                    
                    <div class="radio-group">
                <input type="radio" id="agent" name="role" value="Agent">
                <label for="agent">Agent</label>
                
                <input type="radio" id="buyer" name="role" value="Buyer">
                <label for="buyer">Buyer</label>
                
                <input type="radio" id="seller" name="role" value="Seller">
                <label for="seller">Seller</label>
             </div>  
            
            <input type="submit" value="Register" name="register">
        </form>
    </div>
    </div>
    
    <footer class="footer">
		<i class='bx bxs-copyright'></i><br>
		<p>2024 Real Estate Portal</p>	
	</footer>
</body>
</html>
