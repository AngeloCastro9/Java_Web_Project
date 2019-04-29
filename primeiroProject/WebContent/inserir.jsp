<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="modelo.TesteEnum" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>




	<form action="adicionenabanda" method="post">
	
	<input type='checkbox' name='escolheBanda' value='ROCK' />ROCK
	<input type='checkbox' name='escolheBanda' value='FORRO' />FORRO
	<input type='checkbox' name='escolheBanda' value='AXE' />AXE
	<br/>

		<label>Nome</label><br/>
		<input type="text" name="nome"/><br/>
		<button type="submit">
			inserir banda
		</button>
	</form>
</body>
</html>