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
    	contato1.setLocal(request.getParameter("local"));
    	contato1.setCapacidade(request.getParameter("capacidade"));
    	
    	
    	PrintWriter out = response.getWriter();
		out.println("Nome do local é:" + request.getParameter("local"));
		out.println("a capacidade é de: " + request.getParameter("capacidade"));
		
		String local = request.getParameter("local");
		int capacidade = Integer.parseInt(request.getParameter("capacidade"));
		
		 Local local1 = new Local();
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
