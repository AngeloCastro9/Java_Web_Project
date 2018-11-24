<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Page</title>
</head>
<body>
	<form action="LocalServlet" method="post">
		<label>local</label><br/>
		<input type="text" name="local"/><br/>
	
		<label>capacidade</label><br/>
		<input type="text" name="capacidade"/><br/>
		
		<button type="submit">
			inserir Local
		</button>
	</form>
</body>
</html>