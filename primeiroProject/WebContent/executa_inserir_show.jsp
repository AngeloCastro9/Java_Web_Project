<%@page contentType="text/html" pageEncoding="UTF-8" %>
    
<%@page import="dao.BandaDao"%>
<%@page import="modelo.Show" %>
<%@page import="modelo.Local" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP page</title>
</head>
<body>
	<%	
	try{
			Show show = new Show();
			BandaDao dao = new BandaDao();
			if(request.getParameter("data").equals("")){
				response.sendRedirect("index.jsp");
			}else{
				show.setLocal_Idlocal(Integer.parseInt(request.getParameter("local_idlocal")));
				
				java.util.Date data = null;
	
				java.util.Date dt = new java.util.Date();

					java.text.DateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");

					String currentTime = sdf.format(dt);
					show.setData(sdf.parse( request.getParameter("data")));
					dao.adicionaShow(show);
					response.sendRedirect("index.jsp");
			}
			} catch (Exception e) {
					throw new RuntimeException("erro aqui no inserir show: "+ e);
				}
	finally{
		
	}
				
	
			
	%>
</body>
</html>