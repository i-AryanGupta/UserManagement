<%@ page import ="java.util.List" %>
<%@ page import ="com.ini.jpa.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>

<h1> Update User Detail</h1><br><br>
<%List<User> users = (List) request.getAttribute("existUser"); %>
<% for(User user : users) { %>

	<form action="updateExistUser" method ="post">
	<input type ="number" placeholder="ID" name ="ID" value="<%= user.getID() %>" readonly="readonly"><br><br>
	<input type ="text" placeholder="Name" name ="Name" value="<%=user.getName() %>"><br><br>
	<input type ="email" placeholder="Email" name ="Email" value="<%=user.getEmail()%>"><br><br>
	<input type="date" placeholder="Date of Birth" name="DOB" value="<%=user.getDOB()%>"><br><br>
	<input type ="text" placeholder="Country" name ="Country" value="<%=user.getCountry()%>"><br><br>
	<input type="submit" value ="Update">
	
	</form>
	

<%} %>


</body>
</html>