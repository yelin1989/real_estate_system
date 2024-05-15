<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' href='css/bootstrap.css'></link>
<link rel='stylesheet' href='css/commonstyles.css'></link>
</head>
<body>

<div style="margin:auto;width:500px;margin-top:100px;">
    <form action="<%= request.getContextPath() %>/addproperties" method="post">
        <table class="table table-hover table-striped">
            <tr>
                <td>Block Number</td>
                <td><input type="text" name="blk_no"></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input type="text" name="address"></td>
            </tr>
            <!-- <tr>
                <td>Region</td>
                <td><input type="text" name="region"></td>
            </tr> -->         
            <tr>
            <td>Region</td>
            <td>
            <div class="input-box">
				
					<select id="search-input" name="region">
						<option value="Central">Central</option>
						<option value="East">East</option>
						<option value="West">West</option>
						<option value="North">North</option>
						<option value="North-East">North-East</option>
					</select> 
				</div>
				</td>
            </tr>
            <tr>
                <td>Agent</td>
                <td><input type="text" name="agent"></td>
            </tr>
            <tr>
                <td>Seller</td>
                <td><input type="text" name="seller"></td>
            </tr>
            <tr>
                <td><button type="submit" class="btn btn-outline-success">Add</button></td>
                <td><button type="reset" class='btn btn-outline-danger'><a href="agentprofile.jsp?username=<%=session.getAttribute("username")%>">Cancel</a></button></td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>