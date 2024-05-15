/**
 * 
 */

/*document.getElementById("login").addEventListener("click", function() {
	// Redirect to the login page
	window.location.href = "login.jsp"; // Replace "login.html" with the actual URL of your login page
});

document.getElementById("register").addEventListener("click", function() {
	// Redirect to the login page
	window.location.href = "register.jsp"; // Replace "login.html" with the actual URL of your login page
});*/


$(document).ready(function() {
	// Function to fetch user data from servlet and display it
	function fetchUserData() {
		$.get("../showusers", function(data) {
			$("#userTable").html(data); // Update the content of userTable div with the response from the servlet
		});
	}

	// Event listener for the "Show Users" link
	$("#showUsersLink").click(function(event) {
		event.preventDefault(); // Prevent default link behavior
		fetchUserData(); // Call the function to fetch user data
	});
});

$(document).ready(function() {
	// Function to fetch user data from servlet and display it
	function fetchUserData() {
		$.get("../showsellers", function(data) {
			$("#userTable").html(data); // Update the content of userTable div with the response from the servlet
		});
	}

	// Event listener for the "Show Users" link
	$("#showSellersLink").click(function(event) {
		event.preventDefault(); // Prevent default link behavior
		fetchUserData(); // Call the function to fetch user data
	});
});

$(document).ready(function() {
	// Function to fetch user data from servlet and display it
	function fetchUserData() {
		$.get("../showbuyers", function(data) {
			$("#userTable").html(data); // Update the content of userTable div with the response from the servlet
		});
	}

	// Event listener for the "Show Users" link
	$("#showBuyersLink").click(function(event) {
		event.preventDefault(); // Prevent default link behavior
		fetchUserData(); // Call the function to fetch user data
	});
});


