<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<body>
	<h2>User Sign-In</h2>
	<p>Existing User can Sign-In here</p>
	<form action="validate" method="post">
		User Name * : <input type="text" name="tbName"><br>
		Password * :<input type="password" name="tbPass"><br>
		<input type="submit" value="Sign-In">
	</form><br><br>
	<h2>User Sign-Up</h2>
	<p>New User can add Sign-Up here</p>
	<form action="library" method="post">
		<button name="signup">Sign-Up</button>
	</form><br>
</body>
</html>
