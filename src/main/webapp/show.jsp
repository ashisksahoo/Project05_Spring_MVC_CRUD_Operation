<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page import="com.techpalle.model.Library" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Page</title>
</head>
<body>
	<h2>Book Details</h2>
	<form action="library"><button name="insPage">add book</button><br></form>
	<table>
		<thead>
			<tr>
				<th>Book Id</th>
				<th>Book Name</th>
				<th>Publisher</th>
				<th>Pages</th>
				<th colspan="2">Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="i" items="${libr}">
    			<tr>
    				<th><c:out value="${i.bid}"></c:out></th>
  					<td><c:out value="${i.bname}"></c:out></td>
  					<td><c:out value="${i.publisher}"></c:out></td>
  					<td><c:out value="${i.pages}"></c:out></td>
  					<td>
  						<a href="selectById?id=<c:out value="${i.bid}"></c:out>">edit</a>
  						<a href="delete?id=<c:out value="${i.bid}"></c:out>">delete</a>
  					</td>
  				</tr>
  			</c:forEach>
		</tbody>
	</table>
</body>
</html>
