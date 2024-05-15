<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/mortgage.css">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
<head>
    <title>Mortgage Calculator</title>
    <script>
        function calculateMortgage() {
            // Retrieve form values
            var loanAmount = parseFloat(document.getElementById("loanAmount").value);
            var interestRate = parseFloat(document.getElementById("interestRate").value);
            var loanTerm = parseInt(document.getElementById("loanTerm").value);

            // Validate inputs
            if (isNaN(loanAmount) || loanAmount <= 0) {
                alert("Please enter a valid loan amount.");
                return;
            }
            if (isNaN(interestRate) || interestRate <= 0) {
                alert("Please enter a valid interest rate.");
                return;
            }
            if (isNaN(loanTerm) || loanTerm <= 0) {
                alert("Please enter a valid loan term.");
                return;
            }

            // Calculate monthly payment
            var monthlyInterestRate = interestRate / 100 / 12;
            var numberOfPayments = loanTerm * 12;
            var monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));

            // Display result
            var resultElement = document.getElementById("result");
            resultElement.innerHTML = "Monthly Payment: $" + monthlyPayment.toFixed(2);
            resultElement.style.backgroundColor = "#f8d7da"; // Light red background color
            resultElement.style.color = "#721c24"; // Dark red text color
            resultElement.style.padding = "10px";
            resultElement.style.border = "2px solid #f5c6cb"; // Red border
        }
    </script>
</head>
<body>
    <header>
        <h1>Welcome to your Buyer profile, <%=session.getAttribute("username")%>!</h1>
    </header>
    <nav>
        <a href="buyerprofile.jsp?username=<%=session.getAttribute("username")%>">My Home</a> 
        <a href="searchpropertybyregion.jsp">Search Properties by Region</a>
        <a href="<%=request.getContextPath()%>/browseproperties">Browse All Properties</a>
        <a href="<%=request.getContextPath()%>/favoritelist">My Favorite List</a>
        <a href="mortgage.jsp">Calculate Mortgage</a>
        <a href="login.jsp">Logout</a>
    </nav>
    <div class='body'>   
        <div>
            <form onsubmit="event.preventDefault(); calculateMortgage();">
                <h2>Mortgage Calculator</h2>
                Loan Amount: <input type="text" id="loanAmount"><br>
                Interest Rate (%): <input type="text" id="interestRate"><br>
                Loan Term (years): <input type="text" id="loanTerm"><br>
                <input type="submit" value="Calculate Mortgage">
            </form>
            <div id="result"></div>
        </div>
    </div>
    <footer class="footer">
        <i class='bx bxs-copyright'></i><br>
        <p>2024 Real Estate Portal</p>    
    </footer>
</body>
</html>