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
import modelo.ContatoBanda;
import modelo.Show;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/ShowServlet")
public class AdicionaShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionaShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void service (HttpServletRequest request
			, HttpServletResponse response)
					throws ServerException, IOException, ServletException {
   
    	try{
			Show show = new Show();
			BandaDao dao = new BandaDao();
			if(request.getParameter("data").equals("")){
				response.sendRedirect("index.jsp");
			}else{
				//passar o id como int
				show.setLocal_Idlocal(Integer.parseInt(request.getParameter("local_idlocal")));
				//local.setId(Long.parseLong(request.getParameter("local_idlocal")));
				
				java.util.Date data = null;
	
						//data = new SimpleDateFormat("yyyy/mm/dd").parse(dataTexto);
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
