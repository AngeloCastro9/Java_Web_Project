<%@page contentType="text/html" pageEncoding="UTF-8" %>
    
<%@page import="dao.BandaDao"%>
<%@page import="modelo.Local" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP page</title>
</head>
<body>
	<%
		try{
			Local local = new Local();
			BandaDao dao = new BandaDao();
			if(request.getParameter("local").equals("") || request.getParameter("capacidade").equals("")){
				response.sendRedirect("index.jsp");
			}else{
				local.setLocal(request.getParameter("local"));
				local.setCapacidade(Integer.parseInt(request.getParameter("capacidade")));
				dao.adicionaLocal(local);
				response.sendRedirect("index.jsp");
			}
		} catch (Exception e) {
			throw new RuntimeException("erro aqui no inserir local: "+ e);
		}
		
	%>
</body>
</html>