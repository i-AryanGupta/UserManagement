<%@page import ="com.ini.jpa.User"%>
<%@page import ="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List</title>
</head>
<body>

<%List<User> users = (List) request.getAttribute("userList"); %>

<table border ="">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Email</th>
		<th>DOB</th>
		<th>Country</th>
		<th> </th>
		<th> </th>
	<tr>
	
	<%for(User user : users){ %>
	<tr>
		<td><%=user.getID() %></td>
		<td><%= user.getName() %></td>
		<td><%= user.getEmail() %></td>
		<td><%= user.getDOB() %></td>
		<td><%= user.getCountry() %></td>
		<td><a href="updateRegist?ID=<%=user.getID()%>">Update</a></td>
		<td><a href="deleteRegister?ID=<%=user.getID()%>">Delete</a></td>
		
	</tr>
	<%} %>
	
</table>
<br>
<br>
<a href="index.jsp">Go Back to User Portal</a>

</body>
</html>