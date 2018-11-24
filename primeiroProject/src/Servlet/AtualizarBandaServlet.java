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
import modelo.Show;

/**
 * Servlet implementation class AtualizarBandaServlet
 */
@WebServlet("/atualiza11r")
public class AtualizarBandaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtualizarBandaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void service (HttpServletRequest request
			, HttpServletResponse response)
					throws ServerException, IOException, ServletException {
    	PrintWriter out = response.getWriter();
    	out.println("o ID usado foi o: " + request.getParameter("idbanda"));
		out.println("Nome da banda: " + request.getParameter("nome"));
		out.println("O gênero da banda é:  " + request.getParameter("genero"));

		long idbanda = Integer.parseInt(request.getParameter("idbanda"));
		String nome = request.getParameter("nome");
		String genero = request.getParameter("genero");
		
		Banda banda = new Banda ();
		banda.setId(idbanda);
        banda.setNome(nome);
        banda.setGenero(genero);
        
        try {
	        BandaDao daoExcluir = new BandaDao(request, response);
	        daoExcluir.atualizaBanda(banda);
	        } catch (Exception e) {
	        	 System.out.println("passei por aqui para atualizar a banda");
	 	        e.printStackTrace();
	        }
        
        out.println("<html>");
        out.println("<body>");
        out.println("Banda " + banda.getNome() +
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
