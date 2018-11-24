package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.glassfish.gmbal.ManagedAttribute;

import dao.BandaDao;
import modelo.Banda;
import modelo.TesteEnum;

/**
 * Servlet implementation class LocalServlet
 */





@WebServlet("/adicionenabanda")
public class AdicionaBandaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	//@ModelAttribute ("states")
	
	/*public List<TesteEnum> populateRoster()
	{
	    return Arrays.asList(TesteEnum.values());
	}*/	
	

    protected void service (HttpServletRequest request
			, HttpServletResponse response)
					throws ServerException, IOException, ServletException {
    	
    	
    	 
    	
    	Banda contato1 = new Banda();
    	//long id = Integer.parseInt(request.getParameter("id"));
    	contato1.setNome(request.getParameter("nome"));
    	contato1.setGenero(request.getParameter("escolheBanda"));
    	
    	
    	
    	PrintWriter out = response.getWriter();
    	//out.println("O id usado foi o: " + request.getParameter("id"));
		out.println("Nome do local é:" + request.getParameter("nome"));
		out.println("o genero da banda é: " + request.getParameter("escolheBanda"));
		
		//String contato = request.getParameter("contato");
		//long id1 = Integer.parseInt(request.getParameter("id1"));
        String.valueOf(request.getParameter("escolheBanda"));
        String.valueOf(request.getParameter("escolheBanda"));
        String.valueOf(request.getParameter("escolheBanda"));
		String nome = request.getParameter("nome");
		String ROCK = request.getParameter("escolheBanda");
		String FORRO = request.getParameter("escolheBanda");
		String AXE = request.getParameter("escolheBanda");
		
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
		
		 Banda banda = new Banda();
		 	//contato.setId(id);
		 //	contato.setId(id);
		// request.getSession().setAttribute("ROCK", ROCK);
		 banda.setNome(nome);
		 banda.setGenero(ROCK);
		 banda.setGenero(FORRO);
		 banda.setGenero(AXE);
	        
	        try {
	        	
		        
		        BandaDao dao = new BandaDao(request, response);
		        dao.adicionaBanda(banda);
		        } catch (Exception a) {
		        System.out.println("passei por aqui tentando adicionar na banda!!");
		        a.printStackTrace();
		              	
		        }
	    
	    
	    
		        out.println("<html>");
		        out.println("<body>");
		        out.println("Banda " + banda.getNome() +
		                " adicionado com sucesso");
		        out.println("</body>");
		        out.println("</html>");
		        
    }
   
    

    	

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
