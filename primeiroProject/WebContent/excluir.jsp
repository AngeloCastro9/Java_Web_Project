<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Page</title>
</head>
<body>
	<form action="remover" method="post">		
		<label>Nome</label><br/>
		<input type="text" name="nome" value="<%=request.getParameter("nome")%>"/><br/>
		
		<button type="submit">
			excluir banda
		</button>
	</form>
</body>
</html>