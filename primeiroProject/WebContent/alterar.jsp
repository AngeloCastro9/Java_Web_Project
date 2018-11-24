<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Page</title>
</head>
<body>
	<form action="atualiza11r" method="post">
		<label>Codigo</label><br/> 
		<input type="text" name="idbanda"  value="<%=request.getParameter("idbandas")%>"   /><br/>
		
		<label>Nome</label><br/>
		<input type="text" name="nome" value="<%=request.getParameter("nome")%>"/><br/>
	
		<label>Genero</label><br/>
		<input type="text" name="genero" value="<%=request.getParameter("genero")%>"/><br/>
		
		<button type="submit">
			atualizar banda
		</button>
	</form>
	
	<form action="atualizarLocal" method="post">
		<label>Codigo</label><br/> 
		<input type="text" name="idlocal"  value="<%=request.getParameter("idlocal")%>"   /><br/>
		
		<label>local</label><br/>
		<input type="text" name="local" value="<%=request.getParameter("local")%>"/><br/>
	
		<label>capacidade</label><br/>
		<input type="text" name="capacidade" value="<%=request.getParameter("capacidade")%>"/><br/>
		
		<button type="submit">
			atualizar local
		</button>
	</form>
	
	<form action="ShowAtualiarServlet" method="post">
		
	
		<label>Codigo</label><br/> 
		<input type="text" name="idshow"  value="<%=request.getParameter("idshow")%>"   /><br/>
		
		<label>data</label><br/>
		<input type="text" name="data" value="<%=request.getParameter("data")%>"/><br/>
		
		<button type="submit">
			atualizar data
		</button>
	</form>
	
	
	
</body>
</html>