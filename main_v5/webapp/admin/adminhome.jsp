<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Real Estate Property Website</title>
    <link rel="stylesheet" href="adminstyle.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
    <header>
        <h1>Real Estate Property Portal</h1>
    </header>
    <nav>
        <a href="../home.jsp">Website Home Page</a>
        
    </nav>
    
    <div class='body'>
            <div class='login-wrapper'>
                <form action="<%=request.getContextPath()%>/adminlogin" method="post">
                    <h1>Admin Login</h1>
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

                    <input type="submit" value="Login" name="login">

                    

                </form>

            </div>
        </div>

    
    
</body>
</html>