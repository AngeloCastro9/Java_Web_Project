<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="modelo.Banda" %>    
<%@page import="dao.BandaDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP page</title>
</head>
<body>
	<%
	String nome = request.getParameter("nome");
	
	 Banda contato = new Banda();
       contato.setNome(nome);
	
	try {
       BandaDao daoExcluir = new BandaDao(request, response);
       daoExcluir.exclui(contato);
       response.sendRedirect("index.jsp");
       } catch (Exception e) {
       	 System.out.println("passei por aqui para excluir");
	        e.printStackTrace();
       }
	%>
</body>
</html>