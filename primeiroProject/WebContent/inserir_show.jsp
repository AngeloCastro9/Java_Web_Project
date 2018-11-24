<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Page</title>
</head>
<body>
	<form action="ShowServlet" method="post">
		
		
		<label>data</label><br/>
		<input type="text" name="data"/><br/>
	
		<label>ID Local</label>
		<input type="text" name="local_idlocal"/><br/>
		
		<button type="submit">
			inserir show
		</button>
	</form>
</body>
</html>