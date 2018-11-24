<%@page contentType="text/html" pageEncoding="UTF-8" %>
    
<%@page import="dao.BandaDao"%>
<%@page import="modelo.Banda" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP page</title>
</head>
<body>
	<%
		try{
			Banda banda = new Banda();
			BandaDao dao = new BandaDao();
			if(request.getParameter("nome").equals("") || request.getParameter("genero").equals("")){
				response.sendRedirect("index.jsp");
			}else{
				banda.setNome(request.getParameter("nome"));
				banda.setGenero(request.getParameter("genero"));
				dao.adicionaBanda(banda);
				response.sendRedirect("index.jsp");
			}
		} catch (Exception e) {
			throw new RuntimeException("erro aqui no inserir: "+ e);
		}
		
	%>
</body>
</html>