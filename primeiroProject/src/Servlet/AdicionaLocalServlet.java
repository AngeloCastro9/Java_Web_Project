package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BandaDao;
import modelo.Banda;
import modelo.ContatoBanda;
import modelo.Local;

/**
 * Servlet implementation class LocalServlet
 */
@WebServlet("/LocalServlet")
public class AdicionaLocalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionaLocalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void service (HttpServletRequest request
			, HttpServletResponse response)
					throws ServerException, IOException, ServletException {
    	
    	Local contato1 = new Local();
    	//long id = Integer.parseInt(request.getParameter("id"));
    	contato1.setLocal(request.getParameter("local"));
    	contato1.setCapacidade(request.getParameter("capacidade"));
    	
    	
    	PrintWriter out = response.getWriter();
    	//out.println("O id usado foi o: " + request.getParameter("id"));
		out.println("Nome do local é:" + request.getParameter("local"));
		out.println("a capacidade é de: " + request.getParameter("capacidade"));
		
		//String contato = request.getParameter("contato");
		//long id1 = Integer.parseInt(request.getParameter("id1"));
		String local = request.getParameter("local");
		int capacidade = Integer.parseInt(request.getParameter("capacidade"));
		/*
		 * Lembrando que os Try, Catch
		 * Podem ser implementados de maneira global para o Tomcat
		 * Exemplo:
		 * 		<error-page>
		 * 			<exception-type>java.lang.nullPointerException</exception-type>
		 * 			<location>/erros.html</location>
		 * 		</error-page>
		 * 
		 * 		<error-page>
		 * 			<error-code>404</error-code>
		 * 			<location>/404.html</location>
		 * 		</error-page>
		 */
		
		 Local local1 = new Local();
		 	//contato.setId(id);
		 //	contato.setId(id);
		 local1.setLocal(local);
		 local1.setCapacidade(capacidade);
	        
	        try {
	        	
		        
		        BandaDao dao = new BandaDao(request, response);
		        dao.adicionaLocal(local1);
		        } catch (Exception a) {
		        System.out.println("passei por aqui tentando adicionar no local!!");
		        a.printStackTrace();
		              	
		        }
	    
	    
	    
		        out.println("<html>");
		        out.println("<body>");
		        out.println("Banda " + local1.getLocal() +
		                " adicionado com sucesso");
		        out.println("</body>");
		        out.println("</html>");
		        
    }
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	//BandaDao dao1 = new BandaDao(request, response);
    	//dao1.adiciona(contato1);
    	
    	
    	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
