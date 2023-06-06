<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign-Up Page</title>
</head>
<body>
	<h2>Add New User</h2>
	<p>please fill the following credentials</p>
	<form action="adduser" method="post">
		User Name * : <input type="text" name="tbName"><br>
		Password * :<input type="password" name="tbPass"><br>
		<button type="submit">Add User</button>
	</form><br><br>
	<h2>User Sign-In</h2>
	<p>Existing User can Sign-In here</p>
	<form action="library" method="post">
		<button name="signin">Sign-In</button>
	</form>
</body>
</html>