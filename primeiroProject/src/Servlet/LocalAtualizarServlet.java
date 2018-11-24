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
import modelo.Local;

/**
 * Servlet implementation class AtualizarBandaServlet
 */
@WebServlet("/atualizarLocal")
public class LocalAtualizarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocalAtualizarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void service (HttpServletRequest request
			, HttpServletResponse response)
					throws ServerException, IOException, ServletException {
    	PrintWriter out = response.getWriter();
    	out.println("o ID usado foi o: " + request.getParameter("idlocal"));
		out.println("Nome do local é: " + request.getParameter("local"));
		out.println("O a capacidade é de:  " + request.getParameter("capacidade"));

		long idlocal = Integer.parseInt(request.getParameter("idlocal"));
		String local = request.getParameter("local");
		int capacidade = Integer.parseInt(request.getParameter("capacidade"));
		//String capacidade = request.getParameter("capacidade");
		
		Local local2 = new Local ();
		local2.setId(idlocal);
		local2.setLocal(local);
		local2.setCapacidade(capacidade);
        
        try {
	        BandaDao daoAtualizar = new BandaDao(request, response);
	        daoAtualizar.atualizaLocal(local2);
	        } catch (Exception e) {
	        	 System.out.println("passei por aqui para atualizar o local");
	 	        e.printStackTrace();
	        }
        
        out.println("<html>");
        out.println("<body>");
        out.println("Banda " + local2.getLocal() +
                " atualizada com sucesso");
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
