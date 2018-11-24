<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- https://mvnrepository.com/artifact/javax.servlet.jsp.jstl/javax.servlet.jsp.jstl-api -->
<%@page import="modelo.Banda" %>
<%@page import="dao.BandaDao" %>
<%@page import="java.util.*" %>
<%@page import="java.sql.*"%>

 <html>
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
              </body>
          </html>



