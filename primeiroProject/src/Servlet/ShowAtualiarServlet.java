package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import dao.BandaDao;
import modelo.Show;

/**
 * Servlet implementation class ShowAtualiarServlet
 */
@WebServlet("/ShowAtualiarServlet")
public class ShowAtualiarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAtualiarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    protected void service (HttpServletRequest request
			, HttpServletResponse response)
					throws ServerException, IOException, ServletException {
    	PrintWriter out = response.getWriter();
    	out.println("o ID usado foi o: " + request.getParameter("idlocal"));
		out.println("Data do show:  " + request.getParameter("data"));
		//String contato = request.getParameter("contato");
		//Para valores inteiros se usa dessa forma!
		long idshow = Integer.parseInt(request.getParameter("idshow"));
		String dataTexto = request.getParameter("data");
		java.util.Date data = null;
		
		//data = new SimpleDateFormat("yyyy/mm/dd").parse(dataTexto);
		java.util.Date dt = new java.util.Date();

	java.text.DateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		
		

		   Show show = new Show ();
		   	show.setId(idshow);
	        show.setData(dataTexto);
	        
	        try {
		        BandaDao daoExcluir = new BandaDao(request, response);
		        daoExcluir.atualizaShow(show);
		        } catch (Exception e) {
		        	 System.out.println("passei por aqui para atualizar o show");
		 	        e.printStackTrace();
		        }
	        
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
