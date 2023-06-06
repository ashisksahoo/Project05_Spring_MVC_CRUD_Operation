<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Page</title>
</head>
<body>
	<c:if test="${library == null}">
	<h2>Register Form</h2>
	<form action="insert" method="post">
	</c:if>
	<c:if test="${library != null}">
	<h2>Update Form</h2>
	<form action="update" method="post">
	</c:if>
		<input value="<c:out value="${library.bid}"></c:out>" type="text" name="tbId" hidden="hidden"><br>
		Book Name: <input value="<c:out value="${library.bname}"></c:out>" type="text" name="tbName"><br>
		Publisher: <input value="<c:out value="${library.publisher}"></c:out>" type="text" name="tbPublisher"><br>
		Pages: <input value="<c:out value="${library.pages}"></c:out>" type="text" name="tbPages"><br>
		<input type="submit" value="save">
	</form><br><br>
	<form action="library" method="post">
		<button name="showPage">Home</button>
	</form>
</body>
</html>
