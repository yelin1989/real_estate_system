<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="css/login.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
    <header>
        <h1>Real Estate Property Login</h1>
    </header>
    <nav>
        <a href="home.jsp">Home</a>
        <a href="<%=request.getContextPath()%>/showagents">Agents</a>
        <a href="register.jsp">Register</a>
        <a href="login.jsp">Login</a>
    </nav>
    
    <div class='body'>
        <div class='login-wrapper'>
            <form action="<%=request.getContextPath()%>/login" method="post">
                <h1>Login</h1>

                <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
                <% if (errorMessage != null) { %>
                    <div class="error-message" style="color: red; text-align: center;"><%= errorMessage %></div>
                <% } %>

                <div class="input-box">
                    <input type='text' placeholder='Username' name="username" required />
                    <i class='bx bxs-user' ></i>
                </div>
                <div class="input-box">
                    <input type='password' class="password" placeholder='Password' name="password" required />
                    <i class='bx bxs-lock-alt'></i>
                </div>
                <div class='remember-forgot'>
                    <label><input type="checkbox" />Remember me</label>
                    <a href='.'>Forgot password</a>
                </div>
                
                <div class="radio-group">
                    <input type="radio" id="agent" name="role" value="Agent" required>
                    <label for="agent">Agent</label>
                    
                    <input type="radio" id="buyer" name="role" value="Buyer" required>
                    <label for="buyer">Buyer</label>
                    
                    <input type="radio" id="seller" name="role" value="Seller" required>
                    <label for="seller">Seller</label>
                </div>  

                <input type="submit" value="Login" name="login">

                <div class="register-link">
                    <p>Don't have an account? <a href='register.jsp'>Register</a></p>
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