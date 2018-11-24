
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- https://mvnrepository.com/artifact/javax.servlet.jsp.jstl/javax.servlet.jsp.jstl-api -->
<%@page import="modelo.Banda" %>
<%@page import="dao.BandaDao" %>
<%@page import="java.util.*" %>
<%@page import="java.sql.*"%>
<%@page import="modelo.Local" %>    
<%@page import="modelo.Banda" %>   
<%@page import="modelo.Show" %> 
<%@page import="dao.BandaDao"%>
<%@page import="java.util.ArrayList" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Page</title>
</head>
<body>

			   <table border="1">
               <tr>
	<td>Nome</td><td>Genero</td>
	</tr>
                      <%
                      BandaDao dao = new BandaDao();
                      List<Banda> contatos = dao.getListaBandas();

                      for (Banda contato : contatos ) {
                      %>
                          <tr>
                              <td><%=contato.getNome() %></td> 
                             <td><%=contato.getGenero() %></td> 
                          </tr>
                      <%
                      }
                      %>
</table>

</br>

 <table border="1">
               <tr>
	<td>local</td><td>Capacidade</td>
	</tr>
                      <%
                      BandaDao dao1 = new BandaDao();
                      List<Local> local = dao.getListaLocal();

                      for (Local local1 : local ) {
                      %>
                          <tr>
                              <td><%=local1.getLocal() %></td> 
                             <td><%=local1.getCapacidade() %></td> 
                          </tr>
                      <%
                      }
                      %>
</table>


</br>


	 <table border="1">
               <tr>
	<td>Data</td>
	</tr>
                      <%
                      BandaDao dao2 = new BandaDao();
                      List<Show> show = dao.getListaShow();

                      for (Show show1 : show ) {
                      %>
                          <tr>
                              <td><%=show1.getData() %></td> 
                            
                          </tr>
                      <%
                      }
                      %>
</table>


</br>

	<form action=inserir.jsp method="post">
	
	<label>Cadastrar Bandas</label><br/>		
	
	<button type="submit">
		CLIQUE
	</button>
	</form>

	<form action=inserir_local.jsp method="post">
	
	<label>Cadastrar Local</label><br/>		
	
	<button type="submit">
		CLIQUE
	</button>
	</form>
	
	<form action=inserir_show.jsp method="post">
	
	<label>Cadastrar Show</label><br/>		
	
	<button type="submit">
		CLIQUE
	</button>
	</form>
	
	<form action=alterar.jsp method="post">
	
	<label>Alterações</label><br/>		
	
	<button type="submit">
		CLIQUE
	</button>
	</form>
	
	
	<form action="excluir.jsp" method="post">
	
	<label>Excluir</label><br/>		
	
	<button type="submit">
		CLIQUE
	</button>
	</form>
	
	
</body>
</html>